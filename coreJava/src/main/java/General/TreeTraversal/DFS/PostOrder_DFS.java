package General.TreeTraversal.DFS;

import General.TreeTraversal.TreeNode;

/**
 * 
 * Post-ordre -> LRN
 * 
 * Check if the current node is empty or null.
	Traverse the left subtree by recursively calling the post-order function.
	Traverse the right subtree by recursively calling the post-order function.
	Display the data part of the root (or current node).
	
	Ans : Post-order: A, C, E, D, B, H, I, G, F.

 * @author cnayak
 *
 */
public class PostOrder_DFS {
	
public void traverse(TreeNode rootNode) {
		
		//left
		if(rootNode.getLeft()!=null) {
			this.traverse(rootNode.getLeft());
		}
		
		//right
		if(rootNode.getRight()!=null) {
			this.traverse(rootNode.getRight());
		}
		
		//node
		if(!rootNode.isProcessed()) {
			System.out.print(rootNode.getValue()+" ");
			rootNode.setProcessed(true);
		}
	}

}
