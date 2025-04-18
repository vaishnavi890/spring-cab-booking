package com.vaishnavi.cab.booking.service;

import com.vaishnavi.cab.booking.model.Payment;
import com.vaishnavi.cab.booking.repository.PaymentRepository;
import java.sql.SQLException;
import java.util.List;

public class PaymentService {
    private PaymentRepository paymentRepository;

    public void setPaymentRepository(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    public void processPayment(Payment payment) throws SQLException {
        if (payment.getAmount() > 0) {
            payment.setStatus("Paid");
            paymentRepository.makePayment(payment);
        } else {
            throw new IllegalArgumentException("Amount must be greater than zero.");
        }
    }

    public List<Payment> getAllPayments() throws SQLException {
        return paymentRepository.getAllPayments();
    }
}




