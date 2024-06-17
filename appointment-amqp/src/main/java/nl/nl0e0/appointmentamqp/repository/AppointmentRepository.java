package nl.nl0e0.appointmentamqp.repository;

import nl.nl0e0.appointmentamqp.entity.appointment.AppointmentEntity;
import org.springframework.data.repository.Repository;

public interface AppointmentRepository extends Repository<AppointmentEntity,String> {
    void save(AppointmentEntity appointmentEntity);
}
