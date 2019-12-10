package com.stpl.pms.struts.common;

import java.util.ArrayList;

public class DuplicationLogic {
	
	public static double compareStrings(String str1, String str2) {
		
		 if(str1.length()==1 && str2.length()==1){
			   if(str1.equalsIgnoreCase(str2))
			 	   return 1.0;
			   else
				   return 0.0;
		   }
		ArrayList pairs1 = wordLetterPairs(str1.toUpperCase());
		ArrayList pairs2 = wordLetterPairs(str2.toUpperCase());
		int intersection = 0;
		int union = pairs1.size() + pairs2.size();
		for (int i = 0; i < pairs1.size(); i++) {
			Object pair1 = pairs1.get(i);
			for (int j = 0; j < pairs2.size(); j++) {
				Object pair2 = pairs2.get(j);
				if (pair1.equals(pair2)) {
					intersection++;
					pairs2.remove(j);
					break;
				}
			}
		}
		return (2.0 * intersection) / union;
	}

	private static ArrayList wordLetterPairs(String str) {
		ArrayList allPairs = new ArrayList();
		String[] words = str.split("\\s");
		// For each word
		for (int w = 0; w < words.length; w++) {
			for (int i = 0; i < words[w].length() - 1; i++) {
				allPairs.add(str.substring(i, i + 2));
			}
		}
		return allPairs;
	}
}
