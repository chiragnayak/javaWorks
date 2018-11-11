package General.udacity.IntroToGraduateAlgos.LIS;

import java.util.Arrays;

/**
 * LIS - longest increasing subsequence
 * 
 * for an array as {5,7,4,-3,9,1,10,4,5,8,9,3};
 * 
 * subString : elements for certain index i to another index j, where i < j. All the elements betweej i and j will form sub-string.
 * (increasing) sub-sequence : 
 * 			-> any single element of multiple element, provided, they are in increasing (natural) order.
 * 			-> 5,7,9,10
 * 			-> -3,1,4,5,8,9 
 * 
 * How to attack a DP ? 
 * 
 * -> Define sub-problem in words
 * -> statte recursive relation
 * 
 * @author cnayak
 *
 */
public class LIS {
	
	public static void main(String[] args) {
		
		
		int [] sequence = {5,7,4,-3,9,1,10,4,5,8,9,3};
		
		System.out.println(LISMethod(sequence));
	}

	private static int LISMethod(int[] sequence) {
		
		if(sequence.length==0) {
			return 0;
		}
		
		if(sequence.length==1) {
			return 1;
		}
		
		int length = sequence.length;	
		
		int L [] = new int [length];
		
		// TODO Auto-generated method stub
		for(int i = 0; i < sequence.length; i++) {
			
			L[i] = 1;
			
			for(int j = 0; j < i; j++) {
				
				if(sequence[j] < sequence[i] &&
						L[i] < 1 + L[j]) { //if L[current-position] is less than 1 (for itself) + previous smaller value's L
										   //basically, it is to track and use the max L of previous smaller numbers.
					L[i] = 1 + L[j];
				}
			}
			
			printMe(L);
		}
		
		//max of L
		int max = L[0];
		
		for(int m=0; m<L.length;m++) {
			if(L[m] > max) {
				max = L[m];
			}
		}
		
		return max;
	}

	private static void printMe(int[] l) {
		
		Arrays.stream(l).mapToObj(x -> x+" ").forEach(System.out::print);
		
		System.out.println("");
		
	}

}

/*
 input array : A {5,7,4,-3,9,1,10,4,5,8,9,3}
 outlut array : L (prints are as below)
 
1 0 0 0 0 0 0 0 0 0 0 0 
1 2 0 0 0 0 0 0 0 0 0 0 
1 2 1 0 0 0 0 0 0 0 0 0 
1 2 1 1 0 0 0 0 0 0 0 0 
1 2 1 1 3 0 0 0 0 0 0 0 
1 2 1 1 3 2 0 0 0 0 0 0 
1 2 1 1 3 2 4 0 0 0 0 0 
1 2 1 1 3 2 4 3 0 0 0 0 
1 2 1 1 3 2 4 3 4 0 0 0 
1 2 1 1 3 2 4 3 4 5 0 0 
1 2 1 1 3 2 4 3 4 5 6 0 
1 2 1 1 3 2 4 3 4 5 6 3 -> final list of L
6 -> max sub sequence
 
 * 
 * */



