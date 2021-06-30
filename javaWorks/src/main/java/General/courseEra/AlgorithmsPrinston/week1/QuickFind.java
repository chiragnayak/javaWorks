package General.courseEra.AlgorithmsPrinston.week1;

/**
 * 	position : p and q in the array (data structure name : id)
 * 
 * 	union (p, q) : p's id is pId and q's id is qId
 * 
 *  update all entries with pId with qId
 * 
 * @author cnayak
 *
 */
public class QuickFind {
	
	private int [] id;
	
	public QuickFind(int N) {
		
		id = new int [N];
		
		for(int x = 0; x < N ; x ++){
			id[x] = x;
		}
		
	}
	
	public boolean connected(int p, int q) {
		return id[p]==id[q];
	}
	
	public void union(int p, int q){
		
		int pId = id[p];
		int qId = id[q];
		for(int x = 0; x < id.length; x ++){
			if (id[x]==pId && x != q) id[x] = qId;
		}
		
		print(id);
	}
	
	private void print(int[] id2) {
		StringBuilder sb = new StringBuilder("[ ");
		
		for(int x : id2){
			sb.append(x+" ");
		}
		
		sb.append("]");
		
		System.out.println(sb.toString());
	}

	public static void main(String[] args) {
		
		QuickFind qf = new QuickFind(10);
		
		qf.union(4, 3);
		qf.union(3, 8);
		qf.union(6, 5);
		qf.union(9, 4);
		qf.union(2, 1);
		
		System.out.println(qf.connected(8, 9));
		System.out.println(qf.connected(5, 0));
		
		qf.union(5, 0);
		qf.union(7, 2);
		qf.union(6, 1);
		
		/*
		 
        [ 0 1 2 3 3 5 6 7 8 9 ]
		[ 0 1 2 8 8 5 6 7 8 9 ]
		[ 0 1 2 8 8 5 5 7 8 9 ]
		[ 0 1 2 8 8 5 5 7 8 8 ]
		[ 0 1 1 8 8 5 5 7 8 8 ]
		true
		false
		[ 0 1 1 8 8 0 0 7 8 8 ]
		[ 0 1 1 8 8 0 0 1 8 8 ]
		[ 1 1 1 8 8 1 1 1 8 8 ]

		  
		 **/
	}

}
