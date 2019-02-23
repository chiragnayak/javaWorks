package General.courseEra.AlgorithmsPrinstonII.week1.undirectedGraphs.breadthFirstSearch;

import java.util.ArrayList;
import java.util.Arrays;

import General.courseEra.AlgorithmsPrinston.week2.queue.Queue_LL;
import General.courseEra.AlgorithmsPrinstonII.week1.undirectedGraphs.graphAPI.Graph;
import General.courseEra.utils.CEUtils;

public class BreadthFirstSearch {
	
	private Boolean [] marked;
	private Integer [] edgeTo;
	private Integer s;
	
	public BreadthFirstSearch(Graph G, int s){
		
		edgeTo = new Integer [G.V()];
		marked = new Boolean [G.V()];
		
		for(int x = 0; x < G.V(); x++){
			edgeTo[x] = -1;
			marked[x] = false;
		}
		
		this.s=s;
		bfs(G, s);
		
	}

	private void bfs(Graph g, int s) {
		
		Queue_LL<Integer> q = new Queue_LL<>();
		
		q.enQueue(s);
		System.out.println(q.toString());
		
		while(!q.isEmpty()){
			
			int v = q.deQueue();
			
			System.out.println("DeQue and process : "+v+" >> "+g.adj(v).toString());
			
			for (int w : (ArrayList<Integer>)g.adj(v)) { //find all adjacencts of de-queued elememts
				
				if(!marked[w]){ //if not marked put them to queue and mark them as visited. and edge-to via v (dequed elm)
					System.out.println("Enque n mark: "+w);
					q.enQueue(w);
					System.out.println(q.toString());
					marked[w] = true;
					edgeTo[w] = v;
				}else{
					System.out.println(w+" Already Marked");
				}
			}
		}
		
		CEUtils.print(marked);
		
	}
	
	
	/**
	 * 
	 * if vertice-v is marked for this.s (source), then by property of BFS, s is connected to v by some path
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

}
