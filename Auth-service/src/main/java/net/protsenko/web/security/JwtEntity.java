package net.protsenko.web.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class JwtEntity implements UserDetails {

    private Long id;

    private final String username;

    private final String name;

    private final String password;

    private final Collection<? extends GrantedAuthority> authorities;

    public JwtEntity(String password, Collection<? extends GrantedAuthority> authorities, String name, String username, Long id) {
        this.password = password;
        this.authorities = authorities;
        this.name = name;
        this.username = username;
        this.id = id;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
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
