package Graph;

import java.util.Stack;

public class UndirectedDFS {
	private boolean[] marked;
	private int[] edgeto; //last vertex on known path to this vertex
	private final int s; //source
	private int count;
	
	public UndirectedDFS(Graph G, int s){
		marked = new boolean[G.V()];
		edgeto = new int[G.V()];
		this.s = s;
		dfs(G,s);
	}
	private void dfs(Graph G, int v){
		marked[v] = true;
		count ++;
		for(int w: G.adj(v)){
			if(!marked[w]){
				edgeto[w] = v;
				dfs(G,w);
			}
		}
	}
	public boolean hasPathTo(int v){
		return marked[v];
	}
	public Iterable<Integer> pathTo(int v){
		if(!hasPathTo(v))
			return null;
		Stack<Integer> path = new Stack<Integer>();
		for(int x = v ; x != s; x = edgeto[x]){
			path.push(x);
		}
		path.push(s);
		return path;
	}
	public int count(){
		return count;
	}
}
