package General.leetCode.easy;

import java.util.Arrays;
import java.util.Comparator;

public class LongestPrefixWithIn {

	
	public static void main(String[] args) {
		
		String [] strs = null;
		
		strs = new String [] {
				"a",
				"ca"		
		};
		
		System.out.println(longestCommonPrefix(strs));
		
		strs = new String [] {
				"ca",
				"a"		
		};
		
		System.out.println(longestCommonPrefix(strs));
		
		strs = new String [] {
				"chiragaaggaaaa",
				"thaaaaaneaaddddaaaa",
				"naaaaaaaay"
				
		};
		
		System.out.println(longestCommonPrefix(strs));
		
		strs = new String [] {
				"c",
				"c"		
		};
		
		System.out.println(longestCommonPrefix(strs));
		
		strs = new String [] {
				"",
				""		
		};
		System.out.println(longestCommonPrefix(strs));
		strs = new String [] {
				""
		};
		System.out.println(longestCommonPrefix(strs));
		strs = new String [] {
				
		};
		
		System.out.println(longestCommonPrefix(strs));		
	} 
	
	 public static String longestCommonPrefix(String[] strs) {
		 
		 if(strs.length==0) {
			 return "";
		 }
		 
		 Comparator<String> comparator = (str1, str2) -> str1.length() - str2.length();
		
		 String seed = Arrays.asList(strs).stream().min(comparator).get();
		 
		 String answerMax = "";
		 
		 int startPos = 0;
		 int endPos = 0;
		 for(startPos=0; startPos< seed.length(); startPos++) {
			 
			 for(endPos=startPos ;endPos <= seed.length(); endPos++) {
				 
				 String strToLook = seed.substring(startPos, endPos);
				 
				 if(ifPresent(strToLook, strs)) {
					 if(strToLook.length()>answerMax.length()) {
						 answerMax = strToLook;
					 }
				 }else {
					 break;
				 }
			 }
		 }
		 
	     return answerMax;  
	 }
	 
	 public  static boolean ifPresent(String str, String... data) {
		 
		 boolean present = true;
		 
		 for(String temp : data) {
			 
			 present = present && temp.contains(str);
		 }
	        
		 return present;
	  }
}
