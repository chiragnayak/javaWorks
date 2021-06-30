package General.leetCode;

/**
 * Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.

Example 1:

Input: 121
Output: true
Example 2:

Input: -121
Output: false
Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
Example 3:

Input: 10
Output: false
Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
Follow up:

Coud you solve it without converting the integer to a string?
 *
 */
public class palindrome {

	
	public static void main(String[] args) {
		palindrome p = new palindrome();
		System.out.println(p.isPalindromeFastest(101));
		
	}
	
	 public boolean isPalindromeMySol(int x) {
	        
	        if (x<0) return false;
	        
	        char [] charArr = String.valueOf(x).toCharArray();
	        char [] charArrRev = new char [charArr.length];
	        
	        boolean notEq = true;
	        
	        int p = 0;
	        int q = charArr.length-1;
	        while(p<charArr.length){  // while(p<(charArr.length/2)){ -> This will also work, as we need not to compare the second half if first half is matching after reversing. 
	            
	            charArrRev [p] = charArr[q];
	            if(charArrRev[p]!=charArr[p]){
	                notEq = false;
	                break;
	            }
	            
	            p++;
	            q--;
	        }
	        
	        return notEq;
	    }

		public boolean isPalindromeFastest(int x) {
		    if(x<0)
		        return false;
		    int palindromeValue=0;
		    int srcdata=x;
		    while (x!=0)
		    {
		       int temp =x%10;
		       x/=10;
		       palindromeValue=palindromeValue*10+temp;
		    }
		    return palindromeValue==srcdata; 
		 }
		
		 /**
		  * 
		  * Complexity Analysis

				Time complexity : O(log{base-10}(n))
				
				We divided the input by 10 for every iteration, so the time complexity is O(log{base-​10}​ (n))

				Space complexity : O(1).
		  * 
		 * @param x
		 * @return
		 */
		public boolean IsPalindromeSolution(int x) {
		        // Special cases:
		        // As discussed above, when x < 0, x is not a palindrome.
		        // Also if the last digit of the number is 0, in order to be a palindrome,
		        // the first digit of the number also needs to be 0.
		        // Only 0 satisfy this property.
		        if(x < 0 || (x % 10 == 0 && x != 0)) {
		            return false;
		        }

		        /*
		         * divided the number by 10, and multiplied the reversed number by 10, 
		         * when the original number is less than the reversed number, 
		         * it means we've processed half of the number digits
		         * */
		        
		        int revertedNumber = 0;
		        while(x > revertedNumber) {
		            revertedNumber = revertedNumber * 10 + x % 10;
		            x /= 10;
		        }

		        // When the length is an odd number, we can get rid of the middle digit by revertedNumber/10
		        // For example when the input is 12321, at the end of the while loop we get x = 12, revertedNumber = 123,
		        // since the middle digit doesn't matter in palidrome(it will always equal to itself), we can simply get rid of it.
		        return x == revertedNumber || x == revertedNumber/10;
		    }
}
