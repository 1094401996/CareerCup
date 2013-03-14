package threedot7;

public class Queue1 {
	int N;
	int a[];
	int front;
	int rear;
	
	public Queue1(int N){
		this.N = N;
		a = new int[N];
		front = 0;
		rear = 0;
		
	}
	public boolean isEmpty(){
		return front == rear;
	}
	public int size(){
		return (rear - front + N ) % N;
	}
	public boolean isFull(){
		return N == size();
	}
	public int peekfront() throws Exception{
		if(isEmpty()){
			throw new Exception("empty queue");
		}
		return a[front];
		
	}
	public int peekrear() throws Exception{
		if(isEmpty()){
			throw new Exception("empty queue");
		}
		int i = rear - 1;
		return a[i];
	}
	public int dequeue() throws Exception{
		if(isEmpty()){
			throw new Exception("empty queue");
		}
		int temp = a[front];
		front = (++front) % N;
		return temp;
	}
	
	public void enqueue(int data) throws Exception{
		if(isFull()){
			throw new Exception("full queue");
		}
		a[rear] -= data;
		rear = (++rear)%N;
	}
	
}

