package com.stpl.pms.struts.common;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.SecureRandom;
import java.util.Random;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;

public class Encryption {
	private static final Random RANDOM = new SecureRandom();
	private static String algorithm = "DES";
	private static Key key = null;
	private static Cipher cipher = null;

	static {
		try {
			setUp();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void setUp() throws Exception {
		key = KeyGenerator.getInstance(algorithm).generateKey();
		cipher = Cipher.getInstance(algorithm);
	}

	private static byte[] encrypt(String input)
			throws InvalidKeyException, 
			BadPaddingException,
			IllegalBlockSizeException {

		cipher.init(Cipher.ENCRYPT_MODE, key);
		byte[] inputBytes = input.getBytes();
		return cipher.doFinal(inputBytes);
	}

	private static String decrypt(byte[] encryptionBytes)
			throws InvalidKeyException, 
			BadPaddingException,
			IllegalBlockSizeException {
		cipher.init(Cipher.DECRYPT_MODE, key);
		byte[] recoveredBytes = 
				cipher.doFinal(encryptionBytes);
		String recovered = 
				new String(recoveredBytes);
		return recovered;
	}

	public static String createToken() {
		byte[] encryptionBytes = null;
		long currTime = System.currentTimeMillis();
		try {
			encryptionBytes = encrypt(generateGUID()+currTime);
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (BadPaddingException e) {
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			e.printStackTrace();
		}
		String token = "";
		try {
			token  = new String(encryptionBytes, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return token;
	}

	public static String generateGUID() {
		return new BigInteger(165, RANDOM).toString(36).toUpperCase();
	}

	public static void main(String[] args) throws InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
		byte[] encryptionBytes = null;
		String input = "7CC018DB3152D3F27FE14A97CA45AFC9";
		System.out.println("Entered: " + input);
		System.out.println();
		encryptionBytes = encrypt(input);
		//		for(Byte b : encryptionBytes) {
		//			System.out.print(b+",");
		//		}
		System.out.println(new String(encryptionBytes));
		//		System.out.println(encryptionBytes.hashCode());
		System.out.println();
		System.out.println(
				"Recovered: " + decrypt(encryptionBytes));
	}
}
