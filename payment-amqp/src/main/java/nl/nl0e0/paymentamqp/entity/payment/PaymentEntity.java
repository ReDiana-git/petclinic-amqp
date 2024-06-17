package nl.nl0e0.paymentamqp.entity.payment;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import nl.nl0e0.paymentamqp.entity.appointment.MedicalRecord;

import java.io.Serializable;

@Entity
@Setter
@Getter
@Table(name = "payment")
public class PaymentEntity implements Serializable {

	public boolean getPaymentStatus() {
		return paymentStatus;
	}
	@Id
	@Column(name = "id")
	private String id;
	@Column(name = "price")
	private Integer price;
	@Column(name = "payment_status")
	private boolean paymentStatus;
	public PaymentEntity(MedicalRecord medicalRecord){
		this.id = medicalRecord.getPaymentId();
		this.paymentStatus = false;
	}
	public PaymentEntity(String id){
		this.id = id;
		this.price = 0;
		this.paymentStatus = false;
	}
	public PaymentEntity(){

	}
}
