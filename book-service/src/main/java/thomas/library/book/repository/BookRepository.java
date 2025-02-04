package thomas.library.book.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import thomas.library.book.model.Book;

public interface BookRepository extends JpaRepository<Book, Long>{
    
}
