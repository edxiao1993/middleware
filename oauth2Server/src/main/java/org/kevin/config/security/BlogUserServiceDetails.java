package org.kevin.config.security;

import org.kevin.model.BlogUser;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

/**
 * @author Kevin.Z
 * @version 2021/6/20
 */
public class BlogUserServiceDetails implements UserDetails {
    private final BlogUser blogUser;
    private final String authorities;

    public BlogUserServiceDetails(BlogUser blogUser){
        this.blogUser = blogUser;
        authorities = "read";
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(() -> this.authorities);
    }

    @Override
    public String getPassword() {
        return blogUser.getPassword();
    }

    @Override
    public String getUsername() {
        return blogUser.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
