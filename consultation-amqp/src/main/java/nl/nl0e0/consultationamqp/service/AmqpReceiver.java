package nl.nl0e0.consultationamqp.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import nl.nl0e0.consultationamqp.service.ConsultationService;

@Component
public class AmqpReceiver {
    @Autowired
    ConsultationService consultationService;

    @RabbitListener(queues = "createConsultationQueue")
    public void createConsultationReceiver(String consultationId){
        consultationService.createConsultation(consultationId);
    }
}
