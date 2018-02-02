package com.credibleninjas.entities;

import java.sql.Date;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
@MappedSuperclass
public class AbstractEntity {

	   @Id
	    protected String id;
		protected String name;
		protected Date dateOfBirth;
		protected String gender;
		protected String address;
		
		public AbstractEntity(){}
		
		public AbstractEntity(String id, String name, Date dateOfBirth, String gender, String address) {
			super();
			this.name = name;
			this.dateOfBirth = dateOfBirth;
			this.gender = gender;
			this.address = address;
			this.id = id;
		}
		
		
		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
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
			return "AadharEntity [id=" + id + ", name=" + name + ", dateOfBirth=" + dateOfBirth
					+ ", gender=" + gender + ", address=" + address + "]";
		}


}
