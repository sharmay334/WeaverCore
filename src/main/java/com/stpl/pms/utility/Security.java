package com.stpl.pms.utility;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;

public class Security {
	public static String encrypt(String input, String key){
	  byte[] crypted = null;
	  try{
	    SecretKeySpec skey = new SecretKeySpec(key.getBytes(), "AES");
	      Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
	      cipher.init(Cipher.ENCRYPT_MODE, skey);
	      crypted = cipher.doFinal(input.getBytes());
	    }catch(Exception e){
	    	System.out.println(e.toString());
	    }
	    return new String(Base64.encodeBase64(crypted));
	}

	public static String decrypt(String input, String key){
	    byte[] output = null;
	    try{
	      SecretKeySpec skey = new SecretKeySpec(key.getBytes(), "AES");
	      Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
	      cipher.init(Cipher.DECRYPT_MODE, skey);
	      output = cipher.doFinal(Base64.decodeBase64(input));
	    }catch(Exception e){
	      System.out.println(e.toString());
	    }
	    return new String(output);
	}
	
	public static void main(String[] args) {
	  String key = "1234567891234567";
	  String data = "example";
	//  System.out.println(Security.decrypt("RogeNuJJjF2T0ejsa0MYGg==", key));
	  System.out.println(Security.decrypt("1/PUuQ/XmDiS36dRPP+ubdJwoqkH9/Iv95ibmoIsZqKHhoVGlOLBRGDZ8qkq+VkQwlmpB4PXBew9QjKg7Hp9LFzRJVui2PdR6V4h7X3WMKDzh4KzIdZ0BSoJB7cGIUMLK0WO9IQO8gRaU86HbD0rW1Ndt9dzpOlli+2PT02gW5gKXUqSEoMqWwwqEsMaKs5xipV1gBmTzZH4PtRvnbafE0E4VpWE9vsUSComDF5jwFBRz5qf1JC1Z6LZ2XV6IXIny81KIopDlHW/FsMMkKAT+Tf66XDWRGq5ycuwbgtUQscvAbEanfp76YQkgWG9w371i4zwth60jzs4CHQ7sYxeZpdhhbZ3rWoBOiqbjictJo1HsG0vQ/rEgMW3xs9hDkrDhumWmhUbgf6ULhEmDcjT2M/k9rboIRXHvEcg4gg5yAqbTUXveSA1HLhtQPOMCviYknB4Xkp2uDRlaKXbwXICNug1J7E3BgNL8JUXASz5Yj9OSTiZaOTpY9FbkOFdqkWeG9d1rSRopqpYPFqBFyUjgx9u36L7Qcy+FL7F4/fFyA86uDlHz0xxYuFy6w6vpNst7YR2TGNtLxLsFJiOChOc7OyByDTuMcctCsWmD7AfjD9UEKF8y6lYOcjN497PUR4m998xcs5/uX0xxUqN+MDPs9WW80/9DqcU5CbVQ7Pu3OJ+ybUOAQDS838p0b5Sr0+Fr4s8XH21kytRIoafbQzkV42TX0i1f631JgR5WaZV77roKzC29SDuFXC+BOt77lOpVqTUtxAnHAJo0QWQUDkKAum5EA1UCeAvgoUu2PpDtHhG8eTaHcHIXX+QLibNEV4z1fbq5poGVG6IELMWM9RzvEOkAi0lCTaKanStigFJ+693qFbBGlNh9z/h1LWv6aKmTb0JcsEJRu0Or/At6SnT5RO7mVws5f2XeRj7UohDkBNohJ2UfCmZlH749wQWkFmGaaOoj6fDDvBg8EBXUfUbZ5mtJ1sLLauirSEt2/f4ctpjGihLtG96kpcDdLsUkZCcvXFdaku6IoHbvnGH4rQYV15uVfktHL0LkYwcjo7TvBaTMw87t5b8h3sgXhalSgE8DA8dcdwarwj3FIvfxBUik/GDcglucc7yxEDSLuGUtfY=", "ADHAAROTP_VERIFY"));	    
	}	
}