package threedot3;
/**
 * Imagine a (literal) stack of plates. If the stack gets too high, it might topple.
 *  Therefore, in real life, we would likely start a new stack when the previous stack 
 *  exceeds some threshold. Implement a data structure SetOfStacks that mimics this. 
 *  SetOfStacks should be composed of several stacks and should create a new stack once the 
 *  previous one exceeds capacity.SetOfStacks.push() and SetOfStacks.pop() should behave identically 
 *  to a single stack (that is, pop() should return the same values as it would if there were just a 
 *  single stack).
 *  
 *  
 *  
 *  FOLLOW UP
 *  Implement a function popAt(int index) which performs a pop operation on a specific sub-stack.
 */

import java.util.ArrayList;


public class SetOfStack {
	  ArrayList<Stack>  pointers = new ArrayList<Stack>();
	  int N ;
	  int index = -1;
	  public SetOfStack(int N){
		  this.N = N;
	  }
	  public void push(int data) throws Exception{
		  if (index == -1){
			  Stack s = new Stack(N);
			  index++;
			  pointers.add(s);
			  s.push(data);
			  return ;
		  }else{
			  Stack s =  pointers.get(index);
			  if(s.isFull()){
				  Stack snew = new Stack(N);
				  pointers.add(snew);
				  index++;
				  snew.push(data);
				  return ;
			  }
			 s.push(data);  
		  }
	  }
		  public int pop() throws Exception {
			  if(pointers.isEmpty()){
				  throw new Exception("empty stack");
			  }
			  else{
				  Stack s = pointers.get(index);
				  int data = s.pop();
				  if (s.isEmpty()){
					  pointers.remove(s);
					  index--;
				  }
				  return  data;
			  }
		  }
		  public int  popAt(int index) throws Exception{
			  if ((index > this.index) || (index <0))
				  throw new Exception("out of range");
			  Stack sub = pointers.get(index);
			  return sub.pop();
		  }
		  public static void main(String[] args) throws Exception{
			  SetOfStack s = new SetOfStack(3);
			  for (int i = 0; i < 10; i++){
				  s.push(i);
			  }
			  System.out.println(s.popAt(2));
	
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