package General.LaakMaan.ArraysAndStrings;

import java.util.Arrays;

/**
 * Like in many questions, we should confirm some details with our interviewer. 
 * 
 * We should understand if the permutation comparison is case sensitive. That is: is God a permutation of dog?
 *  Additionally, we should ask if whitespace is significant. 
 *  
 *  We will assume for this problem that the comparison is case sensitive and whitespace is significant. So, "god " is different from "dog".

Observe first that strings of different lengths cannot be permutations of each other
 * 
 * @author cnayak
 *
 */
public class CheckPermutation {
	
	public static void main(String[] args) {
		
		
		System.out.println(checkPermutationII("chirag", "ragchi"));
		
	}
	
	public static boolean checkPermutationII(String str1, String str2){
		
		if(str1.length()!=str2.length()) return false;
		
		char [] str1Arr = str1.toCharArray();
		char [] str2Arr = str2.toCharArray();
		
		Arrays.sort(str1Arr);
		Arrays.sort(str2Arr);
		
		return compare(str1Arr, str2Arr);
		
	}
	
	private static boolean compare(char[] str1Arr, char[] str2Arr) {
		
		int x = 0;
		while(x < str1Arr.length){
			
			if(str1Arr[x]!=str2Arr[x]) return false;
			x++;
		}
		
		return true;
		
	}

	public static boolean checkPermutation(String str1, String str2){
		
		if(str1.length()!=str2.length()) return false;
		
		char [] str1Arr = str1.toCharArray();
		char [] str2Arr = str2.toCharArray();
		
		Arrays.sort(str2Arr);
		
		int x=0;
		boolean isPermute = false;
		while(x<str1.length()){
			int where = binarySearch(str2Arr, str1Arr[x]);
			if(where!=-1){
				str2Arr[where]= '-';
				isPermute = true;
				x++;
			}else{
				isPermute = false;
				break;
			}
		}
		
		return isPermute;
		
	}
	
	public static int binarySearch(char [] array , char char_){
		
		
		int low = 0;
		int high = array.length-1;
		int mid = (low + high) /2;
		
		while(low < high){

			if(array[mid]> char_){
				high = mid-1;
			}else if(array[mid] < char_){
				low = mid+1;
			}else{
				break;
			}
			
			mid = (low + high) /2;
			
		}
		
		if(array[mid]==char_){
			return mid;
		}else{
			return -1;
		}
		
	}

}
