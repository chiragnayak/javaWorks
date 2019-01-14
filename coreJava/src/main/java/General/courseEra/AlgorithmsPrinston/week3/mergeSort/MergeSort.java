package General.courseEra.AlgorithmsPrinston.week3.mergeSort;

import General.courseEra.AlgorithmsPrinston.week2.utilities.SortUtil;

/**
 * 
 * uses: 
 * 	at most : N lg N compares
 * 		  	  6 N lg N array access
 * 
 * Improvements : 
 * 	
 * 1) Use Insertion Sort for sorting small sized arrays. Like redirect to insertions sort till CUTOFF size say 7.
 * 
 * 2) Stop if already sorted :
 * 	
 * 	How to find : ? if the biggest item in the first half <= smallest item in the second half. Provided both halves are sorted. 
 * 
 * @author cnayak
 *
 */
public class MergeSort {
	
	public static void sort(Comparable [] array, Comparable [] auxArray, int low, int high){
		
		if(high <= low) return;
		int mid = low + (high-low)/2;
		sort(array, auxArray, low, mid);
		sort(array, auxArray, mid+1, high);
		merge(array, auxArray, low, mid, high);
	}
	
	private static void merge (Comparable [] array, Comparable [] auxArray, int low, int mid, int high) {
		
		System.out.println("Merge : low : "+low+" mid : "+mid+" high : "+ high);
		
		//copy current state of array to auxArray
		int t = 0;
		while(t < array.length) {auxArray[t] = array[t]; t++; }
		
		int i = low;
		int j = mid+1;
		for(int x=low; x<=high; x++){
			
			if(i>mid){
				array[x] = auxArray[j++];
			}else if(j > high){
				array[x] = auxArray[i++];
			}else if(SortUtil.lessThan(auxArray[j], auxArray[i])){
				array[x] = auxArray[j++];
			}else{
				array[x] = auxArray[i++];
			}
			
		}
		
	}

}
