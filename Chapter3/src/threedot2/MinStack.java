package threedot2;

    class Stack {
		private int[] a;
		private int N;
		public Stack (int cap){
			a = new int[cap] ;
			}
		public boolean isEmpty(){
			return N == 0;
		}
		public int size(){
			return N;
		}
		public void push(int data){
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
		public class MinStack {
			private Stack s;
			private Stack help;
			public MinStack(int cap){
				s = new Stack(cap);
				help = new Stack(cap);
			}
			public boolean isEmpty(){
				return s.isEmpty();
			}
			public int size(){
				return s.size();
			}
			public void push(int data) throws Exception {
				s.push(data);
				if (help.isEmpty()){
					help.push(data);
					return ;
				}
				if (data <= help.peek())
					help.push(data);
			}
			public int pop() throws Exception{
				if (s.isEmpty())
					throw new Exception("empty stack");
				int data = s.pop();
				if(data == help.peek())
					help.pop();
				return data;
			}
			public int min() throws Exception{
				return help.peek();
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
