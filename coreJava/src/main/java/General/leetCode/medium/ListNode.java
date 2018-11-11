package General.leetCode.medium;

public class ListNode {

	public int val;
	public ListNode next;

	public ListNode(int x) {
		val = x;
	}
	
	public static void printFromHere(ListNode root) {
		
		System.out.println("");
		
		while(root.next!=null) {
			System.out.print(root.val+",");
			root=root.next;
		}

		System.out.print(root.val+" -> NULL");
	}

}
