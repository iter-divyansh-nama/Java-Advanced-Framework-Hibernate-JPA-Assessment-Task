package com.capgemini.user.profile.entity;



import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.*;

@Entity
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String username;
    private String email;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "profile_id")
    private Profile profile;

    public User() {
    }

    public User(Integer id, String username, String email, Profile profile) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.profile = profile;
    }

    public User(String username, String email, Profile profile) {
        this.username = username;
        this.email = email;
        this.profile = profile;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, id, username);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (obj == null || getClass() != obj.getClass())
            return false;

        User other = (User) obj;

        return Objects.equals(id, other.id)
                && Objects.equals(username, other.username)
                && Objects.equals(email, other.email);
    }

    @Override
    public String toString() {
        return "User [id=" + id +
                ", username=" + username +
                ", email=" + email +
                ", profile=" + profile + "]";
    }
}