package nl.nl0e0.medicineamqp.service;

import nl.nl0e0.medicineamqp.entity.medicine.MedicineEntity;

public class SuccessActionAlert {
    public void createMedicine(MedicineEntity entity){
        System.out.println("-----------------");
        System.out.println("Create Medicine Success.");
        System.out.println(entity);
        System.out.println("-----------------");
    }
}
