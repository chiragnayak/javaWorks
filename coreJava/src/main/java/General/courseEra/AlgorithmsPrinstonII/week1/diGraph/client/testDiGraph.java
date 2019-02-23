package General.courseEra.AlgorithmsPrinstonII.week1.diGraph.client;

import General.courseEra.AlgorithmsPrinstonII.week1.diGraph.api.DiGraph;

public class testDiGraph {
	
	public static void main(String[] args) {
		
		DiGraph<Integer> g = new DiGraph<>(20);
		
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
		
	}

}
