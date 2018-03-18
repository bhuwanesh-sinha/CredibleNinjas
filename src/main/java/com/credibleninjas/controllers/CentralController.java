package com.credibleninjas.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.xml.ws.ResponseWrapper;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.credibleninjas.engine.Engine;
import com.credibleninjas.entities.AadharEntity;
import com.credibleninjas.entities.AbstractEntity;
import com.credibleninjas.entities.CredibleNinjaEntity;
import com.credibleninjas.entities.FacebookEntity;
import com.credibleninjas.entities.LinkedInEntity;
import com.credibleninjas.weightage.CommonWeightage;
import com.credibleninjas.weightage.PlatformWeightage;

import RequestWrappers.ErrorResponseWrapper;
import RequestWrappers.RespWrapper;
import RequestWrappers.UserDataWrapper;
import Utilities.ParametersCheck;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
public class CentralController {
	
	private static final Logger log = LoggerFactory.getLogger(CentralController.class);
	
	RestTemplate restTemplate = new RestTemplate();
//Takes in Aadhar number and calculates credibility.
	@RequestMapping("/getCredibility/{cn_id}")
	public String getCredibility(@PathVariable String cn_id, HttpServletRequest request){
		
		//get servlet path and remove mapping path to get base url
		String baseUrl = request.getRequestURL().toString().replaceAll(request.getServletPath(), "") + "/"; 
		
		List<AbstractEntity> list = new ArrayList<AbstractEntity>();
		int credibilityScore = 0;
		
		// TODO MAKE THIS CREDIBLE-NINJA-ENTITY
		CredibleNinjaEntity credibleNinjaEntity = restTemplate.getForObject(baseUrl+"credibleNinjaProfiles/"+cn_id, CredibleNinjaEntity.class);
       // list.add(aadharEntity);
        
        FacebookEntity facebookEntity = restTemplate.getForObject(baseUrl+"facebookProfiles/"+cn_id, FacebookEntity.class);
        list.add(facebookEntity);
        
        LinkedInEntity linkedInEntity = restTemplate.getForObject(baseUrl+"linkedInProfiles/"+cn_id, LinkedInEntity.class);
        list.add(linkedInEntity);
        //System.out.println(aadharEntity.toString()+"\n"+ linkedInEntity.toString() +"\n"+ facebookEntity.toString());
        credibilityScore = Engine.getCredibility(list,credibleNinjaEntity);
        return  String.valueOf(credibilityScore);
	}
	
	/*
	 * Take FB data and aadhar number, retrieve aadhar details from official aadhar API,
	verify that both are of same person, if yes, then store FB data and generate CredibleNinja Standard Profile using Aadhar data
	Retrieve data for all other platforms at this step only..
	*/
	@RequestMapping(method=RequestMethod.POST, value="/initiateProfiles", produces = { "application/json"})
	public RespWrapper initiateProfile(@RequestBody UserDataWrapper userDataWrapper, HttpServletRequest request){
		log.info("Initiate profile request.. Adhar_d: " + userDataWrapper.getAadharNumber() +" Facebook details - "+ userDataWrapper.getFacebookEntity().toString());
		Boolean result = false;
		CredibleNinjaEntity credibleNinjaEntity = null;
		String baseUrl = request.getRequestURL().toString().replaceAll(request.getServletPath(), "") + "/"; 
		//TODO: Accept aadhar number and facebook Entity, generate json "result" : cn_id & credibility_score
		//if user gives Aadhar Id of different person, reply with error message else save FB data..
		log.info("Fetching Aadhar details..");
		AadharEntity aadharEntity = restTemplate.getForObject(baseUrl+"aadharProfiles/"+userDataWrapper.getAadharNumber(), AadharEntity.class);
		if(aadharEntity==null)
		{
			log.info("Aadhar details not found..");
			return new ErrorResponseWrapper("User not found in Aadhar Database..", -1);
		}
		else
		{
			log.info("Aadhar details fetched....");
			FacebookEntity facebookEntity = userDataWrapper.getFacebookEntity();
			if(ParametersCheck.verifyName(facebookEntity.getName(), aadharEntity.getName()))
			{
				
				log.info("Aadhar and facebook data matches.. creating Credible Ninja Profile and saving FaceBook profile..");
				credibleNinjaEntity = new CredibleNinjaEntity(aadharEntity);
				credibleNinjaEntity = restTemplate.postForObject(baseUrl+"credibleNinjaProfiles/", credibleNinjaEntity, CredibleNinjaEntity.class);
				if(credibleNinjaEntity==null)
				{
					log.info("User already exists..");
					return new RespWrapper("User already exists..",-1);
				}
				facebookEntity.setCn_id(Integer.toString(credibleNinjaEntity.getCn_id()));
				restTemplate.postForObject(baseUrl+"facebookProfiles/", facebookEntity, String.class);
				log.info("Done..!!");
			}
			else
			{
				return new RespWrapper("User details did not match..",-1);
			}
		}
		// TODO add code to fetch data from all other platforms and save in database.. keep refreshing that database daily at night..
		return new RespWrapper("User details added successfully..", credibleNinjaEntity.getCn_id());	
	}
	
	@RequestMapping("/showCurrentWeightage")
	public String showCurrentWeightage()
	{// Later return the values from map in a loop
		return  "Platforms: \n" +
				"FaceBook: " + PlatformWeightage.FACEBOOK_WT +
				"\n LinkedIn: " + PlatformWeightage.LINKEDIN_WT+
				"Commons: \n"+
		"NAME: "+CommonWeightage.NAME_WT+"\n" +
		"ADDRESS: "+CommonWeightage.ADDRESS_CITY_WT+"\n" +
		"DESIGNATION: "+CommonWeightage.CURRENT_DESIGNATION_WT+"\n" +
		"CURRENT ORGANIZATION: "+CommonWeightage.CURRENT_ORGANIZATION_WT+"\n" +
		"DOB: "+CommonWeightage.DOB_WT+"\n" +
		"GENDER: "+CommonWeightage.GENDER_WT+"\n";
	}
	
	@RequestMapping("/isAlive")
	public String isAlive()
	{
		return "Credible Ninjas API v1.2 alive";
	}
	
	
	
}
