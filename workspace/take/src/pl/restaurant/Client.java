package pl.restaurant;

import java.util.List;

import javax.persistence.*;

@Entity
public class Client {
	
	@Id
	@GeneratedValue
	private int id;
	private String name;
	private String surname;
	private String address;
	private String email;
	@OneToMany(mappedBy ="client")
	private List<Order> clientOrders;
	
	public int getId() {
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
	public List<Order> getClientOrders() {
		return clientOrders;
	}
	public void setClientOrders(List<Order> clientOrders) {
		this.clientOrders = clientOrders;
	}
	
}
