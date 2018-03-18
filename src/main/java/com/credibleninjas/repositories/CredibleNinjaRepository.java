package com.credibleninjas.repositories;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


import com.credibleninjas.entities.AadharEntity;
import com.credibleninjas.entities.CredibleNinjaEntity;

public interface CredibleNinjaRepository extends CrudRepository<CredibleNinjaEntity, Integer>   {
//TODO modify this method later..
	 @Query(value = "SELECT * FROM credible_ninja_entity WHERE name = ?1 AND date_of_birth = ?2", nativeQuery = true)
	  String findProfile(String name, Date dob);
	
}
