package threedot7;

public class Queue2 {
	SLinkedList sl = null;
	SNode front = null;
	SNode rear = null;
	
	
	public Queue2(){
		sl = new SLinkedList();
		front = sl.getHead();
		rear = sl.getTail();
		
	}
	public boolean isEmpty(){
		return sl.isEmpty();
	}
	public int size(){
		return sl.length();
	}
	
	public SNode peekfront() throws Exception{
		if(isEmpty()){
			throw new Exception("empty queue");
		}
		return front;
		
	}
	public SNode peekrear() throws Exception{
		if(isEmpty()){
			throw new Exception("empty queue");
		}
		return rear;
	}
	public SNode dequeue() throws Exception{
		if(isEmpty()){
			throw new Exception("empty queue");
		}
		SNode temp = sl.getHead();
		sl.deleteHead();
		front = sl.getHead();
		return temp;
	}
	
	public void enqueue(int data) throws Exception{
		sl.append(data);
		rear = sl.getTail();
	}
	
}

