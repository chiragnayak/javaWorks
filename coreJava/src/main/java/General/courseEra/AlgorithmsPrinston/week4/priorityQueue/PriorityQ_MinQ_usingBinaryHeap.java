package General.courseEra.AlgorithmsPrinston.week4.priorityQueue;

import General.courseEra.AlgorithmsPrinston.week2.utilities.SortUtil;

/**
implementation          insert          del max          max
unordered array          1       	   N          N
ordered array            N            1          1
binary heap            log N         log N        1 
d-ary heap          logd N          d logdN          1
Fibonacci          1          		log N          1
impossible          1       		   1          1
 * @author cnayak
 *
 */
public class PriorityQ_MinQ_usingBinaryHeap {
	
	Comparable [] array;
	
	int N;
	
	int nextPosition;
	
	public PriorityQ_MinQ_usingBinaryHeap(int initialCapacity){
		
		array = new Comparable [initialCapacity+1]; //as we are not using position 0
		N = array.length;
		nextPosition = 1 ; //skip index 0 to save from complex code in swim and sink functions. 
	}
	
	
	/**
	 * 
	 * Add node at the end and then swim it up
	 * Cost : at most 1 + lg N compares (log n because it just need to traverse position equal to height)
	 * 
	 * @param element
	 */
	public void add(Comparable element){
		
		array[nextPosition] = element;
		
		swim(nextPosition);
		
		++nextPosition;
		
		//Q is full, resize and copy
		if(nextPosition==array.length){
			
			Comparable [] newArray = new Comparable [N*2] ;
			
			for(int x =0; x< N; x++){
				newArray[x] = array[x];
			}
			
			array = newArray;
			
			System.out.println("Q RESIZED TO TOTAL PLACES > "+array.length);
		}
	}

	private void swim(int k) {
		
		/*
		 * k>1
		 * 
		 * -> To check node is not root
		 * 
		 * greaterThan(array[k/2], array[k])
		 * 
		 * -> if parent is less than current node, then swap
		 * 
		 * */
		
		while(k > 1  && SortUtil.greaterThan(array[k/2], array[k])){ // k/2 >= 1
			
			SortUtil.swap(array, k/2, k);
			
			k = k/2;
			
		}
		
		SortUtil.printArray(array);
		
	}
	
	/**
	 * Scenario : parent key becomes greater than one (or both) ot its children's.
	 * 
	 * What to do ?
	 * exchange key in parent with the key in smaller child. 
	 * 
	 * in other words :
	 * 	1) find which one of the two childeren in smaller.
	 *  2) exchange with that smaller child. 
	 *  3) Repeat until heap is restored. (both children are greater)
	 *  
	 *  Why with smaller child ?
	 *  A : 
	 * 
	 * 
	 * @param k
	 */
	public void sink(int k){
		
		int lastPosition = nextPosition-1; //last valid occupied position
		
		while(2*k <= lastPosition){
			
			int j = 2*k;
			
			System.out.println("self "+k+" : "+array[k]);
			System.out.println("j "+j+": "+array[j]);
			System.out.println("j+1 "+(j+1)+" : "+array[j+1]);
			
			//j must not be last position as we cannot do j++ in that case. 
			if(j < lastPosition && SortUtil.greaterThan(array[j], array[j+1])) j++;
			
			if(SortUtil.greaterThan(array[j], array[k])) break;
			
			SortUtil.swap(array, j, k);
			
			k = j;
		}
			
		SortUtil.printArray(array);		
	}
	
	/**
	 * 
	 * Delete max. Exchange root with node at end, then sink it down.
		Cost. At most 2 lg N compares.

	 * @return
	 */
	public Comparable delete_MinQ () {
		
		Comparable toReturn = array[1];
		
		int lastPos =  nextPosition-1;
		
		SortUtil.swap(array, 1, lastPos);
		
		nextPosition--; //as this is to be deleted (made null)
		
		sink(1);
		
		array[nextPosition] = null;
		
		SortUtil.printArray(array);
		
		return toReturn;
	}

}
