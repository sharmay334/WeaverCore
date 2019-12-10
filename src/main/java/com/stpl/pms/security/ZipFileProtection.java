package com.stpl.pms.security;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.RandomStringUtils;

import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.model.ZipParameters;
import net.lingala.zip4j.util.Zip4jConstants;

public class ZipFileProtection {

	public static String ZIP_LOGIN_PASSWORD;
	public static int sms_mail_activity = 0;
	private Map<String,String> finalDataMap;
	public void createVirnRankZip(int gameNo,int batchNo,String path,String password){
		
		try{
			
			Map<String,String> zipFileMap= new HashMap<String, String>(); 
			String ZIP_FILE_NAME = path+""+gameNo+"/TextFiles/"+gameNo+"_"+batchNo+"_virnRankData.zip";
			
			ZipFile zipFile = new ZipFile(path+""+gameNo+"/TextFiles/"+gameNo+"_"+batchNo+"_virnRankData.zip");
			
			//Add files to be archived into zip file
			ArrayList<File> filesToAdd = new ArrayList<File>();
			filesToAdd.add(new File(path+"/"+gameNo+"/TextFiles/"+gameNo+"_"+batchNo+"_VIRN_Ticket_1234.txt"));
			filesToAdd.add(new File(path+"/"+gameNo+"/TextFiles/"+gameNo+"_"+batchNo+"_Rank.txt"));
			
			
			//Initiate Zip Parameters which define various properties
			ZipParameters parameters = new ZipParameters();
			parameters.setCompressionMethod(Zip4jConstants.COMP_DEFLATE); // set compression method to deflate compression
			
			//DEFLATE_LEVEL_FASTEST 	- Lowest compression level but higher speed of compression
			//DEFLATE_LEVEL_FAST 		- Low compression level but higher speed of compression
			//DEFLATE_LEVEL_NORMAL 	- Optimal balance between compression level/speed
			//DEFLATE_LEVEL_MAXIMUM 	- High compression level with a compromise of speed
			//DEFLATE_LEVEL_ULTRA 		- Highest compression level but low speed
			parameters.setCompressionLevel(Zip4jConstants.DEFLATE_LEVEL_NORMAL); 
			
			//Set the encryption flag to true
			parameters.setEncryptFiles(true);
			
			//Set the encryption method to AES Zip Encryption
			parameters.setEncryptionMethod(Zip4jConstants.ENC_METHOD_AES);
			
			//AES_STRENGTH_128 - For both encryption and decryption
			//AES_STRENGTH_192 - For decryption only
			//AES_STRENGTH_256 - For both encryption and decryption
			//Key strength 192 cannot be used for encryption. But if a zip file already has a
			//file encrypted with key strength of 192, then Zip4j can decrypt this file
			parameters.setAesKeyStrength(Zip4jConstants.AES_STRENGTH_256);
			
			//Set password
			
			parameters.setPassword(password);
			
			
			//Now add files to the zip file
			zipFile.addFiles(filesToAdd, parameters);
			zipFileMap.put(ZIP_FILE_NAME,gameNo+"_"+batchNo+"_virnRankData.zip");
			finalDataMap.put(ZIP_FILE_NAME,gameNo+"_"+batchNo+"_virnRankData.zip");
			copyZipFileToBackup(ZIP_FILE_NAME,path,gameNo,batchNo,"_virnRankData.zip");
			deleteFile(path+"/"+gameNo+"/TextFiles/"+gameNo+"_"+batchNo+"_VIRN_Ticket_1234.txt");
		}catch(Exception e){e.printStackTrace();}
		
	}
	
