package threedot1;
/*
 *Career 3.1 
 * Describe how you could use a single array to implement three stacks.
 * 把题目想负责了。。。擦  看了答案才知道这么简单
 * ps:注意一下判断堆栈的空和满
 */

public class ThreeStack {
	 int stackSize = 10;
	 int[] buffer = new int[stackSize *3];
	 int[] stackPointer = {0,0,0};
	public static void main(String[] args) throws Exception{
		ThreeStack ts = new ThreeStack();
		for(int i = 0 ; i < 10 ; i++){
			ts.push(1, i);
		}
		for(int i = 0; i < 10; i++){
			System.out.print(ts.pop(1) + " ");
		}
	}
	public  void push(int stackNum, int value) throws Exception{
		if(isFull(stackNum)){
			throw new Exception("out of range");
		}
		
		stackPointer[stackNum]++;
		buffer[absTopOfStack(stackNum)] = value;
	}
	public  int pop(int stackNum) throws Exception{
		if(isEmpty(stackNum)){
			throw new Exception("Trying to pop an empty stack");
		}
		int value = buffer[absTopOfStack(stackNum)];
		buffer[absTopOfStack(stackNum)] = 0;
		stackPointer[stackNum]--;
		return value;
	}
	public int peek(int stackNum){
		int index = absTopOfStack(stackNum);
		return buffer[index];
	}
	public  boolean isEmpty(int stackNum){
		return stackPointer[stackNum] == 0;
	}
	public boolean isFull(int stackNum){
		return stackPointer[stackNum] == stackSize;
	}
	public  int absTopOfStack(int stackNum){
		return stackNum * stackSize + stackPointer[stackNum];
	}
}
