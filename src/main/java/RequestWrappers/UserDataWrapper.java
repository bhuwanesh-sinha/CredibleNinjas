package RequestWrappers;

import com.credibleninjas.entities.FacebookEntity;

public class UserDataWrapper {

FacebookEntity facebookEntity;
String aadharNumber;

public FacebookEntity getFacebookEntity() {
	return facebookEntity;
}

public void setFacebookEntity(FacebookEntity facebookEntity) {
	this.facebookEntity = facebookEntity;
}

public String getAadharNumber() {
	return aadharNumber;
}

public void setAadharNumber(String aadharNumber) {
	this.aadharNumber = aadharNumber;
}

 

public UserDataWrapper(FacebookEntity facebookEntity, String aadharNumber) {
	super();
	this.facebookEntity = facebookEntity;
	this.aadharNumber = aadharNumber;
}

public UserDataWrapper() {
	
}

}
