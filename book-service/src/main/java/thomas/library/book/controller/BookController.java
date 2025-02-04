package thomas.library.book.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import thomas.library.book.model.Book;
import thomas.library.book.service.BookService;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping({ "", "/" })
    public ResponseEntity<List<Book>> getAllBooks() {
        System.out.println("BookController.getAllBooks()");
        List<Book> books = bookService.getAllBooks();
        return new ResponseEntity<>(books, books.isEmpty() ? HttpStatus.NOT_FOUND : HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getBookById(@PathVariable Long id) {
        System.out.println("BookController.getBookById() id: " + id);
        Book book = bookService.getBookById(id);
        return new ResponseEntity<>(book, book == null ? HttpStatus.NOT_FOUND : HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable Long id, Book book) {
        System.out.println("BookController.updateBook() book: " + book);
        Book updatedBook = bookService.updateBook(id, book);
        return new ResponseEntity<>(updatedBook, updatedBook == null ? HttpStatus.NOT_FOUND : HttpStatus.OK);
    }

    @PostMapping
    public Book addBook(@RequestBody Book book) {
        System.out.println("BookController.addBook() book: " + book);
        return bookService.saveBook(book);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id) {
        System.out.println("BookController.deleteBook() id: " + id);
        bookService.deleteBook(id);
    }
    
}
