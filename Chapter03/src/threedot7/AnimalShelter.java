package threedot7;
/**Career 3.7
 * An animal shelter holds only dogs and cats, and operates ona strictly “first in, first out” basis. 
 * People must adopt either the “oldest”(based on arrival time) of all animals at the shelter, or they 
 * can selectwhether they could prefer a dog or a cat (and will receive the oldest animal ofthat type).
 *  They cannot select which specific animal they would like. Createthe data structures to maintain this 
 *  system and implement operations such asenqueue, dequeueAny, dequeueDog and dequeueCat. You may use the 
 *  built-inLinkedList data structure.
 *  
 * 题目不是很难。。。但是用到了oo的思想，J2SE不熟的情况去学j2ee真是纯傻逼的行为，白白浪费了一周时间。。。。。
 * 包里别的文件是自己写的队列的实现。。。
 */
import java.util.LinkedList;
class Animal{
	String name;
	int priority;
	Animal(String name){
		this.name = name;
	}
	void setPriority(int priority){
		this.priority = priority;
	}
	int getPriority(){
		return priority;
	}
	String getName(){
		return name;
	}
	
}
 class Dog extends Animal{
	 Dog(String name){
		super(name);
	}
}
 
class Cat extends Animal{
	 Cat(String name){
		 super(name);
	 }
}

public class AnimalShelter {
	private LinkedList<Dog> ld = new LinkedList<Dog>();
	private LinkedList<Cat> lc = new LinkedList<Cat>();
	private int priority = 0;
	
	public void enqueue(Animal a){
		if( a instanceof Dog){
			a.setPriority(this.priority);
			ld.addLast((Dog)a);
			this.priority++;
			
		}
		if(a instanceof Cat){
			a.setPriority(this.priority);
			lc.addLast((Cat)a);
			this.priority++;
		}
	}
	public Cat dequeueCat() throws Exception{
		if(lc.isEmpty()){
			throw new Exception("no cat");
		}
		return lc.removeFirst();
	}
	public Dog dequeueDog() throws Exception{
		if(ld.isEmpty()){
			throw new Exception("no dog");
		}
		return ld.removeFirst();
	}
	
	public Animal dequeueAny() throws Exception{
		if(ld.isEmpty()){
			return this.dequeueCat();
		}else if(lc.isEmpty()){
			return this.dequeueDog();
		}else{
			Cat c = lc.peekFirst();
			Dog d = ld.peekFirst();
			return c.getPriority() > d.getPriority() ? ld.removeFirst() : lc.removeFirst();
		}
	}
	
	public static void main(String[] args) throws Exception{
		Dog d1 = new Dog("d1");
		Dog d2 = new Dog("d2");
		Dog d3 = new Dog("d3");
		Dog d4 = new Dog("d4");
		Dog d5 = new Dog("d5");
		Cat c1 = new Cat("c1");
		Cat c2 = new Cat("c2");
		Cat c3 = new Cat("c3");
		Cat c4 = new Cat("c4");
		AnimalShelter as = new AnimalShelter();
		as.enqueue(d1);
		as.enqueue(c4);
		as.enqueue(d3);
		as.enqueue(d2);
		as.enqueue(c1);
		as.enqueue(c2);
		as.enqueue(d5);
		as.enqueue(d4);
		as.enqueue(c3);
		for(int i = 0 ; i < 3 ; i++ ){
			System.out.println(as.dequeueAny().getName());
		}
		System.out.println(as.dequeueCat().getName());

		
	}
	
}

