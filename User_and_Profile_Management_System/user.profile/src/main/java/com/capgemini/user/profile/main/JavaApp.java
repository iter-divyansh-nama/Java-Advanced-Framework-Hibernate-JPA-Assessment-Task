package com.capgemini.user.profile.main;



import java.util.Scanner;

import com.capgemini.user.profile.dao.UserDAO;
import com.capgemini.user.profile.entity.Profile;
import com.capgemini.user.profile.entity.User;

public class JavaApp {

    public static void execute() {

        Scanner sc = new Scanner(System.in);
        UserDAO dao = new UserDAO();

        while(true)
        {

            System.out.println("1 Add User");
            System.out.println("2 Search User");
            System.out.println("3 Update Email");
            System.out.println("4 Update Profile");
            System.out.println("5 Delete User");
            System.out.println("6 Exit");

            int choice = sc.nextInt();
            sc.nextLine();

            switch(choice)
            {

            case 1:

                System.out.println("Enter Username:");
                String username = sc.nextLine();

                System.out.println("Enter Email:");
                String email = sc.nextLine();

                System.out.println("Enter Phone:");
                String phone = sc.nextLine();

                System.out.println("Enter Gender:");
                String gender = sc.nextLine();

                System.out.println("Enter DOB (yyyy-MM-dd):");
                String dob = sc.nextLine();

                Profile profile = new Profile(phone, gender, dob);
                User user = new User(username, email, profile);

                dao.addUser(user);

                break;

            case 2:

                System.out.println("Enter ID:");
                int id = sc.nextInt();

                User u = dao.getUser(id);

                if(u != null)
                {
                    System.out.println("ID: " + u.getId());
                    System.out.println("Username: " + u.getUsername());
                    System.out.println("Email: " + u.getEmail());

                    System.out.println("Profile:");
                    System.out.println("Phone: " + u.getProfile().getPhone());
                    System.out.println("Gender: " + u.getProfile().getGender());
                    System.out.println("DOB: " + u.getProfile().getDob());
                }

                break;

            case 3:

                System.out.println("Enter ID:");
                int uid = sc.nextInt();
                sc.nextLine();

                System.out.println("Enter New Email:");
                String newEmail = sc.nextLine();

                dao.updateEmail(uid, newEmail);

                break;

            case 4:

                System.out.println("Enter ID:");
                int pid = sc.nextInt();
                sc.nextLine();

                System.out.println("Enter Phone:");
                String ph = sc.nextLine();

                System.out.println("Enter Gender:");
                String g = sc.nextLine();

                System.out.println("Enter DOB:");
                String d = sc.nextLine();

                dao.updateProfile(pid, ph, g, d);

                break;

            case 5:

                System.out.println("Enter ID:");
                dao.deleteUser(sc.nextInt());

                break;

            case 6:

                System.exit(0);
            }

        }

    }
}
