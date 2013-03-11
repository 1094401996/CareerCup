package threedot2;

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
		 s.pop();
		 if(diff < 0){
			 s.push(min - diff);
			 return min;
		 }else{
			 if(!s.isEmpty()){
				 s.push(min);
				 return diff + min;
			 }
			 return min;
		 }
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
