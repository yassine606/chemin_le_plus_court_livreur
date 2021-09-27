package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "T_DELIVERY")
public class Delivery implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "DELIVERY_ID")
	private Long id; // Clé primaire

	@Temporal(TemporalType.DATE)
	private Date deliveryDate;
	
	@Column(name = "DELIVERY_STATUS")
	private String status;

	@ManyToOne
	DeliveryMan deliveryMans;

/*
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "deliveries")
	private Set<Order> orders;
	*/
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}


	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}


	public DeliveryMan getDeliveryMans() {
		return deliveryMans;
	}

	public void setDeliveryMans(DeliveryMan deliveryMans) {
		this.deliveryMans = deliveryMans;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


/*
	public Set<Order> getOrders() {
		return orders;
	}*/
/*
	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}

	@Override
	public String toString() {
		return "Delivery [id=" + id + ", deliveryDate=" + deliveryDate + ", status=" + status
				 + ", deliveryMans=" + deliveryMans + ", orders=" + orders + "]";
	}
	*/
	public Delivery(Date deliveryDate, String status, DeliveryMan deliveryMans) {
		this.deliveryDate = deliveryDate;
		this.status = status;
		this.deliveryMans = deliveryMans;
	}

	public Delivery() {
	}

	public Delivery( Date deliveryDate, String status) {
		this.deliveryDate = deliveryDate;
		this.status = status;

	}


	
	

}
