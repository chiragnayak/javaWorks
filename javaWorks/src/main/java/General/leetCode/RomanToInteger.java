package General.leetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

Symbol       Value
I             1
V             5
X             10
L             50
C             100
D             500
M             1000
For example, two is written as II in Roman numeral, just two one's added together. Twelve is written as, XII, which is simply X + II. The number twenty seven is written as XXVII, which is XX + V + II.

Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:

I can be placed before V (5) and X (10) to make 4 and 9. 
X can be placed before L (50) and C (100) to make 40 and 90. 
C can be placed before D (500) and M (1000) to make 400 and 900.
Given a roman numeral, convert it to an integer. Input is guaranteed to be within the range from 1 to 3999.

Example 1:

Input: "III"
Output: 3
Example 2:

Input: "IV"
Output: 4
Example 3:

Input: "IX"
Output: 9
Example 4:

Input: "LVIII"
Output: 58
Explanation: C = 100, L = 50, XXX = 30 and III = 3.
Example 5:

Input: "MCMXCIV"
Output: 1994
Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
 * 
 *
 */
public class RomanToInteger {
	
	 public int romanToIntMySol(String s) {
	        
	        char [] input = s.toCharArray();
	        
	        int pos = 0;
	        int value = 0;
	        boolean lastPos = false;
	        while(pos<input.length){
	            
	            if(pos==(input.length-1)){
	                lastPos = true;
	            }
	            
	            if(input[pos]=='I'){
	                
	                if(!lastPos && input[pos+1]=='V'){
	                    value += 4;
	                    pos+=2;
	                }else if(!lastPos && input[pos+1]=='X'){
	                    value += 9;
	                    pos+=2;
	                }else{
	                  value += 1; 
	                  pos+=1;
	                }
	                
	            } else  if(input[pos]=='V'){
	                value += 5;
	                pos+=1;
	            } else  if(input[pos]=='X'){
	                
	                if(!lastPos && input[pos+1]=='L'){
	                    value += 40;
	                    pos+=2;
	                }else if(!lastPos && input[pos+1]=='C'){
	                    value += 90;
	                    pos+=2;
	                }else{
	                  value += 10; 
	                  pos+=1;
	                }
	                
	            } else  if(input[pos]=='L'){
	                value += 50;
	                pos+=1;
	            } else  if(input[pos]=='C'){
	                
	                 if(!lastPos && input[pos+1]=='D'){
	                    value += 400;
	                    pos+=2;
	                }else if(!lastPos && input[pos+1]=='M'){
	                    value += 900;
	                    pos+=2;
	                }else{
	                  value += 100; 
	                  pos+=1;
	                }
	            } else  if(input[pos]=='D'){
	                value += 500;
	                pos+=1;
	            } else  if(input[pos]=='M'){
	                value += 1000;
	                pos+=1;
	            } 
	                    
	         }
	        
	        return value;
	            
	    }
	 
	 public int romanToIntFastest(String s) {
		    int result = 0;
		    int [] values =  new int[s.length()];
		    for(int i=0; i<s.length(); i++){
		        values[i] = charMap.get(s.charAt(i));
		    }
		    for(int i=0; i<values.length; i++){
		        result = (i < values.length-1 && values[i] < values[i+1]) ? result - values[i] : result + values[i];
		    }
		    return result;
		}

		private static final Map<Character, Integer> charMap = createMap();
		private static Map<Character, Integer> createMap(){
		    Map<Character, Integer> map = new HashMap<>();
		    map.put('I', 1);
		    map.put('V', 5);
		    map.put('X', 10);
		    map.put('L', 50);
		    map.put('C', 100);
		    map.put('D', 500);
		    map.put('M', 1000);
		    return map;
		}

}
