package nl.nl0e0.medicineamqp.repository;

import nl.nl0e0.medicineamqp.entity.medicine.MedicineEntity;
import org.springframework.data.repository.Repository;

public interface MedicineRepositroy extends Repository<MedicineEntity,String> {
    void save(MedicineEntity medicineEntity);
}
