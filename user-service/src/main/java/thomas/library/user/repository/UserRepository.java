package thomas.library.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import thomas.library.user.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    
}
