package General.leetCode.easy;

import java.util.ArrayList;
import java.util.Collections;

public class MaximumSubarray {

	public static void main(String[] args) {
		
		System.out.println(maxSubArray(new int [] {-2,1,-3,4,-1,2,1,-5,4}));

	}

	public static int maxSubArray(int[] nums) {
		
		if( nums==null || nums.length==0) {
			return 0;
		}
		
		if(nums.length==1) {
			return nums[0];
		}
		
		ArrayList<Integer> MAXes = new ArrayList<>();
		
		for(int pos = 0; pos < nums.length; pos ++) {
			int tempMAX = nums[pos];
			int tempSum = nums [pos];
			for(int pointer = pos+1; pointer < nums.length; pointer ++) {
				tempSum = tempSum+nums[pointer] ;
				if(tempSum > tempMAX) {
					tempMAX = tempSum ;
				}
			}
			
			MAXes.add(tempMAX);
		}
		
		Collections.sort(MAXes);

		return MAXes.get(MAXes.size()-1);

	}
	
	
	/*
	 * Other solutions
	 * */
	    public int maxSubArray8ms(int[] nums) {
	        int maxSum = nums[0];
	        int thisRunSum = 0;
	        
	        for (int i = 0; i <= nums.length - 1; i++) {
	            thisRunSum += nums[i];
	            if (thisRunSum > maxSum) {
	                maxSum = thisRunSum;
	            }
	            if (thisRunSum < 0) { // This looks incorrect ! Max sum can be a negative if all the elements in array are negative numbers.
	                thisRunSum = 0;
	            }
	        }
	        
	        return maxSum;
	    }
	    
	    

}
