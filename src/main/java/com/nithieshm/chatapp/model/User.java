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

    @Column(unique = true, nullable = false)
    @NotBlank(message = "Username is required.")
    @Size(min = 3, max = 20, message = "Username should be between 3 and 20 characters")
    private String username;

    @Email
    @Column(unique = true, nullable = false)
    @NotBlank(message = "Email is required")
    private String email;

    @Column(nullable = false)
    @Size(min = 8, max = 24, message = "Password is required")
    private String password;

    private LocalDateTime createdAt;

    private boolean isOnline;

    public User() {}

    public User(UUID id, String username, String email, String password, LocalDateTime createdAt, boolean isOnline) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.createdAt = createdAt;
        this.isOnline = isOnline;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public @NotBlank(message = "Username is required.") @Size(min = 3, max = 20, message = "Username should be between 3 and 20 characters") String getUsername() {
        return username;
    }

    public void setUsername(@NotBlank(message = "Username is required.") @Size(min = 3, max = 20, message = "Username should be between 3 and 20 characters") String username) {
        this.username = username;
    }

    public @Email @NotBlank(message = "Email is required") String getEmail() {
        return email;
    }

    public void setEmail(@Email @NotBlank(message = "Email is required") String email) {
        this.email = email;
    }

    public @Size(min = 8, max = 24, message = "Password is required") String getPassword() {
        return password;
    }

    public void setPassword(@Size(min = 8, max = 24, message = "Password is required") String password) {
        this.password = password;
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
}
