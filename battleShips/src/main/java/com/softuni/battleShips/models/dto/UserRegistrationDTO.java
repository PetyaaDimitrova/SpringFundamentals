package com.softuni.battleShips.models.dto;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class UserRegistrationDTO {

    @Size(min = 3, max = 10)
    @NotBlank
    private String username;
    @Size(min = 3, max = 10)
    @NotBlank
    private String fullName;

    @Email
    @NotBlank
    private String email;

    @Size(min = 3)
    @NotBlank
    private String password;
    private String confirmPassword;

    public UserRegistrationDTO(){}

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
