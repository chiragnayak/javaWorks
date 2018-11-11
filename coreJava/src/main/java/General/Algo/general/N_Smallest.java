package General.Algo.general;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * 
 * given an array, find the N smallest elements (sub-arry) of it
 * 
 * @author cnayak
 *
 */
public class N_Smallest {
	
	public static void main(String[] args) {
		
		IntStream.of(returnSubArray(new int [] {2,6,3,1,76,8}, 3)).forEach(System.out::println);
		
	}
	
	public static int[] returnSubArray(int [] array, int count) {
		
		Arrays.sort(array);
		
		int temp [] = new int [count];
		
		for(int x=0; x<count; x++) {
			temp[x]= array[x];
		}
		
		return temp;
		
	}

}
