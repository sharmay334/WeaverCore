package com.stpl.pms.utility;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.security.Key;
import java.security.spec.AlgorithmParameterSpec;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;

public class PayGateCryptoUtils {

	public PayGateCryptoUtils() {
		// TODO Auto-generated constructor stub
	}
	
    static {
        try {
            Field field = Class.forName("javax.crypto.JceSecurity").getDeclaredField("isRestricted");
            field.setAccessible(true);
            field.set(null, Boolean.FALSE);
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static String encrypt(String textToEncrypt, String key) {
        try {
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(1, PayGateCryptoUtils.makeKey(key), PayGateCryptoUtils.makeIv());
            return new String(Base64.encodeBase64((byte[])cipher.doFinal(textToEncrypt.getBytes())));
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static String decrypt(String textToDecrypt, String key) {
        try {
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(2, PayGateCryptoUtils.makeKey(key), PayGateCryptoUtils.makeIv());
            return new String(cipher.doFinal(Base64.decodeBase64((String)textToDecrypt)));
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static AlgorithmParameterSpec makeIv() {
        try {
            return new IvParameterSpec("0123456789abcdef".getBytes("UTF-8"));
        }
        catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static Key makeKey(String encryptionKey) {
        try {
            byte[] key = Base64.decodeBase64((String)encryptionKey);
            return new SecretKeySpec(key, "AES");
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String generateMerchantKey() {
        String newKey = null;
        try {
            KeyGenerator kgen = KeyGenerator.getInstance("AES");
            kgen.init(256);
            SecretKey skey = kgen.generateKey();
            byte[] raw = skey.getEncoded();
            newKey = new String(Base64.encodeBase64((byte[])raw));
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        return newKey;
    }
    
    public static void main(String[] args) {
			String data ="fasdasdsa|dasdasdas|fadsfasdasd|kgfdglkfdgj|sfdfsadfsdfsd|fsadefsdf";
    	System.out.println(encrypt(data, "ui9NRIXGFGc89T94A+IDvz7/5lUlz02FCXo4D1JkGEo="));
	}

}
