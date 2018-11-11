package General.TreeTraversal;

public class TreeNode {
	
	boolean processed = false;
	String value;
	TreeNode left;
	TreeNode right;
	
	public TreeNode(String value) {
		this.value= value;
	}

	
	public TreeNode(int value) {
		this.value= String.valueOf(value);
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public TreeNode getLeft() {
		return left;
	}

	public void setLeft(TreeNode left) {
		this.left = left;
	}

	public TreeNode getRight() {
		return right;
	}

	public void setRight(TreeNode right) {
		this.right = right;
	}

	public boolean isProcessed() {
		return processed;
	}

	public void setProcessed(boolean processed) {
		this.processed = processed;
	}

}
