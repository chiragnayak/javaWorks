package General.courseEra.AlgorithmsPrinston.week4.BinartSearchTree.client;

import General.courseEra.AlgorithmsPrinston.week4.BinartSearchTree.BST;

public class TestBst {
	public static void main(String[] args) {
		
		BST<String, Integer> bst = new BST<>();
		
		bst.put("C", 1);
		bst.put("H", 2);
		bst.put("I", 3);
		bst.put("R", 4);
		bst.put("A", 5);
		bst.put("G", 6);
		bst.put("J", 7);
		bst.put("B", 8);
		bst.put("D", 9);
		bst.put("K", 10);
		bst.put("F", 11);
		bst.put("L", 12);
		
		bst.Print_InOrderTraversal(bst.getRoot());
		
		System.out.println("MIN() : "+bst.Min().toString());
		System.out.println("MAX() : "+bst.Max().toString());
		
		System.out.println("FLOOR : "+bst.floor("E"));
		System.out.println("CEILING : "+bst.ceiling("E"));
		System.out.println("RANK : "+ bst.rank("H"));
	}

}
