package General.leetCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Given a positive integer N, find and return the longest distance between two consecutive 1's in the binary representation of N.

If there aren't two consecutive 1's, return 0.

 

Example 1:

Input: 22
Output: 2
Explanation: 
22 in binary is 0b10110.
In the binary representation of 22, there are three ones, and two consecutive pairs of 1's.
The first consecutive pair of 1's have distance 2.
The second consecutive pair of 1's have distance 1.
The answer is the largest of these two distances, which is 2.
Example 2:

Input: 5
Output: 2
Explanation: 
5 in binary is 0101.
Example 3:

Input: 6
Output: 1
Explanation: 
6 in binary is 0110.
Example 4:

Input: 8
Output: 0
Explanation: 
8 in binary is 0b1000.
There aren't any consecutive pairs of 1's in the binary representation of 8, so we return 0.
 

Note:

1 <= N <= 10^9
 *
 */
class Binarygap {
	
	public static void main(String[] args) {
		
		for(int x = 0; x<23; x++) {
			ArrayList<Integer> xx = getBinary(x);
			System.out.println(x+" -> "+xx.toString() +" -> "+getBinary1Gap(x));
		}
	}
	
	private static int getGap(List<Integer> xx) {
		
		if(xx.lastIndexOf(1) == xx.indexOf(1) || xx.lastIndexOf(1)==-1) {
			return 0;
		}
		
		int temp = 0;
		int pos = 0;
		int max = 0;
		for(int x=pos; x<xx.size();x++) {
			
			
			if(xx.get(x)==1) {
				temp = x - pos;
				if(temp > max) {
					max = temp;
				}
				
				pos = x;
			}
			
			
		}

		return max;
		
	}

	public static ArrayList<Integer> getBinary(int x) {
		
		ArrayList<Integer> xx = new ArrayList<>();
		
		if(x==0) {
			xx.add(0);
		}
		
		while(x!=0) {
			xx.add(x%2);
			x = x/2;
		}
		
		Collections.reverse(xx);
		return xx;
	}
	
	public static int getBinary1Gap(int num) {

		int temp = 0;
		int mark = 0;
		int max = 0;
		int val = -1;
		int index = 0;
		boolean first = true;
		
		while(num!=0) {

			val = num%2;
		
//			System.out.println(val);
			
			if (val == 1) {
				
				if(first) {
					mark = index;
					first = false;
				}else {
					
					temp = index - mark;
					if (temp > max) {
						max = temp;
					}

					mark = index;
					
				}
				
				
			}
			
			index++;
			
			num /=2;

		}

		return max;
		
	}
	
}