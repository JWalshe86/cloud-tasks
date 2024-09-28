package com.example.cloudtasks.model; // Only one package declaration

import jakarta.persistence.*; // For JPA annotations

@Entity
public class ExampleEntity {

    @Id
    private Long id;

    @Version
    private Long version;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }
}

