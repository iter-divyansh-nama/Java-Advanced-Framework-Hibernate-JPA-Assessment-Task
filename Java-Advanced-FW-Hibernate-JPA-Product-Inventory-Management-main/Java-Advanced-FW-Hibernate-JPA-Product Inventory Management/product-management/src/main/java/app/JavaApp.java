package app;

import dao.ProductDAO;
import entity.Product;

import java.util.List;
import java.util.Scanner;

public class JavaApp {

    public static void execution1() {

        Scanner sc = new Scanner(System.in);
        ProductDAO dao = new ProductDAO();

        while(true) {

            System.out.println("1 Add Product");
            System.out.println("2 View All");
            System.out.println("3 Search By ID");
            System.out.println("4 Search By Category");
            System.out.println("5 Update Price");
            System.out.println("6 Delete Product");
            System.out.println("7 Exit");

            int choice = sc.nextInt();

            switch(choice) {

            case 1:

                sc.nextLine();

                System.out.println("Name:");
                String name = sc.nextLine();

                System.out.println("Category:");
                String category = sc.nextLine();

                System.out.println("Price:");
                double price = sc.nextDouble();

                System.out.println("Quantity:");
                int qty = sc.nextInt();

                Product p = new Product(name,category,price,qty);

                dao.addProduct(p);

                break;

            case 2:

                List<Product> list = dao.getAllProducts();

                if(list.isEmpty())
                    System.out.println("No product found.");

                for(Product pr : list) {

                    System.out.println("ID: "+pr.getId());
                    System.out.println("Name: "+pr.getName());
                    System.out.println("Category: "+pr.getCategory());
                    System.out.println("Price: "+pr.getPrice());
                    System.out.println("Quantity: "+pr.getQuantity());
                    System.out.println();
                }

                break;

            case 3:

                System.out.println("Enter ID:");
                int id = sc.nextInt();

                Product prod = dao.getProductById(id);

                if(prod == null)
                    System.out.println("No product found.");
                else {
                    System.out.println("ID: "+prod.getId());
                    System.out.println("Name: "+prod.getName());
                    System.out.println("Category: "+prod.getCategory());
                    System.out.println("Price: "+prod.getPrice());
                    System.out.println("Quantity: "+prod.getQuantity());
                }

                break;

            case 4:

                sc.nextLine();
                System.out.println("Enter Category:");
                String cat = sc.nextLine();

                List<Product> catList = dao.getProductsByCategory(cat);

                if(catList.isEmpty())
                    System.out.println("No product found.");

                for(Product pr : catList) {

                    System.out.println("ID: "+pr.getId());
                    System.out.println("Name: "+pr.getName());
                    System.out.println("Category: "+pr.getCategory());
                    System.out.println("Price: "+pr.getPrice());
                    System.out.println("Quantity: "+pr.getQuantity());
                    System.out.println();
                }

                break;

            case 5:

                System.out.println("Enter Product ID:");
                int pid = sc.nextInt();

                System.out.println("Enter New Price:");
                double newPrice = sc.nextDouble();

                dao.updateProductPrice(pid, newPrice);

                break;

            case 6:

                System.out.println("Enter Product ID:");
                int did = sc.nextInt();

                dao.deleteProduct(did);

                break;

            case 7:
                System.exit(0);

            }

        }
    }

    public static void main(String[] args) {

        execution1();
    }
}