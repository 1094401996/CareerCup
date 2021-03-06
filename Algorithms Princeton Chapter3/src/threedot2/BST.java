package threedot2;

import java.util.LinkedList;

public class BST<Key extends Comparable<Key> , Value> {
	private Node root;
	
	private class Node{
		private Key key;
		private Value value;
		private Node left,  right;
		private int N;
		
		public Node (Key key, Value value , int N){
			this.key = key;
			this.value = value;
			this.N = N;
		}
	}
		
	public int size(){
		return size(root);		
	}
		
	public int size(Node x){
		if(x == null){			
			return 0;
		}else{
			return x.N;
		}
	}
	
	public Value get(Key key){
		return get(root,key);
	}
		
	private Value get(Node x, Key key){
		if(x == null){
			return null;
		}
		int cmp = key.compareTo(x.key);
		if(cmp < 0){
			return get(x.left, key);
		}
		else if(cmp > 0){
			return get(x.right, key);
		}else{
			return x.value;
		}
	}
		
	public void put(Key key, Value value){
		root = put(root, key , value);
	}
		
	private Node put(Node x, Key key, Value value){
		if(x == null)
			return new Node(key, value, 1);
		int cmp = key.compareTo(x.key);
		if(cmp < 0 ){
			x.left = put(x.left, key , value);
		}
		else if (cmp > 0){
			x.right = put(x.right, key, value);
		}else{
			x.value = value;
		}
		x.N = size(x.left) + size(x.right) + 1;
		return x;
	}
		
	public Key min(){
		return min(root).key;
	}
	
	private Node min(Node x){
		if(x.left == null){
			return x;
		}else{
			return min(x.left);
		}
	}
		
	public Key max(){
		return max(root).key;
	}
		
	private Node max(Node x){
		if(x.right == null){
			return x;
		}else{
			return max(x.right);
		}
	}
		
	public Key select(int k){
		return select(root,k).key;
	}
	
	private Node select(Node x, int k){
		//return Node containing key of rank k
		if(x == null){
			return null;
		}
		int t = size(x.left);
		if(t > k){
			return select(x.left,k);
		}
		else if(t < k){
			return select(x.right, k - t -1);
		}else
			return x;
	}
		
	public int  rank(Key key){
		return rank(key,root);
	}
		
	private int rank(Key key, Node x){
		if(key.compareTo(x.key) == 0){
			return size(x.left);
		}
		else if(key.compareTo(x.key) <  0){
			return rank(key, x.left);
		}else{
			return  rank(key,x.right) + size(x.left) + 1 ; 
		}
	}
		
	public void deleteMin(){
		root = deleteMin(root);
	}
		
	private Node deleteMin(Node x){
		if(x.left  == null)
			return x.right;
		x.left = deleteMin(x.left);
		x.N = size(x.left) + size(x.right) + 1;
		return x;
	}
		
	public void delete(Key key){
		root = delete(root,key);
	}
		
	private Node delete(Node x, Key key){
		if(x == null){
			return null;
		}
				
		int cmp = key.compareTo(x.key);
		if(cmp > 0){
			x.right = delete(x.right, key);
		}
		else if(cmp > 0){
			x.left  = delete(x.left,key);
		}else{
			if(x.right == null){
				return x.left;
			}
			if(x.left  == null){
				return x.right;
			}
			Node t = x;
			x = min(t.right);
			x.right = deleteMin(t.right);
			x.left = t.left;
		}
		x.N = size(x.left ) + size(x.right) + 1;
		return x;
	}

		
	public Iterable<Key> keys(){
		return keys(min(), max());
	}
		
		
	public Iterable<Key> keys(Key low, Key high){
		LinkedList<Key> ll = new LinkedList<Key>();
		keys(root, ll, low ,high);
		return ll;
	}
		
		
	private void keys(Node x, LinkedList<Key> ll, Key low, Key high){
		if(x == null){
			return ;
		}
			
		int cmplow = low.compareTo(x.key);
		int cmphigh = high.compareTo(x.key);
		if(cmplow < 0)
			keys(x.left,ll,low, high);
		if(cmplow <= 0 && cmphigh >= 0){
			ll.add(x.key);
		}
		if(cmphigh > 0)
			keys(x.right,ll,low,high);
		}
	}

