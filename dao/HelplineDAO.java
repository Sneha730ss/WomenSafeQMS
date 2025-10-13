package com.WomenSafeQMS.dao;

import java.sql.*;
import java.util.*;
import com.WomenSafeQMS.config.DBConnection;
import com.WomenSafeQMS.model.HelplineContact;

public class HelplineDAO {
	// ADD Helpline
    public void addHelpline(HelplineContact h) {
        String sql = "INSERT INTO helpline_contacts (department_name, contact_number) VALUES (?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setString(1, h.getDepartmentName());
            pst.setString(2, h.getContactNumber());
            pst.executeUpdate();
            System.out.println("✅ Helpline added successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // VIEW all Helplines
    public List<HelplineContact> getAllHelplines() {
        List<HelplineContact> list = new ArrayList<>();
        String sql = "SELECT * FROM helpline_contacts";
        try (Connection conn = DBConnection.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                HelplineContact h = new HelplineContact();
                h.setHelplineId(rs.getInt("helpline_id"));
                h.setDepartmentName(rs.getString("department_name"));
                h.setContactNumber(rs.getString("contact_number"));
                list.add(h);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    // UPDATE Helpline
    public void updateHelpline(int id, String newContact) {
        String sql = "UPDATE helpline_contacts SET contact_number = ? WHERE helpline_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setString(1, newContact);
            pst.setInt(2, id);
            int rows = pst.executeUpdate();
            if (rows > 0)
                System.out.println("✅ Helpline updated successfully!");
            else
                System.out.println("⚠️ Helpline not found!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // DELETE Helpline
    public void deleteHelpline(int id) {
        String sql = "DELETE FROM helpline_contacts WHERE helpline_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setInt(1, id);
            int rows = pst.executeUpdate();
            if (rows > 0)
                System.out.println("🗑️ Helpline deleted successfully!");
            else
                System.out.println("⚠️ Helpline not found!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
