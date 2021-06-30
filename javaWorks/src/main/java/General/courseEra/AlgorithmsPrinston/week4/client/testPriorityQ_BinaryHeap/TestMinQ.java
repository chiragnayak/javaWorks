package General.courseEra.AlgorithmsPrinston.week4.client.testPriorityQ_BinaryHeap;

import General.courseEra.AlgorithmsPrinston.week4.priorityQueue.PriorityQ_MinQ_usingBinaryHeap;

public class TestMinQ {
	
	public static void main(String[] args) {
		
		PriorityQ_MinQ_usingBinaryHeap q = new PriorityQ_MinQ_usingBinaryHeap(10);
		
		Integer [] array = {10,7,8,6,5,4,3,2,1,0,9,12,13,5,22,19,15,1};
		
		for(Integer element : array){
			q.add(element);
		}
		
		System.out.println("Min Q : "+q.delete_MinQ());
	}

}
