package graph;
import java.util.*;

@SuppressWarnings("unchecked")
public class Graph{
	static final int MAX_SIZE = 50;
	private int vertices;
	private int edges;
	private LinkedList<Integer>[] adjList;
	
	
	public Graph(){
		vertices = 0;
		edges = 0;
		adjList =(LinkedList<Integer>[]) new LinkedList[MAX_SIZE];
		for(int i = 0; i < MAX_SIZE; i++){
			adjList[i] = new LinkedList<Integer>();
		}

	}
	
	public void addVertex(int v){
		
		
	}
	
	public void addEdge(int v, int e){
		adjList[v].add(e);
		edges++;
	}
	
	static void dfs(Graph g, int start, int dest){
		boolean[] visited = new boolean[MAX_SIZE];
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(start);
		while(!stack.isEmpty()){
			int s = stack.pop();
			System.out.println(s);
			if(!visited[s]){
				visited[s] = true;
				if(s == dest) System.out.println("Solution found at "+s);
				List<Integer> adj = g.adjList[s];
				for(int i : adj){
					stack.push(i);
				}
			}
		}
		
	}
	
	private class Edge{
		
	}
	
}
