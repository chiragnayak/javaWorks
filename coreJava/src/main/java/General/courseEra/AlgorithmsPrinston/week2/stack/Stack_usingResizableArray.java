package General.courseEra.AlgorithmsPrinston.week2.stack;

public class Stack_usingResizableArray {
	
	private Node [] stack = null;
	private int capacity = 5;
	private int nextFreeIndex;
	
	//Node of a linked List
	private class Node {
		
		String data;
		Node next;
	}
	
	public Stack_usingResizableArray(){
		stack = new Node [capacity];
		nextFreeIndex = stack.length-1;
	}
	
	public boolean isEmpty(){
		return (nextFreeIndex==stack.length-1);
	}
	
	public void push(String item){
		
		//save previous
		Node temp = new Node();
		temp.data = item;
		stack [nextFreeIndex] = temp;
		
		nextFreeIndex--;
		
		/*
		 *  HANDLING OVERFLOW
		 * 
		 * Approach#1
		 * ==========
			Here array will resize itself to increase size with half of the current capacity
			When the current stack is full. i.e. if(nextFreeIndex<0)
			
			effect : we are doubling the array (and copying as well, when it is full).
		*	 this will make each push/pop operation as 1 cost, making the total cost as N.
			
			Approach #2
			===========
			 
		
		*/ 
		if(nextFreeIndex<0){
			//resize array and copy
			capacity = capacity + (capacity*2);
			Node [] newStack = new Node[capacity];
			
			int newStackIndex = newStack.length-1;
			for(int i=stack.length-1; i>=0;i--,newStackIndex--){
				newStack[newStackIndex] =stack[i]; 
			}
			
			stack = newStack;
			nextFreeIndex = newStackIndex;
		}
		
		System.out.println(this.toString());
		
	}
	
	public String pop(){
		
		/* during pop operation also we can half the size of array when array is half-full. This
		* is known as thrashing.
		* 
		* effect : there can be a situation when on one addition we ae doubling and for another 
		* operation we are halving the array (and copying as well).
		* this will make each push/pop operation as N cost, making the total cost as N^2.
		* 
		* So, resize to half of the size, when it is occupied 25% of current capacity
		* 
		*  N = stack.length/4 .. then resize to stack.length/2
		*  
		*  i.e. reduce the capacity to half when it is only occupied 25% of capacity. It will leave room 
		*  to push entities without triggering the resizing logic.
		* 
		*/
		
		if(!isEmpty()){
			int index = nextFreeIndex+1;
			String toreturn = stack [index].data;
			stack[index] = null; //so the popped element can be garbage colleted. Avoid loitering.
			nextFreeIndex++;
			return toreturn;
		}else{
			//underflow condition
			return "Stack Empty";
		}
	}
	
	@Override
	public String toString(){
		
		StringBuilder sb = new StringBuilder("[ ");
		
		for (int i = nextFreeIndex+1; i < stack.length; i++) {
			sb.append(stack[i].data+" ");
		}
		
		sb.append("]");
		
		return sb.toString();
	}
	
	public static void main(String[] args) {
		
		Stack_usingResizableArray obj = new Stack_usingResizableArray();
		
		for (int i = 1; i <= 10; i++) {
			obj.push(i+"");
		}
		
		System.out.println(obj.pop());
		System.out.println(obj.isEmpty());
		
		for (int i = 1; i <= 10; i++) {
			System.out.println(obj.pop());
			System.out.println(obj.isEmpty());
		}
	}

}
