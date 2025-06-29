package com.nithieshm.chatapp.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UserRegistrationDTO {

    @NotBlank(message = "Password is required")
    private String password;

    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    private String email;

    @NotBlank(message = "First name is required")
    @Size(min = 1, max = 64, message = "First name should be between 1 and 64 characters")
    private String firstName;

    @NotBlank(message = "First name is required")
    @Size(min = 1, max = 64, message = "First name should be between 1 and 64 characters")
    private String lastName;

    public @NotBlank(message = "Password is required") String getPassword() {
        return password;
    }

    public void setPassword(@NotBlank(message = "Password is required") String password) {
        this.password = password;
    }

    public @NotBlank(message = "Email is required") @Email(message = "Invalid email format") String getEmail() {
        return email;
    }

    public void setEmail(@NotBlank(message = "Email is required") @Email(message = "Invalid email format") String email) {
        this.email = email;
    }

    public @NotBlank(message = "First name is required") @Size(min = 1, max = 64, message = "First name should be between 1 and 64 characters") String getFirstName() {
        return firstName;
    }

    public void setFirstName(@NotBlank(message = "First name is required") @Size(min = 1, max = 64, message = "First name should be between 1 and 64 characters") String firstName) {
        this.firstName = firstName;
    }

    public @NotBlank(message = "First name is required") @Size(min = 1, max = 64, message = "First name should be between 1 and 64 characters") String getLastName() {
        return lastName;
    }

    public void setLastName(@NotBlank(message = "First name is required") @Size(min = 1, max = 64, message = "First name should be between 1 and 64 characters") String lastName) {
        this.lastName = lastName;
    }
}
