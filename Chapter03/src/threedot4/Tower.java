package threedot4;
/*	CareerCup 3.4
 * 
 * In the classic problem of the Towers of Hanoi, you have 3 towers and N disks of different 
 * sizes which can slide onto any tower. The puzzle starts with disks sorted in ascending order
 *  of size from top to bottom (i.e., each disk sits on top of an even larger one). You have the following constraints:
 *  (1) Only one disk can be moved at a time.
 *  (2) A disk is slid off the top of one tower onto the next tower.
 *  (3) A disk can only be placed on top of a larger disk.
 *  Write a program to move the disks from the first tower to the last using stacks.
 *  
 *  f(n) = 2 f(n-1) + 1
 *  f(N) = O(2^N)
 *  
 *  useful link : http://blog.csdn.net/xujinsmile/article/details/8091738
 *  此人代码写的有点混乱。。。。
 *  
 *  对递归的认识还不够。。。别人写的代码能看懂，自己想就跪了。。。。。。。
 * */

public class Tower {
	
	public static void main(String[]args) throws Exception{
		int n =3;
		String a = "TowerA";
		String b = "TowerB";
		String c = "TowerC";
		hanoi(n,a,c,b);
		oomethod();
		
	}
	//move n plates form a to c with the help of b
	public static void hanoi(int n, String origin, String destination , String buffer ){
		if(n > 0){
			//move top n-1 disks form origin to buffer using destination as a buffer
			hanoi(n -1 , origin, buffer, destination);
			
			/*move top from origin to destination*/
			move(origin,destination);
			
			//move top n-1 disks form buffer to destination, using origin as the a buffer;
			hanoi(n - 1 , buffer, destination, origin);
			
		}
	}
	private static void move(String origin, String destination){
		System.out.println(origin + "---->" + destination);
	}



//书上的oo方法
	public static void oomethod() throws Exception{
		System.out.println("-----------------------------------");
		int N = 3;
		Stack[] towers = new Stack[3];
		for (int i = 0 ; i < 3; i++){
			towers[i] = new Stack(64, i);
		}
		for(int i = N ; i >0 ; i--){
			towers[0].push(i);
		}
		towers[0].moveElements(towers[2], towers[1]);
	}

}
class Stack {
	private int[] a;
	private int N;
	private int index;
	public Stack (int cap,int index){
		a = new int[cap] ;
		this.index = index;
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
		}else if( !this.isEmpty() && this.peek() <= data){
			System.out.println("illegal");
		}{
			a[N++] = data;
		}
	}
	public int index(){
		return index;
	}
	public int pop(){
		if(this.isEmpty()){		
			System.out.println("empty");
		}
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
	private void move(Stack s) throws Exception{
		int top = this.pop();
		s.push(top);
		System.out.println("move disk  " + top + "  from tower" + index() + "  to  tower" + s.index() );
	}
	public void moveElements(Stack destination, Stack buffer) throws Exception{
		int size = this.size();
		moveElementshelper(size, destination, buffer);
	}
	private void moveElementshelper(int n, Stack destination, Stack buffer) throws Exception{
		if(n > 0){
			moveElementshelper(n - 1, buffer, destination);
			move(destination);
			buffer.moveElementshelper(n - 1, destination, this);
		}
				
	}
	
	
}

