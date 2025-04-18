package com.vaishnavi.cab.booking.repository;

import com.vaishnavi.cab.booking.connection.DBConnection;
import com.vaishnavi.cab.booking.model.Payment;
import java.sql.*;
import java.util.*;

public class PaymentRepository {
    public void makePayment(Payment payment) throws SQLException {
        String sql = "INSERT INTO payments (payment_id, ride_id, user_id, amount, method, status) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, payment.getPaymentId());
            ps.setInt(2, payment.getRideId());
            ps.setInt(3, payment.getUserId());
            ps.setDouble(4, payment.getAmount());
            ps.setString(5, payment.getMethod());
            ps.setString(6, payment.getStatus());
            ps.executeUpdate();
        }
    }

    public List<Payment> getAllPayments() throws SQLException {
        List<Payment> list = new ArrayList<>();
        String sql = "SELECT * FROM payments";
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                list.add(new Payment(
                        rs.getInt("payment_id"),
                        rs.getInt("ride_id"),
                        rs.getInt("user_id"),
                        rs.getDouble("amount"),
                        rs.getString("method"),
                        rs.getString("status")
                ));
            }
        }
        return list;
    }
}


