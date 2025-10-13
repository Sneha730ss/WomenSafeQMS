package com.WomenSafeQMS.dao;

import com.WomenSafeQMS.config.DBConnection;
import com.WomenSafeQMS.model.Woman;

import java.sql.*;
import java.util.*;

public class WomanDAO {
	// Add
    public void addWoman(Woman w) {
        String sql = "INSERT INTO women (full_name, age, mobile_number, email, address) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setString(1, w.getFullName());
            pst.setInt(2, w.getAge());
            pst.setString(3, w.getMobileNumber());
            pst.setString(4, w.getEmail());
            pst.setString(5, w.getAddress());
            pst.executeUpdate();
            System.out.println("✅ Woman Added Successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Read all
    public List<Woman> getAllWomen() {
        List<Woman> list = new ArrayList<>();
        String sql = "SELECT * FROM women";
        try (Connection conn = DBConnection.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                Woman w = new Woman();
                w.setWomanId(rs.getInt("woman_id"));
                w.setFullName(rs.getString("full_name"));
                w.setAge(rs.getInt("age"));
                w.setMobileNumber(rs.getString("mobile_number"));
                w.setEmail(rs.getString("email"));
                w.setAddress(rs.getString("address"));
                list.add(w);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    // Update
    public void updateWoman(Woman w) {
        String sql = "UPDATE women SET full_name=?, age=?, mobile_number=?, email=?, address=? WHERE woman_id=?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setString(1, w.getFullName());
            pst.setInt(2, w.getAge());
            pst.setString(3, w.getMobileNumber());
            pst.setString(4, w.getEmail());
            pst.setString(5, w.getAddress());
            int rows = pst.executeUpdate();
            if (rows > 0) System.out.println("✅ Updated Successfully!");
            else System.out.println("❌ Woman Not Found!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Delete
    public void deleteWoman(int id) {
        String sql = "DELETE FROM women WHERE woman_id=?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setInt(1, id);
            int rows = pst.executeUpdate();
            if (rows > 0) System.out.println("✅ Deleted Successfully!");
            else System.out.println("❌ Woman Not Found!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	


}
