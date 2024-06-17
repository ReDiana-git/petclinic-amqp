package nl.nl0e0.appointmentamqp;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class Receiver {

    @RabbitListener(queues = "queue-name")
    public void receive(String message) {
        System.out.println(" [x] Received '" + message + "'");
    }
}
