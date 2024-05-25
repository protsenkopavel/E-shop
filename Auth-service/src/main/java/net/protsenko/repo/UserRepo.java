package net.protsenko.repo;

import net.protsenko.domain.Role;
import net.protsenko.domain.User;

import java.util.Optional;

public interface UserRepo {

    Optional<User> findById(Long userId);

    Optional<User> findByUsername(String username);

    void save(User user);

    void insertUserRole(Long userId, Role role);

}