	public Map<String,String> zipFileName(int gameNO,int batchNo,String path,String userName) throws Exception{
		try {
			finalDataMap = new HashMap<>();
			//This is name and path of zip file to be created
			Map<String,String> zipFileMap= new HashMap<String, String>(); 
			String ZIP_FILE_NAME = path+""+gameNO+"/TextFiles/"+gameNO+"_"+batchNo+"_printReadyData.zip";
			
			ZipFile zipFile = new ZipFile(path+""+gameNO+"/TextFiles/"+gameNO+"_"+batchNo+"_printReadyData.zip");
			
			//Add files to be archived into zip file
			ArrayList<File> filesToAdd = new ArrayList<File>();
		//	filesToAdd.add(new File(path+"/"+gameNO+"/TextFiles/"+gameNO+"_"+batchNo+"_After-Merge-Final-VIRN.txt"));
			filesToAdd.add(new File(path+"/"+gameNO+"/TextFiles/"+gameNO+"_"+batchNo+"-shuffled.txt"));
			filesToAdd.add(new File(path+"/"+gameNO+"/TextFiles/"+gameNO+"_"+batchNo+"_bookListing.txt"));
			filesToAdd.add(new File(path+"/"+gameNO+"/TextFiles/"+gameNO+"_"+batchNo+"_packListing.txt"));
			filesToAdd.add(new File(path+"/"+gameNO+"/TextFiles/"+gameNO+"_"+batchNo+"_halfPackBookListing.txt"));
			
			//Initiate Zip Parameters which define various properties
			ZipParameters parameters = new ZipParameters();
			parameters.setCompressionMethod(Zip4jConstants.COMP_DEFLATE); // set compression method to deflate compression
			
			//DEFLATE_LEVEL_FASTEST 	- Lowest compression level but higher speed of compression
			//DEFLATE_LEVEL_FAST 		- Low compression level but higher speed of compression
			//DEFLATE_LEVEL_NORMAL 	- Optimal balance between compression level/speed
			//DEFLATE_LEVEL_MAXIMUM 	- High compression level with a compromise of speed
			//DEFLATE_LEVEL_ULTRA 		- Highest compression level but low speed
			parameters.setCompressionLevel(Zip4jConstants.DEFLATE_LEVEL_NORMAL); 
			
			//Set the encryption flag to true
			parameters.setEncryptFiles(true);
			
			//Set the encryption method to AES Zip Encryption
			parameters.setEncryptionMethod(Zip4jConstants.ENC_METHOD_AES);
			
			//AES_STRENGTH_128 - For both encryption and decryption
			//AES_STRENGTH_192 - For decryption only
			//AES_STRENGTH_256 - For both encryption and decryption
			//Key strength 192 cannot be used for encryption. But if a zip file already has a
			//file encrypted with key strength of 192, then Zip4j can decrypt this file
			parameters.setAesKeyStrength(Zip4jConstants.AES_STRENGTH_256);
			
			//Set password
			ZIP_LOGIN_PASSWORD = getRandomPassword(userName.substring(0,4).toUpperCase());
			parameters.setPassword(ZIP_LOGIN_PASSWORD);
			
			
			//Now add files to the zip file
			zipFile.addFiles(filesToAdd, parameters);
			zipFileMap.put(ZIP_FILE_NAME,gameNO+"_"+batchNo+"_printReadyData.zip");
			copyZipFileToBackup(ZIP_FILE_NAME,path,gameNO,batchNo,"_printReadyData.zip");
			finalDataMap.put(ZIP_FILE_NAME,gameNO+"_"+batchNo+"_printReadyData.zip");
			createVirnRankZip(gameNO,batchNo,path,ZIP_LOGIN_PASSWORD);
			deleteFile(path+"/"+gameNO+"/TextFiles/"+gameNO+"_"+batchNo+"-shuffled.txt");
			path = path.substring(0,path.lastIndexOf("/"));
			path = path.substring(0,path.lastIndexOf("/"));
			path = path.substring(0,path.lastIndexOf("/"));
			path = path.substring(0,path.lastIndexOf("/"));
			path = path.substring(0,path.lastIndexOf("/"));
			path = path.substring(0,path.lastIndexOf("/"));
			path = path.substring(0,path.lastIndexOf("/"));
			
			//deleteFile(path+"/docs/.empty/"+gameNO+"/"+gameNO+"_"+batchNo+"-shuffled.txt");
			return finalDataMap;
		} 
		catch (ZipException e)
		{
			e.printStackTrace();
		}
		return null;
		
	}
	
