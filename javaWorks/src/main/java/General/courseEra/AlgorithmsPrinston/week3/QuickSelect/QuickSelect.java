package General.courseEra.AlgorithmsPrinston.week3.QuickSelect;

import General.courseEra.AlgorithmsPrinston.week2.utilities.SortUtil;

/**
 * 
 * Given a array of N items, find the Kth largest element
 * 
 * Min element (k=0)
 * Max element  (k=N-1)
 * mid  (k=N/2)
 * 
 * My understanding : Nth largest element will be at position N-1. 
 * 
 * partition so that a[j] is in place
 * no larger entry in left if a[j]
 * no smaller entry in right of a[j]
 * 
 * Repeat for one sub array, depending upon j; select the next sub-array (side to call).
 * return index j, when j=k
 * 
 * takes "linear" time on average
 * 
 * @author cnayak
 *
 */
public class QuickSelect {
	
	public static Comparable select(Comparable [] array, int k){
		
		if(k > array.length){
			System.err.println("CHEK ARRAY SIZE !!");
			return null;
		}
		
		k = k-1; //added code per my understanding : Nth largest element will be at position N-1. So compare partition against k-1 instead of k.
		
		int low = 0;
		int high = array.length-1;
		
		while(high > low) { // what blunder i did ??!! >>> partition!=k){
			
			int partition = partition(array, low, high);
			
			System.out.println("Partition : "+partition);
			
			if(partition < k) {
				
				low = partition+1;
				
			}else if (partition > k){
				
				high = partition -1;
				
			}else 
				return array [k];
			
		}
		
		return array [k];
		
	}
	
	private static int partition (Comparable [] array, int low, int high) {
		
		int i = low+1;
		int j = high;
		int partition = low;
		
		while(true){
			
			//continue till you find greater element on the left
			while(SortUtil.lessThan(array[i], array[partition])){
				i++;
				if(i>=high)break;
			}
			
			//continue till you find smaller element on the right
			while(SortUtil.lessThan(array[partition], array[j])){
				j--;
				if(j<=low) break;
			}
			
			//check if point crosses
			if(i>=j){
				break;
			}
			
			//swap these two positions
			SortUtil.swap(array, i , j);
			
			System.out.print("<>");
			SortUtil.printArray(array);
			
		}
		
		//swap it with partition
		SortUtil.swap(array, partition, j);
		
		return j;
	}

}
