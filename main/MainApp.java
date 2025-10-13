package com.WomenSafeQMS.main;

import com.WomenSafeQMS.dao.WomanDAO;
import com.WomenSafeQMS.model.Woman;


import java.util.*;

public class MainApp {
	public static void main(String[] args) {
        WomanDAO dao = new WomanDAO();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== WomenSafeQ Management System =====");
            System.out.println("1. Add Woman");
            System.out.println("2. View All Women");
            System.out.println("3. Update Woman");
            System.out.println("4. Delete Woman");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            int ch = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (ch) {
                case 1:
                    System.out.print("Full Name: ");
                    String name = sc.nextLine();
                    System.out.print("Age: ");
                    int age = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Mobile Number: ");
                    String mobile = sc.nextLine();
                    System.out.print("Email: ");
                    String email = sc.nextLine();
                    System.out.print("Address: ");
                    String address = sc.nextLine();
                    Woman w = new Woman(name, age, mobile, email, address);
                    dao.addWoman(w);
                    break;

                case 2:
                    List<Woman> list = dao.getAllWomen();
                    for (Woman ww : list) {
                        System.out.println("ID: " + ww.getWomanId() + " | Name: " + ww.getFullName() +
                                " | Age: " + ww.getAge() + " | Mobile: " + ww.getMobileNumber() +
                                " | Email: " + ww.getEmail() + " | Address: " + ww.getAddress());
                    }
                    break;

                case 3:
                    System.out.print("Enter Woman ID to update: ");
                    int uid = sc.nextInt(); sc.nextLine();
                    System.out.print("New Name: ");
                    String n = sc.nextLine();
                    System.out.print("New Age: ");
                    int a = sc.nextInt(); sc.nextLine();
                    System.out.print("New Mobile: ");
                    String m = sc.nextLine();
                    System.out.print("New Email: ");
                    String e = sc.nextLine();
                    System.out.print("New Address: ");
                    String ad = sc.nextLine();
                    Woman w2 = new Woman(n, a, m, e, ad);
                    w2.setWomanId(uid);
                    dao.updateWoman(w2);
                    break;

                case 4:
                    System.out.print("Enter ID to delete: ");
                    int did = sc.nextInt();
                    dao.deleteWoman(did);
                    break;

                case 5:
                    System.out.println("Exiting... Thank You!");
                    sc.close();
                    System.exit(0);
            }
        }
    }

}
