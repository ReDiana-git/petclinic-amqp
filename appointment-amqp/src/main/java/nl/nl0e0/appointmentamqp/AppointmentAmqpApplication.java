package nl.nl0e0.appointmentamqp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import java.time.LocalDateTime;

@SpringBootApplication
public class AppointmentAmqpApplication {

    public static void main(String[] args){
        SpringApplication.run(AppointmentAmqpApplication.class, args);
    }

}
