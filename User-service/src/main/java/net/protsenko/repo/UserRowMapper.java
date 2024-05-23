package net.protsenko.repo;

import lombok.SneakyThrows;
import net.protsenko.domain.Role;
import net.protsenko.domain.User;

import java.sql.ResultSet;
import java.util.HashSet;
import java.util.Set;

public class UserRowMapper {

    @SneakyThrows
    public static User mapRow(ResultSet rs) {
        Set<Role> roles = new HashSet<>();
        while (rs.next()) {
            roles.add(Role.valueOf(rs.getString("user_user_role")));
        }
        rs.beforeFirst();
        if (rs.next()) {
            User user = new User();
            user.setId(rs.getLong("id"));
            user.setName(rs.getString("user_name"));
            user.setEmail(rs.getString("user_email"));
            user.setPassword(rs.getString("user_password"));
            user.setRole(roles);
            return user;
        }
        return null;
    }

}
