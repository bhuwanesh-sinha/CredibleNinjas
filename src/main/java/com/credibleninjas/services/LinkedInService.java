package com.credibleninjas.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.credibleninjas.entities.LinkedInEntity;
import com.credibleninjas.repositories.LinkedInRepository;

@Service
public class LinkedInService {
	
	@Autowired
	private LinkedInRepository linkedInRepository;
	
	public List<LinkedInEntity> getAllLinkedInProfiles()
	{
		// return topics;
		List<LinkedInEntity> linkedInProfiles = new ArrayList<LinkedInEntity>();
		linkedInRepository.findAll().forEach(linkedInProfiles::add);
		return linkedInProfiles;
	}
	
	public LinkedInEntity getLinkedInProfile(String id){
		//return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
		return linkedInRepository.findOne(id);
	}
	
	

	public void addLinkedInProfile(LinkedInEntity entity) {
		//topics.add(topic);
		linkedInRepository.save(entity);
		
	}

	
	public void updateLinkedInProfile(LinkedInEntity linkedInEntity, String id) {
		linkedInRepository.delete(id);
		linkedInRepository.save(linkedInEntity);
	}
}
