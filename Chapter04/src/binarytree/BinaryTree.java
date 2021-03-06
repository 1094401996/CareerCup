package binarytree;
/**
 * 定义：空二叉树的高度为-1，只有根节点的二叉树高度为0，根节点在0层，深度为0。
 */
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
	private Node root;
	
	public BinaryTree(){
		
	}
	public BinaryTree(int[]arr){
		initTree(arr);
	}
	
	//CareerCup 4.3
	public BinaryTree(int[]arr,boolean a){
		root = buildMinBST(arr);
	}
	
	
	/**
	 * 初始化二叉树
	 */
    public void initTree(int []arr){
    	if (arr !=null){
    		root = new Node(arr[0]);
    		
    		Node p ;// 相当与遍历指针
    		Node node;//子节点
    		for (int i = 1; i <arr.length; i++){
    			p = root;
    			node = new Node(arr[i]);
    			while(true){
    				if(arr[i] <= p.getElement()){
    					if(p.getLeft() == null){
    						p.setLeft(node);
    						break;
    					}else{
    						p = p.getLeft();
    					}
    				}else{
    					if(p.getRight() == null){
    						p.setRight(node);
    						break;
    					}else{
    						p = p.getRight();
    					}
    				}
    			}
    			
    		}
    	}
    }

    private Node buildMinBST(int[]arr){
		return  creatMinBST(arr,0 , arr.length - 1);
	}
	private Node creatMinBST(int[]arr,int left, int right){
			if(left > right){
				return null;
			}
			int mid = (left + right)/2;
			Node n = new Node(arr[mid]);
			n.setLeft(creatMinBST(arr,left,mid - 1));
			n.setRight(creatMinBST(arr,mid + 1,right));
			return n;
		
	}
	private int getIndex(int inorder[], int val){
		int index = -1;
		for(int i = 0 ; i < inorder.length; i++){
			if(inorder[i] == val){
			     index = i;
			     break;
			}
		}
		return index;
	}
	public void reConstruct(int[]preorder, int[] inorder){
		int left = 0;
		int right = preorder.length - 1;
		int offset = 0;
		root = reConstruct(preorder,  inorder, left, right, offset);
	}
	private Node reConstruct(int[]preorder, int[] inorder ,int left, int right, int offset){
		if(left >  right)
			return null;
		int rootVal = preorder[left];
		int index = getIndex(inorder,rootVal);
		int i = index - offset;
		Node node = new Node(rootVal);
		node.setLeft(reConstruct(preorder,inorder, left + 1, left + i,offset));
		node.setRight(reConstruct(preorder,inorder,left + 1 + i, right,index + 1));
		return node;
	}

	
	
	
   
    
    public Node findNodeInBST(int element){
    	return findNodeInBST(root, element);
    }
    
    private Node findNodeInBST(Node n, int element){
    	while(n != null){
    		if(n.getElement() == element){
    			break;
    		}
    		else if(n.getElement() < element){
    			n = n.getRight();
    		}else{
    			n = n.getLeft();
    		}
    	}
    	return n;
    }
    public Node findNode(int element){
    	Node p = root;
    	return findNode(root, element);
    }
    
    private Node findNode(Node n , int element){
    	if(n == null){
    		return null;
    	}
    	if(n.getElement() == element){
    		return n;
    	}
    	Node left = findNode(n.getLeft(),element);
    	Node right = findNode(n.getRight(),element);
    	return left == null ? right : left;
    }
    
    //count the number of nodes in a tree
    public int NumOfNode(Node n){
    	if(n == null)
    		return 0;
    	return NumOfNode(n.getLeft()) + NumOfNode(n.getRight()) + 1;
    }
    
    //works for the binary tree
    public Node generalFindNode(int element){
    	return generalFindNode(root, element);
    }
    private Node generalFindNode(Node x, int element){
    	if(x == null){
    		return null;
    	}
    	if(x.getElement() == element ){
    		return x;
    	}
    	Node left = generalFindNode(x.getLeft(),element);
    	Node right = generalFindNode(x.getRight(),element);
    	return left == null ? right : left;
    }
    public Node getRoot(){
    	return root;
    }
    public void setRoot(int element){
    	root.setElement(element);
    }
    //先序遍历
    public void preorder(Node p ){
    	 if (p == null)
  		   return ;
    		System.out.print(p.getElement() + " ");
    		preorder(p.getLeft());
    		preorder(p.getRight());
    	
    }
    //中序遍历
    public void inorder(Node p){
    	   if (p == null)
    		   return ;
    		inorder(p.getLeft());
    		System.out.print(p.getElement() + " ");
    		inorder(p.getRight());
    	}
    //后序遍历
    
    public void postorder(Node p ){
    	 if (p == null)
  		   return ;
    		postorder(p.getLeft());
    		postorder(p.getRight());
    		System.out.print(p.getElement() + " ");
    	

    }
    //层次遍历
    public void levelorder(Node p){
    	if(p == null)
    		return ;
    	Queue<Node> queue = new LinkedList<Node>();
    	queue.offer(p);
    	while(queue.size() > 0){
    		Node temp = queue.poll();
    		System.out.print(temp.getElement()+" ");
    		if(temp.getLeft()!=null){
    			queue.offer(temp.getLeft());
    		}
    		if(temp.getRight() != null){
    			queue.offer(temp.getRight());
    		}
    		
    	}
    	System.out.println();
    }
    
    
    
  //CareerCup 4.1
    public boolean isBalanced1 (Node root){
    	if (root == null)
    		return true;
    	int heightDiff = Math.abs(getHeight(root.getLeft()) - getHeight(root.getRight()));
    	if (heightDiff > 1){
    		return false;
    	}else{
    		return isBalanced1(root.getLeft()) && isBalanced1(root.getRight());
    	}
  
    }
    
    private int checkHeight(Node root){
    	if(root == null)
    		return -1;
    	int leftHeight = checkHeight(root.getLeft());
    	if(leftHeight == -2){
    		return -2;
    	}
        int rightHeight = checkHeight(root.getRight());
        if (rightHeight == -2){
        	return -2;
        }
        int heightDiff = Math.abs(leftHeight - rightHeight);
        if (heightDiff > 1){
        	return -2;
        }else{
        	return Math.max(leftHeight,rightHeight) + 1;
        }
    }
    public boolean isBalanced2(Node root){
    	if (checkHeight(root) == -2){
    		return false;
    	}
    	return true;
    }
    
    
    //chapter 4.4 
    public LinkedList[] linlkedTree(Node p ){
    	if(p == null)
    		return null;
    	int H = getHeight(p);
    	LinkedList[] ll = new LinkedList[H + 1];
    	for(int i = 0 ; i < H + 1; i++){
    		ll[i] = new LinkedList();
    	}
    	ArrayList<Node> array = new ArrayList<Node>();
    	array.add(root);
    	int cur = 0;
    	int last = 1;
    	int level = 0;
    	while(cur < array.size()){
    		last = array.size();//the new level begin,新的一行访问开始，重新定位last于当前行最后一个节点的下一个位置
    		while(cur < last){
    			ll[level].add(array.get(cur));
    			if(array.get(cur).getLeft()!= null){
    				array.add((array.get(cur).getLeft()));
    			}
    			if(array.get(cur).getRight() != null){
    				array.add((array.get(cur).getRight()));
    			}
    			cur++;
    		}
    		level++;
    		
    	}
    	return ll;
    }
    public int getHeight(Node node){
    	if (node == null)
    		return -1;
    	return Math.max(getHeight(node.getLeft()),getHeight(node.getRight())) + 1;
    }
    public int getDepth(Node node){
    	
    	if(node == null){
    		return -1;
    	}else{
    		int left = getDepth(node.getLeft());
    		int right = getDepth(node.getRight());
    		return (left >right ? left :right) + 1;
    	}
    }
    
    //CarreerCup 4.5 if it's a binary tree, the inorder traverse should be in increasing order
   	public boolean isBST1(){
   		WrapInt i = new WrapInt();
   		return isBST1(root, i);
   	};
   	
   	public boolean isBST1(Node x, WrapInt i){
   		if( x == null){
   			return true;
   		}
   		//check / recurse right
   		if(!isBST1(x.getLeft(), i)){
   			return false;
   		}
   		//check current
   		if(x.getElement() < i.value){
   			return false;
   		}
   		i.value  = x.getElement();
   		//check right
   		if(!isBST1(x.getRight(), i)){
   			return false;
   		}
   		return true;
   		
   	}
	
	class WrapInt{
		public int value = Integer.MIN_VALUE;
	 }
	
	//method 2
	 public boolean isBST2(){
	       	return isBST2(root ,Integer.MIN_VALUE,Integer.MAX_VALUE);
	       }
	       
	       boolean isBST2(Node x, int min, int max){
	       	if(x == null){
	       		return true;
	       	}
	       	if(x.getElement() <= min || x.getElement() > max){
	       		return false;
	       	}
	       	if(!isBST2(x.getLeft(), min , x.getElement()) || !isBST2(x.getRight(), x.getElement(), max)){
	       		return false;
	       	}
	       	return true;
	       }
   	//this is wrong because the node should bigger than all nodes in its left subtree, not just 
   	// the left child node....sigh
