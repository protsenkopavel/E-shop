package net.protsenko.domain;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
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
