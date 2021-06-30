package General.Algo.searching;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * 
 * Jump Search is a searching algorithm for sorted arrays. (note -> sorted array)
 * The basic idea is to check fewer elements (than linear search) by jumping ahead by fixed steps
 *  or 
 *  skipping some elements in place of searching all elements.
 *  
 *  What is the optimal block size to be skipped?
	In the worst case, we have to do n/m jumps and if the last checked value is greater than the element to be searched for, 
	we perform m-1 comparisons more for linear search. 
	
	Therefore the total number of comparisons in the worst case will be ((n/m) + m-1).
	
	The value of the function ((n/m) + m-1) will be minimum when m = √n. 
	 
	 -> Therefore, the best step size is m = √n.
	 
	 Time Complexity : O(√n)
	Auxiliary Space : O(1)
 * 
 * @author cnayak
 *
 */
public class JumpSearch {
	
	public static void main(String[] args) {
		
		int [] array = new int [] {1,3,5,3,65,32,6,78,3,5,7};
		Arrays.sort(array);
		IntStream.of(array).forEach(x -> System.out.print(x+" "));
		System.out.println("\nAt position "+jumpSearchArry(array, 32));
		
	}

	private static int jumpSearchArry(int[] array, int target) {
		
		int jump = (int) Math.round(Math.sqrt(array.length));
		
		int pos=0;
		int count=1;
		int lastPos=0;
		while(array[pos]<target) { //compare if target is less that element at this position. //signifies, if false, target is between previous pos and this pos
			lastPos = pos;
			pos = jump*count; //do jumps to position
			count++;			
		}
		
		//linear search from last position to next position only (no need to go till end of array)
		for(int iPos = lastPos; iPos<(lastPos+jump); iPos++) {
			if(array[iPos]==target) {
				return iPos;
			}
		}
		
		return -1;
		
	}

}
