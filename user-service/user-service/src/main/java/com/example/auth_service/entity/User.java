package com.example.auth_service.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(unique = true, nullable = false)
    private String username; // Kolom baru untuk username

    @Column(nullable = false)
    private String country;

    @Column(nullable = false)
    private String role;

    @Column(nullable = false)
    private boolean enabled = false;  // Status verifikasi email

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    // === Field baru: Credit Token ===
    @Column(nullable = false)
    private int credit;

    @PrePersist
    public void prePersist() {
        createdAt = LocalDateTime.now();
        updatedAt = createdAt;
        // Set nilai default credit, misalnya 100 token
        credit = 10;
    }

    @PreUpdate
    public void preUpdate() {
        updatedAt = LocalDateTime.now();
    }
}
