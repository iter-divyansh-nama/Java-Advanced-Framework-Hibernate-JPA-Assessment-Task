package com.capgemini.vehicle.registration.main;

import java.util.Scanner;

import com.capgemini.vehicle.registration.dao.VehicleDAO;
import com.capgemini.vehicle.registration.entity.Registration;
import com.capgemini.vehicle.registration.entity.Vehicle;

public class JavaApp {

    public static void execute() {

        Scanner sc = new Scanner(System.in);
        VehicleDAO dao = new VehicleDAO();

        while(true)
        {

            System.out.println("1 Add Vehicle");
            System.out.println("2 Search Vehicle");
            System.out.println("3 Update Registration Expiry");
            System.out.println("4 Delete Vehicle");
            System.out.println("5 Exit");

            int choice = sc.nextInt();
            sc.nextLine();

            switch(choice)
            {

            case 1:

                System.out.println("Enter Brand:");
                String brand = sc.nextLine();

                System.out.println("Enter Model:");
                String model = sc.nextLine();

                System.out.println("Enter Registration Number:");
                String number = sc.nextLine();

                System.out.println("Enter Expiry Date:");
                String expiry = sc.nextLine();

                Registration reg = new Registration(number,expiry);
                Vehicle vehicle = new Vehicle(brand,model,reg);

                dao.addVehicle(vehicle);

                break;

            case 2:

                System.out.println("Enter ID:");
                Integer id = sc.nextInt();

                Vehicle v = dao.getVehicle(id);

                if(v != null)
                {
                    System.out.println("ID: " + v.getId());
                    System.out.println("Brand: " + v.getBrand());
                    System.out.println("Model: " + v.getModel());

                    System.out.println("Registration:");
                    System.out.println("Number: " + v.getRegistration().getRegistrationNumber());
                    System.out.println("Expiry Date: " + v.getRegistration().getExpiryDate());
                }

                break;

            case 3:

                System.out.println("Enter Vehicle ID:");
                Integer vid = sc.nextInt();
                sc.nextLine();

                System.out.println("Enter New Expiry Date:");
                String newExpiry = sc.nextLine();

                dao.updateExpiry(vid,newExpiry);

                break;

            case 4:

                System.out.println("Enter ID:");
                dao.deleteVehicle(sc.nextInt());

                break;

            case 5:

                System.exit(0);
            }
        }
    }
}