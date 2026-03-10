package com.capgemini.user.profile.entity;


import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.*;

@Entity
public class Profile implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String phone;
    private String gender;
    private String dob;

    @OneToOne(mappedBy = "profile")
    private User user;

    public Profile() {
    }

    public Profile(Integer id, String phone, String gender, String dob) {
        this.id = id;
        this.phone = phone;
        this.gender = gender;
        this.dob = dob;
    }

    public Profile(String phone, String gender, String dob) {
        this.phone = phone;
        this.gender = gender;
        this.dob = dob;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public int hashCode() {
        return Objects.hash(dob, gender, id, phone);
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj)
            return true;

        if (obj == null || getClass() != obj.getClass())
            return false;

        Profile other = (Profile) obj;

        return Objects.equals(id, other.id)
                && Objects.equals(phone, other.phone)
                && Objects.equals(gender, other.gender)
                && Objects.equals(dob, other.dob);
    }

    @Override
    public String toString() {
        return "Profile [id=" + id +
                ", phone=" + phone +
                ", gender=" + gender +
                ", dob=" + dob + "]";
    }
}