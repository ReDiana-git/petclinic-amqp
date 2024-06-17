package nl.nl0e0.consultationamqp.service;

import nl.nl0e0.consultationamqp.entity.consultation.ConsultationEntity;
import nl.nl0e0.consultationamqp.repository.ConsultationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConsultationService {
    @Autowired
    ConsultationRepository consultationRepository;
    SuccessActionAlert alert = new SuccessActionAlert();
    public void createConsultation(String consultationId){
        ConsultationEntity consultationEntity = new ConsultationEntity();
        consultationEntity.setId(consultationId);
        consultationEntity.setSymptom("");
        alert.createConsultation(consultationEntity);
        consultationRepository.save(consultationEntity);
    }
}
