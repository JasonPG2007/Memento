package com.example.Memento_A.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.time.ZonedDateTime;

@Entity
@Data
public class Post {
    @Id
    private int postId;
    private String title;
    private String contents;
    @Column(nullable = true)
    private String tag;
    private ZonedDateTime createdAt;
    private ZonedDateTime updatedAt;

    // Relationship
    @ManyToOne
    @JoinColumn(name = "groupId", insertable = false, updatable = false)
    @JsonIgnore
    private ClassGroup classGroup; // ClassGroup (1) - Post (n)
}
