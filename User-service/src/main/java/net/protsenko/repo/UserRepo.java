package net.protsenko.repo;

import net.protsenko.domain.Role;
import net.protsenko.domain.User;

import java.util.Optional;

public interface UserRepo {

    Optional<User> findById(Long userId);

    Optional<User> findByEmail(String email);

    void save(User user);

    void update(User user);

    void delete(Long userId);

    void insertUserRole(Long userId, Role role);

}
