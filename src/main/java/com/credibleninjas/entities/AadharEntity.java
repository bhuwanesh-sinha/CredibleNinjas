package com.credibleninjas.entities;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class AadharEntity{

	@Id
	protected String aadhar_id;
	protected String name;
	protected Date dateOfBirth;
	protected String gender;
	protected String address;
	
	public AadharEntity(){}
	
	public AadharEntity(String aadhar_id, String name, Date dateOfBirth, String gender, String location) {
		this.name = name;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		this.address = address;
		this.aadhar_id = aadhar_id;
	}
	
	
	

	public String getAadhar_id() {
		return aadhar_id;
	}

	public void setAadhar_id(String aadhar_id) {
		this.aadhar_id = aadhar_id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	

	

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "AadharEntity [aadhar_id=" + aadhar_id + ", name=" + name + ", dateOfBirth=" + dateOfBirth + ", gender="
				+ gender + ", address=" + address + "]";
	}
	
	

}
