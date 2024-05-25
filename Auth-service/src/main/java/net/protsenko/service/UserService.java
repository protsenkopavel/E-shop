package net.protsenko.service;

import net.protsenko.domain.User;

public interface UserService {

    User getById(Long userId);

    User getByUsername(String username);

    User save(User user);

}
