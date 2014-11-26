package linkedlist;

public class CircleList {
	
	protected Node cursor;    //the current cursor
	protected int size;             //the number of nodes in the list
	
	public CircleList(){
		cursor = null;
		size = 0;
	}
	
	public int size(){
		return size;
	}
	
	public Node getCursor(){
		return cursor;
	}
	
	public void advance(){
		cursor  = cursor.next;
	}
	
	public void add(String s){
		if(cursor == null){
			Node newNode = new Node(s);		
			cursor = newNode;
			newNode.next = cursor;
			size++;
		}
		else{
			Node newNode = new Node(s);
			newNode.next =cursor.next;
			cursor.next = newNode;
			size++;
		}
	}
	
	public void remove(){
		Node oldNode = cursor.next;
		if(oldNode == cursor){
			cursor = null;
		}
		else{
			cursor.next = oldNode.next;
			oldNode = null;
		}
		size--;
	}
	
	public String toString(){
		if(cursor == null)			
			return "[]";
		String s ="[..." + cursor.element;
		Node oldCursor = cursor.next;
		while(oldCursor != cursor){
			s +=", " + oldCursor.element;
			oldCursor = oldCursor.next;
		}
		return s + "...]";
	}
	
	public static void main(String[] args){
		CircleList myList = new CircleList();

		myList.add("Jingguo Feng");
		myList.add("Lydia");
		myList.add("GUOGUO");
		myList.add("MUMU");

		
		System.out.println(myList);
		
		myList.remove();
		System.out.println(myList);
	}
	
}
