package com.example.Memento_A.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.util.Date;

@Entity
@Data
public class Account {
    @Id
    private int accountId;
    @NotBlank(message = "Username is required and cannot be empty or whitespace only")
    private String username;
    private String password;
    private Date createdAt;
}
