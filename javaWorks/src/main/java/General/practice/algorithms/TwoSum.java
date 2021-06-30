package General.practice.algorithms;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * Given nums = [2, 7, 11, 15], target = 9,

		Because nums[0] + nums[1] = 2 + 7 = 9,
		return [0, 1].
 * @author cnayak
 *
 */
public class TwoSum {
	
	//Sol 1 : Brute force
	
	/*
	 * complexity : O(n^2)
	 * 
	 * */
	
	class Solution {
	    public int[] twoSum(int[] nums, int target) {
	      
	        for(int i=0;i<nums.length; i++){
	            for(int y=i+1;y<nums.length; y++){
	                if((nums[i]+nums[y])==target){
	                    return new int []{i,y};
	                }
	            }
	        }
	        
	        return new int []{};
	        
	    }
	}
	
	
	
	//Sol 2 : Two-pass Hash Table
	/*
	 * create a map
	 * 
	 * traverse a map and look for complement (target - current num) in map
	 * 
	 * */
	
	public int[] twoSum(int[] nums, int target) {
	    Map<Integer, Integer> map = new HashMap<>();
	    for (int i = 0; i < nums.length; i++) {
	        map.put(nums[i], i);
	    }
	    for (int i = 0; i < nums.length; i++) {
	        int complement = target - nums[i];
	        if (map.containsKey(complement) && map.get(complement) != i) {
	            return new int[] { i, map.get(complement) };
	        }
	    }
	    throw new IllegalArgumentException("No two sum solution");
	}
	
	
	//Sol 3 :  One-pass Hash Table
	public int[] twoSumV2(int[] nums, int target) {
	    Map<Integer, Integer> map = new HashMap<>();
	    for (int i = 0; i < nums.length; i++) {
	        int complement = target - nums[i];
	        if (map.containsKey(complement)) {
	            return new int[] { map.get(complement), i };
	        }
	        map.put(nums[i], i);
	    }
	    throw new IllegalArgumentException("No two sum solution");
	}

}
