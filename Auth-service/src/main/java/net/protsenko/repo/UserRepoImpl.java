package net.protsenko.repo;

import net.protsenko.config.DataSourceConfig;
import net.protsenko.domain.Role;
import net.protsenko.domain.User;
import net.protsenko.domain.exception.ResourceNotFoundException;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

@Repository
public class UserRepoImpl implements UserRepo {

    private final DataSourceConfig dataSourceConfig;

    public UserRepoImpl(DataSourceConfig dataSourceConfig) {
        this.dataSourceConfig = dataSourceConfig;
    }

    private final String FIND_BY_ID = """
            SELECT u.id as user_id,
                   u.name as user_name,
                   u.email as user_email,
                   u.password as user_password,
                   u.address as user_address,
                   ur.role as user_role
            FROM users u
                     LEFT JOIN users_roles ur ON u.id = ur.user_id
            WHERE u.id = ?
            """;

    private final String FIND_BY_USERNAME = """
            SELECT u.id as user_id,
                   u.name as user_name,
                   u.email as user_email,
                   u.password as user_password,
                   u.address as user_address,
                   ur.role as user_role
            FROM users u
                     LEFT JOIN users_roles ur ON u.id = ur.user_id
            WHERE u.email = ?
            """;

    private final String SAVE = """
            INSERT INTO users (user_id, user_name, user_email, user_password, user_role, user_address)
            VALUES (?, ?, ?, ?, ?, ?);
            """;

    private final String INSERT_USER_ROLE = """
            INSERT INTO users_roles (user_id, role_id)
            VALUES (?, ?)
            """;

    @Override
    public Optional<User> findById(Long userId) {
        try (Connection conn = dataSourceConfig.getDataSource().getConnection()) {
            PreparedStatement ps = conn.prepareStatement(
                    FIND_BY_ID,
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            ps.setLong(1, userId);
            try (ResultSet rs = ps.executeQuery()) {
                return Optional.ofNullable(UserRowMapper.mapRow(rs));
            }
        } catch (SQLException e) {
            throw new ResourceNotFoundException("Exception while fetching user with id " + userId);
        }
    }

    @Override
    public Optional<User> findByUsername(String username) {
        try (Connection conn = dataSourceConfig.getDataSource().getConnection()) {
            PreparedStatement ps = conn.prepareStatement(
                    FIND_BY_USERNAME,
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            ps.setString(1, username);
            try (ResultSet rs = ps.executeQuery()) {
                return Optional.ofNullable(UserRowMapper.mapRow(rs));
            }
        } catch (SQLException e) {
            throw new ResourceNotFoundException("Exception while fetching user with email " + username);
        }
    }

    @Override
    public void save(User user) {
        try (Connection conn = dataSourceConfig.getDataSource().getConnection()) {
            PreparedStatement ps = conn.prepareStatement(SAVE, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, user.getName());
            ps.setString(2, user.getUsername());
            ps.setString(3, user.getPassword());
            ps.setString(4, user.getAddress());
            ps.executeUpdate();
            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    user.setId(rs.getLong(1));
                }
            }
        } catch (SQLException e) {
            throw new ResourceNotFoundException("Exception while saving user " + user.getName());
        }
    }

    @Override
    public void insertUserRole(Long userId, Role role) {
        try (Connection conn = dataSourceConfig.getDataSource().getConnection()) {
            PreparedStatement ps = conn.prepareStatement(INSERT_USER_ROLE);
            ps.setLong(1, userId);
            ps.setString(2, role.name());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new ResourceNotFoundException("Exception while inserting user role " + role.name());
        }
    }
}
