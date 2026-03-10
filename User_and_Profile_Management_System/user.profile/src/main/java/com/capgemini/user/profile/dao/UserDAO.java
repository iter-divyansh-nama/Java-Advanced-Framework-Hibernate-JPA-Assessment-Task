package com.capgemini.user.profile.dao;


import com.capgemini.user.profile.entity.User;
import jakarta.persistence.*;

public class UserDAO {

    EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("user-unit");

    EntityManager em = emf.createEntityManager();

    public void addUser(User user) {

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        em.persist(user);

        tx.commit();

        System.out.println("User added successfully");
    }

    public User getUser(int id) {

        User user = em.find(User.class, id);

        if(user == null)
        {
            System.out.println("No user found");
        }

        return user;
    }

    public void updateEmail(int id, String email) {

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        User user = em.find(User.class, id);

        if(user != null)
        {
            user.setEmail(email);
            em.merge(user);

            System.out.println("Email updated successfully");
        }
        else
        {
            System.out.println("No user found");
        }

        tx.commit();
    }

    public void updateProfile(int id, String phone, String gender, String dob) {

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        User user = em.find(User.class, id);

        if(user != null)
        {
            user.getProfile().setPhone(phone);
            user.getProfile().setGender(gender);
            user.getProfile().setDob(dob);

            em.merge(user);

            System.out.println("Profile updated successfully");
        }
        else
        {
            System.out.println("No user found");
        }

        tx.commit();
    }

    public void deleteUser(int id) {

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        User user = em.find(User.class, id);

        if(user != null)
        {
            em.remove(user);
            System.out.println("User deleted successfully");
        }
        else
        {
            System.out.println("No user found");
        }

        tx.commit();
    }
}
