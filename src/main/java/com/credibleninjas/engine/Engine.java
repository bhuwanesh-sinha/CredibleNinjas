package com.credibleninjas.engine;

import java.util.List;

import com.credibleninjas.entities.AadharEntity;
import com.credibleninjas.entities.AbstractEntity;
import com.credibleninjas.entities.CredibleNinjaEntity;
import com.credibleninjas.entities.FacebookEntity;
import com.credibleninjas.entities.LinkedInEntity;
import com.credibleninjas.factory.PlatformWeightageFactory;
import com.credibleninjas.weightage.CommonWeightage;
import com.credibleninjas.weightage.PlatformWeightage;

public class Engine {

	public static Integer getCredibility(List<AbstractEntity> entityList, CredibleNinjaEntity credibleNinjaEntity) {
		int cred = 0;
		//AadharEntity aadharEntity = (AadharEntity) entityList.get(0);
		
		for(AbstractEntity entity : entityList)
		{
			cred = cred + getTotalPlatformScore(credibleNinjaEntity, entity) * PlatformWeightageFactory.getPlatformWeightage(entity);
		}
		
		return cred;
	}

	private static int getTotalPlatformScore(CredibleNinjaEntity credibleNinjaEntity, AbstractEntity abstractEntity) {
		int credibility = 0;
		credibility =  getNameCredibility(credibleNinjaEntity, abstractEntity)
								+ getAddressCredibility(credibleNinjaEntity, abstractEntity)
								+ getDOBCredibility(credibleNinjaEntity, abstractEntity)
								+ getGenderCredibility(credibleNinjaEntity, abstractEntity);
		
		return credibility;
	}

	

	private static int getGenderCredibility(CredibleNinjaEntity credibleNinjaEntity, AbstractEntity abstractEntity) {
		int cred = 0;
		if(credibleNinjaEntity.getGender().equals(abstractEntity.getGender()))
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

	private static int getDOBCredibility(CredibleNinjaEntity credibleNinjaEntity, AbstractEntity abstractEntity) {
		int cred = 0;
		if(credibleNinjaEntity.getDateOfBirth().equals(abstractEntity.getDateOfBirth()))
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

	private static int getAddressCredibility(CredibleNinjaEntity credibleNinjaEntity, AbstractEntity abstractEntity) {
		int cred = 0;
		if(credibleNinjaEntity.getAddress().contains(abstractEntity.getLocation()))
		{
			cred = cred + CommonWeightage.ADDRESS_CITY_WT;
		}
		else if(abstractEntity.getLocation().equals(null))
		{
			// don't effect credibility if parameter not present..
		}
		else
		{
			cred = cred - CommonWeightage.ADDRESS_CITY_WT;
		}
		return cred;
	}

	private static int getNameCredibility(CredibleNinjaEntity credibleNinjaEntity, AbstractEntity abstractEntity) {
		int cred = 0;
		String[] nameArray = abstractEntity.getName().split(" ");
		String fName = nameArray[0];
		String mName = nameArray[1];
		String lName = nameArray[2];
		
		if(!fName.equals(null) && credibleNinjaEntity.getName().contains(fName))
		{
			cred = cred + CommonWeightage.NAME_WT;
		}
		else
		{
			cred = cred - CommonWeightage.NAME_WT;
		}
		if(!fName.equals(null) && credibleNinjaEntity.getName().contains(mName))
			cred = cred + CommonWeightage.NAME_WT;
		if(!fName.equals(null) && credibleNinjaEntity.getName().contains(lName))
			cred = cred + CommonWeightage.NAME_WT;
		
		return cred;
	
	}

}
