package blogproject.blog.service;

import blogproject.blog.model.Role;
import blogproject.blog.model.User;
import blogproject.blog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;
    public User save(User user) {
        String encodepassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodepassword);
        user.setEnabled(true);
        Role role = new Role();
        role.setId(1l);
        user.getRoles().add(role);
        return userRepository.save(user);
    }
}
