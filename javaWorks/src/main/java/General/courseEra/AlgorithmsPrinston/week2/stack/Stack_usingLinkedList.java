package General.courseEra.AlgorithmsPrinston.week2.stack;

public class Stack_usingLinkedList {
	
	private Node firstNode = null;
	
	//Node of a linked List
	private class Node {
		
		String data;
		Node next;
	}
	
	public void push(String item){
		
		//save previous
		Node temp = firstNode;
		
		//create new
		firstNode = new Node();
		
		//update
		firstNode.data = item;
		firstNode.next = temp;
	}
	
	public String pop(){
		
		//save popped item
		String poppedItem = firstNode.data;
		
		//redirect pointer
		firstNode = firstNode.next;
		
		//return item
		return poppedItem;
	}
	
	@Override
	public String toString(){
		
		StringBuilder sb = new StringBuilder("[ ");
		
		Node node = firstNode;
		
		if(node!=null){
			
			sb.append(node.data+" ");
			
			while(node.next!=null){
				node = node.next;
				sb.append(node.data+" ");
			}
		}
		
		sb.append(" ]");
		
		return sb.toString();
	}
	
	public static void main(String[] args) {
		
		Stack_usingLinkedList obj = new Stack_usingLinkedList();
		
		obj.push("Chirag");
		obj.push("Nayak");
		obj.push("Ji");
		System.out.println(obj.toString());
		System.out.println(obj.pop());
		System.out.println(obj.toString());
	}

	public boolean isEmpty() {
		
		return firstNode==null;
	}
}
