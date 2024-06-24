package nl.nl0e0.appointmentamqp.service;



import nl.nl0e0.appointmentamqp.entity.appointment.AppointmentEntity;
import nl.nl0e0.appointmentamqp.entity.appointment.MedicalRecord;
import nl.nl0e0.appointmentamqp.entity.model.BaseRecord;
import nl.nl0e0.appointmentamqp.entity.owner.Owner;
import nl.nl0e0.appointmentamqp.entity.owner.Pet;
import nl.nl0e0.appointmentamqp.entity.vet.Vet;
import nl.nl0e0.appointmentamqp.repository.AppointmentRepository;
import nl.nl0e0.appointmentamqp.repository.OwnerRepository;
import nl.nl0e0.appointmentamqp.repository.PetRepository;
import nl.nl0e0.appointmentamqp.repository.VetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AppointmentRecordBuilder {

    @Autowired
    OwnerRepository ownerRepository;
    @Autowired
    AppointmentRepository appointmentRepository;
    @Autowired
    VetRepository vetRepository;
    @Autowired
    PetRepository petRepository;

    public List<BaseRecord> buildRecordsFromMedicalRecords(List<MedicalRecord> medicalRecords) {
        List<BaseRecord> records = new ArrayList<>();
        for(MedicalRecord record: medicalRecords){
            records.add(createBaseRecord(record));
        }
        return records;
    }

    public BaseRecord buildBaseRecord(Vet vet, Pet pet, Owner owner, AppointmentEntity appointmentEntity, MedicalRecord medicalRecord){
        BaseRecord baseRecord = new BaseRecord();
        baseRecord.setVetFirstName(vet.getFirstName());
        baseRecord.setVetLastName(vet.getLastName());
        baseRecord.setOwnerFirstName(owner.getFirstName());
        baseRecord.setOwnerLastName(owner.getLastName());
        baseRecord.setPetName(pet.getName());
        baseRecord.setAppointmentDate(appointmentEntity.getAppointmentDate());
        baseRecord.setState(medicalRecord.getState());
        if(medicalRecord.getState().equals("payment")){
            baseRecord.setPrice(100);
        }
        return baseRecord;
    }

    private BaseRecord createBaseRecord(MedicalRecord record) {
        Owner owner = ownerRepository.findById(record.getOwnerId());
        AppointmentEntity appointmentEntity = appointmentRepository.findById(record.getAppointmentId());
        Vet vet = vetRepository.findById(record.getVetId());
        Pet pet = petRepository.findById(record.getPetId());
        return buildBaseRecord(vet, pet, owner, appointmentEntity, record);
    }
//
//    private AppointmentState resolveState(AppointmentState state) {
//        return switch (state) {
//            case INIT -> AppointmentState.INIT;
//            case CONSULTAION -> AppointmentState.CONSULTAION;
//            case PAYMENT -> AppointmentState.PAYMENT; // Set additional properties if necessary
//            case MEDICINE -> AppointmentState.MEDICINE;
//            default -> throw new IllegalStateException("Unknown state: " + state);
//        };
//    }

}
