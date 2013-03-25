package fourdot2;
/**
 * CareerCup 4.2
 * Given a directed graph, design an algorithm to find out whether there is a route between two nodes.
 * 
 * method: 两种方法 DFS, BFS  大家可以参考一下我的实现方式，我把有向图无向图的BFS和DFS都实现了。。。。
 */
import Graph.Digraph;
import Graph.DirectedBFS;
import Graph.DirectedDFS;

public class IfConnected {
	public static void main(String[] args) throws Exception{
		int [] data = {13,22,4,2,2,3,3,2,6,0,0,1,2,0,11,12,12,9,9,10,9,11,8,9,10,12,11,4,4,3,3,5,7,8,8,7,5,4,0,5,6,4,6,9,7,6};
		Digraph dg = new Digraph(data);
		int source = 6;
		int destination = 4;
		//DFS

		DirectedDFS reachable1 = new DirectedDFS(dg,source);
		System.out.println(reachable1.hasPathTo(0));
		for(int i : reachable1.pathTo(destination)){
			System.out.print(i + " --> ");
		}
		System.out.println();
		System.out.println();
		System.out.println();
		//BFS
		DirectedBFS reachable2 = new DirectedBFS(dg,source);
		System.out.println(reachable2.hasPathTo(0));
		for(int i : reachable2.pathTo(destination)){
			System.out.print(i + " --> ");
		}
		
	}
}
