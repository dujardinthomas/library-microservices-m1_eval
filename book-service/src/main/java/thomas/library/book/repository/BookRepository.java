package thomas.library.book.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import thomas.library.book.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long>{
    
}
