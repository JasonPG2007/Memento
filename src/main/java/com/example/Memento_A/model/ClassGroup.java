package com.example.Memento_A.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.time.ZonedDateTime;
import java.util.List;

@Entity
@Data
public class ClassGroup {
    @Id
    private int groupId;
    private int accountId;
    private String groupName;
    private String description;
    @Column(nullable = true)
    private int maxMembers;
    private ZonedDateTime createdAt;
    private ZonedDateTime updatedAt;

    // Relationship
    @ManyToOne
    @JoinColumn(name = "accountId", insertable = false, updatable = false)
    @JsonIgnore
    private Account account; // Account (1) - Group (n)

    @OneToMany(mappedBy = "classGroup")
    @JsonIgnore
    private List<Post> posts; // ClassGroup (1) - Post (n)

}
