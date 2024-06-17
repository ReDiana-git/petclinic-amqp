package nl.nl0e0.appointmentamqp.service;

import nl.nl0e0.appointmentamqp.entity.appointment.CreateAppointmentDTO;
import nl.nl0e0.appointmentamqp.entity.appointment.MedicalRecord;
import nl.nl0e0.appointmentamqp.repository.MedicalRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MedicalRecordService {
    @Autowired
    MedicalRecordRepository repository;
    public MedicalRecord createMedicalRecord(CreateAppointmentDTO createAppointmentDTO){
        MedicalRecord medicalRecord = new MedicalRecord(createAppointmentDTO);
        repository.save(medicalRecord);
        return medicalRecord;
    }
}
