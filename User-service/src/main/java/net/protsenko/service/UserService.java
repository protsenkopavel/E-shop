package net.protsenko.service;

import net.protsenko.domain.User;

public interface UserService {

    User getById(Long userId);

    User getByEmail(String email);

    User save(User user);

    User update(User user);

    void delete(Long userId);

}
