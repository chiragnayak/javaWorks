package General.leetCode.easy;

import java.util.HashMap;

public class MiddleOfLinkedList {

	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public static void main(String[] args) {

		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		l1.next = l2;
		// ListNode l3 = new ListNode(3); l2.next = l3;
		// ListNode l4 = new ListNode(4); l3.next = l4;
		// ListNode l5 = new ListNode(5); l4.next = l5;

		System.out.println(middleNode(l1).val);

	}

	public static ListNode middleNode(ListNode head) {

		if (head == null || head.next == null) {
			return head;
		}

		HashMap<Integer, ListNode> mapping = new HashMap<>();

		int count = 1;
		ListNode curr = head;
		while (curr.next != null) {
			mapping.put(count, curr);
			curr = curr.next;
			count++;
		}

		mapping.put(count, curr);

		int position = count / 2 + 1;

		return mapping.get(position);

	}

	/**
	 * 
	 * When traversing the list with a pointer slow, make another pointer fast that
	 * traverses twice as fast. When fast reaches the end of the list, slow must be
	 * in the middle.
	 * 
	 * @param head
	 * @return
	 */
	public ListNode middleNode1MsSolution(ListNode head) {
		ListNode slow = head, fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}
}
