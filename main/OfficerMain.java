package com.WomenSafeQMS.main;

import java.util.List;
import java.util.Scanner;
import com.WomenSafeQMS.dao.OfficerDAO;
import com.WomenSafeQMS.model.Officer;

public class OfficerMain {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        OfficerDAO dao = new OfficerDAO();

        while (true) {
            System.out.println("\n===== WomenSafeQ Officer Management =====");
            System.out.println("1. Add Officer");
            System.out.println("2. View All Officers");
            System.out.println("3. Update Officer Phone");
            System.out.println("4. Delete Officer");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int ch = sc.nextInt();
            sc.nextLine();

            switch (ch) {
                case 1:
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Designation: ");
                    String desig = sc.nextLine();
                    System.out.print("Enter Phone: ");
                    String phone = sc.nextLine();
                    System.out.print("Enter Email: ");
                    String email = sc.nextLine();
                    dao.addOfficer(new Officer(name, desig, phone, email));
                    break;

                case 2:
                    List<Officer> list = dao.getAllOfficers();
                    System.out.println("\n--- Officers List ---");
                    for (Officer o : list) {
                        System.out.println("ID: " + o.getOfficerId());
                        System.out.println("Name: " + o.getName());
                        System.out.println("Designation: " + o.getDesignation());
                        System.out.println("Phone: " + o.getPhone());
                        System.out.println("Email: " + o.getEmail());
                        System.out.println("--------------------");
                    }
                    break;

                case 3:
                    System.out.print("Enter Officer ID to Update: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter New Phone Number: ");
                    String newPhone = sc.nextLine();
                    dao.updateOfficerPhone(id, newPhone);
                    break;

                case 4:
                    System.out.print("Enter Officer ID to Delete: ");
                    int delId = sc.nextInt();
                    dao.deleteOfficer(delId);
                    break;

                case 5:
                    System.out.println("🚪 Exiting Officer Management...");
                    sc.close();
                    System.exit(0);

                default:
                    System.out.println("❌ Invalid choice!");
            }
        }
    }

}
