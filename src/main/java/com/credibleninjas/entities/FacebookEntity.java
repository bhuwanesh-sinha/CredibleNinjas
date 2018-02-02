package com.credibleninjas.entities;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class FacebookEntity extends AbstractEntity{
	private String currentDesignation;
	private String currentOrganization;
	
	public FacebookEntity(String id,String name, Date dateOfBirth, String gender, String address, String currentDesignation,
			String currentOrganization) {
		super(id,name,dateOfBirth,gender,address);
		this.currentDesignation = currentDesignation;
		this.currentOrganization = currentOrganization;
	}
	
	public FacebookEntity() {
		// TODO Auto-generated constructor stub
	}

	
	public String getCurrentDesignation() {
		return currentDesignation;
	}

	public void setCurrentDesignation(String currentDesignation) {
		this.currentDesignation = currentDesignation;
	}

	public String getCurrentOrganization() {
		return currentOrganization;
	}

	public void setCurrentOrganization(String currentOrganization) {
		this.currentOrganization = currentOrganization;
	}
	
	@Override
	public String toString() {
		return "FacebookEntity [id=" + id + ", name=" + name + ", dateOfBirth=" + dateOfBirth + ", gender=" + gender
				+ ", address=" + address + ", currentDesignation=" + currentDesignation
				+ ", currentOrganization=" + currentOrganization + "]";
	}
}
