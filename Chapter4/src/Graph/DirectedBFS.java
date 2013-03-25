package Graph;

import java.util.LinkedList;
import java.util.Queue;

	public class DirectedBFS {
	
		private boolean[] marked;
		private int [] edgeTo;
		private final int s;
		private int count;
		
		public DirectedBFS(Digraph G, int s){
			marked = new boolean[G.V()];
			edgeTo = new int[G.V()];
			this.s = s;
			bfs(G,s);
		}
		
		private void bfs(Digraph G, int s){
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
		
		public Iterable<Integer> pathTo(int v){
			if(!hasPathTo(v))
				return null;
			LinkedList<Integer> path = new LinkedList<Integer>();

			for( int x = v; x != s; x = edgeTo[x]){
				path.push(x);
			}
			path.push(s);
			return path;
		}
	}

