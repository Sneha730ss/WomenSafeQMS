package com.WomenSafeQMS.main;

import java.util.List;
import java.util.Scanner;
import com.WomenSafeQMS.dao.HelplineDAO;
import com.WomenSafeQMS.model.HelplineContact;

public class HelplineMain {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HelplineDAO dao = new HelplineDAO();

        while (true) {
            System.out.println("\n===== WomenSafeQ Helpline Management =====");
            System.out.println("1. Add Helpline");
            System.out.println("2. View All Helplines");
            System.out.println("3. Update Helpline Number");
            System.out.println("4. Delete Helpline");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int ch = sc.nextInt();
            sc.nextLine();

            switch (ch) {
                case 1:
                    System.out.print("Enter Department Name: ");
                    String dept = sc.nextLine();
                    System.out.print("Enter Contact Number: ");
                    String contact = sc.nextLine();
                    dao.addHelpline(new HelplineContact(dept, contact));
                    break;

                case 2:
                    List<HelplineContact> list = dao.getAllHelplines();
                    System.out.println("\n--- Helpline Contacts ---");
                    for (HelplineContact h : list) {
                        System.out.println("ID: " + h.getHelplineId());
                        System.out.println("Department: " + h.getDepartmentName());
                        System.out.println("Contact: " + h.getContactNumber());
                        System.out.println("------------------------");
                    }
                    break;

                case 3:
                    System.out.print("Enter Helpline ID to Update: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter New Contact Number: ");
                    String newNum = sc.nextLine();
                    dao.updateHelpline(id, newNum);
                    break;

                case 4:
                    System.out.print("Enter Helpline ID to Delete: ");
                    int delId = sc.nextInt();
                    dao.deleteHelpline(delId);
                    break;

                case 5:
                    System.out.println("🚪 Exiting Helpline Management...");
                    sc.close();
                    System.exit(0);

                default:
                    System.out.println("❌ Invalid choice!");
            }
        }
    }

}
