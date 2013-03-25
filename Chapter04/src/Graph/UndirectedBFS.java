package Graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class UndirectedBFS {
	private boolean[] marked;
	private int [] edgeTo;
	private final int s;
	private int count = 0;
	
	public UndirectedBFS(Graph G, int s){
		marked = new boolean[G.V()];
		edgeTo = new int[G.V()];
		this.s = s;
		bfs(G,s);
	}
	
	private void bfs(Graph G, int s){
		Queue<Integer> q = new LinkedList<Integer>();
		marked[s] = true;
		count ++;
		q.offer(s);
		while(!q.isEmpty()){
			int v = q.poll();
			for(int w : G.adj(v)){
				if(!marked[w]){
					edgeTo[w] = v;
					marked[w] = true;
					count++;
					q.offer(w);
				}
			}
		}
	}
	
	public boolean hasPathTo(int v){
		return marked[v];
	}
	
	public Iterable<Integer> PathTo(int v){
		if(!hasPathTo(v))
			return null;
		Stack<Integer> stack = new Stack<Integer>();

		for( int x = v; x != s; x = edgeTo[x]){
			stack.push(x);
		}
		stack.push(s);
		return stack;
	}
	
	public int count(){
		return count;
	}
}
