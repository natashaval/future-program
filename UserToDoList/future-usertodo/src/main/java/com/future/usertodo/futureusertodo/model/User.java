package com.future.usertodo.futureusertodo.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name="users")

public class User extends AuditModel {
    @Id
    @GeneratedValue(generator = "user_generator")
    @SequenceGenerator(
            name="user_generator",
            sequenceName = "user_sequence",
            initialValue = 1
    )
    private Long id;

    @Column(name="username", nullable = false, unique = true)
    private String username;

    @NotBlank
    @Size(min = 5, max = 50)
    private String name;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
