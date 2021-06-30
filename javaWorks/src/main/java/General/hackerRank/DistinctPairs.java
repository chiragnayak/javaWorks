package General.hackerRank;

import java.util.ArrayList;

public class DistinctPairs {
	
	public static void main(String[] args) {
		System.out.println(numberOfPairs(new int [] {7,
				6,
				12,
				3,
				9,
				3,
				5,
				1}, 12));
	}
	
	//logic will not work if duplicates are present in the list
	public static int numberOfPairs(int[] a, long k) {
		
		ArrayList<Integer> list = new ArrayList<>();
		
		for(int x : a) {
			list.add(x);
		}

		ArrayList<String> distinct = new ArrayList<>();
		
		for(Integer curr : list) {
			
			int indexCurr = list.indexOf(curr);
			
			int anotherOne = (int) (k - curr);
			
			list.set(indexCurr, curr*(-1));
			
			if(list.contains(anotherOne)) {
				
				int indexAnotherOne = list.indexOf(anotherOne);
				
				if(indexAnotherOne!=indexCurr) {
					String Way1 = curr+""+anotherOne;
					String Way2 = anotherOne+""+curr;
					if(!distinct.contains(Way1) && !distinct.contains(Way2)) {
						distinct.add(Way1);
					}
				}
			}
			
			list.set(indexCurr, curr);
		
		}
		
		return distinct.size();
		
    }

}
