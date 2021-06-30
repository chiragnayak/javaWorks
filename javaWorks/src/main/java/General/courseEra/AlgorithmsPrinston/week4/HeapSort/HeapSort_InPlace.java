package General.courseEra.AlgorithmsPrinston.week4.HeapSort;

import General.courseEra.AlgorithmsPrinston.week2.utilities.SortUtil;

public class HeapSort_InPlace {
	
	public static void sort (Comparable [] array){
		
			/*
			 * Although earlier implementations (Prinston implementation as well), starts heap from index=1. 
			 * This will make position "0" not into consideration or else you will have to copy (extra cost)
			 * your array to new heap array whcih start from index 1
			 * 
			 * hence, this is bit different implementation where
			 * 
			 * 		N -> represents max index (and not elements in Heap)
			 * */
			int N = array.length-1;
			
			
			/*
			 * k >= 0 : because to ensure that all the indexes or nodes are covered till the root (root is at index 0)
			 * 
			 * */
			for(int k = N/2; k>=0; k--){ 
				System.out.print("k : "+k);
				sink(array, k, N);
			}
			
			System.out.print(" HEAP : ");SortUtil.printArray(array);
			
			/*
			 * N > 0 : becuase 0 is the root which is max (when in correct heap), we are swapping with "0th with the Nth" so no need to iterate when N=0 (0th swap 0th)
			 * --N  : to skip last postion (wehre we moved the MAX) while performing sink for swapped element. 
			 * */
			while(N > 0){
				System.out.print("N : "+N+" ");
				SortUtil.swap(array, 0, N);
				sink(array, 0, --N);
			}
			
		}
	
	/*
	 * usual implementation
	 * 
	 * if key at "K" is greater than its parent at "K/2", exchange their positions
	 * repeat for key's new position (i.e. K/2),
	 * 
	 * */
	private static void swim(Comparable [] array, int keyPosition, int N){
		
		int parentPosition = keyPosition/2;
		while(parentPosition >=0) {
			
			if(SortUtil.lessThan(array[parentPosition], array[keyPosition])){
				SortUtil.swap(array, parentPosition, keyPosition);
				keyPosition = parentPosition;
				parentPosition = keyPosition/2;
			}
		}
		
	}
	
	private static void sink(Comparable [] a, int keyPosition, int N){

		System.out.print(" -> SINK - N : "+N+" --> ");
		
		System.out.print("Previous :"+SortUtil.toString(a));
		
		if(N==0){
			return;
		}
		
		while(2*keyPosition <= N){
			
			int j = 2*keyPosition;
			
			if( (j < N) && SortUtil.lessThan(a[j], a[j+1])) j++;
			
			if(SortUtil.lessThan(a[j], a[keyPosition])) break;
			
			SortUtil.swap(a, j, keyPosition);
			
			keyPosition = j;
			
			if(j==0) {
				break; // indicating that we are at root only and not moved further or "sinked", so do not proceed, else infinite loop. Test hangs.
			}else{
				System.out.print(" {"+j+"} "); //depicts position element at "index" has moved
			}
			
		}		
		
		System.out.print("Post Sink :"+SortUtil.toString(a)+" \n");
	}

}
