package com.capgemini.author.management.dao;

import com.capgemini.author.management.entity.Author;

import jakarta.persistence.*;

public class AuthorDAO {

    EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("author-unit");

    EntityManager em = emf.createEntityManager();

    public void addAuthor(Author author) {

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        em.persist(author);

        tx.commit();

        System.out.println("Author added successfully");
    }

    public Author getAuthor(Integer id) {

        Author author = em.find(Author.class, id);

        if(author == null)
            System.out.println("No author found");

        return author;
    }

    public void updateBiography(Integer id,String summary,String birthPlace,String birthDate) {

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        Author author = em.find(Author.class,id);

        if(author != null)
        {
            author.getBiography().setSummary(summary);
            author.getBiography().setBirthPlace(birthPlace);
            author.getBiography().setBirthDate(birthDate);

            em.merge(author);

            System.out.println("Biography updated successfully");
        }
        else
            System.out.println("No author found");

        tx.commit();
    }

    public void deleteAuthor(Integer id) {

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        Author author = em.find(Author.class,id);

        if(author != null)
        {
            em.remove(author);
            System.out.println("Author deleted successfully");
        }
        else
            System.out.println("No author found");

        tx.commit();
    }
}