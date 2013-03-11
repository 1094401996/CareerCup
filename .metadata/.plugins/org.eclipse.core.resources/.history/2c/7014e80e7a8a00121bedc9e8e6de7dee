package threedot1;

public class ThreeStack {
	static int stackSize = 100;
	static int[] buffer = new int[stackSize *3];
	static int[] stackPointer = {-1,-1,-1};
	public static void main(String[] args){
		
	}
	public static void push(int stackNum, int value) throws Exception{
		if(stackPointer[stackNum] + 1 >= stackSize){
			throw new Exception("out of space");
		}
		
		stackPointer[stackNum]++;
		buffer[absTopOfStack(stackNum)] = value;
	}
	public static int pop(int stackNum) throws Exception{
		if(stackPointer[stackNum] == -1){
			throw new Exception("Trying to pop an empty stack");
		}
		int value = buffer[absTopOfStack(stackNum)];
		buffer[absTopOfStack(stackNum)] = 0;
		stackPointer[stackNum]--;
		return value;
	}
	public static int peek(int stackNum){
		int index = absTopOfStack(stackNum);
		return buffer[index];
	}
	public static boolean isEmpty(int stackNum){
		return stackPointer[stackNum] == -1;
	}
	public static int absTopOfStack(int stackNum){
		return stackNum * stackSize + stackPointer[stackNum];
	}
}
