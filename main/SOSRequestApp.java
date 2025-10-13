package com.WomenSafeQMS.main;

import java.util.List;
import java.util.Scanner;
import com.WomenSafeQMS.dao.SOSRequestDAO;
import com.WomenSafeQMS.model.SOSRequest;

public class SOSRequestApp{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SOSRequestDAO dao = new SOSRequestDAO();

        while (true) {
            System.out.println("\n===== WomenSafeQ SOS Management =====");
            System.out.println("1. Add SOS Request");
            System.out.println("2. View All SOS Requests");
            System.out.println("3. Mark SOS as Resolved");
            System.out.println("4. Delete SOS Request");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int ch = sc.nextInt();
            sc.nextLine(); // clear buffer

            switch (ch) {
                case 1:
                    SOSRequest sos = new SOSRequest();
                    System.out.print("Enter Woman ID: ");
                    sos.setWomanId(sc.nextInt());
                    sc.nextLine();
                    System.out.print("Enter Location: ");
                    sos.setLocation(sc.nextLine());
                    sos.setResolved(false);
                    dao.addSOSRequest(sos);
                    break;

                case 2:
                    List<SOSRequest> list = dao.getAllSOSRequests();
                    System.out.println("\n--- SOS Requests List ---");
                    for (SOSRequest s : list) {
                        System.out.println("SOS ID: " + s.getSosId());
                        System.out.println("Woman ID: " + s.getWomanId());
                        System.out.println("Location: " + s.getLocation());
                        System.out.println("Time: " + s.getTimestamp());
                        System.out.println("Resolved: " + s.isResolved());
                        System.out.println("------------------------");
                    }
                    break;

                case 3:
                    System.out.print("Enter SOS ID to mark resolved: ");
                    int sosId = sc.nextInt();
                    dao.updateResolvedStatus(sosId, true);
                    break;

                case 4:
                    System.out.print("Enter SOS ID to delete: ");
                    int delId = sc.nextInt();
                    dao.deleteSOSRequest(delId);
                    break;

                case 5:
                    System.out.println("🚪 Exiting SOS Management...");
                    sc.close();
                    System.exit(0);

                default:
                    System.out.println("❌ Invalid choice!");
            }
        }
    }
}
