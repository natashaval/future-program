package hellomysql.hellomysql.service;

import hellomysql.hellomysql.entity.CurrentUser;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

public class UserPrincipal extends User {
    private final CurrentUser user;

    public UserPrincipal(CurrentUser user, Collection<? extends GrantedAuthority> authorities){
        super(user.getUsername(), user.getPassword(), authorities);
        this.user = user;
    }

    public UserPrincipal(CurrentUser user, boolean enabled, boolean accountNonExpired,
                         boolean credentialNonExpired, boolean accountNonLocked,
                         Collection<? extends GrantedAuthority> authorities) {
        super(user.getUsername(),user.getPassword(), enabled, accountNonExpired, credentialNonExpired, accountNonLocked, authorities);
        this.user = user;
    }

    public CurrentUser getUser() {
        return this.user;
    }
}
