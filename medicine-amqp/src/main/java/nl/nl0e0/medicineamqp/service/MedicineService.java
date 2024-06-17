package nl.nl0e0.medicineamqp.service;

import nl.nl0e0.medicineamqp.entity.medicine.MedicineEntity;
import nl.nl0e0.medicineamqp.repository.MedicineRepositroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MedicineService {
    @Autowired
    MedicineRepositroy repositroy;
    SuccessActionAlert alert = new SuccessActionAlert();
    public MedicineEntity createMedicine(String medicineId){
        MedicineEntity medicineEntity = new MedicineEntity(medicineId);
        repositroy.save(medicineEntity);
        alert.createMedicine(medicineEntity);
        return medicineEntity;
    }
}
