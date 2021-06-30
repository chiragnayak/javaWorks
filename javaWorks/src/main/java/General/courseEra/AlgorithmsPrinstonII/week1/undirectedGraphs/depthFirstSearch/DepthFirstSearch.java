package General.courseEra.AlgorithmsPrinstonII.week1.undirectedGraphs.depthFirstSearch;

import java.util.ArrayList;

import General.courseEra.AlgorithmsPrinstonII.week1.undirectedGraphs.graphAPI.Graph;

public class DepthFirstSearch {
	
	private boolean [] marked;
	private int [] edgeTo;
	private int s;
	private boolean [] hasCycle;
	private String [] cycle;
	StringBuilder sbCycle;
	
	public DepthFirstSearch(Graph G, int s){
		
		edgeTo = new int [G.V()];
		marked = new boolean [G.V()];
		hasCycle = new boolean [G.V()];
		cycle = new String [G.V()];
		
		this.s=s;
		
		sbCycle = new StringBuilder();
		
		System.out.println(dfs(G, s));
		
		
	}

	private String dfs(Graph g, int v) {
		
		StringBuilder sb = new StringBuilder();
		
		sb.append("-"+v);
		
		marked [v] = true;
		
		for(int w : (ArrayList<Integer>)g.adj(v)){
			
			if(!marked[w]){
				sb.append(dfs(g, w)+"+"); //recursive call
				edgeTo[w] = v;
			}
			
		}
		
		return sb.toString();
		
	}
	
	/**
	 * 
	 * if vertice-v is marked for this.s (source), then by property of DFS, s is connected to v by some (recursive path)
	 * 
	 * @param v
	 * @return
	 */
	public boolean hasPathTo(int v){
		return marked[v];
	}
	
	public String pathTo(int v) {
		
		if(!hasPathTo(v)){
			return "NO PATH";
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(int x = v; x != s; x = edgeTo[x]){
			sb.append(x+"->");
		}
		
		sb.append(s);
		
		return sb.toString();
	}

	public String hasCycle(int v) {
		
		return hasCycle[v]+" : "+cycle[v];
	}

}
