package blogproject.blog.service;

import blogproject.blog.domain.user.User;
import blogproject.blog.domain.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    /**
     * 회원가입 로직
     */
    @Transactional
    public Long save(User user){
        String hashPw = bCryptPasswordEncoder.encode(user.getPassword());
        user.setPassword(hashPw);
        return userRepository.save(user).getId();
    }

    /**
     * 회원수정 로직
     */
    @Transactional
    public Long update(User user){
        User userEntity = userRepository.findById(user.getId()).orElseThrow(() -> new IllegalArgumentException("해당 회원이 없습니다. id="+user.getId()));
        userEntity.update(bCryptPasswordEncoder.encode(user.getPassword()),user.getNickname());
        return userEntity.getId();
    }
}
