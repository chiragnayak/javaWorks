package General.courseEra.AlgorithmsPrinston.week1;

import org.springframework.util.StopWatch;

/**
 * union : take the root of first item and make it child of the root of second item
   connected : check if both items have same root

 * 
 * @author cnayak
 *
 */
/**
 * @author cnayak
 *
 */
public class QuickUnion {


	
	private int [] id;
	
	public QuickUnion(int N) {
		
		id = new int [N];
		idWeight = new int [N];
		
		for(int x = 0; x < N ; x ++){
			id[x] = x;
			idWeight [x] = 1;
		}
		
	}
	
	public boolean connected(int p, int q) {
		return findRoot(p)==findRoot(q);
	}
	
	public void union_ver1(int p, int q){
		
		int rootP = findRoot(p); 
		int rootq = findRoot(q);
		
		//take the root of first item and make it child of the root of second item
		id[rootP] = rootq;
		
		print(id);
	}
	
	
	/**
	 * 
	 * avoid putting below (make it a child) larger trees.
	 * 
	 * so,
	 *  > keep track of size of each tree (seperate data structure)
	 *  > balance by linking root of smaller tree to root of larger tree (and not vice versa)
	 * 
	 * @param p
	 * @param q
	 */
	
	private int [] idWeight;
	
	public void union_ver2_weighted(int p, int q){
		
		int rootP = findRoot(p); 
		int rootQ = findRoot(q);
		
		// ideally :take the root of first item and make it child of the root of second item
		// but if weight of first is greater that weith for second
		// flip
		if(idWeight[rootP] >= idWeight[rootQ]){
			id[rootQ] = rootP;	
			idWeight[rootP] = idWeight[rootP] + idWeight[rootQ];
		}else{
			id[rootP] = rootQ;
			idWeight[rootQ] = idWeight[rootQ] + idWeight[rootP];
		}

		print(id);
		print(idWeight);
		System.out.println("=============");
	}
	
	private int findRoot(int position) {
		int root = id[position];
		while(id[position]!=position){
			/*
			 * Path compression
			 * 
			 * Simple implementation : make every other node in the path point to its grandparent  (there-by halving the path length)
			 * 
			 * id[position] = id [id [position]];// improvement
			 * 
			 * Two pass implementation : add Second loop to root () to set the id [] of each examined node to root. 
			 * 
			 *  //TO DO
			 *
			 * */
			root = id[position];
			position = root;
		}
		return root;
	}
	
	private void print(int[] id2) {
		StringBuilder sb = new StringBuilder("[ ");
		
		for(int x : id2){
			sb.append(x+" ");
		}
		
		sb.append("]");
		
		System.out.println(sb.toString());
	}

	public static void main(String[] args) throws InterruptedException {
		
		
		StopWatch sw = new StopWatch();
		sw.start();
		
		QuickUnion qf = new QuickUnion(10);
		
		/*qf.union_ver1(4, 3);
		qf.union_ver1(3, 8);
		qf.union_ver1(6, 5);
		qf.union_ver1(9, 4);
		qf.union_ver1(2, 1);
		
		System.out.println(qf.connected(8, 9));
		System.out.println(qf.connected(5, 4));
		
		qf.union_ver1(5, 0);
		qf.union_ver1(7, 2);
		qf.union_ver1(6, 1);
		qf.union_ver1(7, 3);*/
		
		qf.union_ver2_weighted(4, 3);
		qf.union_ver2_weighted(3, 8);
		qf.union_ver2_weighted(6, 5);
		qf.union_ver2_weighted(9, 4);
		qf.union_ver2_weighted(2, 1);
		
		System.out.println(qf.connected(8, 9));
		System.out.println(qf.connected(5, 4));
		
		qf.union_ver2_weighted(5, 0);
		qf.union_ver2_weighted(7, 2);
		qf.union_ver2_weighted(6, 1);
		qf.union_ver2_weighted(7, 3);
		
		sw.stop();
		System.out.println(sw.getTotalTimeMillis());
		
	}
}
