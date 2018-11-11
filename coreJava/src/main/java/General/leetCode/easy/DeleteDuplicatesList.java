package General.leetCode.easy;

import General.leetCode.medium.ListNode;

public class DeleteDuplicatesList {

	public static void main(String[] args) {

		ListNode n1 = new ListNode(1);

		ListNode n2 = new ListNode(1);
		n1.next = n2;

		ListNode n3 = new ListNode(2);
		n2.next = n3;

		ListNode n4 = new ListNode(3);
		n3.next = n4;

		ListNode n5 = new ListNode(3);
		n4.next = n5;

		ListNode n6 = new ListNode(4);
		n5.next = n6;

		ListNode n7 = new ListNode(4);
		n6.next = n7;

		ListNode.printFromHere(n1);
		
		deleteDuplicates(n1);
		
		ListNode.printFromHere(n1);
	}

	public static ListNode deleteDuplicates(ListNode head) { //100% success
		
		if(head==null || head.next==null) {
			return head;
		}
		
		ListNode duplicate = null; //record the first node of the duplicated nodes.
		ListNode current = head;
		
		while(current.next!=null) {
			
			if(current.next.val == current.val) {
				if(duplicate==null) {
					duplicate = current;	
				}
			}else {
				
				if(duplicate!=null) {
					duplicate.next = current.next; //connect the first ofthe duplicate node to the next unique node. This will skip al lduplicates in between
					duplicate = null;
				}
			}
			
			current = current.next;
		}
		
		if(duplicate!=null) {
			duplicate.next = null;
		}
		

		return head;

	}

}
