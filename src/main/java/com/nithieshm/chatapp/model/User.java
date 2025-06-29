package com.nithieshm.chatapp.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Email
    @Column(unique = true, nullable = false)
    @NotBlank(message = "Email is required")
    private String email;

    @Column(nullable = false)
    @NotBlank(message = "Password is required")
    private String password;

    @Column(nullable = false)
    @NotBlank(message = "First name is required")
    @Size(min = 1, max = 64, message = "First name should be between 1 and 64 characters")
    private String firstName;

    @Column(nullable = false)
    @NotBlank(message = "First name is required")
    @Size(min = 1, max = 64, message = "First name should be between 1 and 64 characters")
    private String lastName;

    private LocalDateTime createdAt;

    private boolean isOnline;

    public User() {}

    public User(UUID id, String email, String password, String firstName, String lastName, LocalDateTime createdAt, boolean isOnline) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.createdAt = createdAt;
        this.isOnline = isOnline;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public @Email @NotBlank(message = "Email is required") String getEmail() {
        return email;
    }

    public void setEmail(@Email @NotBlank(message = "Email is required") String email) {
        this.email = email;
    }

    public @NotBlank(message = "Password is required") String getPassword() {
        return password;
    }

    public void setPassword(@NotBlank(message = "Password is required") String password) {
        this.password = password;
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

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public boolean isOnline() {
        return isOnline;
    }

    public void setOnline(boolean online) {
        isOnline = online;
    }

    @PrePersist
    public void prePersist() {
        createdAt = LocalDateTime.now();
    }
}
