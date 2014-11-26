package linkedlist;

public class Node {

		protected String element;
		protected Node next;
		
		public Node(){
			this("nothing");
		}
		
		public Node(String s){
			this.element = s;
			next = null;
		}
		
		public void setElement(String s){
			element = s;
		}
		
		public String toString(){
			return element;
		}
}
