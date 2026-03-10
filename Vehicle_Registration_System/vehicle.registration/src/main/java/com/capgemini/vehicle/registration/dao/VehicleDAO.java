package com.capgemini.vehicle.registration.dao;

import com.capgemini.vehicle.registration.entity.Vehicle;

import jakarta.persistence.*;

public class VehicleDAO {

    EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("vehicle-unit");

    EntityManager em = emf.createEntityManager();

    public void addVehicle(Vehicle vehicle) {

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        em.persist(vehicle);

        tx.commit();

        System.out.println("Vehicle added successfully");
    }

    public Vehicle getVehicle(Integer id) {

        Vehicle vehicle = em.find(Vehicle.class, id);

        if(vehicle == null)
            System.out.println("No vehicle found");

        return vehicle;
    }

    public void updateExpiry(Integer id,String newExpiry) {

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        Vehicle vehicle = em.find(Vehicle.class,id);

        if(vehicle != null)
        {
            vehicle.getRegistration().setExpiryDate(newExpiry);

            em.merge(vehicle);

            System.out.println("Registration updated successfully");
        }
        else
            System.out.println("No vehicle found");

        tx.commit();
    }

    public void deleteVehicle(Integer id) {

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        Vehicle vehicle = em.find(Vehicle.class,id);

        if(vehicle != null)
        {
            em.remove(vehicle);
            System.out.println("Vehicle deleted successfully");
        }
        else
            System.out.println("No vehicle found");

        tx.commit();
    }
}