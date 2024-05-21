package net.protsenko.repo;

import net.protsenko.domain.Role;
import net.protsenko.domain.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UserRepoImpl implements UserRepo {
    @Override
    public Optional<User> findById(Long userId) {
        return Optional.empty();
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return Optional.empty();
    }

    @Override
    public void save(User user) {

    }

    @Override
    public void update(User user) {

    }

    @Override
    public void delete(Long userId) {

    }

    @Override
    public void insertUserRole(Long userId, Role role) {

    }
}
