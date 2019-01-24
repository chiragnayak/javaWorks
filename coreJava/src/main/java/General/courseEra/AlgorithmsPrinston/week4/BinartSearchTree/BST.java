package General.courseEra.AlgorithmsPrinston.week4.BinartSearchTree;

/**
 * BST is a binary tree in symetrric order 
 * 
 * Binary tree is either :
 * 		- empty
 * 		- two disjoint binary tree (left and right)
 * 
 *  Symettric order : each node has a key, and every node's key is 
 *  	- Larger than all keys in left sub-tree
 *  	- smaller than all keys in right sub-tree
 *  
 *  Proposition : If N distinct keys are inserted into a BST in 'random' order, the expected number of compares for a search/insert is ~ 2 ln N
 *  prrof : 1-1 correspondence to quick sort partitioning.
 *  
 *  
 *  Tree shape depends on order of insertion
 *  
 *  Number of compares for search/insert is equal to 1 + depth of node.
 *  
 *  
 * 
 * @author cnayak
 *
 */
public class BST <Key extends Comparable<Key>, Value> {
	
	private Node root;
	
	public class Node {
		
		Key key;
		Value value;
		Node left;
		Node right;
		int count;
		
		public Node (Key key, Value value) {
			this.key = key;
			this.value = value;
		}
		
		public String toString() {
			StringBuilder sb = new StringBuilder();
			sb.append(key.toString()+":");
			sb.append(value.toString()+" ");
			sb.append("S "+count);
			return sb.toString();
		}
	}
	
	public void put(Key key, Value value){
		root = put (root, key,value);
	}
	
	private Node put(Node currRoot, Key key, Value value) {

		if (currRoot == null)
			return new Node(key, value);

		int cmp = key.compareTo(currRoot.key);

		if (cmp > 0) {
			currRoot.right = put(currRoot.right, key, value);
		} else if (cmp < 0) {
			currRoot.left = put(currRoot.left, key, value);
		} else {
			currRoot.value = value;
		}
		
		currRoot.count = 1 + size(currRoot.left)+ size(currRoot.right);

		return currRoot;

	}
	
	public Value get(Key key){
		
		return null;
	}
	
	/**
	 * 
	 * Hibard Deletion
	 * 
	 * @param key
	 */
	public void delete (Key key){
		
		
		
	}
	
	public int size(Node x){
		if(x==null){
			return 0;
		}
		return x.count;
		
		
	}
	
	public Iterable <Key> iterator () {
		return null;
	}
	
	/**
	 * 
	 * Yields the keys in ascending order
	 * 
	 * @param node
	 */
	public void Print_InOrderTraversal(Node node){
		
		if(node.left!=null){
			Print_InOrderTraversal(node.left);
		}
		
		System.out.println(node.toString());
		
		if(node.right!=null){
			Print_InOrderTraversal(node.right);
		}
		
	}
	
	public Node getRoot() { return this.root; }
	
	public Node Min() {
		
		if(root==null) return null;
		
		Node min = root;
		while(min.left!=null){
			min = min.left;
		}
		
		return min;
	}
	
	public Node Max() {
		
		if(root==null) return null;
		
		Node max = root;
		while(max.right!=null){
			max = max.right;
		}
		
		return max;
	}
	
	/**
	 * Floor. Largest key ≤ a given key, k.
	 * 
	 * Step 1. [k equals the key at root]
			The floor of k is k.
		Step 2. [k is less than the key at root]
			The floor of k is in the left subtree.
		Step 3. [k is greater than the key at root]
			The floor of k is in the right subtree
			
			(if there is any key ≤ k in right subtree);
			otherwise it is the key in the root.
	 * 
	 * @param key
	 * @return
	 */
	public Node floor(Key key){
		
		Node x = floor(root, key);
		
		return x;
		
	}
	
	private Node floor (Node x, Key key){
		
		if(x==null){
			System.out.println( "curr-root is null");
			return null;
		}
		
		System.out.println("comparing :  key "+key+" compareTo() curr-root.Key "+x.key);
		int cmp = key.compareTo(x.key);
		
		if(cmp==0) return x;
		
		//current root is smaller than key
		//floor is in left subtree
		if(cmp < 0){
			System.out.println("Going Left !");
			return floor(x.left, key);
		}
		
		System.out.println("Going Right !");
		Node t = floor(x.right, key);
		System.out.println(" t is "+t);
		if(t!=null)
			return t;
		else {
			System.out.println("x is "+x.toString());
			return x;
		}
	}
	
	/**
	 * 
	 * Ceiling. Smallest key ≥ a given key
	 * 
	 * step 1. [k equals the key at root]
			The ceiling of k is k.
		Step 2. [k is greater than the key at root]
			The ceiling of k is in the right subtree
		Step 3. [k is less than the key at root]
			The ceiling of k is in the left subtree.		
				
			(if there is any key >= k in left subtree);
			otherwise it is the key in the root.
	 * 
	 * @param key
	 * @return
	 */
	public Node ceiling(Key key){
	
		Node x = ceiling(root, key);
		
		return x;
	}

	private Node ceiling(Node currRoot, Key key) {
		
		if(currRoot==null) return null;
		
		System.out.println("comparing :  key "+key+" compareTo() curr-root.Key "+currRoot.key);
		int cmp = key.compareTo(currRoot.key);
		
		if(cmp==0) return currRoot;
		
		if(cmp > 0) {
			System.out.println("Going Right !");
			return ceiling(currRoot.right, key);
		}
		
		System.out.println("Going Left !");
		Node t = ceiling(currRoot.left,key);
		System.out.println(" t is "+t);
		if(t!=null){
			return t;
		}else{
			System.out.println("curr-root is "+currRoot.toString());
			return currRoot;
		}
		
	}
	
	/**
	 * 
	 * How many keys (nodes) are less than given k
	 * 
	 * @param key
	 * @return
	 */
	public int rank(Key k){
		
		return rank(root, k);
	}
	
	private int rank(Node root, Key key){
		
		if(root==null) return 0;
		
		int cmp = key.compareTo(root.key);
		
		if(cmp < 0) return rank(root.left, key); //go towards left and keep searching
		else if(cmp>0) return 1 + size(root.left) + rank (root.right, key); //1 added for root, + all the sub-tree towards left (i.e. smaller than key) + keep searching for key in right
		else return size(root.left);
	}
}


