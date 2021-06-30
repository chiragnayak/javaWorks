package General.leetCode.medium;

import java.util.HashMap;

/**
 * 
 * Given a linked list, rotate the list to the right by k places, where k is non-negative.

Example 1:

Input: 1->2->3->4->5->NULL, k = 2
Output: 4->5->1->2->3->NULL
Explanation:
rotate 1 steps to the right: 5->1->2->3->4->NULL
rotate 2 steps to the right: 4->5->1->2->3->NULL
Example 2:

Input: 0->1->2->NULL, k = 4
Output: 2->0->1->NULL
Explanation:
rotate 1 steps to the right: 2->0->1->NULL
rotate 2 steps to the right: 1->2->0->NULL
rotate 3 steps to the right: 0->1->2->NULL
rotate 4 steps to the right: 2->0->1->NULL
 * 
 * @author cnayak
 *
 */
public class RotateList {

	public static void main(String[] args) {

		ListNode one = new ListNode(1);
		ListNode two = new ListNode(2);
		ListNode three = new ListNode(3);
		ListNode four = new ListNode(4);
		ListNode five = new ListNode(5);
		ListNode root = one;

		one.next = two;
		two.next = three;
		three.next = four;
		four.next = five;
		five.next = null;

		PrintList(root);
		
		PrintList(rotateRight(root, 12));

	}

	private static void PrintList(ListNode root) {
		
		System.out.println("");
		
		while(root.next!=null) {
			System.out.print(root.val+",");
			root=root.next;
		}

		System.out.print(root.val+" -> NULL");
	}

	public static ListNode rotateRight(ListNode head, int rotate) {

		if (rotate < 0)
			return head;
		
		if(head==null) {
			return head;
		}
		
		HashMap<Integer, ListNode> map = new HashMap<>();
		
		int position = 1;
		ListNode tempHead = head;
		while(tempHead.next!=null) {
			map.put(position, tempHead);
			tempHead = tempHead.next;
			position++;
		}
		map.put(position, tempHead);
		
		int size =map.size();
		int newPosToNull = size - (rotate%size);
		
		if(newPosToNull==size) {
			return head;
		}
		
//		PrintList(head);
		
		//save next of new last node (as it is going to be null)
		ListNode nextOfNewNullNode = map.get(newPosToNull).next;
		
		//associate original head to original last node.
		ListNode originalToNullNode = map.get(map.size());
		originalToNullNode.next = head;
		
		//new head is next of new last node.
		ListNode newHead = nextOfNewNullNode;

		//next of new last node is set to null
		map.get(newPosToNull).next = null;
		
//		PrintList(newHead);

		return newHead;

	}

}
