package General.hackerRank;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Maxes {
	
	public static void main(String[] args) {
		
		IntStream.of(counts(new int [] {1,4,2,4}, new int [] {3,5})).mapToObj(s -> String.valueOf(s) + ",").forEach(System.out::print);
		
	}
	
	public static int[] counts(int[] nums, int[] maxes) {

		Arrays.sort(nums);
		
		int returnMe [] = new int [maxes.length];
		
		for(int maxPos = 0; maxPos < maxes.length; maxPos++) {
			
			int count = 0;;
			
			for(int position = 0; position<nums.length; position++) {
				if(!(nums[position] <= maxes[maxPos])) {
					break;
				}
				
				count++;
			}
			
			returnMe [maxPos] = count;
		}

		
		return returnMe;
	}

}
