package Graph;

import java.util.*;

//undirected graph implementation
public class Graph {
	private final int V;
	private int E;
	private LinkedList <Integer>[] adj;

	@SuppressWarnings("unchecked")
	public Graph(int[]data) throws Exception{   //length should be 2E+2
		if(data.length >=2){
			this.V = data[0];
			this.E = data[1];
			if(data.length == 2*E + 2){
				adj = (LinkedList<Integer>[])new LinkedList[V];//attention,you could build generic array directly with new keyword
				for(int v = 0; v < V; v++){
					adj[v] = new LinkedList<Integer>();
				}

				for (int i = 2; i < data.length;){
					int v = data[i++];
					int w = data[i++];
					addEdge(v,w);
				}
			}else{
				throw new Exception("fail to construct");
			}
		}else{
			throw new Exception("fail to construct");
		}
		
	}
	public int V(){
		return V;
	}
	public int E(){
		return E;
	}
	public void addEdge(int v, int w){
		adj[v].addFirst(w);
		adj[w].addFirst(v);
		E++;
	}
	public Iterable<Integer>adj(int v){
		return adj[v];
	}
}
