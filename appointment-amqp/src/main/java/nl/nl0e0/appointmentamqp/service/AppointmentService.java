package nl.nl0e0.appointmentamqp.service;

import nl.nl0e0.appointmentamqp.entity.appointment.AppointmentEntity;
import nl.nl0e0.appointmentamqp.entity.appointment.CreateAppointmentDTO;
import nl.nl0e0.appointmentamqp.entity.appointment.MedicalRecord;
import nl.nl0e0.appointmentamqp.entity.appointment.OwnerNameDTO;
import nl.nl0e0.appointmentamqp.entity.model.BaseRecord;
import nl.nl0e0.appointmentamqp.entity.owner.Owner;
import nl.nl0e0.appointmentamqp.repository.AppointmentRepository;
import nl.nl0e0.appointmentamqp.repository.OwnerRepository;
import nl.nl0e0.appointmentamqp.service.MedicalRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentService {
    @Autowired
    MedicalRecordService medicalRecordService;
    @Autowired
    AmqpSender amqpSender;
    @Autowired
    OwnerRepository ownerRepository;
    @Autowired
    AppointmentRecordBuilder appointmentRecordBuilder;

    @Autowired
    AppointmentRepository appointmentRepository;
    public void checkCreateAppointmentDTOValidation(CreateAppointmentDTO createAppointMentDTO){
        String notBeNull = " should not be null.";
        if(createAppointMentDTO.getAppointmentDate() == null)
            throw new NullPointerException("Appointment Date" + notBeNull);
        if(createAppointMentDTO.getPetId() == null)
            throw new NullPointerException("Pet ID" + notBeNull);
        if(createAppointMentDTO.getOwnerId() == null)
            throw new NullPointerException("Owner ID" + notBeNull);
        if(createAppointMentDTO.getVetId() == null)
            throw new NullPointerException("Vet ID" + notBeNull);
    }
    public MedicalRecord createAppointment(CreateAppointmentDTO createAppointmentDTO){
        MedicalRecord medicalRecord = medicalRecordService.createMedicalRecord(createAppointmentDTO);
        amqpSender.createMedicalRecord(medicalRecord);
        appointmentRepository.save(new AppointmentEntity(medicalRecord, createAppointmentDTO));
        return medicalRecord;
    }

    public List<?> getAppointmentsByOwnerName(OwnerNameDTO ownerNameDTO) {
        Owner owner = ownerRepository.findByFullName(ownerNameDTO.getFirstName(), ownerNameDTO.getLastName());
        List<MedicalRecord> MedicalRecords = medicalRecordService.findByOwnerId(owner.getId());
        return getRecordsFromStates(MedicalRecords);
    }

    private List<BaseRecord> getRecordsFromStates(List<MedicalRecord> medicalRecords){
        return appointmentRecordBuilder.buildRecordsFromMedicalRecords(medicalRecords);
    }
}
