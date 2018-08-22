package com.future.usertodo.futureusertodo.model;

import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "user")
//pemberian nama harus camelCase

public class User extends AuditModel {
    @Id
    //membuat sequence pada PostGreSQL
    @GeneratedValue(generator = "user_generator")
    @SequenceGenerator(
            name = "user_generator",
            sequenceName = "user_sequence"
    )
    private Long id;

    @NotBlank
    @Column(name="username", unique = true, nullable = false)
    private String username;

    @Size(min = 5, max = 50)
    //panjang nama (maks varchar (50))
    private String name;

    //Getter and Setter

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}
