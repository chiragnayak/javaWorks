package General.TreeTraversal.DFS;

import General.TreeTraversal.TreeNode;

/**
 * 
 * In-ordre -> LNR
 * 
 * Check if the current node is empty or null. Traverse the left subtree by
 * recursively calling the in-order function. Display the data part of the root
 * (or current node). Traverse the right subtree by recursively calling the
 * in-order function.
 * 
 * ANS : A, B, C, D, E, F, G, H, I.
 * 
 * @author cnayak
 *
 */
public class InOrder_DFS {

	public void traverse(TreeNode rootNode) {

		// left
		if (rootNode.getLeft() != null) {
			this.traverse(rootNode.getLeft());
		}

		// node
		if (!rootNode.isProcessed()) {
			System.out.print(rootNode.getValue() + " ");
			rootNode.setProcessed(true);
		}

		// right
		if (rootNode.getRight() != null) {
			this.traverse(rootNode.getRight());
		}
	}

}
