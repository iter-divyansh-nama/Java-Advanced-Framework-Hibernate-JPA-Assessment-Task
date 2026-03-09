package dao;

import entity.Product;
import util.JPAUtil;

import jakarta.persistence.*;
import java.util.List;

public class ProductDAO {

    public void addProduct(Product p) {

        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        em.persist(p);
        tx.commit();

        em.close();

        System.out.println("Product added successfully.");
    }

    public List<Product> getAllProducts() {

        EntityManager em = JPAUtil.getEntityManager();

        TypedQuery<Product> query =
                em.createQuery("SELECT p FROM Product p", Product.class);

        return query.getResultList();
    }

    public Product getProductById(int id) {

        EntityManager em = JPAUtil.getEntityManager();
        return em.find(Product.class, id);
    }

    public List<Product> getProductsByCategory(String category) {

        EntityManager em = JPAUtil.getEntityManager();

        TypedQuery<Product> query =
                em.createQuery(
                "SELECT p FROM Product p WHERE p.category=:cat",
                Product.class);

        query.setParameter("cat", category);

        return query.getResultList();
    }

    public void updateProductPrice(int id, double newPrice) {

        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();

        Product p = em.find(Product.class, id);

        if(p != null) {

            tx.begin();
            p.setPrice(newPrice);
            em.merge(p);
            tx.commit();

            System.out.println("Product price updated successfully.");
        }
        else
            System.out.println("No product found.");

        em.close();
    }

    public void deleteProduct(int id) {

        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();

        Product p = em.find(Product.class, id);

        if(p != null) {

            tx.begin();
            em.remove(p);
            tx.commit();

            System.out.println("Product deleted successfully.");
        }
        else
            System.out.println("No product found.");

        em.close();
    }
}