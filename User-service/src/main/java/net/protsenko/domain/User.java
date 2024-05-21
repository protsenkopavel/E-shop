package net.protsenko.domain;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class User {

    private UUID id;

    private String name;

    private String email;

    private String password;

    private String passwordConfirm;

    private Role role;

    private Address address;

}
