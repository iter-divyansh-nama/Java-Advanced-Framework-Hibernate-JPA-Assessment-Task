package com.capgemini.vehicle.registration.entity;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.*;

@Entity
public class Vehicle implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String brand;
    private String model;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "registration_id")
    private Registration registration;

    public Vehicle() {}

    public Vehicle(String brand, String model, Registration registration) {
        this.brand = brand;
        this.model = model;
        this.registration = registration;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Registration getRegistration() {
        return registration;
    }

    public void setRegistration(Registration registration) {
        this.registration = registration;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, brand, model);
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj)
            return true;

        if (obj == null || getClass() != obj.getClass())
            return false;

        Vehicle other = (Vehicle) obj;

        return Objects.equals(id, other.id);
    }

    @Override
    public String toString() {
        return "Vehicle [id=" + id +
                ", brand=" + brand +
                ", model=" + model +
                ", registration=" + registration + "]";
    }
}