package com.vaishnavi.cab.booking.controller;

import com.vaishnavi.cab.booking.model.Payment;
import com.vaishnavi.cab.booking.service.PaymentService;
import java.sql.SQLException;
import java.util.List;

public class PaymentController {
    private PaymentService paymentService;

    public void setPaymentService(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    public void pay(Payment payment) {
        try {
            paymentService.processPayment(payment);
            System.out.println("Payment successful.");
        } catch (SQLException | IllegalArgumentException e) {
            System.err.println("Error in payment: " + e.getMessage());
        }
    }

    public void listPayments() {
        try {
            List<Payment> payments = paymentService.getAllPayments();
            payments.forEach(p -> System.out.println(p.getPaymentId() + " | " + p.getAmount() + " | " + p.getMethod()));
        } catch (SQLException e) {
            System.err.println("Error fetching payments: " + e.getMessage());
        }
    }

    public void makePayment(Payment payment) {
    }

    public void listAllPayments() {
    }
}



