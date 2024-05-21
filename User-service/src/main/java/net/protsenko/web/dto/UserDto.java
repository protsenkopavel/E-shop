package net.protsenko.web.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import net.protsenko.domain.Address;
import net.protsenko.web.validation.OnCreate;
import net.protsenko.web.validation.OnUpdate;
import org.hibernate.validator.constraints.Length;

import java.util.UUID;

@Data
@Builder
public class UserDto {

    @NotNull(message = "Id must not be null.", groups = OnCreate.class)
    private UUID id;

    @NotNull(message = "Name must not be null.", groups = {OnCreate.class, OnUpdate.class})
    @Length(max = 255, message = "Name length must be smaller than 255 symbols", groups = {OnCreate.class, OnUpdate.class})
    private String name;

    @NotNull(message = "Email must not be null.", groups = {OnCreate.class, OnUpdate.class})
    @Length(max = 255, message = "Email length must be smaller than 255 symbols", groups = {OnCreate.class, OnUpdate.class})
    private String email;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @NotNull(message = "Password must not be null.", groups = {OnCreate.class, OnUpdate.class})
    private String password;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @NotNull(message = "Password confirmation must not be null.", groups = OnUpdate.class)
    private String passwordConfirm;

    @NotNull(message = "Password must not be null.", groups = {OnCreate.class, OnUpdate.class})
    private Address address;

}
