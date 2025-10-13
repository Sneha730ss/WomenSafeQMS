package com.WomenSafeQMS.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.WomenSafeQMS.config.DBConnection;
import com.WomenSafeQMS.model.Complaint;

public class ComplaintDAO {
	// ADD Complaint
    public void addComplaint(Complaint complaint) {
        String sql = "INSERT INTO complaints (woman_id, complaint_details, status) VALUES (?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setInt(1, complaint.getWomanId());
            pst.setString(2, complaint.getComplaintDetails());
            pst.setString(3, complaint.getStatus());
            pst.executeUpdate();
            System.out.println("✅ Complaint added successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // VIEW all complaints
    public List<Complaint> getAllComplaints() {
        List<Complaint> complaints = new ArrayList<>();
        String sql = "SELECT * FROM complaints";
        try (Connection conn = DBConnection.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                Complaint c = new Complaint();
                c.setComplaintId(rs.getInt("complaint_id"));
                c.setWomanId(rs.getInt("woman_id"));
                c.setComplaintDetails(rs.getString("complaint_details"));
                c.setDateFiled(rs.getString("date_filed"));
                c.setStatus(rs.getString("status"));
                complaints.add(c);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return complaints;
    }
    // UPDATE complaint status
    public void updateComplaintStatus(int complaintId, String newStatus) {
        String sql = "UPDATE complaints SET status = ? WHERE complaint_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setString(1, newStatus);
            pst.setInt(2, complaintId);
            int rows = pst.executeUpdate();
            if (rows > 0) {
                System.out.println("✅ Complaint status updated successfully!");
            } else {
                System.out.println("⚠️ Complaint not found!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // DELETE complaint
    public void deleteComplaint(int complaintId) {
        String sql = "DELETE FROM complaints WHERE complaint_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setInt(1, complaintId);
            int rows = pst.executeUpdate();
            if (rows > 0) {
                System.out.println("🗑️ Complaint deleted successfully!");
            } else {
                System.out.println("⚠️ Complaint not found!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
