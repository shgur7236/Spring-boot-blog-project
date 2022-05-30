package blogproject.blog.domain.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User {

    @Id // 테이블의 Primary Key(PK)
    @GeneratedValue(strategy = GenerationType.IDENTITY) // PK를 자동으로 생성하고자 할 때 사용용    private Long id; //sequence, auto_increment
    private Long Id;

    @Column(nullable = false, length = 30)
    private String username; // 아이디

    @Column(nullable = false, length = 100)
    private String password; // 비밀번호

    @Column(nullable = false, length = 50)
    private String email;

    @Column(nullable = false, length = 50)
    private String nickname; // 닉네임

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;
}
