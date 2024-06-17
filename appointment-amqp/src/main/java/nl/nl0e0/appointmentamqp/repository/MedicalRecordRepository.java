package nl.nl0e0.appointmentamqp.repository;

import nl.nl0e0.appointmentamqp.entity.appointment.MedicalRecord;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicalRecordRepository extends org.springframework.data.repository.Repository<MedicalRecord,String> {
    void save(MedicalRecord index);
}
