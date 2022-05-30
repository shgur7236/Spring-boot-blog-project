package blogproject.blog.domain.user;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @AfterEach
    public void cleanUp() {
        userRepository.deleteAll();
    }

    @Test
    public void 회원가입_테스트() {
        //given
        String username = "test";
        String nickname = "NohHyuk";

        userRepository.save(User.builder()
                .username(username)
                .password("1234")
                .email("test@naver.com")
                .nickname(nickname)
                .role(Role.USER)
                .build());

        //when
        // 모든 데이터를 조회
        List<User> userList = userRepository.findAll();

        //then
        User user = userList.get(0);
        assertThat(user.getUsername()).isEqualTo(username);
        assertThat(user.getNickname()).isEqualTo(nickname);
    }
}
