package General.leetCode.medium;

import java.util.ArrayList;
import java.util.List;

public class PermutationsGeneric {

	public static void main(String[] args) {

		List<List<Integer>> xxx = permute(new int[] { 1,2, 3,4});

		System.out.println(xxx.toString());

		System.out.println(xxx.size());
	}

	public static List<List<Integer>> permute(int[] nums) {

		List<List<Integer>> returnList = new ArrayList<>();

		for (int pos = 0; pos < nums.length; pos++) {

			if(nums.length==1) {
				
				ArrayList<Integer> overLay = new ArrayList<>();

				overLay.add(nums[pos]);
				
				returnList.add(overLay);
				
				return returnList;
			}else {
				
				ArrayList<Integer> overLay = new ArrayList<>();

				overLay.add(nums[pos]);

				ArrayList<Integer> yy = new ArrayList<>();

				for (int y = 0; y < nums.length; y++) {

					if (nums[pos] != nums[y]) {
						yy.add(nums[y]);
					}
				}

				for (List<Integer> rr : permute(overLay, yy.toArray(new Integer[yy.size()]))) {
					returnList.add(rr);
				}
			}
			
			
		}

		return returnList;

	}

	public static List<List<Integer>> permute(List<Integer> overlay, Integer[] nums) {

		List<List<Integer>> returnList = new ArrayList<>();

		for (int pos = 0; pos < nums.length; pos++) {
			
			ArrayList<Integer> overLayNew = new ArrayList<>();

			overLayNew.addAll(overlay);

			overLayNew.add(nums[pos]);

			ArrayList<Integer> yy = new ArrayList<>();

			for (int y = 0; y < nums.length; y++) {

				if (nums[pos] != nums[y]) {
					yy.add(nums[y]);
				}
			}

			if (yy.size() > 2) {
				for (List<Integer> rr : permute(overLayNew, yy.toArray(new Integer[yy.size()]))) {
					returnList.add(rr);
				}
			} else {
				
					if(yy.size()==2) {
						ArrayList<Integer> xx = new ArrayList<>();

						System.out.println(overLayNew);
						System.out.println(yy.toString());

						xx.addAll(overLayNew);
						xx.add(yy.get(0));
						xx.add(yy.get(1));

						returnList.add(xx);

						xx = new ArrayList<>();

						xx.addAll(overLayNew);
						xx.add(yy.get(1));
						xx.add(yy.get(0));

						returnList.add(xx);
					}else if (yy.size()==1){
						ArrayList<Integer> xx = new ArrayList<>();

						System.out.println(overLayNew);
						System.out.println(yy.toString());

						xx.addAll(overLayNew);
						xx.add(yy.get(0));

						returnList.add(xx);

					}else {
						
						ArrayList<Integer> xx = new ArrayList<>();

						System.out.println(overLayNew);

						xx.addAll(overLayNew);

						returnList.add(xx);
						
					}

					

			}
		}

		return returnList;
	}

	
	
	/*
	 * Solution : >.
	 * 
	 * */
	
	    public List<List<Integer>> permute2ms(int[] nums) {
	        List<List<Integer>> permutations = new ArrayList<List<Integer>>();
	        findPermutation(nums, 0, nums.length-1, permutations);
	        return permutations;
	    }
	    
	    private static void findPermutation(int[] nums, int left, int right, List<List<Integer>> permutations) {
	        if(left == right) {
	            ArrayList<Integer> list = new ArrayList<Integer>();
	            for(int i: nums) {
	                list.add(i);
	            }
	            permutations.add(list);
	            return;
	        }
	        for(int i=left; i<=right; i++) {
	            swap(nums, left, i);
	            findPermutation(nums, left+1, right, permutations);
	            swap(nums, left, i);
	        }
	    }
	    
	    private static void swap(int[] nums, int i, int j) {
	        int temp = nums[i];
	        nums[i] = nums[j];
	        nums[j] = temp;
	    }
	
	


}
