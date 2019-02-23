package General.courseEra.AlgorithmsPrinstonII.week1.undirectedGraphs.connectedComponents;

import java.util.ArrayList;

import General.courseEra.AlgorithmsPrinstonII.week1.undirectedGraphs.graphAPI.Graph;

public class CC {

	boolean marked[];
	int[] id;
	int count = 0;

	public CC(Graph g) {

		marked = new boolean[g.V()];
		id = new int[g.V()];

		for (int v = 0; v < g.V(); v++) {

			if (!marked[v]) {

				dfs(g, v);
				count++;
			}
		}
	}

	private void dfs(Graph g, int v) {

		marked[v] = true;
		id[v] = count;

		for (int w : (ArrayList<Integer>) g.adj(v)) {

			if (!marked[w]) {
				marked[w] = true;
				dfs(g, w);
			}
		}
	}

	public int count() {
		return count;
	}

	public int id(int v) {
		return id[v];
	}
	
	public String toString() {
		
		StringBuilder sb = new StringBuilder();

		sb.append("[ ");
		
		for(int x : id){
			sb.append(x+" ");
		}
		
		sb.append(" ]");
		
		return sb.toString();
	}
	
	public boolean ifConnected(int v, int w){
		
		return id[v]==id[w];
	}

}
