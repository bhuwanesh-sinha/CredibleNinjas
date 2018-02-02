package com.credibleninjas.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.credibleninjas.entities.AadharEntity;
import com.credibleninjas.services.AadharService;

@RestController
public class AadharController {
	@Autowired
	private AadharService aadharService;

	@RequestMapping("/aadhars")
	public List<AadharEntity> getAllTopics() {

		return aadharService.getAllAadhar();

	}
	
	@RequestMapping("/aadhars/{id}")
	public AadharEntity getAadhar(@PathVariable String id){
		return aadharService.getAadhar(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/aadhars")
	public void addAadhar(@RequestBody AadharEntity aadharEntity){
		aadharService.addAadhar(aadharEntity);
		
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/aadhars/{id}")
	public void updateAadhar(@RequestBody AadharEntity aadharEntity, @PathVariable String id){
		aadharService.updateAadhar(aadharEntity,id);
		
	}
}