	/*public Map<String,String> zipFileNameCopy(int gameNO,int batchNo,String path,String userName){
		try {
			finalDataMap = new HashMap<>();
			//This is name and path of zip file to be created
			Map<String,String> zipFileMap= new HashMap<String, String>(); 
			String ZIP_FILE_NAME = path+"/docs/.empty/"+gameNO+"/"+gameNO+"_"+batchNo+"_printReadyData.zip";
			
			ZipFile zipFile = new ZipFile(path+"/docs/.empty/"+gameNO+"/"+gameNO+"_"+batchNo+"_printReadyData.zip");
			
			//Add files to be archived into zip file
			ArrayList<File> filesToAdd = new ArrayList<File>();
			//filesToAdd.add(new File(path+"/docs/.empty/"+gameNO+"/"+gameNO+"_"+batchNo+"_After-Merge-Final-VIRN.txt"));
			filesToAdd.add(new File(path+"/docs/.empty/"+gameNO+"/"+gameNO+"_"+batchNo+"-shuffled.txt"));
			
			//Initiate Zip Parameters which define various properties
			ZipParameters parameters = new ZipParameters();
			parameters.setCompressionMethod(Zip4jConstants.COMP_DEFLATE); // set compression method to deflate compression
			
			//DEFLATE_LEVEL_FASTEST 	- Lowest compression level but higher speed of compression
			//DEFLATE_LEVEL_FAST 		- Low compression level but higher speed of compression
			//DEFLATE_LEVEL_NORMAL 	- Optimal balance between compression level/speed
			//DEFLATE_LEVEL_MAXIMUM 	- High compression level with a compromise of speed
			//DEFLATE_LEVEL_ULTRA 		- Highest compression level but low speed
			parameters.setCompressionLevel(Zip4jConstants.DEFLATE_LEVEL_NORMAL); 
			
			//Set the encryption flag to true
			parameters.setEncryptFiles(true);
			
			//Set the encryption method to AES Zip Encryption
			parameters.setEncryptionMethod(Zip4jConstants.ENC_METHOD_AES);
			
			//AES_STRENGTH_128 - For both encryption and decryption
			//AES_STRENGTH_192 - For decryption only
			//AES_STRENGTH_256 - For both encryption and decryption
			//Key strength 192 cannot be used for encryption. But if a zip file already has a
			//file encrypted with key strength of 192, then Zip4j can decrypt this file
			parameters.setAesKeyStrength(Zip4jConstants.AES_STRENGTH_256);
			
			//Set password
			ZIP_LOGIN_PASSWORD = getRandomPassword(userName.substring(0,4).toUpperCase());
			parameters.setPassword(ZIP_LOGIN_PASSWORD);
			
			
			//Now add files to the zip file
			zipFile.addFiles(filesToAdd, parameters);
			zipFileMap.put(ZIP_FILE_NAME,gameNO+"_"+batchNo+"_printReadyData.zip");
			finalDataMap.put(ZIP_FILE_NAME, gameNO+"_"+batchNo+"_printReadyData.zip");
			createVirnRankZipCopy(gameNO,batchNo,path,ZIP_LOGIN_PASSWORD);
			deleteShuffleFile(path+"/docs/.empty/"+gameNO+"/"+gameNO+"_"+batchNo+"_VIRN_Ticket_1234.txt");
			deleteShuffleFile(path+"/docs/.empty/"+gameNO+"/"+gameNO+"_"+batchNo+"-shuffled.txt");
			
			return finalDataMap;
		} 
		catch (ZipException e)
		{
			e.printStackTrace();
		}
		return null;
		
	}
	
public void createVirnRankZipCopy(int gameNo,int batchNo,String path,String password){
		
		try{
			
			Map<String,String> zipFileMap= new HashMap<String, String>(); 
			String ZIP_FILE_NAME = path+"/docs/.empty/"+gameNo+"/"+gameNo+"_"+batchNo+"_virnRankData.zip";
			
			ZipFile zipFile = new ZipFile(ZIP_FILE_NAME);
			
			//Add files to be archived into zip file
			ArrayList<File> filesToAdd = new ArrayList<File>();
			filesToAdd.add(new File(path+"/"+gameNo+"/TextFiles/"+gameNo+"_"+batchNo+"_VIRN_Ticket_1234.txt"));
			filesToAdd.add(new File(path+"/"+gameNo+"/TextFiles/"+gameNo+"_"+batchNo+"_Rank.txt"));
			
			//Initiate Zip Parameters which define various properties
			ZipParameters parameters = new ZipParameters();
			parameters.setCompressionMethod(Zip4jConstants.COMP_DEFLATE); // set compression method to deflate compression
			
			//DEFLATE_LEVEL_FASTEST 	- Lowest compression level but higher speed of compression
			//DEFLATE_LEVEL_FAST 		- Low compression level but higher speed of compression
			//DEFLATE_LEVEL_NORMAL 	- Optimal balance between compression level/speed
			//DEFLATE_LEVEL_MAXIMUM 	- High compression level with a compromise of speed
			//DEFLATE_LEVEL_ULTRA 		- Highest compression level but low speed
			parameters.setCompressionLevel(Zip4jConstants.DEFLATE_LEVEL_NORMAL); 
			
			//Set the encryption flag to true
			parameters.setEncryptFiles(true);
			
			//Set the encryption method to AES Zip Encryption
			parameters.setEncryptionMethod(Zip4jConstants.ENC_METHOD_AES);
			
			//AES_STRENGTH_128 - For both encryption and decryption
			//AES_STRENGTH_192 - For decryption only
			//AES_STRENGTH_256 - For both encryption and decryption
			//Key strength 192 cannot be used for encryption. But if a zip file already has a
			//file encrypted with key strength of 192, then Zip4j can decrypt this file
			parameters.setAesKeyStrength(Zip4jConstants.AES_STRENGTH_256);
			
			//Set password
			
			parameters.setPassword(password);
			
			
			//Now add files to the zip file
			zipFile.addFiles(filesToAdd, parameters);
			zipFileMap.put(ZIP_FILE_NAME,gameNo+"_"+batchNo+"_virnRankData.zip.zip");
			finalDataMap.put(ZIP_FILE_NAME,gameNo+"_"+batchNo+"_virnRankData.zip.zip");
			copyZipFileToBackup(ZIP_FILE_NAME,path,gameNo,batchNo,"_virnRankData.zip");
			
		}catch(Exception e){e.printStackTrace();}
		
	}*/
	
