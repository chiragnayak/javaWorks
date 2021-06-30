package General.courseEra.AlgorithmsPrinstonII.week1.diGraph.api;

import java.io.InputStream;
import java.util.ArrayList;

import javax.print.attribute.IntegerSyntax;

public class DiGraph <T extends Integer> {
	
	private final int V; //number of vertices
	private Bag<T> [] adj; //adjacency lists

	public DiGraph(int V) {
		// create an empty DiGraph with V vertices
		
		this.V = V;
		
		for(int x =0; x < V; x++){
			adj[x] = new Bag<>();
		}
	}

	public void addEdge(T v, T w) {
		// add a directed edge v→w
		adj[v].add(w);
	}

	public Iterable<T> adj(T v) {
		// vertices pointing from v
		return adj[v].value;
	}

	public int V() {
		// number of vertices
		return V;
	}

	public int E() {
		// number of edges
		return -1;
	}

	public DiGraph reverse() {
		// reverse of this DiGraph
		return null;
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
			
			sbGraph.append("V : "+vertice+" -> "+sb.toString()+" \n");
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
