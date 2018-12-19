package example.bean;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

//@Embeddable
@Entity
public class Address {
	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int aid;
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	String street,city;
	int zip;
	public Address() {
		// TODO Auto-generated constructor stub
		
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getZip() {
		return zip;
	}
	public void setZip(int zip) {
		this.zip = zip;
	}
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="STUDENT_ID")
	@JsonIgnore
	private Student student;
	

}
