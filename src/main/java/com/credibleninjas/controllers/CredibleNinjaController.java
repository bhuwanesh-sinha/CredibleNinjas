package com.credibleninjas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.credibleninjas.entities.AadharEntity;
import com.credibleninjas.entities.CredibleNinjaEntity;
import com.credibleninjas.entities.FacebookEntity;
import com.credibleninjas.services.CredibleNinjaService;


@RestController
public class CredibleNinjaController {
	@Autowired
	private CredibleNinjaService credibleNinjaService;

	
	@RequestMapping(method=RequestMethod.POST, value="/credibleNinjaProfiles")
	public CredibleNinjaEntity addCredibleNinjaProfile(@RequestBody CredibleNinjaEntity credibleNinjaEntity){
		return credibleNinjaService.addCredibleNinjaProfile(credibleNinjaEntity);
		
	}
	
	@RequestMapping("/credibleNinjaProfiles")
	public List<CredibleNinjaEntity> getAllCredibleNinjaProfiles() {

		return credibleNinjaService.getAllCredibleNinjaProfiles();

	}
	
	@RequestMapping("/credibleNinjaProfiles/{cn_id}")
	public CredibleNinjaEntity getCredibleNinjaProfile(@PathVariable int cn_id){
		return credibleNinjaService.getCredibleNinjaProfile(cn_id);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/credibleNinjaProfiles/{id}")
	public void updateCredibleNinjaProfile(@RequestBody CredibleNinjaEntity credibleNinjaEntity, @PathVariable int id){
		credibleNinjaService.updateCredibleNinjaProfile(credibleNinjaEntity,id);
		
	}
	
	
}

