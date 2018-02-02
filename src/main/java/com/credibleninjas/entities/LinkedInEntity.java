package com.credibleninjas.entities;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class LinkedInEntity extends AbstractEntity{
	private String currentDesignation;
	private String currentOrganization;
	
	public LinkedInEntity(String id,String name, Date dateOfBirth, String gender, String address, String currentDesignation,
			String currentOrganization) {
		super(id,name,dateOfBirth,gender,address);
		this.currentDesignation = currentDesignation;
		this.currentOrganization = currentOrganization;
	}
	
	public LinkedInEntity() {
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
		return "LinkedInEntity [id=" + id + ", name=" + name + ", dateOfBirth=" + dateOfBirth + ", gender=" + gender
				+ ", address=" + address + ", currentDesignation=" + currentDesignation
				+ ", currentOrganization=" + currentOrganization + "]";
	}
}
