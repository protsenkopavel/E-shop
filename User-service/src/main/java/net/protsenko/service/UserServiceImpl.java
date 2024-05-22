package net.protsenko.service;

import net.protsenko.domain.Role;
import net.protsenko.domain.User;
import net.protsenko.domain.exception.ResourceNotFoundException;
import net.protsenko.repo.UserRepo;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepo userRepo, PasswordEncoder passwordEncoder) {
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    @Transactional(readOnly = true)
    public User getById(Long userId) {
        return userRepo.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
    }

    @Override
    @Transactional(readOnly = true)
    public User getByEmail(String email) {
        return userRepo.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
    }

    @Override
    @Transactional
    public User save(User user) {
        if (userRepo.findByEmail(user.getEmail()).isPresent()) {
            throw new IllegalArgumentException("User already exists");
        }
        if (user.getPassword().equals(user.getPasswordConfirm())) {
            throw new IllegalArgumentException("Passwords do not match");
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepo.save(user);
        Set<Role> roles = Set.of(Role.ROLE_USER);
        userRepo.insertUserRole(user.getId(), Role.ROLE_USER);
        user.setRole(roles);
        return user;
    }

    @Override
    @Transactional
    public User update(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepo.update(user);
        return user;
    }

    @Override
    @Transactional
    public void delete(Long userId) {
        userRepo.delete(userId);
    }
}
