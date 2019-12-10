package com.stpl.pms.utility;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;

import org.apache.commons.codec.binary.Base64;


public class EncpDecpUtil {
	public static byte[] keyGeneratorAES() {
		KeyGenerator kgen;
		try {
			kgen = KeyGenerator.getInstance("AES");
			kgen.init(128); // 192 and 256 bits may not be available

			// Generate the secret key specs.
			SecretKey skey = kgen.generateKey();
			return skey.getEncoded();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}

		return null;
	}

	public static byte[] keyGeneratorDES() {
		KeyGenerator kgen;

		try {
			kgen = KeyGenerator.getInstance("DES");
			kgen.init(56); // 192 and 256 bits may not be available

			// Generate the secret key specs.
			SecretKey skey = kgen.generateKey();
			return skey.getEncoded();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}

		return null;
	}

	// BASE64Encoder
	public static String encodeAES(byte[] rawKey, String value) {

		// KeyGenerator kgen;
		try {

			SecretKeySpec skeySpec = new SecretKeySpec(rawKey, "AES");

			// Instantiate the cipher

			Cipher cipher = Cipher.getInstance("AES");

			cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
			return Base64.encodeBase64String(cipher.doFinal(value.getBytes()));
		} catch (NoSuchAlgorithmException e) {

			e.printStackTrace();
		} catch (NoSuchPaddingException e) {

			e.printStackTrace();
		} catch (InvalidKeyException e) {

			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {

			e.printStackTrace();
		} catch (BadPaddingException e) {

			e.printStackTrace();
		}

		return null;

	}

	public static byte[] encodeAES(byte[] rawKey, byte[] value) {

		// KeyGenerator kgen;
		try {

			SecretKeySpec skeySpec = new SecretKeySpec(rawKey, "AES");

			// Instantiate the cipher

			Cipher cipher = Cipher.getInstance("AES");

			cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
			return cipher.doFinal(value);
		} catch (NoSuchAlgorithmException e) {

			e.printStackTrace();
		} catch (NoSuchPaddingException e) {

			e.printStackTrace();
		} catch (InvalidKeyException e) {

			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {

			e.printStackTrace();
		} catch (BadPaddingException e) {

			e.printStackTrace();
		}

		return null;

	}

	public static String decodeAES(byte[] rawKey, String encrypted) {

		SecretKeySpec skeySpec = new SecretKeySpec(rawKey, "AES");

		// Instantiate the cipher

		Cipher cipher;
		try {
			cipher = Cipher.getInstance("AES");
			cipher.init(Cipher.DECRYPT_MODE, skeySpec);
			return new String(cipher.doFinal(Base64.decodeBase64(encrypted)), "UTF-8");
		} catch (NoSuchAlgorithmException e) {

			e.printStackTrace();
		} catch (NoSuchPaddingException e) {

			e.printStackTrace();
		} catch (InvalidKeyException e) {

			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {

			e.printStackTrace();
		} catch (BadPaddingException e) {

			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}

	public static byte[] decodeAES(byte[] rawKey, byte[] encrypted) {

		SecretKeySpec skeySpec = new SecretKeySpec(rawKey, "AES");

		// Instantiate the cipher

		Cipher cipher;
		try {
			cipher = Cipher.getInstance("AES");
			cipher.init(Cipher.DECRYPT_MODE, skeySpec);
			return cipher.doFinal(encrypted);
		} catch (NoSuchAlgorithmException e) {

			e.printStackTrace();
		} catch (NoSuchPaddingException e) {

			e.printStackTrace();
		} catch (InvalidKeyException e) {

			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {

			e.printStackTrace();
		} catch (BadPaddingException e) {

			e.printStackTrace();
		}

		return null;
	}

	public static byte[] encodeDES(byte[] rawKey, byte[] value) {

		// KeyGenerator kgen;
		try {

			SecretKeySpec skeySpec = new SecretKeySpec(rawKey, "DES");

			// Instantiate the cipher

			Cipher cipher = Cipher.getInstance("DES");

			cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
			return cipher.doFinal(value);
		} catch (NoSuchAlgorithmException e) {

			e.printStackTrace();
		} catch (NoSuchPaddingException e) {

			e.printStackTrace();
		} catch (InvalidKeyException e) {

			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {

			e.printStackTrace();
		} catch (BadPaddingException e) {

			e.printStackTrace();
		}

		return null;

	}

	public static byte[] decodeDES(byte[] rawKey, byte[] encrypted) {

		SecretKeySpec skeySpec = new SecretKeySpec(rawKey, "DES");

		// Instantiate the cipher

		Cipher cipher = null;
		try {
			cipher = Cipher.getInstance("DES");
			cipher.init(Cipher.DECRYPT_MODE, skeySpec);
			return cipher.doFinal(encrypted);
		} catch (NoSuchAlgorithmException e) {

			e.printStackTrace();
		} catch (NoSuchPaddingException e) {

			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {

			e.printStackTrace();
		} catch (BadPaddingException e) {

			e.printStackTrace();
		} catch (InvalidKeyException e) {

			e.printStackTrace();
		}

		return null;

	}
	
	public static void main(String[] args) throws IOException {
////	byte[] main_key = EncpDecpUtil.keyGeneratorAES();
////	byte[] game_key2 = EncpDecpUtil.keyGeneratorDES();
//	byte[] main_key = new byte[]{22, 43, 56, -60, 56, -125, 51, -66, -48, -75, -43, -68, 93, 23, 120, 94};
//	byte[] key2 = new byte[]{56, 81, 1, 37, -43, -118, 104, -98};
//	byte[] key1 = EncpDecpUtil.encodeDES(key2, main_key);
//	byte[] rawKey = EncpDecpUtil.decodeDES(key2, key1);
//	
//	String aa=EncpDecpUtil.encodeAES(rawKey, "REFER_FRIEND/22/21");
//	System.out.println(aa);
////	System.out.println(URLEncoder.encode(aa,"UTF-8"));
////	System.out.println(URLDecoder.decode(aa,"UTF-8"));
////	System.out.println(new String(new BASE64Decoder().decodeBuffer(aa)));
//	aa=EncpDecpUtil.decodeAES(rawKey, aa);
//	
//	System.out.println(aa);
	
	byte[] key = keyGeneratorAES();
	String str = DatatypeConverter.printBase64Binary( key );
	
	for (byte b : key) {
		System.out.print(b+",");
	}
	System.out.println();
	System.out.println(str);
	byte[] arr = DatatypeConverter.parseBase64Binary(str);
	for (byte b : arr) {
		System.out.print(b+",");
	}
}

}
