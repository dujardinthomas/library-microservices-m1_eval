package thomas.library.book.model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
// import lombok.Data;

//TODO lombok ne fonctionne pas pourquoi ?, j'ai mis les getter et setter manuellement
// @Data
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String author;
    private String category;
    private boolean isAvailable;

    public Book() {
    }

    public Book(String title, String author, String category, boolean isAvailable) {
        this.title = title;
        this.author = author;
        this.category = category;
        this.isAvailable = isAvailable;
    }

    public Book(Long id, String title, String author, String category, boolean isAvailable) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.category = category;
        this.isAvailable = isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getCategory() {
        return category;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setCategory(String category) {
        this.category = category;
    }
    
}
