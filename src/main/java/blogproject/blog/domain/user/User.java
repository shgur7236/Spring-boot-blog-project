package blogproject.blog.domain.user;

import blogproject.blog.domain.BaseTimeEntity;
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
public class User extends BaseTimeEntity {

    @Id // 테이블의 Primary Key(PK)
    @GeneratedValue(strategy = GenerationType.IDENTITY) // PK를 자동으로 생성하고자 할 때 사용용    private Long id; //sequence, auto_increment
    private Long Id;

    @Column(nullable = false, length = 30, unique = true)
    private String username; // 아이디

    @Column(nullable = false, length = 100)
    private String password; // 비밀번호

    @Column(nullable = false, length = 50)
    private String email;

    @Column(nullable = false, length = 20)
    private String nickname; // 닉네임

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    public void setPassword(String password){
        this.password = password;
    }

    /**
     * 권한 메소드
     */
    public String getRoleKey(){
        return this.role.getKey();
    }

    /**
     * 회원수정 메소드
     */
    public void update(String password, String nickname){
        this.password = password;
        this.nickname = nickname;
    }
}
