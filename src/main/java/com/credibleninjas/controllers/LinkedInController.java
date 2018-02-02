package com.credibleninjas.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.credibleninjas.entities.LinkedInEntity;
import com.credibleninjas.services.LinkedInService;

@RestController
public class LinkedInController {
	@Autowired
	private LinkedInService linkedInService;

	@RequestMapping("/linkedInProfiles")
	public List<LinkedInEntity> getAllTopics() {

		return linkedInService.getAllLinkedInProfiles();

	}
	
	@RequestMapping("/linkedInProfiles/{id}")
	public LinkedInEntity getTopic(@PathVariable String id){
		return linkedInService.getLinkedInProfile(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/linkedInProfiles")
	public void addLinkedInProfile(@RequestBody LinkedInEntity linkedInEntity){
		linkedInService.addLinkedInProfile(linkedInEntity);
		
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/linkedInProfiles/{id}")
	public void updateLinkedInProfile(@RequestBody LinkedInEntity linkedInEntity, @PathVariable String id){
		linkedInService.updateLinkedInProfile(linkedInEntity,id);
		
	}
}
