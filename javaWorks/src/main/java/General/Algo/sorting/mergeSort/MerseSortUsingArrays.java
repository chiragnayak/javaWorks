package General.Algo.sorting.mergeSort;

public class MerseSortUsingArrays {
	
	public static void main(String[] args) {
		
		int [] a = {1,5,3,2,6,8,9,3,2};
		
		a = mergeSort(a);
		
		for(int i=0; i<a.length;i++){
			System.out.print(a[i]+" ");
		}
	}

	private static int [] mergeSort(int[] a) {

		if(a.length==1){
			return a;
		}

		if(a.length==2){ //no need to split can swap in place if required.
			if(a[0]>a[1]){
				int temp = a[0];
				a[0]=a[1];
				a[1] = temp;
			}
			return a;
		}
		
		int low = 0;
		int high = a.length-1;
		int mid = (low + high)/2;
		
		
		int aLeft [] = new int [mid];
		int aRight [] = new int [a.length-mid];
		
		for(int i=0; i<mid; i++){
			aLeft[i] = a[i];
		}
		
		for(int i=mid, y=0; i<=high; i++,y++){
			aRight[y] = a[i];
		}
		
		aLeft = mergeSort(aLeft);
		aRight = mergeSort(aRight);

		a = merge(a, aLeft, aRight);
		
		for(int i=0; i<a.length;i++){
			System.out.print(a[i]+" ");
		}
		
		System.out.println("---");
	
		return a;
	}

	private static int [] merge(int[] a, int[] aLeft, int[] aRight) {

		int count = 0;
		int loc1 = 0;
		int loc2 = 0;
		
		int [] aRes = new int [a.length];
		
		while(loc1 < aLeft.length && loc2 < aRight.length) { //check : do not use "count"
			
			if(aLeft[loc1] <= aRight[loc2]){
				aRes[count] = aLeft[loc1];
				count++;
				loc1++;
			}else{
				aRes[count] = aRight[loc2];
				count++;
				loc2++;
			}
		}
		
		while(loc1<aLeft.length){
			aRes[count] = aLeft[loc1];
			count++;
			loc1++;
		}
		
		while(loc2<aRight.length){
			aRes[count] = aRight[loc2];
			count++;
			loc2++;
		}
		
		return aRes;
	}

}
