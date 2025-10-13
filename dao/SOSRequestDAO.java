package com.WomenSafeQMS.dao;

import com.WomenSafeQMS.config.DBConnection;
import com.WomenSafeQMS.model.SOSRequest;
import java.sql.*;
import java.util.*;

public class SOSRequestDAO {

    // Add new SOS request
    public void addSOSRequest(SOSRequest request) {
        String sql = "INSERT INTO sos_requests (woman_id, location, resolved) VALUES (?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {

            pst.setInt(1, request.getWomanId());
            pst.setString(2, request.getLocation());
            pst.setBoolean(3, request.isResolved());
            pst.executeUpdate();
            System.out.println("✅ SOS Request added successfully!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // View all SOS requests
    public List<SOSRequest> getAllSOSRequests() {
        List<SOSRequest> list = new ArrayList<>();
        String sql = "SELECT * FROM sos_requests";

        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                SOSRequest s = new SOSRequest();
                s.setSosId(rs.getInt("sos_id"));
                s.setWomanId(rs.getInt("woman_id"));
                s.setLocation(rs.getString("location"));
                s.setTimestamp(rs.getString("timestamp"));
                s.setResolved(rs.getBoolean("resolved"));
                list.add(s);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    // Update request status (mark resolved)
    public void updateResolvedStatus(int sosId, boolean resolved) {
        String sql = "UPDATE sos_requests SET resolved = ? WHERE sos_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {

            pst.setBoolean(1, resolved);
            pst.setInt(2, sosId);
            pst.executeUpdate();
            System.out.println("✅ SOS request updated successfully!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Delete SOS request
    public void deleteSOSRequest(int sosId) {
        String sql = "DELETE FROM sos_requests WHERE sos_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {

            pst.setInt(1, sosId);
            pst.executeUpdate();
            System.out.println("🗑️ SOS request deleted successfully!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

