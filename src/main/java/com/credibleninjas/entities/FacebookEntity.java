package com.credibleninjas.entities;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class FacebookEntity extends AbstractEntity{
	private String currentDesignation = null;
	private String currentOrganization = null;
	private String public_profile;
	private String fb_id;
	
	public FacebookEntity(String cn_id, String name, Date dateOfBirth, String gender, String location, String fb_id, String public_profile, String currentDesignation,
			String currentOrganization) {
		super(cn_id, name, dateOfBirth, gender, location);
		this.currentDesignation = currentDesignation;
		this.currentOrganization = currentOrganization;
		this.public_profile = public_profile;
		this.fb_id = fb_id;
	}
	
	public String getPublic_profile() {
		return public_profile;
	}

	public void setPublic_profile(String public_profile) {
		this.public_profile = public_profile;
	}

	public String getFb_id() {
		return fb_id;
	}

	public void setFb_id(String fb_id) {
		this.fb_id = fb_id;
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
		return "FacebookEntity [currentDesignation=" + currentDesignation + ", currentOrganization="
				+ currentOrganization + ", public_profile=" + public_profile + ", fb_id=" + fb_id + ", cn_id=" + cn_id
				+ ", name=" + name + ", dateOfBirth=" + dateOfBirth + ", gender=" + gender + ", location=" + location
				+ "]";
	}
}
