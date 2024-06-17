package nl.nl0e0.medicineamqp.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AmqpReceiver {
    @Autowired
    MedicineService medicineService;

    @RabbitListener(queues = "createMedicineQueue")
    public void createMedicineReceiver(String medicineId){
        medicineService.createMedicine(medicineId);
    }
}
