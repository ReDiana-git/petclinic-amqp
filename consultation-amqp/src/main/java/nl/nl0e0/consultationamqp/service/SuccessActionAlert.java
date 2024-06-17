package nl.nl0e0.consultationamqp.service;

import nl.nl0e0.consultationamqp.entity.consultation.ConsultationEntity;

public class SuccessActionAlert {
    public void createConsultation(ConsultationEntity entity){
        System.out.println("-----------------");
        System.out.println("Create Consultation Success.");
        System.out.println(entity);
        System.out.println("-----------------");
    }
}
