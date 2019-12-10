package com.stpl.pms.utility;

import java.util.Random;

import com.stpl.pms.constants.ClientNames;
import org.apache.log4j.Logger;

public abstract class AutoGenerate {
	private static final Logger log=Logger.getLogger(AutoGenerate.class);
 
	public static String autoPassword() {
		log.info("--In Auto Password--");
		Random r = new Random();

		StringBuffer newString = new StringBuffer();
		//No of Big letters in password
		int a1 = r.nextInt(6)+1;
		//No of small letters in password
//		int a2 = r.nextInt(7-a1)+1;
		//no on numbers
//		int a3 = 8-a1-a2;
		int a3 = 8-a1;
		
		for(int j=0;j<a1;j++){
			char c1= (char) (r.nextInt(26)+65);
			//AL.add(new Character(c1));
			 newString.append(new Character(c1));
		}
//		for(int j=0;j<a2;j++){
//			char c1= (char) (r.nextInt(26)+97);
//			//AL.add(new Character(c1));
//			newString.append(new Character(c1));
//		}
		for(int j=0;j<a3;j++){
			char c1= (char) (r.nextInt(9)+48);
			//AL.add(new Character(c1));
			newString.append(new Character(c1));
		}
		//log.info("pwd = "+newString.toString());
		return newString.toString();
	}
	
	public static String getAlphaNumSpecialPassword()
	{
		StringBuffer newString = new StringBuffer();
		String specchars = "!$?^_@[]{|}~";
		Random r = new Random();

		
		//No of small letters in password
		int a1 = r.nextInt(5)+1;
		//No of special characters in password
		int a2 = r.nextInt(6-a1)+1;
		//No of BIG letters in password
		int a3 = r.nextInt(7-a1-a2)+1;
		//no of numbers
		int a4 = 8-a1-a2-a3;
		
		for(int j=0;j<a1;j++){
			char c1= (char) (r.nextInt(26)+97);
			//AL.add(new Character(c1));
			 newString.append(new Character(c1));
		}
		for(int j=0;j<a2;j++){
			Random r1 = new Random();
			char c1= specchars.charAt(r1.nextInt(specchars.length()));
			//AL.add(new Character(c1));
			newString.append(new Character(c1));
		}
		for(int j=0;j<a3;j++){
			Random r1 = new Random();
			char c1= (char) (r1.nextInt(26)+65);
			//AL.add(new Character(c1));
			newString.append(new Character(c1));
		}
		for(int j=0;j<a4;j++){
			char c1= (char) (r.nextInt(9)+48);
			//AL.add(new Character(c1));
			newString.append(new Character(c1));
		}
		//log.info("pwd = "+newString.toString());
		return newString.toString();
	}
	
	public static String getAlphaNumPassword()
	{
		Random r = new Random();
		StringBuffer newString = new StringBuffer();
		
		//No of small letters in password
		int a1 = r.nextInt(6)+1;
		//No of BIG letters in password
		int a2 = r.nextInt(7-a1);
		//no on numbers
		int a3 = 8-a1-a2;
		
		for(int j=0;j<a1;j++){
			char c1= (char) (r.nextInt(26)+97);
			//AL.add(new Character(c1));
			 newString.append(new Character(c1));
		}
		for(int j=0;j<a2;j++){
			char c1= (char) (r.nextInt(26)+65);
			//AL.add(new Character(c1));
			newString.append(new Character(c1));
		}
		for(int j=0;j<a3;j++){
			char c1= (char) (r.nextInt(9)+48);
			//AL.add(new Character(c1));
			newString.append(new Character(c1));
		}
		//log.info("pwd = "+newString.toString());
		return newString.toString();
	}
	
