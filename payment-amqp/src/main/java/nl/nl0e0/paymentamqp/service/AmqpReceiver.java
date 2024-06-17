package nl.nl0e0.paymentamqp.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AmqpReceiver {
    @Autowired
    PaymentService paymentService;

    @RabbitListener(queues = "createPaymentQueue")
    public void createPaymentReceiver(String paymentId){
        paymentService.createPayment(paymentId);
    }
}
