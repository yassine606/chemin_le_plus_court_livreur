package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class DeliveryMan implements Serializable {

	private static final long serialVersionUID = 1L;

	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="deliveryMans")
	private Set<Delivery> deliveries;

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private long id ; 
	
	
	@Column(name = "salary")
	private int salary;

	//@NotNull(message="name is compulsory")
	@Column(name = "name")
	private String name; 
	
	//@NotNull(message="email is compulsory")
	//@Email(message = "Email is invalid")
	@Column(name = "email")
	private String email; 
	@Column(name = "phone")
	private int phone; 
	
	//@NotNull(message="Password is compulsory")
	//@Length(min=5, message="Password should be at least 5 characters")
	@Column(name = "password")
	private String password;
	@Column(name = "adress")
	private String adress;
	@Column(name = "status")
	private String status;
	
	public DeliveryMan() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	
	
	
	
	

	public DeliveryMan(Set<Delivery> deliveries, long id, int salary, String name, String email, int phone,
			String password, String adress, String status) {
		super();
		this.deliveries = deliveries;
		this.id = id;
		this.salary = salary;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.password = password;
		this.adress = adress;
		this.status = status;
	}


	public int getSalary() {
		return salary;
	}


	public void setSalary(int salary) {
		this.salary = salary;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public int getPhone() {
		return phone;
	}


	public void setPhone(int phone) {
		this.phone = phone;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getAdress() {
		return adress;
	}


	public void setAdress(String adress) {
		this.adress = adress;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public Set<Delivery> getDeliveries() {
		return deliveries;
	}


	public void setDeliveries(Set<Delivery> deliveries) {
		this.deliveries = deliveries;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
