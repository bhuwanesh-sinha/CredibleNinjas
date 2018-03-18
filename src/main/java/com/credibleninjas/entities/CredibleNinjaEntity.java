package com.credibleninjas.entities;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CredibleNinjaEntity{
	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "cn_id")
    public int cn_id;
	protected String name;
	protected Date dateOfBirth;
	protected String gender;
	protected String address;

	public CredibleNinjaEntity(AadharEntity aadharEntity) {
		
		this.name = aadharEntity.getName();
		this.dateOfBirth = aadharEntity.getDateOfBirth();
		this.gender = aadharEntity.getGender();
		this.address = aadharEntity.getAddress();
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

	public CredibleNinjaEntity() {
		// TODO Auto-generated constructor stub
	}
	
	public int getCn_id() {
		return cn_id;
	}

	public void setCn_id(int cn_id) {
		this.cn_id = cn_id;
	}

	
}
