package com.capgemini.customer.wallet.main;

import java.util.Scanner;

import com.capgemini.customer.wallet.dao.CustomerDAO;
import com.capgemini.customer.wallet.entity.Customer;
import com.capgemini.customer.wallet.entity.Wallet;

public class JavaApp {

    public static void execute() {

        Scanner sc = new Scanner(System.in);
        CustomerDAO dao = new CustomerDAO();

        while(true) {

            System.out.println("1 Add Customer");
            System.out.println("2 Search Customer");
            System.out.println("3 Update Wallet Balance");
            System.out.println("4 Delete Customer");
            System.out.println("5 Exit");

            int choice = sc.nextInt();
            sc.nextLine();

            switch(choice) {

            case 1:

                System.out.println("Enter Name:");
                String name = sc.nextLine();

                System.out.println("Enter Email:");
                String email = sc.nextLine();

                System.out.println("Enter Balance:");
                Double balance = sc.nextDouble();
                sc.nextLine();

                System.out.println("Enter Currency:");
                String currency = sc.nextLine();

                Wallet wallet = new Wallet(balance, currency);
                Customer customer = new Customer(name, email, wallet);

                dao.addCustomer(customer);

                break;

            case 2:

                System.out.println("Enter ID:");
                Integer id = sc.nextInt();

                Customer c = dao.getCustomer(id);

                if(c != null) {

                    System.out.println("ID: " + c.getId());
                    System.out.println("Name: " + c.getName());
                    System.out.println("Email: " + c.getEmail());

                    System.out.println("Wallet:");
                    System.out.println("Balance: " + c.getWallet().getBalance());
                    System.out.println("Currency: " + c.getWallet().getCurrency());
                }

                break;

            case 3:

                System.out.println("Enter Customer ID:");
                Integer cid = sc.nextInt();

                System.out.println("Enter New Balance:");
                Double newBalance = sc.nextDouble();

                dao.updateWalletBalance(cid, newBalance);

                break;

            case 4:

                System.out.println("Enter ID:");
                dao.deleteCustomer(sc.nextInt());

                break;

            case 5:

                System.exit(0);
            }
        }
    }
}