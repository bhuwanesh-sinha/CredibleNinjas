package com.credibleninjas.entities;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class AadharEntity extends AbstractEntity{
	
	public AadharEntity() {
		// TODO Auto-generated constructor stub
	}
	
	public AadharEntity(String id,String name, Date dateOfBirth, String gender, String address) {
		super(id,name,dateOfBirth,gender,address);
		
	}
}
