package threedot7;

 public class SNode {
       private int val;
       private SNode next;
       public static int a = 3;
       
       public SNode(){
    	   
       }
       public SNode(int val){
    	   this.val = val;
       }
       public SNode(int val, SNode next){
    	   this.val = val;
    	   this.next = next;
       }
       
       public int getVal(){
    	   return this.val;
       }
       public SNode getNext(){
    	   return this.next;
       }
       public void setVal(int val){
    	   this.val = val;
       }
       public void SetNext(SNode next){
    	   this.next = next;
       }
       public boolean deleteMyself(){
    	   if(this != null && this.getNext() != null){
    		   this.setVal(this.getNext().getVal());
    		   this.SetNext(this.getNext().getNext());
    		   return true;
    	   }
    	   return false;
       }

}
