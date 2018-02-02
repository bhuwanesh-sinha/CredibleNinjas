package com.credibleninjas.engine;

import java.util.List;

import com.credibleninjas.entities.AadharEntity;
import com.credibleninjas.entities.AbstractEntity;
import com.credibleninjas.entities.FacebookEntity;
import com.credibleninjas.entities.LinkedInEntity;
import com.credibleninjas.factory.PlatformWeightageFactory;
import com.credibleninjas.weightage.CommonWeightage;
import com.credibleninjas.weightage.PlatformWeightage;

public class Engine {

	public static Integer getCredibility(List<AbstractEntity> entityList) {
		int cred = 0;
		AadharEntity aadharEntity = (AadharEntity) entityList.get(0);
		
		for(AbstractEntity entity : entityList)
		{
			if(!(entity instanceof AadharEntity))
			cred = cred + getTotalPlatformScore(aadharEntity, entity) * PlatformWeightageFactory.getPlatformWeightage(entity);
		}
		
		return cred;
	}

	private static int getTotalPlatformScore(AadharEntity aadharEntity, AbstractEntity abstractEntity) {
		int credibility = 0;
		credibility =  getNameCredibility(aadharEntity, abstractEntity)
								+ getAddressCredibility(aadharEntity, abstractEntity)
								+ getDOBCredibility(aadharEntity, abstractEntity)
								+ getGenderCredibility(aadharEntity, abstractEntity);
		
		return credibility;
	}

	

	private static int getGenderCredibility(AadharEntity aadharEntity, AbstractEntity abstractEntity) {
		int cred = 0;
		if(aadharEntity.getGender().equals(abstractEntity.getGender()))
		{
			cred = cred + CommonWeightage.GENDER_WT;
		}
		else if(abstractEntity.getGender().equals(null))
		{
			// don't effect credibility if parameter not present..
		}
		else
		{
			cred = cred - CommonWeightage.GENDER_WT;
		}
		return cred;
	}

	private static int getDOBCredibility(AadharEntity aadharEntity, AbstractEntity abstractEntity) {
		int cred = 0;
		if(aadharEntity.getDateOfBirth().equals(abstractEntity.getDateOfBirth()))
		{
			cred = cred + CommonWeightage.DOB_WT;
		}
		else if(abstractEntity.getDateOfBirth().equals(null))
		{
			// don't effect credibility if parameter not present..
		}
		else
		{
			cred = cred - CommonWeightage.DOB_WT;
		}
		return cred;
	}

	private static int getAddressCredibility(AadharEntity aadharEntity, AbstractEntity abstractEntity) {
		int cred = 0;
		if(aadharEntity.getAddress().contains(abstractEntity.getAddress()))
		{
			cred = cred + CommonWeightage.ADDRESS_CITY_WT;
		}
		else if(abstractEntity.getAddress().equals(null))
		{
			// don't effect credibility if parameter not present..
		}
		else
		{
			cred = cred - CommonWeightage.ADDRESS_CITY_WT;
		}
		return cred;
	}

	private static int getNameCredibility(AadharEntity aadharEntity, AbstractEntity abstractEntity) {
		int cred = 0;
		String[] nameArray = abstractEntity.getName().split(" ");
		String fName = nameArray[0];
		String mName = nameArray[1];
		String lName = nameArray[2];
		
		if(!fName.equals(null) && aadharEntity.getName().contains(fName))
		{
			cred = cred + CommonWeightage.NAME_WT;
		}
		else
		{
			cred = cred - CommonWeightage.NAME_WT;
		}
		if(!fName.equals(null) && aadharEntity.getName().contains(mName))
			cred = cred + CommonWeightage.NAME_WT;
		if(!fName.equals(null) && aadharEntity.getName().contains(lName))
			cred = cred + CommonWeightage.NAME_WT;
		
		return cred;
	
	}

}
