package thomas.library.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import thomas.library.user.model.User;
import thomas.library.user.repository.UserRepository;
import thomas.library.user.tools.MembershipTypeEnum;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User saveUser(User user) {
        User userNew = new User();
        userNew.setEmail(user.getEmail());
        userNew.setName(user.getName());
        userNew.setMembershipType(user.getMembershipType());
        userNew.setNombreMaxEmprunt(getNombreMaxEmprunt(user.getMembershipType()));
        userNew.setLocked(false);
        return userRepository.save(userNew);
    }


    private int getNombreMaxEmprunt(String membershipType) {
        if ("regular".equalsIgnoreCase(membershipType.toLowerCase())) {
            return 5;
        } else if ("premium".equalsIgnoreCase(membershipType.toLowerCase())) {
            return 7;
        } else {
            throw new IllegalArgumentException("Unknown membership type: " + membershipType);
        }
    }


    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

}