	public static String getNumPassword()
	{
		Random r = new Random();
		StringBuffer newString = new StringBuffer();
		
		//No of small letters in password
//		int a1 = r.nextInt(6)+1;
//		//No of BIG letters in password
//		int a2 = r.nextInt(7-a1);
		//no on numbers
		int a3 = 4;
		
//		for(int j=0;j<a1;j++){
//			char c1= (char) (r.nextInt(9)+48);
//			//AL.add(new Character(c1));
//			 newString.append(new Character(c1));
//		}
//		for(int j=0;j<a2;j++){
//			char c1= (char) (r.nextInt(9)+48);
//			//AL.add(new Character(c1));
//			newString.append(new Character(c1));
//		}
		for(int j=0;j<a3;j++){
			char c1= (char) (r.nextInt(9)+48);
			//AL.add(new Character(c1));
			newString.append(new Character(c1));
		}
		//log.info("pwd = "+newString.toString());
		return newString.toString();
	}
	
	public static void main(String[] args) {
		System.out.println(getNumPassword());
	}
	
	public static String getAlphaNumCapsPassword()
	{
		Random r = new Random();
		StringBuffer newString = new StringBuffer();
		
		//No of Big letters in password
		int a1 = r.nextInt(6)+1;
		//No of small letters in password
		int a2 = r.nextInt(7-a1)+1;
		//no on numbers
		int a3 = 8-a1-a2;
		
		for(int j=0;j<a1;j++){
			char c1= (char) (r.nextInt(26)+97);
			//AL.add(new Character(c1));
			 newString.append(new Character(c1));
		}
		for(int j=0;j<a2;j++){
			char c1= (char) (r.nextInt(26)+65);
			//AL.add(new Character(c1));
			newString.append(new Character(c1));
		}
		for(int j=0;j<a3;j++){
			char c1= (char) (r.nextInt(9)+48);
			//AL.add(new Character(c1));
			newString.append(new Character(c1));
		}
		//log.info("pwd = "+newString.toString());
		return newString.toString();
	}
	public static String getFirstLastLetterPassword()
	{
		Random r = new Random();
		StringBuffer newString = new StringBuffer();
		
		//No of Big letters in password
		int a1 = r.nextInt(5)+1;
		//No of small letters in password
		int a2 = r.nextInt(6-a1);
		//no on numbers
		int a3 = r.nextInt(7-a1-a2);
		//No of letters in last
		int a4 = 8-a1-a2-a3;
		for(int j=0;j<a1;j++){
			char c1= (char) (r.nextInt(26)+97);
			//AL.add(new Character(c1));
			 newString.append(new Character(c1));
		}
		for(int j=0;j<a2;j++){
			Random r1 = new Random();
			char c1= (char) (r1.nextInt(26)+65);
			//AL.add(new Character(c1));
			newString.append(new Character(c1));
		}
		for(int j=0;j<a3;j++){
			char c1= (char) (r.nextInt(9)+48);
			//AL.add(new Character(c1));
			newString.append(new Character(c1));
		}
		for(int j=0;j<a4;j++){
			char c1= (char) (r.nextInt(26)+97);
			//AL.add(new Character(c1));
			newString.append(new Character(c1));
		}
		//log.info("pwd = "+newString.toString());
		return newString.toString();
	}

	public static char[] getNumericPassword(int size) {
		Random rand= new Random();
	    char[] token= new char[size];	    
	    for (int i = 0; i < token.length; i++) {
	    		token[i]=(char)(rand.nextInt(10) + 48);//57- 48
		}
	    return token;
	}

	public static String genPassword(String passwordPolicy, String profile) {
		String password = null;
		if ("NUMERIC".equals(passwordPolicy)) {
			if (profile != null && ClientNames.ITHUBA.toString().equals(profile)) {
				password = String.valueOf(getNumericPassword(5));
			} else {
				password = String.valueOf(getNumericPassword(4));
			}
		} else if ("FIRSTLASTLETTER".equals(passwordPolicy)) {
			password = getFirstLastLetterPassword();
		} else if ("ALPHANUM".equals(passwordPolicy)) {
			password = getAlphaNumPassword();
		} else if("ALPHANUMCAPS".equals(passwordPolicy)) {
			password = getAlphaNumCapsPassword();
		} else if("ALPHANUMSPECIAL".equals(passwordPolicy)) {
			password = getAlphaNumSpecialPassword();
		} else if("GENERIC".equals(passwordPolicy)){
			password=getAlphaNumPassword();
		}
		return password;

	}

	public static String genPassword(String passwordPolicy){
		return genPassword(passwordPolicy, null);
	}
}