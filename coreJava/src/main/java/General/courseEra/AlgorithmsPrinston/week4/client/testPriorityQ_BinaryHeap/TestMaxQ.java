package General.courseEra.AlgorithmsPrinston.week4.client.testPriorityQ_BinaryHeap;

import General.courseEra.AlgorithmsPrinston.week4.priorityQueue.PriorityQ_MaxQ_usingBinaryHeap;

public class TestMaxQ {
	
	public static void main(String[] args) {
		
		PriorityQ_MaxQ_usingBinaryHeap q = new PriorityQ_MaxQ_usingBinaryHeap(10);
		
		Integer [] array = {10,7,8,6,5,4,3,2,1,0,9,12,13,5,22,19,15,1};
		
		for(Integer element : array){
			q.add(element);
		}
		
		System.out.println("Max Q : "+q.delete_MaxQ());
		
		q = new PriorityQ_MaxQ_usingBinaryHeap(10);
		array = new Integer []{1,2,3,4,5,6,7,8,9};
		
		for(Integer element : array){
			q.add(element);
		}
	}

}
