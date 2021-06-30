package General.leetCode.easy;

public class LongestPrefixFromStart {

	
	public static void main(String[] args) {
		
		String [] strs = null;
		

		strs = new String [] {"",""};
		
		System.out.println(longestCommonPrefix(strs));
		
		strs = new String [] {"aa","a"};
		
		System.out.println(longestCommonPrefix(strs));
		
		strs = new String [] {"a","aa"};
		
		System.out.println(longestCommonPrefix(strs));
		
		strs = new String [] {"c","acc","ccc"};
		
		System.out.println(longestCommonPrefix(strs));
		
		strs = new String [] {"flower","flow","flight"};
		
		System.out.println(longestCommonPrefix(strs));
		
		strs = new String [] {
				"a",
				"a"		
		};
		
		System.out.println(longestCommonPrefix(strs));
		
		strs = new String [] {
				"a",
				"ac"		
		};
		
		System.out.println(longestCommonPrefix(strs));
		
		strs = new String [] {
				"ca",
				"a"		
		};
		
		System.out.println(longestCommonPrefix(strs));
		
		} 
	
	 public static String longestCommonPrefix(String[] strs) {
		 
		 if(strs.length==0) {
			 return "";
		 }
		 
		 String answerMax = "";
		 
		 String seed = strs [0];
		 int startPos = 0;
		 int endPos = 1;
		 
		while(endPos <= seed.length()) {

			String strToLook = seed.substring(startPos, endPos);

			if (ifPresent(strToLook, strs)) {
				if (strToLook.length() > answerMax.length()) {
					answerMax = strToLook;
					endPos++;
				}
			} else {
				break;
			}
		}
		 
	     return answerMax;  
	 }
	 
	 public  static boolean ifPresent(String str, String... data) {
		 
		 boolean present = true;
		 int len = str.length();
		 for(String temp : data) {
			 
			 if(temp.length()<len) {
				 return false;
			 }
			 
			 present = present && temp.substring(0,len).equalsIgnoreCase(str);
		 }
	        
		 return present;
	  }
	 
	 public String longestCommonPrefix5ms(String[] strs) {
	       if(strs.length == 0) {return "";}
	        String res = strs[0];
	        for(String str : strs) {
	            int i = res.length();
	            if(res.length() == 0)
	                return "";
	            while(i > 0) {
	                if(!str.startsWith(res)) 
	                    res = res.substring(0,--i);
	                else
	                    break;
	            }
	        }
	        return res;
	    }
}
