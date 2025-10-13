package com.WomenSafeQMS.dao;

import java.sql.*;
import java.util.*;
import com.WomenSafeQMS.config.DBConnection;
import com.WomenSafeQMS.model.Officer;

public class OfficerDAO {
	// ADD Officer
    public void addOfficer(Officer o) {
        String sql = "INSERT INTO officers (name, designation, phone, email) VALUES (?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setString(1, o.getName());
            pst.setString(2, o.getDesignation());
            pst.setString(3, o.getPhone());
            pst.setString(4, o.getEmail());
            pst.executeUpdate();
            System.out.println("✅ Officer added successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // VIEW all Officers
    public List<Officer> getAllOfficers() {
        List<Officer> list = new ArrayList<>();
        String sql = "SELECT * FROM officers";
        try (Connection conn = DBConnection.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                Officer o = new Officer();
                o.setOfficerId(rs.getInt("officer_id"));
                o.setName(rs.getString("name"));
                o.setDesignation(rs.getString("designation"));
                o.setPhone(rs.getString("phone"));
                o.setEmail(rs.getString("email"));
                list.add(o);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    // UPDATE Officer
    public void updateOfficerPhone(int id, String newPhone) {
        String sql = "UPDATE officers SET phone = ? WHERE officer_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setString(1, newPhone);
            pst.setInt(2, id);
            int rows = pst.executeUpdate();
            if (rows > 0)
                System.out.println("✅ Officer phone updated successfully!");
            else
                System.out.println("⚠️ Officer not found!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // DELETE Officer
    public void deleteOfficer(int id) {
        String sql = "DELETE FROM officers WHERE officer_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setInt(1, id);
            int rows = pst.executeUpdate();
            if (rows > 0)
                System.out.println("🗑️ Officer deleted successfully!");
            else
                System.out.println("⚠️ Officer not found!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
