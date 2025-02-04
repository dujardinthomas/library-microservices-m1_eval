package thomas.library.borrowing.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import thomas.library.borrowing.dto.BorrowingDTO;
import thomas.library.borrowing.model.Borrowing;
import thomas.library.borrowing.service.BorrowingService;

@RestController
@RequestMapping("/borrowing")
public class BorrowingController {
    
    @Autowired
    private BorrowingService borrowingService;

    @GetMapping({"/", ""})
    public List<Borrowing> getAllBorrowings() {
        return borrowingService.getAllBorrowings();
    }

    @GetMapping("/{id}")
    public Borrowing getBorrowingById(@PathVariable Long id) {
        return borrowingService.getBorrowingById(id);
    }  
    
    
    @GetMapping("/dto/{id}")
    public BorrowingDTO getBorrowingDTO(@PathVariable Long id) {
        return borrowingService.getBorrowingDTO(id);
    }


    @PostMapping
    public Borrowing createBorrowing(@RequestBody Borrowing borrowing) {
        return borrowingService.createBorrowing(borrowing);
    }

    @DeleteMapping("/{id}")
    public void deleteBorrowingById(@PathVariable Long id) {
        borrowingService.deleteBorrowingById(id);
    }
}
