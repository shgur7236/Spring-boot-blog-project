package blogproject.blog.config.auth;

import blogproject.blog.domain.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

@RequiredArgsConstructor
public class PrincipalDetail implements UserDetails {

    private final User user;

    //사용자 이메일
    public String getEmail(){
        return user.getEmail();
    }

    //사용자 닉네임
    public String getNickname(){
        return user.getNickname();
    }

    //사용자 pk
    public Long getId(){
        return user.getId();
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> collection = new ArrayList<>();
        collection.add(() -> user.getRole().getKey());

        return collection;
    }

    //사용자 패스워드
    @Override
    public String getPassword() {
        return null;
    }

    //사용자 아이디
    @Override
    public String getUsername() {
        return null;
    }

    //계정이 만료되어있는지 (true = 만료되지 않음)
    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    // 계정이 잠겨있는지 (true = 잠겨있지 않음)
    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    //패스워드가 만료되지 않았는지 (true = 만료되지 않음)
    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    //계정이 활성화되어 있는지 (true = 활성화)
    @Override
    public boolean isEnabled() {
        return false;
    }
}
