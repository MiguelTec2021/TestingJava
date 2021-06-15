package com.uttl.javatest.payments;

public interface PaymentGateway {

    PaymentResponse requestPayment(PaymentRequest request);
}
