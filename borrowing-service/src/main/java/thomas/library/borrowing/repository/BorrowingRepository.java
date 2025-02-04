package thomas.library.borrowing.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import thomas.library.borrowing.model.Borrowing;

@Repository
public interface BorrowingRepository extends JpaRepository<Borrowing, Long>{

    @Query("SELECT COUNT(b) FROM Borrowing b WHERE b.userId = :userId AND b.returnDate IS NULL")
    long countActiveReservationsByUserId(@Param("userId") Long userId);
    
}
