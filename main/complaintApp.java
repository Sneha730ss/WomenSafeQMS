package com.WomenSafeQMS.main;

import java.util.List;
import java.util.Scanner;
import com.WomenSafeQMS.dao.ComplaintDAO;
import com.WomenSafeQMS.model.Complaint;

public class complaintApp {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ComplaintDAO complaintDAO = new ComplaintDAO();

        while (true) {
            System.out.println("\n===== WomenSafeQ Management System =====");
            System.out.println("1. Add Complaint");
            System.out.println("2. View All Complaints");
            System.out.println("3. Update Complaint Status");
            System.out.println("4. Delete Complaint");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Woman ID: ");
                    int womanId = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Complaint Details: ");
                    String details = sc.nextLine();
                    System.out.print("Enter Status (Pending/Resolved): ");
                    String status = sc.nextLine();
                    Complaint complaint = new Complaint(womanId, details, status);
                    complaintDAO.addComplaint(complaint);
                    break;

                case 2:
                    List<Complaint> list = complaintDAO.getAllComplaints();
                    System.out.println("\n--- All Complaints ---");
                    for (Complaint c : list) {
                        System.out.println("Complaint ID: " + c.getComplaintId());
                        System.out.println("Woman ID: " + c.getWomanId());
                        System.out.println("Details: " + c.getComplaintDetails());
                        System.out.println("Date Filed: " + c.getDateFiled());
                        System.out.println("Status: " + c.getStatus());
                        System.out.println("----------------------");
                    }
                    break;

                case 3:
                    System.out.println("Exiting...");
                    sc.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

}
