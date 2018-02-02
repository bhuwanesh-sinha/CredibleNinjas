package com.credibleninjas.factory;

import com.credibleninjas.entities.AbstractEntity;
import com.credibleninjas.entities.FacebookEntity;
import com.credibleninjas.entities.LinkedInEntity;
import com.credibleninjas.weightage.PlatformWeightage;

public class PlatformWeightageFactory {

	public static int getPlatformWeightage(AbstractEntity entity) {
		if(entity instanceof FacebookEntity)
			return PlatformWeightage.FACEBOOK_WT;
		if(entity instanceof LinkedInEntity)
			return PlatformWeightage.LINKEDIN_WT;
		return 0;
	}

}
