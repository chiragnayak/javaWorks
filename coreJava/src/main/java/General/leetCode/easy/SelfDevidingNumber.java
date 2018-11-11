package General.leetCode.easy;

import java.util.ArrayList;
import java.util.List;

public class SelfDevidingNumber {

	
	public static void main(String[] args) {
		
		System.out.println(giveMeSelfDeviding(1, 22));
		
	}

	public static List<Integer> giveMeSelfDeviding(int left, int right) {
		
		List<Integer> list = new ArrayList<>();
		
		for(int num = left; num <= right; num++) {
			
			int nextDividend = num; 
			int nextDivisor = nextDividend %10;
			
			boolean addMe = true;
			
			while(nextDividend!=0 && nextDivisor !=num) {
				
				if(nextDivisor==0) {
					addMe = false;
					break;
				}
				
				if(num%nextDivisor!=0) {
					addMe = false;
					break;
				}else {
					nextDividend = nextDividend/10;
					nextDivisor = nextDividend %10;
				}
			}
			
			if(addMe) {
				list.add(num);
			}
			
		}
		
		
		return list;
	}


}
