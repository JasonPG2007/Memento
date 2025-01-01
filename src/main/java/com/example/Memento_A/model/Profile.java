package com.example.Memento_A.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.time.*;
import java.util.List;

@Entity
@Data
public class Profile {
    @Id
    private int profileId;
    private String fullName;
    private int age;
    private String grade;
    private String school;
    private String city;
    private OffsetDateTime createdAt;
    private OffsetDateTime updatedAt;

    // Relationship
    @OneToOne(mappedBy = "profile")
    private Account account; // Account (1) - Profile (1)
}
