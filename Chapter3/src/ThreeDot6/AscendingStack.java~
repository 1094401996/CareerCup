package ThreeDot6;

public class AscendingStack {
	public static void main(String[] args) throws Exception{

		Stack s = new Stack(10);
		for(int i = 10 ; i >0 ; i--){
			s.push(i);
		}
		Stack ns = AscendingStack(s);
		while(!ns.isEmpty()){
			System.out.println(ns.pop());
		}
		
		
	}


public static Stack AscendingStack(Stack s) throws Exception{
	Stack ns = new Stack(s.size());
	while(!s.isEmpty()){
		int temp = s.pop();
		while(!ns.isEmpty() && temp < ns.peek()){
			s.push(ns.pop());
		}
		ns.push(temp);
	}
	return ns;
	
}


}




class Stack {
	private int[] a;
	private int N;
	public Stack (int cap){
		a = new int[cap] ;
		}
	public boolean isEmpty(){
		return N == 0;
	}
	public boolean isFull(){
		return N == a.length;
	}
	public int size(){
		return N;
	}
	public void push(int data) throws Exception{
		if(N >= a.length){
			throw new Exception("stackoverflow");
		}
		a[N++] = data;
	}
	public int pop(){
		return a[--N];
	}
	public int peek() throws Exception{
		if (!isEmpty()){
			return a[N - 1];
		}
		throw new Exception("empty stack");
	}
	public void clear(){
		N = 0;
	}
}