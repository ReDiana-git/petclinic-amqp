package nl.nl0e0.paymentamqp.repository;

import nl.nl0e0.paymentamqp.entity.payment.PaymentEntity;
import org.springframework.data.repository.Repository;
public interface PaymentRepository extends Repository<PaymentEntity,String> {
    void save(PaymentEntity paymentEntity);
}
