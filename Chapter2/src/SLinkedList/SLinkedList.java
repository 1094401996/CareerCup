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
	
	public void prepend(int val){
		SNode s = new SNode(val,head);
		if(head == null)
			tail = s;
		head = s;
		size++;
	}
	public void deleteHead(){
		if (head == null)
			return;
		head = head.getNext();
		size--;
		
	}
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
	public void deleteIth(int i){
		if(i >= length())
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
	public SNode ithNodeFromTail(int i){
		if ((tail == null)&&(i >=length()))
				return null;
		SNode s = head;
		int j = 0;
		while(j != (size - 1 -i)){
			s = s.getNext();
			j++;
		}
		return s;
	}
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
	public void deldup3(){
		if(head == null)
			return ;
	
	SNode prev = head;
	SNode curr = prev.getNext();
	while(curr != null){
		if(curr.getVal() == prev.getVal()){
			curr = curr.getNext();
		    prev.SetNext(curr.getNext());
		    size--;
		}
		else{
			SNode runner = curr.getNext();
			while(runner != null){
				if(runner.getVal() == curr.getVal()){
					prev.SetNext(curr.getNext());
					curr = curr.getNext();
					break;
				}
				runner = runner.getNext();
			}
			if(runner == null){
				prev = prev.getNext();
				curr = curr.getNext();
			}
		
		}
			
		}
	}
	public static void main(String[]args){
		int val[] = {1,2,4,5,6,5,3,3,3,3,1,3,5,6};
		SLinkedList s = new SLinkedList(val);
		
		s.deleteIth(13);
		s.printList();
		s.delDup1();
		s.printList();
		/*int data[] = {1,1,4,5,6,5,3,3,3,3,1,3,5,6};
		SLinkedList list = new SLinkedList(data);
		list.printList();
		list.delDup2();
		list.printList();
		int data1[] = {1,1,1,1,1,1,1,1,1,1,1};
		SLinkedList list1 = new SLinkedList(data1);
		list1.printList();
		list1.delDup2();
		list1.printList();
		*/
	
	}
}
