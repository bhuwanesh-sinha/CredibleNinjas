package com.credibleninjas.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.credibleninjas.entities.AadharEntity;
import com.credibleninjas.repositories.AadharRepository;

@Service
public class AadharService {
	
	@Autowired
	private AadharRepository aadharRepository;
	
	public List<AadharEntity> getAllAadhar()
	{
		// return topics;
		List<AadharEntity> aadhars = new ArrayList<AadharEntity>();
		aadharRepository.findAll().forEach(aadhars::add);
		return aadhars;
	}
	
	public AadharEntity getAadhar(String id){
		//return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
		return aadharRepository.findOne(id);
	}
	
	

	public void addAadhar(AadharEntity entity) {
		//topics.add(topic);
		aadharRepository.save(entity);
		
	}


	public void updateAadhar(AadharEntity aadharEntity, String id) {
		aadharRepository.delete(id);
		aadharRepository.save(aadharEntity);}
}
