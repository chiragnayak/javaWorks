package General.LaakMaan.LinkedLists;

import java.util.HashMap;
import java.util.Stack;

public class MyLinkedList {

	Node head = null;
	
	public void reverse() {
		
		Stack<Node> stack = new Stack<>();
		
		Node n = head;
		stack.push(n);
		while(n.next!=null){
			stack.push(n.next);
			n=n.next;
		}
		
		head = n;
		
		while(!stack.isEmpty()){
			Node temp = stack.pop();
			n.next = temp;
			n = temp;
		}
		
		n.next = null;
	}

	public void add(int val) {

		if (head == null) {
			head = new Node(val);
			return;
		}

		Node n = head;

		while (n.next != null) {

			n = n.next;
		}

		n.next = new Node(val);
	}

	public void delete(int value) {

		if (head.value == value) {
			head = head.next; // move head
		} else {

			Node n = head;

			while (n.next != null) {

				if (n.next.value == value) {
					n.next = n.next.next;
					return;
				}

				n = n.next;
			}
		}
	}

	public void removeDuplicatesI() {

		int position = 0;

		Node temp = head;

		while (temp != null) {

			int value = temp.value;
			int occurance = getPosition(value);
			System.out.println("value : " + value + " Position : " + position + " occurance : " + occurance);
			if (position != occurance) {
				delete(value);
			} else {
				position++;
			}
			temp = temp.next;
		}
	}

	/**
	 * 
	 * Using HashMap as bufer
	 * 
	 */
	public Node removeDuplicatesII() {

		HashMap<Integer, Node> unique = new HashMap<>();

		if (head == null) {
			return null;
		}

		unique.put(head.value, head);

		Node n = head;

		while (n.next != null) {

			if (unique.get(n.next.value) != null) {
				// duplicate
				n.next = n.next.next;
			} else {
				unique.put(n.value, n);
				n = n.next;
			}

		}

		return head;

	}

	/**
	 * 
	 * without using buffer
	 * 
	 */
	public void removeDuplicatesIII() {

		Node n = head;

		if (n == null) {
			return;
		}

		removeDups(head);

	}

	private void removeDups(Node head) {

		Node n = head;

		if (n == null) {
			return; // if null return
		}

		while (n.next != null) {

			if (n.next.value == head.value) { // see, we need to compare to
												// head.value and not n.value !!
				n.next = n.next.next;
				// no need to do n.next as it has moved already by n.next.next,
				// hence re-evaluate the position
			} else {
				n = n.next;
				// not duplicate move to next position
			}
		}

		removeDups(head.next);
	}

	public int getPosition(int value) {

		Node temp = head;
		int position = 0;

		if (temp.value == value) {
			return 0;
		}

		while (temp.next != null) {

			position++;
			if (temp.next.value == value) {
				return position;
			} else {
				temp = temp.next;
			}
		}

		return -1;
	}

	public String toString() {

		StringBuilder sb = new StringBuilder();

		Node temp = head;
		sb.append(temp.value + " -> ");
		while (temp.next != null) {

			sb.append(temp.next.value + " -> ");
			temp = temp.next;
		}

		return sb.append("null").toString();

	}

	public class Node {

		Node next;
		int value;

		public Node(int val) {
			this.value = val;
		}
	}

}
