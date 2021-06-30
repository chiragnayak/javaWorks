package General.TreeTraversal;

import General.TreeTraversal.DFS.InOrder_DFS;
import General.TreeTraversal.DFS.PostOrder_DFS;
import General.TreeTraversal.DFS.PreOrder_DFS;

public class TraversalPractice {

	// create a Tree
	public static TreeNode A = new TreeNode("A");
	public static TreeNode B = new TreeNode("B");
	public static TreeNode C = new TreeNode("C");
	public static TreeNode D = new TreeNode("D");
	public static TreeNode E = new TreeNode("E");
	public static TreeNode F = new TreeNode("F");
	public static TreeNode G = new TreeNode("G");
	public static TreeNode H = new TreeNode("H");
	public static TreeNode I = new TreeNode("I");
	public static TreeNode J = new TreeNode("J");
	public static TreeNode K = new TreeNode("K");

	public static void main(String[] args) {

		F.setLeft(B);
		F.setRight(G);

		B.setLeft(A);
		B.setRight(D);

		G.setRight(I);

		D.setRight(E);
		D.setLeft(C);

		I.setLeft(H);

		PreOrder_DFS preOrder = new PreOrder_DFS();
		System.out.print("PreOrder (NLR) -> ");
		preOrder.traverse(F);

		System.out.println(" ");
		reInitialize();

		PostOrder_DFS postOrder = new PostOrder_DFS();
		System.out.print("PostOrder (LRN) -> ");
		postOrder.traverse(F);
		
		System.out.println(" ");
		reInitialize();

		InOrder_DFS inOrder = new InOrder_DFS();
		System.out.print("In-Order (LNR) -> ");
		inOrder.traverse(F);

	}

	public static void reInitialize() {
		A.setProcessed(false);
		B.setProcessed(false);
		B.setProcessed(false);
		C.setProcessed(false);
		D.setProcessed(false);
		E.setProcessed(false);
		F.setProcessed(false);
		G.setProcessed(false);
		H.setProcessed(false);
		I.setProcessed(false);
		J.setProcessed(false);
		K.setProcessed(false);
		
	}

}