	public void copyZipFileToBackup(String zipPath,String topath,int gameNo,int batchNo,String fileName) throws Exception{
		 FileInputStream fis  = new FileInputStream(zipPath);
		topath = topath.substring(0,topath.lastIndexOf("/"));
		topath = topath.substring(0,topath.lastIndexOf("/"));
		topath = topath.substring(0,topath.lastIndexOf("/"));
		topath = topath.substring(0,topath.lastIndexOf("/"));
		topath = topath.substring(0,topath.lastIndexOf("/"));
		topath = topath.substring(0,topath.lastIndexOf("/"));
		topath = topath.substring(0,topath.lastIndexOf("/"));
		 FileOutputStream fos = new FileOutputStream(topath+"/docs/.empty/"+gameNo+"/"+gameNo+"_"+batchNo+fileName);
		try{

			 byte[] buf = new byte[4096];
			    int i = 0;
			    while ((i = fis.read(buf)) != -1) {
			        fos.write(buf, 0, i);
			    }
			
		}catch(Exception e){ throw e;}
		finally {
		    if (fis != null) fis.close();
		    if (fos != null) fos.close();
		  }
		
	}
		public String getRandomPassword(String username){
			String characters = "1234==567890AB@CDE@@@F????GHKL####MNOP+_QRSTU56?9VX@@@YZabc+_defgh===klmn5678?????9opqrs@tuvw---xyz#####";
			String pwd =username+RandomStringUtils.random(6, characters);
			char temp[] = pwd.toCharArray();
			System.out.println("HEX-STRING::::::::"+Integer.toHexString(temp[0])+Integer.toHexString(temp[1])+Integer.toHexString(temp[2])+Integer.toHexString(temp[3])+Integer.toHexString(temp[4])+Integer.toHexString(temp[5])+Integer.toHexString(temp[6])+Integer.toHexString(temp[7])+Integer.toHexString(temp[8])+Integer.toHexString(temp[9]));
			return pwd;
		}
		
		public void deleteFile(String fileName){
			try{
	    		
	    		File file = new File(fileName);
	        	
	    		if(file.delete()){
	    			System.out.println("file is deleted!");
	    		}else{
	    			System.out.println("Delete operation is failed.");
	    		}
	    	   
	    	}catch(Exception e){
	    		
	    		e.printStackTrace();
	    		
	    	}
			
		}

	}

