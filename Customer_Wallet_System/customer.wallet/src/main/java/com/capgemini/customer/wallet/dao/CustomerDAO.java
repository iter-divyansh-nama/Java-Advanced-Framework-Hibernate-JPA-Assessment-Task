package com.capgemini.customer.wallet.dao;

import com.capgemini.customer.wallet.entity.Customer;
import jakarta.persistence.*;

public class CustomerDAO {

    EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("customer-unit");

    EntityManager em = emf.createEntityManager();

    public void addCustomer(Customer customer) {

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        em.persist(customer);

        tx.commit();

        System.out.println("Customer added successfully");
    }

    public Customer getCustomer(Integer id) {

        Customer customer = em.find(Customer.class, id);

        if(customer == null)
            System.out.println("No customer found");

        return customer;
    }

    public void updateWalletBalance(Integer id, Double newBalance) {

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        Customer customer = em.find(Customer.class, id);

        if(customer != null) {

            customer.getWallet().setBalance(newBalance);

            em.merge(customer);

            System.out.println("Wallet updated successfully");
        }
        else
            System.out.println("No customer found");

        tx.commit();
    }

    public void deleteCustomer(Integer id) {

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        Customer customer = em.find(Customer.class, id);

        if(customer != null) {

            em.remove(customer);

            System.out.println("Customer deleted successfully");
        }
        else
            System.out.println("No customer found");

        tx.commit();
    }
}