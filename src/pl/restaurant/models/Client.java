package pl.restaurant.models;

import java.util.List;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@JsonIdentityInfo(
		  generator = ObjectIdGenerators.PropertyGenerator.class, 
		  property = "id")
public class Client {
	
	@Id
	@GeneratedValue
	private int id;
	private String name;
	private String surname;
	private String address;
	private String email;
	@OneToMany(fetch = FetchType.EAGER, mappedBy ="client")
	//@JsonBackReference
	private List<TemporaryOrder> clientOrders;
	
	public long getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public List<TemporaryOrder> getClientOrders() {
		return clientOrders;
	}
	public void setClientOrders(List<TemporaryOrder> clientOrders) {
		this.clientOrders = clientOrders;
	}
	
}
