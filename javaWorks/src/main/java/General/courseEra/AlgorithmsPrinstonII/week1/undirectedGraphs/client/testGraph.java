package General.courseEra.AlgorithmsPrinstonII.week1.undirectedGraphs.client;

import General.courseEra.AlgorithmsPrinstonII.week1.undirectedGraphs.breadthFirstSearch.BreadthFirstSearch;
import General.courseEra.AlgorithmsPrinstonII.week1.undirectedGraphs.connectedComponents.CC;
import General.courseEra.AlgorithmsPrinstonII.week1.undirectedGraphs.depthFirstSearch.DepthFirstSearch;
import General.courseEra.AlgorithmsPrinstonII.week1.undirectedGraphs.graphAPI.Graph;

public class testGraph {
	
	public static void main(String[] args) {
		
		Graph<Integer> g = new Graph<>(20);
		
		g.addEdge(1, 2);
		g.addEdge(2, 5);
		g.addEdge(1, 3);
		g.addEdge(3, 4);
		g.addEdge(5, 6);
		g.addEdge(7, 1);
		g.addEdge(5, 8);
		g.addEdge(8, 9);
		g.addEdge(8, 11);
		g.addEdge(11, 13);
		g.addEdge(5, 14);
		g.addEdge(14, 13);
		g.addEdge(15, 16);
		g.addEdge(17, 18);
		g.addEdge(18, 19);
		g.addEdge(12, 18);
		g.addEdge(10, 16);
		g.addEdge(0, 8);
		
		System.out.println(g.toString());
		
//		System.out.println("-----> "+g.adj(1).toString());
//		
//		DepthFirstSearch dfs = new DepthFirstSearch(g, 1); //it is depending on insertion order
//		
//		System.out.println(dfs.pathTo(11));
		
		BreadthFirstSearch bfs = new BreadthFirstSearch(g, 1);
		
		System.out.println(bfs.pathTo(13)); //shortest path
		
		CC cc = new CC(g);
		System.out.println(cc.count());
		System.out.println(cc.toString());
		System.out.println(cc.ifConnected(1, 16));
		System.out.println(cc.ifConnected(1, 13));
		System.out.println(cc.ifConnected(19, 16));
		
		
		
		for(int v = 0 ; v < g.V(); v++){
			
			DepthFirstSearch dfs = new DepthFirstSearch(g, v);
			System.out.println(v+" Has cycle "+dfs.hasCycle(v));
		}

	}

}
