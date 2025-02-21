package thomas.library.borrowing.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import thomas.library.borrowing.dto.BookDTO;
import thomas.library.borrowing.dto.BorrowingDTO;
import thomas.library.borrowing.dto.UserDTO;
import thomas.library.borrowing.model.Borrowing;
import thomas.library.borrowing.repository.BorrowingRepository;
import thomas.library.borrowing.rest.ServiceRest;

@Service
public class BorrowingService {

    @Autowired
    private BorrowingRepository borrowingRepository;

    @Autowired
    private ServiceRest serviceRest;

    public Borrowing createBorrowing(Borrowing borrowing) {
        BookDTO book = serviceRest.getBookById(borrowing.getBookId());
        UserDTO user = serviceRest.getUserById(borrowing.getUserId());

        if (book != null && book.isAvailable() && user != null && !user.isLocked()) {
            Borrowing borrowingNew = new Borrowing();
            borrowing.setBookId(borrowing.getBookId());
            borrowing.setUserId(borrowing.getUserId());
            borrowing.setBorrowDate(LocalDate.now());
            borrowing.setReturnDate(null);

            book.setAvailable(false);
            serviceRest.updateBook(book);

            //si l'user a son max de reservation atteint, on le lock
            if (user.getNombreMaxEmprunt() >= borrowingRepository.countActiveReservationsByUserId(user.getId())) {
                user.setLocked(true);
                serviceRest.updateUser(user);
            }

            return borrowingRepository.save(borrowingNew);
        } else {
            throw new RuntimeException("Book is not available or user is locked.");
        }
    }

    public Borrowing getBorrowingById(Long id) {
        return borrowingRepository.findById(id).orElse(null);
    }

    public BorrowingDTO getBorrowingDTO(Long id){
        Borrowing borrowing = borrowingRepository.findById(id).orElse(null);
        System.out.println("borrowing: " + borrowing);
        
        BorrowingDTO borrowingDTO = new BorrowingDTO();
        borrowingDTO.setId(borrowing.getId());
        borrowingDTO.setBorrowDate(borrowing.getBorrowDate());
        borrowingDTO.setReturnDate(borrowing.getReturnDate());

        Long bookId = borrowing.getBookId();
        Long userId = borrowing.getUserId();

        BookDTO book = (bookId != null) ? serviceRest.getBookById(bookId) : null;
        UserDTO user = (userId != null) ? serviceRest.getUserById(userId) : null;

        borrowingDTO.setBook(book);
        borrowingDTO.setUser(user);


        return borrowingDTO;
    }



    public List<Borrowing> getAllBorrowings() {
        return borrowingRepository.findAll();
    }

    public void deleteBorrowingById(Long id) {
        borrowingRepository.deleteById(id);
    }

    
    
}
