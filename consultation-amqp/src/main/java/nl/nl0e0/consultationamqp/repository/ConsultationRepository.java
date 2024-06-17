package nl.nl0e0.consultationamqp.repository;

import nl.nl0e0.consultationamqp.entity.consultation.ConsultationEntity;
import org.springframework.data.repository.Repository;

public interface ConsultationRepository extends Repository<ConsultationEntity,String> {
    void save(ConsultationEntity consultationEntity);
}
