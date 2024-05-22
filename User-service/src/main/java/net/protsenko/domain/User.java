package net.protsenko.domain;

import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Data
@Builder
public class User {

    private Long id;

    private String name;

    private String email;

    private String password;

    private String passwordConfirm;

    private Set<Role> role;

    private Address address;

}
