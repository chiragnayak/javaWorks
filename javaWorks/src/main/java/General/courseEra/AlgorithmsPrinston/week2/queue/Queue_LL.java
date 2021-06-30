package General.courseEra.AlgorithmsPrinston.week2.queue;

import General.courseEra.AlgorithmsPrinston.week2.stack.Stack_usingLinkedList;
import General.designPatterns.creationalPattern.factoryMethod.factories.IFacilityfactory;

public class Queue_LL <T> {
	
	private Node firstNode = null;
	
	private Node lastNode = null;
	
	//Node of a linked List
	private class Node {
		
		T data;
		Node next;
	}
	
	public boolean isEmpty() {
		return firstNode==null;
	}
	
	public void enQueue(T item){
		
		if(firstNode==null) {
			firstNode = new Node();
			firstNode.data = item;
			return;
		}else{
			
			Node temp = firstNode;
			
			while(temp.next!=null){
				temp = temp.next;
			}
			
			temp.next = new Node();
			temp.next.data = item;
		}
		
	}
	
	public T deQueue(){
		
		if(firstNode==null){
			System.out.println("Queue EMPTY !");
			return null;
		}
		
		//savedeQueue item
		T deQueueItem = firstNode.data;
		
		//redirect pointer
		firstNode = firstNode.next;
		
		//return item
		return deQueueItem;
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
		
		Queue_LL<Integer> obj = new Queue_LL<>();
		
		obj.enQueue(1);
		obj.enQueue(2);
		obj.enQueue(3);
		obj.enQueue(4);
		obj.enQueue(5);
		System.out.println(obj.toString());
		System.out.println(obj.deQueue());
		System.out.println(obj.toString());
		
		System.out.println(obj.deQueue());
		System.out.println(obj.toString());
		
		System.out.println(obj.deQueue());
		System.out.println(obj.toString());
		
		System.out.println(obj.deQueue());
		System.out.println(obj.toString());
		
		System.out.println(obj.deQueue());
		System.out.println(obj.toString());
		
		System.out.println(obj.deQueue());
		System.out.println(obj.toString());
		
	}

}
