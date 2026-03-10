package com.capgemini.customer.wallet.entity;

import java.io.Serializable;
import java.util.Objects;
import jakarta.persistence.*;

@Entity
public class Customer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String email;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "wallet_id")
    private Wallet wallet;

    public Customer() {}

    public Customer(String name, String email, Wallet wallet) {
        this.name = name;
        this.email = email;
        this.wallet = wallet;
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

    public Wallet getWallet() {
        return wallet;
    }

    public void setWallet(Wallet wallet) {
        this.wallet = wallet;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, email);
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Customer other = (Customer) obj;

        return Objects.equals(id, other.id);
    }

    @Override
    public String toString() {
        return "Customer [id=" + id +
                ", name=" + name +
                ", email=" + email +
                ", wallet=" + wallet + "]";
    }
}