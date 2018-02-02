package com.credibleninjas.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.credibleninjas.engine.Engine;
import com.credibleninjas.entities.AadharEntity;
import com.credibleninjas.entities.AbstractEntity;
import com.credibleninjas.entities.FacebookEntity;
import com.credibleninjas.entities.LinkedInEntity;

@RestController
public class CentralController {
//Takes in Aadhar number and calculates credibility.
	@RequestMapping("/getCredibility/{aadharId}")
	public String getCredibility(@PathVariable String aadharId){
		List<AbstractEntity> list = new ArrayList<AbstractEntity>();
		Integer credibilityScore = 0;
		RestTemplate restTemplate = new RestTemplate();
        AadharEntity aadharEntity = restTemplate.getForObject("http://localhost:8080/aadhars/"+aadharId, AadharEntity.class);
        list.add(aadharEntity);
        FacebookEntity facebookEntity = restTemplate.getForObject("http://localhost:8080/facebookProfiles/"+aadharId, FacebookEntity.class);
        list.add(facebookEntity);
        LinkedInEntity linkedInEntity = restTemplate.getForObject("http://localhost:8080/linkedInProfiles/"+aadharId, LinkedInEntity.class);
        list.add(linkedInEntity);
        //System.out.println(aadharEntity.toString()+"\n"+ linkedInEntity.toString() +"\n"+ facebookEntity.toString());
		credibilityScore = Engine.getCredibility(list);
        return credibilityScore.toString();
	}
	
}
