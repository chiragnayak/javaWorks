package General.LaakMaan.ArraysAndStrings;

import General.courseEra.AlgorithmsPrinston.week2.utilities.SortUtil;
import General.courseEra.AlgorithmsPrinston.week4.HeapSort.HeapSort_InPlace;

/**
 * 
 * Is Unique: Implement an algorithm to determine if a string has all unique characters. What if you
cannot use additional data structures?

 * @author cnayak
 *
 */
public class IsUnique {
	
	public static void main(String[] args) {
		
		String [] array = {"c","t","r","i","d","h","g"};
		
		boolean isUniq = true;
		
		//sort it first
		HeapSort_InPlace.sort(array);
		
		for(int x = 0; x < array.length; x++){
			
			//swap wit position 0
			SortUtil.swap(array, x, 0);
			
			//search in rest of the array
			if(getIndex(array, array[0])!=-1){
				System.out.println(array[x]+" is duplicate, NOT UNIQUE !!");
				isUniq = false;
				break;
			}
		}
		
		if(isUniq) System.out.println("IS UNIQUE !!");
	}
	
	//search x in array, low = 1 (skip position 0), binary search.
	private static int getIndex(String [] array, String x){
	
		int middle = -1;;
		int low = 1;
		int high = array.length-1;
		
		//as we are initializing the low to 1 in first pass, we need to make low < = high else position 1
		//will not be consdered.
		while(low <= high){ 
			
			middle = (low+high)/2;
			
			int cmp = array[middle].compareTo(x);
			
			if(cmp<0){
				low = middle+1;
			}else if(cmp > 0){
				high = middle -1;
			}else{
				break;
			}
			
		}
		
		if (array[middle] == x)
			return middle;
		else
			return -1;
		
	}

}
