package thomas.library.borrowing.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import thomas.library.borrowing.model.Borrowing;
import thomas.library.borrowing.repository.BorrowingRepository;

@Service
public class BorrowingService {

    @Autowired
    private BorrowingRepository borrowingRepository;

    public Borrowing createBorrowing(Borrowing borrowing) {
        return borrowingRepository.save(borrowing);
    }

    public Borrowing getBorrowingById(Long id) {
        return borrowingRepository.findById(id).orElse(null);
    }

    public List<Borrowing> getAllBorrowings() {
        return borrowingRepository.findAll();
    }

    public void deleteBorrowingById(Long id) {
        borrowingRepository.deleteById(id);
    }
    
}
