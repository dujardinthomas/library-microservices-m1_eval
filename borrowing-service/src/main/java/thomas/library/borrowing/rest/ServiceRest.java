package thomas.library.borrowing.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import thomas.library.borrowing.dto.BookDTO;
import thomas.library.borrowing.dto.UserDTO;


@Service
public class ServiceRest {

    @Autowired
    private RestTemplate restTemplate;

    private static final String USER_SERVICE_URL = "http://user-service/user/";
    private static final String BOOK_SERVICE_URL = "http://book-service/book/";

    public BookDTO getBookById(Long bookId) {
        try {
            ResponseEntity<BookDTO> response = restTemplate.exchange(
                BOOK_SERVICE_URL + bookId, 
                HttpMethod.GET, 
                null,
                new ParameterizedTypeReference<BookDTO>() {});
                System.out.println("response: " + response);
            return response.getBody();
        } catch (Exception e) {
            System.out.println("Error: " + e);
            return null;
        }
    }


    public UserDTO getUserById(Long userId) {
        try {
            ResponseEntity<UserDTO> response = restTemplate.exchange(
                USER_SERVICE_URL + userId, 
                HttpMethod.GET, 
                null,
                new ParameterizedTypeReference<UserDTO>() {});
                System.out.println("response: " + response);
            return response.getBody();
        } catch (Exception e) {
            System.out.println("Error: " + e);
            return null;
        }
    }


    public void updateBook(BookDTO book) {
        try {
            restTemplate.put(BOOK_SERVICE_URL + book.getId(), book);
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
    
}
