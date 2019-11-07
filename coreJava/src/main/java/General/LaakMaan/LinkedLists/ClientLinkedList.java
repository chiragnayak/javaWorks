package General.LaakMaan.LinkedLists;

public class ClientLinkedList {
	
public static void main(String[] args) {
		
		MyLinkedList LL = new MyLinkedList();
		LL.add(1);
		LL.add(2);
		LL.add(3);
		LL.add(4);
		LL.add(5);
		LL.add(1);
		LL.add(1);
		LL.add(6);
		LL.add(2);
		LL.add(7);
		LL.add(1);

		
		System.out.println(LL.toString());
		
//		LL.removeDuplicatesI(); //3 -> 4 -> 5 -> 6 -> 2 -> 7 -> 1 -> null
	
		
		/*
		 
		 LL.removeDuplicatesII(); 
		
			1 -> 2 -> 3 -> 4 -> 5 -> 1 -> 1 -> 6 -> 2 -> 7 -> 1 -> null
			1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> null
		*/
		
		LL.removeDuplicatesIII();

		System.out.println(LL.toString());

		LL.reverse();

		System.out.println(LL.toString());

	}

}