//   	//T(n) = 2T(n/2) + O(1)    ===> T(n) = O(logN )
//   	// T(n) = T(n/2) + O(1)    ===> T(n) = O(N)
//   	private boolean isBST(Node x){
//   		if (x == null){
//   			return true;
//   		}else{
//   			boolean toLeft = true;
//   			boolean toRight = true;
//   			if(x.getLeft() != null){
//   				toLeft = (x.getElement() >= x.getLeft().getElement());
//   			}
//   			if(x.getRight() != null){
//   				toRight = (x.getElement() < x.getRight().getElement());
//   			}
//   			return toLeft && toRight && isBST(x.getLeft()) && isBST(x.getRight());
//   		}
//   	}
   	
      
    
    
    
 
    

    //careercup 4.7  
    //如果是二察搜索树
    
    public Node foundLowerstCommonAncesterInBST( Node n1, Node n2){
    	return foundLowerstCommonAncesterInBST(root, n1, n2);
    }
    private Node foundLowerstCommonAncesterInBST(Node x, Node n1, Node n2){
    	if(x == null){
    		return null;
    	}
    	Node p = x;
    	while(p!=null){
    		if(p.getElement() > n1.getElement() && p.getElement() > n2.getElement()){
    			p = p.getLeft();
    		}
    		else if((p.getElement() < n1.getElement() && p.getElement() < n2.getElement())){
    			p = p.getRight();
    		}else{
    			return p;
    		}
    	}
    	return p;
    }
    
    
    
    //如果只是binarytree
    
    //method 1
    public Node lowestCommonAncester1(Node p , Node q){
    	return lowestCommonAncester1(root, p, q);
    }
    
    private Node lowestCommonAncester1(Node n, Node p, Node q){
    	if(!isDecendent(n,p) || !isDecendent(n,q)){
    		return null;
    	}
    	else
    		return lowestCommonAncester1Helper(n, p, q);
    }
    private boolean isDecendent(Node n, Node p){
    	if (n == null){
    		return false;
    	}
    	if(n == p){
    		return true;
    	}
    	return isDecendent(n.getLeft(),p) || isDecendent(n.getRight(),p);
    }
    private Node lowestCommonAncester1Helper(Node n, Node p, Node q){
    	if(n == null)
    		return null;
    	if(n == p || n == q){
    		return n;
    	}

    	boolean is_p_left = isDecendent(n.getLeft(),p);
    	boolean is_q_left = isDecendent(n.getLeft(),q);
    	
    	if(is_p_left != is_q_left){
    		return n;
    	}
    	Node child_side = is_p_left ? n.getLeft() : n.getRight();
    	return lowestCommonAncester1Helper(child_side, p,q);
    }
    
    
    
    //optimal method2............Hard to understand for my IQ
    public Node lowestCommonAncester2( Node p , Node q){
    	Result s = lowestCommAncester2Helper(root, p, q);
    	if(s.isAncestor){
    		return s.node;
    	}
    	return null;
    }
    Result lowestCommAncester2Helper(Node n, Node p, Node q){
    	if(n == null){
    		return new Result(null,false);
    	}
    	
    	//I don't think this kind of thing would happen....
//    	if(n == p && n == q ){
//    		return new Result(n, true);
//    	}
    	
    	Result rl = lowestCommAncester2Helper(n.getLeft(),p,q);
    	if(rl.isAncestor){
    		return rl;
    	}
    	Result rr = lowestCommAncester2Helper(n.getRight(),p,q);
    	if(rr.isAncestor){
    		return rr;
    	}
    	
    	if(rl.node != null && rr.node != null){
    		return new Result(n,true);
    	}else if(n == p || n == q){
    		boolean isAncestor = rl.node != null || rr.node != null ? true :false;
    		return new Result(n, isAncestor);
    	}else{
    		return new Result(rl.node!=null ? rl.node :rr.node,false);
    	}
    }
    class Result{
    	Node node;
    	boolean isAncestor;
    	
    	Result(Node n, boolean isAnc){
    		node = n;
    		isAncestor = isAnc;
    	}
    }
    
    
    
    //careercup 4.8
    public  boolean subTree(BinaryTree bt2){
     	Node n1 = this.getRoot();
     	Node n2 = bt2.getRoot();
     	return subTree(n1, n2);
     }
     private boolean subTree(Node n1, Node n2){
     	boolean n1_is_null = (n1 == null);
     	boolean n2_is_null = (n2 == null);
     	if(n2_is_null){
     		return true;
     	}
     	if(n1_is_null){
     		return false;
     	}
     	if(n1.getElement() == n2.getElement()){
     		if(match(n1,n2)){
     			return match(n1,n2);
     		}
     	}
     	return subTree(n1.getLeft(),n2) && subTree(n1.getRight(),n2);
     }

     boolean match(Node n1, Node n2){
     	
     	if(n2 == null ){
     		return true;
     	}
     	if(n1 == null){
     		return false;
     	}
     	if(n1.getElement() != n2.getElement()){
     		return false;
     	}
     	return match(n1.getLeft(),n2.getLeft()) && match(n1.getRight(), n2.getRight());
     }
     
     
     
     //CareerCup 4.9 
     
     public void findSum(int sum){
    	  findSum(root, sum);
     }
     private void findSum(Node n, int sum){
    	 int height = this.getHeight(n);
    	 int [] path = new int[height + 1];
    	 findSum(n,sum,path,0);
     }
     
     private void findSum(Node n, int sum, int[]path , int level){
    	 if(n == null){
    		 return ;
    	 }
    	 
    	 path[level] = n.getElement();
    	 
    	 
    	 //this part is great.....remember the pattern
    	 int t = 0;
    	 for(int i = level; i >= 0 ; i--){
    		 t += path[i];
    		 if(t == sum){
    			 print(path,i,level);
    		 }
    	 }
    	 
    	 /* search nodes beneath this one*/
    	 
    	 findSum(n.getLeft(),sum,path, level + 1);
    	 findSum(n.getRight(),sum,path,level + 1);
    	 
    	 //remove current node fromm path. Not strickly necessary, since we would ignore the 
    	 // value, but it's a good practice
    	 path[level] = Integer.MIN_VALUE;
     }
     
     private void print(int[]path, int start, int end){
    	 for(int i = start; i<= end; i ++){
    		 System.out.print(path[i] + "- >");
    	 }
    	 System.out.println();
     }
    	
}




