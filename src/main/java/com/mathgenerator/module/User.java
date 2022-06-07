package com.mathgenerator.module;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;


@Entity
@Table(name="users")
public class User {
    @Id
    @Column(name="id", nullable=false)
    private UUID id;
    @Column(name="name")
    private String name;
    @Column(name="email")
    private String email;
    @Column(name="password")
    private String password;
    public User(UUID id, String name, String email, String password){
        this.id = id;
        this.name = name;
        this.email =email;
        this.password = password;
    }

    public User() {

    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
