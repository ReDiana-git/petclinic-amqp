package nl.nl0e0.paymentamqp.service;

import nl.nl0e0.paymentamqp.entity.payment.PaymentEntity;
import nl.nl0e0.paymentamqp.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    @Autowired
    PaymentRepository repository;
    SuccessActionAlert alert = new SuccessActionAlert();
    public void createPayment(String paymentId){
        PaymentEntity payment = new PaymentEntity();
        payment.setId(paymentId);
        repository.save(payment);
        alert.createConsultation(payment);
    }
}
