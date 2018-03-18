package com.credibleninjas.entities;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
@MappedSuperclass
public class AbstractEntity {

		@Id
		protected String cn_id;
		protected String name;
		protected Date dateOfBirth;
		protected String gender;
		protected String location;
		
		public AbstractEntity(){}
		
		public AbstractEntity(String cn_id, String name, Date dateOfBirth, String gender, String location) {
			super();
			this.cn_id = cn_id;
			this.name = name;
			this.dateOfBirth = dateOfBirth;
			this.gender = gender;
			this.location = location;
			
		}
		
		
		

		public String getCn_id() {
			return cn_id;
		}

		public void setCn_id(String cn_id) {
			this.cn_id = cn_id;
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
		

		public String getLocation() {
			return location;
		}
		public void setLocation(String location) {
			this.location = location;
		}
		
		@Override
		public String toString() {
			return "AadharEntity [cn_id=" + cn_id + ", name=" + name + ", dateOfBirth=" + dateOfBirth
					+ ", gender=" + gender + ", location=" + location + "]";
		}


}
