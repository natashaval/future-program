package hellomysql.hellomysql.service;

import hellomysql.hellomysql.entity.CurrentUser;
import hellomysql.hellomysql.repository.CurrentUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class InternalUserDetailsService implements UserDetailsService {
//    http://www.doubleh.ie/index.php/2016/09/09/how-to-save-db-user-entity-in-spring-security-authentication-object/
    @Autowired
    private CurrentUserRepository userRepository;

    @Override
    public UserPrincipal loadUserByUsername(String username) throws UsernameNotFoundException {
        CurrentUser user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("Unknown User");
        }
        boolean enabled = true;
        boolean accountNonExpired = true;
        boolean credentialsNotExpired = true;
        boolean accountNonLocked = true;
        UserPrincipal principal = new UserPrincipal(
                user,
                enabled, accountNonExpired, credentialsNotExpired, accountNonLocked,
                getAuthorities(user.getRoles())
        );
        return principal;
    }

    private List<GrantedAuthority> getAuthorities(List<String> roles) {
            return roles.stream()
                    .map(r -> new SimpleGrantedAuthority(r))
                    .collect(Collectors.toList());
    }
}
