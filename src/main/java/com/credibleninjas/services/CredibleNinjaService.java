package com.credibleninjas.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.credibleninjas.entities.AadharEntity;
import com.credibleninjas.entities.CredibleNinjaEntity;
import com.credibleninjas.entities.FacebookEntity;
import com.credibleninjas.repositories.AadharRepository;
import com.credibleninjas.repositories.CredibleNinjaRepository;

@Service
public class CredibleNinjaService {
	
	@Autowired
	private CredibleNinjaRepository credibleNinjaRepository;
	
	public CredibleNinjaEntity addCredibleNinjaProfile(CredibleNinjaEntity entity) {
		//topics.add(topic);
		if(!(credibleNinjaRepository.findProfile(entity.getName(), entity.getDateOfBirth())==null))
			return null;//"User already present in Database..";
		else
		{
			return credibleNinjaRepository.save(entity);
			//"User added succesfully in Database..";
		}
		//credibleNinjaRepository.
		
	}
	
	public List<CredibleNinjaEntity> getAllCredibleNinjaProfiles()
	{
		
		List<CredibleNinjaEntity> credibleNinjaProfiles = new ArrayList<CredibleNinjaEntity>();
		credibleNinjaRepository.findAll().forEach(credibleNinjaProfiles::add);
		return credibleNinjaProfiles;
	}
	
	public CredibleNinjaEntity getCredibleNinjaProfile(Integer cn_id){
		
		return credibleNinjaRepository.findOne(cn_id);
	}
	
	
	public void updateCredibleNinjaProfile(CredibleNinjaEntity credibleNinjaEntity, Integer cn_id) {
		credibleNinjaRepository.delete(cn_id);
		credibleNinjaRepository.save(credibleNinjaEntity);
		
	}

}
