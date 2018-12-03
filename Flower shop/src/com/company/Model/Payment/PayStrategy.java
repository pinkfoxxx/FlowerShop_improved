package com.company.Model.Payment;

public interface PayStrategy {
    boolean pay(double paymentAmount);
    void collectPaymentDetails();
}
