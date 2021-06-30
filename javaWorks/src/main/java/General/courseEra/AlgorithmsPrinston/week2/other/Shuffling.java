package General.courseEra.AlgorithmsPrinston.week2.other;

import General.courseEra.AlgorithmsPrinston.week2.utilities.SortUtil;
import General.courseEra.AlgorithmsPrinston.week2.utilities.StdRandom;

/**
 * 
 * Approach #1 : create a paralled "key" array, which is having random number, and is mapped to each entry in parent "array".
 * 				 Sort this "key" array
 * 				 print the parent "array" element in mapped (sorted) order of keys now. 
 * 
 * 
 * Approach #2 (implemented below) : In iteration i, pick integer r between 0 and i; uniformly at random. Swap a[i] with a[r]
 * 
 * @author cnayak
 *
 */
public class Shuffling {
	
	public static void shuffle(Object [] array){
		
		int N = array.length;
		
		for(int i=0; i<N; i++){
			int randomBetweenStartOfArrayAndI = StdRandom.uniform(i + 1);
			SortUtil.swap((Comparable[]) array, i, randomBetweenStartOfArrayAndI);
			SortUtil.printArray(array);
		}
	}

}
