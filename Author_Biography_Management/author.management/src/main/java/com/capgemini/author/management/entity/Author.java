package com.capgemini.author.management.entity;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.*;

@Entity
public class Author implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String email;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "biography_id")
    private Biography biography;

    public Author() {}

    public Author(String name, String email, Biography biography) {
        this.name = name;
        this.email = email;
        this.biography = biography;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Biography getBiography() {
        return biography;
    }

    public void setBiography(Biography biography) {
        this.biography = biography;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, email);
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj)
            return true;

        if (obj == null || getClass() != obj.getClass())
            return false;

        Author other = (Author) obj;

        return Objects.equals(id, other.id);
    }

    @Override
    public String toString() {
        return "Author [id=" + id +
                ", name=" + name +
                ", email=" + email +
                ", biography=" + biography + "]";
    }
}