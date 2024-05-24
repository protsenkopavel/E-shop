package net.protsenko.repo;

import net.protsenko.domain.Role;
import net.protsenko.domain.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

public class UserRowMapper {

    public static User mapRow(ResultSet rs) {
        Set<Role> roles = new HashSet<>();
        try {
            while (rs.next()) {
                roles.add(Role.valueOf(rs.getString("user_role")));
            }
            rs.beforeFirst();
            if (rs.next()) {
                User user = new User();
                user.setId(rs.getLong("user_id"));
                user.setName(rs.getString("user_name"));
                user.setEmail(rs.getString("user_email"));
                user.setPassword(rs.getString("user_password"));
                user.setRole(roles);
                user.setAddress(rs.getString("user_address"));
                return user;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

}
