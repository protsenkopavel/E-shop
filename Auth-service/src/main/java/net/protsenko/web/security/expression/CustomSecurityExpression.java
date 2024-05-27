package net.protsenko.web.security.expression;

import net.protsenko.domain.Role;
import net.protsenko.service.UserService;
import net.protsenko.web.security.JwtEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service("customSecurityExpression")
public class CustomSecurityExpression {

    private final UserService userService;

    public CustomSecurityExpression(UserService userService) {
        this.userService = userService;
    }

    public boolean canAccess(Long id) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        JwtEntity user = (JwtEntity) authentication.getPrincipal();
        Long userId = user.getId();

        return userId.equals(id) || hasAnyRole(authentication, Role.ROLE_ADMIN);
    }

    private boolean hasAnyRole(Authentication authentication, Role ... role) {
        for (Role r : role) {
            SimpleGrantedAuthority authority = new SimpleGrantedAuthority(r.name());
            if (authentication.getAuthorities().contains(authority)) {
                return true;
            }
        }
        return false;
    }
}
