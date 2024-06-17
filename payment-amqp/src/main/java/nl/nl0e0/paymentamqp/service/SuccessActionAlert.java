package nl.nl0e0.paymentamqp.service;

import nl.nl0e0.paymentamqp.entity.payment.PaymentEntity;

public class SuccessActionAlert {
    public void createConsultation(PaymentEntity entity){
        System.out.println("-----------------");
        System.out.println("Create Payment Success.");
        System.out.println(entity);
        System.out.println("-----------------");
    }
}
