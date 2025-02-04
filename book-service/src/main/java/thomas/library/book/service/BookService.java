package thomas.library.book.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import thomas.library.book.model.Book;
import thomas.library.book.repository.BookRepository;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    public Book getBookById(Long id) {
        try {
            return bookRepository.findById(id).get();
        } catch (Exception e) {
            return null;
        }
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }

}
