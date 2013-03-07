package SLinkedList;

import java.util.Hashtable;


public class SLinkedList {

	private SNode head;
	private SNode tail;
	private int size;
	public SLinkedList(){
	
		
	}
	public SLinkedList(int val[]){
		for(int i =0;i < val.length;i++){
			append(val[i]);
		}
	}
	//加在尾部
	public void append(int val){
		SNode s = new SNode(val,null);
		if(tail == null){ 
			head = s;
		}
		else tail.SetNext(s);
		tail = s;
		size++;
	}
	public void append(SNode s){
		if(tail == null){
			head = s;
		}
		else tail.SetNext(s);
		tail = s;
		size++;
	}
	//加在头部
	public void prepend(int val){
		SNode s = new SNode(val,head);
		if(head == null)
			tail = s;
		head = s;
		size++;
	}
	public void prepend(SNode s){
		if(head == null){
			tail  = s;
		}
		head  = s;
		size ++;
		
	}
	//删除头部节点
	public void deleteHead(){
		if (head == null)
			return;
		head = head.getNext();
		size--;
		
	}
	//删除尾部节点
	public void deleteTail(){
		if(tail == null)
			return;
		SNode s = head;
		while(s.getNext() != tail){
			s = s.getNext();
		}
		s.SetNext(null);
		tail = s;
		size--;
		
	}
	//删除第i个节点 头节点为第0个
	public void deleteIth(int i){
		if(i >= length() ||i < 0)
			return ;
		if(i == length() - 1){
			deleteTail();
		   return;
		}
		if(i == 0){
			deleteHead();
			return;
		}
		SNode s = head;
		int j = 0;
		while( j != i-1){
			s = s.getNext();
			j++;
		}
		s.SetNext(s.getNext().getNext());
		size--;
		return ;
	}
	public void deleteIthFromTail(int i){
		this.deleteIth(this.size - 1 - i);
	}
	public SNode ithNode(int i){
		return this.ithNodeFromTail(size - 1 - i);
	}
	public SNode ithNodeFromTail(int i){
		if ((tail == null)&&(i >=length()))
				return null;
		SNode s = head;
		int j = 0;
		while(j != (size - 1 - i)){
			s = s.getNext();
			j++;
		}
		return s;
	}
	//这个方法可以好好研究一下。。。。不知刀自己当时怎么想到的。。。
	public void partitionList(int i){
		if(size == 0)
			return ;
		SNode curr = getHead();
		SNode prev = new SNode();
		prev.SetNext(head);
		
		while(curr != null){
			    int temp;
				if (curr.getVal() < i){
					  prev = prev.getNext();
					  temp = curr.getVal();
					  curr.setVal(prev.getVal());
					  prev.setVal(temp);
				}
		curr = curr.getNext();
		}
	}

	public int length(){
		return size;
	}
	public void purge(){
		head = null;
		tail = null;
		size = 0;
	}
	public SNode getHead(){
		return head;
	}
	public SNode getTail(){
		return tail;
	}
	public boolean isEmpty(){
		return head == null;
	}
   
	
	public void printList(){
		if(head == null)
			return;
		SNode curr = head;
		while(curr != null){
			System.out.print(curr.getVal()+",");
			curr = curr.getNext();
		}
		System.out.println();
	}
	public void delDup1(){
		if (getHead() == null)
			return ;
		Hashtable<Integer, Boolean> table = new Hashtable<Integer, Boolean>();
		SNode prev = head;
		SNode curr = prev.getNext();
		table.put(head.getVal(),true);
		while(curr != null){
			if(table.containsKey(curr.getVal())){
				prev.SetNext(curr.getNext());
				size--;
			}
			else{
				table.put(curr.getVal(), true);
				prev = curr;
			}
			curr = curr.getNext();
		}
	}
	//curr指向当前节点，prev指向curr前面的那个节点，每次检查curr的时候，使用一个runner从头部开始扫描，这里有一个循环不变量：【head prev】之间的元素都是不同的，
	//这里有点插入排序的思想在里面
	public void delDup2(){
		if(head == null)
			return ;
		SNode prev = head;
		SNode curr = prev.getNext();
		while(curr != null){
			SNode runner = head;
			while(runner != curr){
				if (runner.getVal() == curr.getVal()){
					prev.SetNext(curr.getNext());
					curr = curr.getNext();
					size--;
					break;
				}
				runner = runner.getNext();
			}
			if(runner == curr){
				prev = curr;
				curr = curr.getNext();
			}
		}
	}
	
	
}
