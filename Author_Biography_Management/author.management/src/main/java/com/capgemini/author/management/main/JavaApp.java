package com.capgemini.author.management.main;

import java.util.Scanner;

import com.capgemini.author.management.dao.AuthorDAO;
import com.capgemini.author.management.entity.Author;
import com.capgemini.author.management.entity.Biography;

public class JavaApp {

    public static void execute() {

        Scanner sc = new Scanner(System.in);
        AuthorDAO dao = new AuthorDAO();

        while(true)
        {
            System.out.println("1 Add Author");
            System.out.println("2 Search Author");
            System.out.println("3 Update Biography");
            System.out.println("4 Delete Author");
            System.out.println("5 Exit");

            int choice = sc.nextInt();
            sc.nextLine();

            switch(choice)
            {

            case 1:

                System.out.println("Enter Name:");
                String name = sc.nextLine();

                System.out.println("Enter Email:");
                String email = sc.nextLine();

                System.out.println("Enter Summary:");
                String summary = sc.nextLine();

                System.out.println("Enter Birth Place:");
                String birthPlace = sc.nextLine();

                System.out.println("Enter Birth Date:");
                String birthDate = sc.nextLine();

                Biography bio = new Biography(summary,birthPlace,birthDate);
                Author author = new Author(name,email,bio);

                dao.addAuthor(author);

                break;

            case 2:

                System.out.println("Enter ID:");
                Integer id = sc.nextInt();

                Author a = dao.getAuthor(id);

                if(a != null)
                {
                    System.out.println("ID: " + a.getId());
                    System.out.println("Name: " + a.getName());
                    System.out.println("Email: " + a.getEmail());

                    System.out.println("Biography:");
                    System.out.println("Summary: " + a.getBiography().getSummary());
                    System.out.println("Birth Place: " + a.getBiography().getBirthPlace());
                    System.out.println("Birth Date: " + a.getBiography().getBirthDate());
                }

                break;

            case 3:

                System.out.println("Enter Author ID:");
                Integer aid = sc.nextInt();
                sc.nextLine();

                System.out.println("Enter Summary:");
                String s = sc.nextLine();

                System.out.println("Enter Birth Place:");
                String bp = sc.nextLine();

                System.out.println("Enter Birth Date:");
                String bd = sc.nextLine();

                dao.updateBiography(aid,s,bp,bd);

                break;

            case 4:

                System.out.println("Enter ID:");
                dao.deleteAuthor(sc.nextInt());

                break;

            case 5:

                System.exit(0);
            }
        }
    }
}