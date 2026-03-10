package com.capgemini.vehicle.registration.entity;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.*;

@Entity
public class Registration implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String registrationNumber;
    private String expiryDate;

    @OneToOne(mappedBy = "registration")
    private Vehicle vehicle;

    public Registration() {}

    public Registration(String registrationNumber, String expiryDate) {
        this.registrationNumber = registrationNumber;
        this.expiryDate = expiryDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, registrationNumber, expiryDate);
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj)
            return true;

        if (obj == null || getClass() != obj.getClass())
            return false;

        Registration other = (Registration) obj;

        return Objects.equals(id, other.id);
    }

    @Override
    public String toString() {
        return "Registration [registrationNumber=" + registrationNumber +
                ", expiryDate=" + expiryDate + "]";
    }
}