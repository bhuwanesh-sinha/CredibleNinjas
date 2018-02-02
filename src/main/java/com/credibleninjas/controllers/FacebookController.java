package com.credibleninjas.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.credibleninjas.entities.FacebookEntity;
import com.credibleninjas.services.FacebookService;

@RestController
public class FacebookController {
	@Autowired
	private FacebookService facebookService;

	@RequestMapping("/facebookProfiles")
	public List<FacebookEntity> getAllTopics() {

		return facebookService.getAllFacebookProfiles();

	}
	
	@RequestMapping("/facebookProfiles/{id}")
	public FacebookEntity getTopic(@PathVariable String id){
		return facebookService.getFacebookProfile(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/facebookProfiles")
	public void addFaceBookProfile(@RequestBody FacebookEntity facebookEntity){
		facebookService.addFacebookProfile(facebookEntity);
		
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/facebookProfiles/{id}")
	public void updateFacebookProfile(@RequestBody FacebookEntity facebookEntity, @PathVariable String id){
		facebookService.updateFacebookProfile(facebookEntity,id);
		
	}
}
