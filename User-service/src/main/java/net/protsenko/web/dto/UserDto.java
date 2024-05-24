package net.protsenko.web.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import net.protsenko.web.validation.OnCreate;
import net.protsenko.web.validation.OnUpdate;
import org.hibernate.validator.constraints.Length;

public class UserDto {

    @NotNull(message = "Id must not be null.", groups = OnCreate.class)
    private Long id;

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
    private String address;

    public @NotNull(message = "Id must not be null.", groups = OnCreate.class) Long getId() {
        return id;
    }

    public void setId(@NotNull(message = "Id must not be null.", groups = OnCreate.class) Long id) {
        this.id = id;
    }

    public @NotNull(message = "Name must not be null.", groups = {OnCreate.class, OnUpdate.class}) @Length(max = 255, message = "Name length must be smaller than 255 symbols", groups = {OnCreate.class, OnUpdate.class}) String getName() {
        return name;
    }

    public void setName(@NotNull(message = "Name must not be null.", groups = {OnCreate.class, OnUpdate.class}) @Length(max = 255, message = "Name length must be smaller than 255 symbols", groups = {OnCreate.class, OnUpdate.class}) String name) {
        this.name = name;
    }

    public @NotNull(message = "Email must not be null.", groups = {OnCreate.class, OnUpdate.class}) @Length(max = 255, message = "Email length must be smaller than 255 symbols", groups = {OnCreate.class, OnUpdate.class}) String getEmail() {
        return email;
    }

    public void setEmail(@NotNull(message = "Email must not be null.", groups = {OnCreate.class, OnUpdate.class}) @Length(max = 255, message = "Email length must be smaller than 255 symbols", groups = {OnCreate.class, OnUpdate.class}) String email) {
        this.email = email;
    }

    public @NotNull(message = "Password must not be null.", groups = {OnCreate.class, OnUpdate.class}) String getPassword() {
        return password;
    }

    public void setPassword(@NotNull(message = "Password must not be null.", groups = {OnCreate.class, OnUpdate.class}) String password) {
        this.password = password;
    }

    public @NotNull(message = "Password confirmation must not be null.", groups = OnUpdate.class) String getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(@NotNull(message = "Password confirmation must not be null.", groups = OnUpdate.class) String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }

    public @NotNull(message = "Password must not be null.", groups = {OnCreate.class, OnUpdate.class}) String getAddress() {
        return address;
    }

    public void setAddress(@NotNull(message = "Password must not be null.", groups = {OnCreate.class, OnUpdate.class}) String address) {
        this.address = address;
    }
}
