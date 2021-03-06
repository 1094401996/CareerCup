package threedot2;
/**career 3.2
 * How would you design a stack which, in addition to push and pop, 
 * also has a function min which returns the minimum element?
 * Push, pop and min should all operate in O(1) time.
 * @author geng
 *  有用的链接：
 *  http://blog.csdn.net/yysdsyl/article/details/4283806 
 *  http://blog.csdn.net/ssjhust123/article/details/7752878
 *  
 *  method2:
 *  push(int elem)函数在栈中压入当前元素与当前栈中最小元素的差值，然后通过比较当前
 *  元素与当前栈中最小元素大小，并将它们中间的较小值压入。pop()函数执行的时候，先pop
 *  出栈顶的两个值，这两个值分别是当前栈中最小值min和最后压入的元素与栈中最小值的差值diff。
 *  如果diff<0，则表示最后压入栈的元素是最小的元素，因此只需将min-diff压入栈中，并将min值返回即可。
 *  min-diff就是当前元素弹出后，栈中剩下元素的最小值。而如果diff>=0且栈不为空，则表示当前值不是最小值，
 *  所以需要在栈中压入最小值min并将diff+min返回；如果栈为空，则表示已经是最后一个数字，直接返回min即可。
 */

public class MinStack2 {
	 Stack s;
	public MinStack2(int cap){
		s = new Stack(100);
	}
	 public void push(int data) throws Exception{
		 if(s.isEmpty()){
			 s.push(data);
			 s.push(data);
		 }else{
			 int min = s.pop();
			 s.push(data - min);
			 s.push(data < min ? data : min);
		 }
	 }
	 public int pop() throws Exception{
		 int min = s.pop();
		 int diff = s.pop();
		 int popeditem = 0;
		 if(diff < 0){//说明最后压入堆栈的是最小元素
			 s.push(min - diff);
			 popeditem = min;
		 }else{
			 if(!s.isEmpty()){
				 s.push(min);
			 }
			 popeditem = diff + min;
			
		 }
		 return popeditem;
	 }
	 public int min() throws Exception{
		 return s.peek();
	 }
	 public static void main(String[]args) throws Exception{
			MinStack s = new MinStack(100);
			s.push(3);
			s.push(2);
			s.push(5);
			s.push(4);
			s.push(1);
			System.out.println(s.min());
			s.pop();
			System.out.println(s.min());
			s.pop();
			System.out.println(s.min());
			s.pop();
			System.out.println(s.min());
			s.pop();
			System.out.println(s.min());

			
			
		}
}
