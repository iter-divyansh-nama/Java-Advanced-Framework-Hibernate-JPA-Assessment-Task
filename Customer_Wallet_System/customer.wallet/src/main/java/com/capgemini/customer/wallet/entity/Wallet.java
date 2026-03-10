package com.capgemini.customer.wallet.entity;

import java.io.Serializable;
import java.util.Objects;
import jakarta.persistence.*;

@Entity
public class Wallet implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Double balance;
    private String currency;

    @OneToOne(mappedBy = "wallet")
    private Customer customer;

    public Wallet() {}

    public Wallet(Double balance, String currency) {
        this.balance = balance;
        this.currency = currency;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, balance, currency);
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Wallet other = (Wallet) obj;

        return Objects.equals(id, other.id);
    }

    @Override
    public String toString() {
        return "Wallet [balance=" + balance +
                ", currency=" + currency + "]";
    }
}