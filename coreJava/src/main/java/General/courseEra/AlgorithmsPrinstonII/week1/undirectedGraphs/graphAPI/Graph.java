package General.courseEra.AlgorithmsPrinstonII.week1.undirectedGraphs.graphAPI;

import java.util.ArrayList;

public class Graph <T extends Integer> {

	private final int V; //number of vertices
	private Bag<T> [] adj; //adjacency lists
	
	public Graph(int V) {
		// create an empty graph with V vertices
		this.V = V;
		adj = new Bag [V]; //empty graph with V vertices
		
		for(int vertice = 0; vertice < adj.length; vertice++){
			adj[vertice] = new Bag<>();
		}
	}

	public void addEdge(T v, T w) {
		// add an edge v-w
		// add an edge w-v
		adj[v].add(w);
		adj[w].add(v);
	}

	@SuppressWarnings("unchecked")
	public Iterable<T> adj(T v) {
		// vertices adjacent to v
		return  (Iterable<T>) adj[v].value;
	}

	public int V() {
		// number of vertices
		return this.V;
	}

	public int E() {
		// number of edges
		return -1;
	}

	public String toString() {
		// string representation
		
		StringBuilder sbGraph = new StringBuilder();
		
		for(int vertice = 0; vertice < adj.length; vertice++){
			
			StringBuilder sb = new StringBuilder();
			
			if(adj[vertice].value.size()>0){
				adj[vertice].value.stream().forEach(x -> sb.append(x.toString()+" "));
			}else{
				sb.append("EMPTY");
			}
			
			sbGraph.append("V : "+vertice+" -	 "+sb.toString()+" \n");
		}
		
		return sbGraph.toString();
		
	}
	
	private class Bag <T> {
		
		ArrayList<T> value = new ArrayList<>();
		
		public void add(T element){
			value.add(element);
		}
		
		public void delete(T element){
			value.remove(element);
		}
		
		@Override
		public String toString() {
			return value.toString();
		};
	}

}
