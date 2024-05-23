package net.protsenko.repo;

import net.protsenko.domain.Role;
import net.protsenko.domain.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UserRepoImpl implements UserRepo {

    private final String FIND_BY_ID = """
            SELECT u.id as user_id,
            u.name as user_name,
            u.email as user_email,
            u.password as user_password,
            ur.role as user_role_role
            FROM user u
            LEFT OUTER JOIN users_roles ur ON u.id = ur.user_id
            WHERE user_id = ?
            """;

    private final String FIND_BY_EMAIL = """
            SELECT u.id as user_id,
            u.name as user_name,
            u.email as user_email,
            u.password as user_password,
            ur.role as user_role_role
            FROM user u
            LEFT OUTER JOIN users_roles ur ON u.id = ur.user_id
            WHERE user_id = ?
            """;

    private final String SAVE = """
            INSERT INTO users (user_id, user_name, user_email, user_password, user_role)
            VALUES (?, ?, ?, ?, ?);
            """;

    private final String UPDATE = """
            UPDATE users
            SET user_name = ?,
            user_email = ?,
            user_password = ?,
            user_role = ?
            WHERE user_id = ?
            """;

    private final String DELETE = """
            DELETE FROM users
            WHERE user_id = ?
            """;

    private final String INSERT_USER_ROLE = """
            INSERT INTO users_roles (user_id, role_id)
            VALUES (?, ?)
            """;

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
