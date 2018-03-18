package Utilities;

import java.util.ArrayList;

public class ParametersCheck {
	
	static public boolean verifyName(String nameToCheck, String nameToCheckAgainst){
		int matchingFactor = 0;
		nameToCheck.replace('.', ' ');
		nameToCheck = nameToCheck.trim();
		String[] nameToCheckArray = nameToCheck.split(" ");
		ArrayList<String> namePossibilities = generatePossibilities(nameToCheckAgainst);
		for(String name : nameToCheckArray)
		{
			for(String names : namePossibilities)
			{
				if(name.equals(names))
					matchingFactor++;
			}
		}
		if(matchingFactor>1)
			return true;
		else
			return false;	
	}

	/*Generates all possible name combination from given name*/
	
	private static ArrayList generatePossibilities(String nameToCheckAgainst) {
		ArrayList<String> namePossibilities = new ArrayList<String>();
		String[] nameArray = nameToCheckAgainst.split(" ");
		namePossibilities.add(nameArray[0].trim()); 
		namePossibilities.add(nameArray[0].split("")[0].toUpperCase()); 
		namePossibilities.add(nameArray[1].trim()); 
		namePossibilities.add(nameArray[1].split("")[0].toUpperCase()); 
		namePossibilities.add(nameArray[2].trim()); 
		namePossibilities.add(nameArray[2].split("")[0].toUpperCase()); 
		
		return namePossibilities;
	}

}
