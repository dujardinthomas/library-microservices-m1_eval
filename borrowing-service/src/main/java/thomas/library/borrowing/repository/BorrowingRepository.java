package thomas.library.borrowing.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import thomas.library.borrowing.model.Borrowing;

@Repository
public interface BorrowingRepository extends JpaRepository<Borrowing, Long>{
    
}
