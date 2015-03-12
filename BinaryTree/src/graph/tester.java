package graph;

public class tester {

	public static void main(String[] args) {
		Graph g = new Graph();
		g.addEdge(0, 2);
		g.addEdge(0, 5);
		g.addEdge(0, 6);
		g.addEdge(0, 1);
		
		g.addEdge(5, 3);
		g.addEdge(5, 4);
		g.addEdge(4, 6);
		Graph.dfs(g, 0, 2);

	}

}
