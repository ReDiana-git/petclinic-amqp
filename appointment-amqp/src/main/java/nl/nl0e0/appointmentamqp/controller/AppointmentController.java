package nl.nl0e0.appointmentamqp.controller;

import nl.nl0e0.appointmentamqp.entity.appointment.MedicalRecord;
import nl.nl0e0.appointmentamqp.entity.appointment.OwnerNameDTO;
import nl.nl0e0.appointmentamqp.service.AppointmentService;
import nl.nl0e0.appointmentamqp.service.SuccessActionAlert;
import nl.nl0e0.appointmentamqp.entity.appointment.CreateAppointmentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Controller
public class AppointmentController {
    @Autowired
    AppointmentService appointmentService;
    SuccessActionAlert successActionAlert = new SuccessActionAlert();
    @PostMapping("/appointment/createAppointments")
    public ResponseEntity<?> createAppointment(@RequestBody CreateAppointmentDTO createAppointMentDTO){

        try{
            appointmentService.checkCreateAppointmentDTOValidation(createAppointMentDTO);
            MedicalRecord medicalRecord = appointmentService.createAppointment(createAppointMentDTO);
            successActionAlert.createAppointmentAlert(medicalRecord);
            return ResponseEntity.status(HttpStatus.CREATED).body(medicalRecord);
        }catch (Exception exception){
            Map<String, Object> body = new LinkedHashMap<>();
            body.put("timestamp", LocalDateTime.now());
            body.put("message", exception.getMessage());

            // 返回包含自定義錯誤訊息和HTTP狀態碼的ResponseEntity
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
        }
    }

    @PostMapping("/appointment/getAppointments")
    public ResponseEntity<?> getAppointmentByOwnerName(@RequestBody OwnerNameDTO ownerNameDTO){
        List<?> appointmentEntities = appointmentService.getAppointmentsByOwnerName(ownerNameDTO);
        return ResponseEntity.status(HttpStatus.OK).body(appointmentEntities);
    }
}
