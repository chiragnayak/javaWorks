package General.TreeTraversal.DFS;

import General.TreeTraversal.TreeNode;

/**
 * Pre-order (NLR)

	Check if the current node is empty or null.
	Display the data part of the root (or current node).
	Traverse the left subtree by recursively calling the pre-order function.
	Traverse the right subtree by recursively calling the pre-order function.
 * 
 * Ans : Pre-order: F, B, A, D, C, E, G, I, H.
 * 
 * @author cnayak
 *
 */
public class PreOrder_DFS {
	
	public void traverse(TreeNode rootNode) {
		
		//node
		if(!rootNode.isProcessed()) {
			System.out.print(rootNode.getValue()+" ");
			rootNode.setProcessed(true);
		}
		
		//left
		if(rootNode.getLeft()!=null) {
			this.traverse(rootNode.getLeft());
		}
		
		//right
		if(rootNode.getRight()!=null) {
			this.traverse(rootNode.getRight());
		}
	}
	
}
