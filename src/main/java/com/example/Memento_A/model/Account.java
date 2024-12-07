package com.example.Memento_A.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.ZonedDateTime;
import java.util.List;

@Entity
@Data
public class Account {
    @Id
    private int accountId;
    @NotBlank(message = "Username is required and cannot be empty or whitespace only")
    private String username;
    @NotBlank(message = "Password is required and cannot be empty or whitespace only")
    private String password;
    private ZonedDateTime createdAt;
    private ZonedDateTime updatedAt;

    // Relationship
    @OneToMany(mappedBy = "account")
    @JsonIgnore
    private List<ClassGroup> classGroups; // Account (1) - Group (n)

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "profileId", referencedColumnName = "profileId")
    private Profile profile; // Account (1) - Profile (1)
}
