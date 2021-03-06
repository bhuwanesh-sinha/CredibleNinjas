package com.credibleninjas.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.credibleninjas.entities.FacebookEntity;
import com.credibleninjas.repositories.FacebookRepository;

@Service
public class FacebookService {
	
	@Autowired
	private FacebookRepository facebookRepository;
	
	public List<FacebookEntity> getAllFacebookProfiles()
	{
		
		List<FacebookEntity> facebookProfiles = new ArrayList<FacebookEntity>();
		facebookRepository.findAll().forEach(facebookProfiles::add);
		return facebookProfiles;
	}
	
	public FacebookEntity getFacebookProfile(String id){
		
		return facebookRepository.findOne(id);
	}
	
	

	public void addFacebookProfile(FacebookEntity entity) {
		
		facebookRepository.save(entity);
		
	}

	
	public void updateFacebookProfile(FacebookEntity facebookEntity, String id) {
		facebookRepository.delete(id);
		facebookRepository.save(facebookEntity);
		
	}
}
