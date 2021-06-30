package General.courseEra.AlgorithmsPrinston.week2.elementrarySorting;

import General.courseEra.AlgorithmsPrinston.week2.utilities.SortUtil;

/**
 * instead of steps of 1 we for h count, to make the array as H-sorted after first pass
 * 
 *  h : to determine best progression or sequece, it is still unknown, but "3h+1" which gives :
 *  	
 *  	// 1 , 4 , 13 , 121, 364 ...
 *  
 *  has been known to give good results as compared to standard insertion sort (when h=1, and single pass)
 * 
 * In shell sort [i], swap a[i] with each larger entry to its left.
 * 
 * @author cnayak
 *
 */
public class ShellSort_HSort {

	public static void sort(Comparable[] array) {
		
		int N = array.length;
		
		int h = 1;
		while(h < N/3) h = 3*h+1; // 1 , 4 , 13 , 121, 364 ... upper limit of the sequence
		
		System.out.println(h);
		
		while(h>=1){ //each pass array is h-sorted.

			for (int i = h; i < N ; i++) {
				for (int j = i; j >=h ; j-=h) {
					if(SortUtil.lessThan(array[j], array[j-h])){
						SortUtil.swap(array, j-h, j);
					}else{
						break;
					}
					
					SortUtil.printArray(array);
				}
			}
			
			h = h/3;
			
		}

		

	}

}
