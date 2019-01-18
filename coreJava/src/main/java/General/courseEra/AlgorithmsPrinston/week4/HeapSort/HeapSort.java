package General.courseEra.AlgorithmsPrinston.week4.HeapSort;

import General.courseEra.AlgorithmsPrinston.week2.utilities.SortUtil;

public class HeapSort {
	
	private static Comparable [] heap;
	private static int N=0;
	
	public static void sort_usingExtraMemory (Comparable [] data){
		
		heap = new Comparable [data.length+1];
		
		for(Comparable element : data){
			
			heap[++N] = element;
			swim(N);
		}
		
		/*
		 * Approach #1 : uses extra memory
		 * 
		 * */
		for(int x = data.length-1; x >= 0; x--){
			
			data[x] = heap[1];
			
			System.out.print(" data : "+SortUtil.printArray(data));
			
			SortUtil.swap(heap, 1, N);
			
			System.out.print(" heap : "+SortUtil.printArray(heap));
			
			N--; //last position not available during sink calculation
			
			sink(1);
		}
	}
	
	private static void sink(int k){
		
		while(2*k <= N){
			
			int j = 2*k;
		
			if(j < N && SortUtil.lessThan(heap[j], heap[j+1])) j++; //i.e. use second child
			
			if(SortUtil.lessThan(heap[j], heap[k])) break;
			
			SortUtil.swap(heap, j, k);
			
			k = j;
		}
		
		SortUtil.printArray(heap);		
	
	}
	
	private static void swim(int index){
		
		int parent = index/2;
		
		while(parent >= 1){
			
			if(SortUtil.lessThan(heap[parent], heap[index])){
				SortUtil.swap(heap, parent, index);
			}
			
			index = parent;
			parent = parent/2;
		}
		
		SortUtil.printArray(heap);
	}

}
