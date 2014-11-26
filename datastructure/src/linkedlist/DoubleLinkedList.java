package linkedlist;

public class DoubleLinkedList {

	protected long size;
	protected DNode header, trailer;
	
	public DoubleLinkedList(){
		size = 0;
		header = new DNode();
		trailer = new DNode();
		header.next = trailer;
		trailer.prev =  header;
	}
	
	public long size(){
		return size;
	}
	
	public boolean isEmpty(){
		return (size == 0);
	}
	
	public DNode getFirst() throws IllegalStateException{
		if(isEmpty()) throw new IllegalStateException("List is empty");
		return header.next;
	}
	
	public DNode getLast() throws IllegalStateException{
		if(isEmpty()) throw new IllegalStateException("List is empty");
		return trailer.prev;
	}
	
	public void addFirst(String s){
		DNode newNode = new DNode(s);
		newNode.next = header.next;
		newNode.prev = header;
		header.next.prev = newNode;
		header.next = newNode;
		size++;
	}
	
	public void addLast(String s){
		DNode newNode =  new DNode(s);
		newNode.next = trailer;
		newNode.prev = trailer.prev;
		trailer.prev.next= newNode;
		trailer.prev = newNode;
		size++;
	}
	
	public void removeFirst(){
		if(isEmpty()){
			System.out.println("Empty List!");
		}
		else{
			DNode theNode = header.next;
			header.next = theNode.next;
			theNode = null;
			size--;
		}
		
	}
	
	public void removeLast(){
		if(isEmpty()){
			System.out.println("Empty List!");
		}
		else{
			DNode theNode = trailer.prev;
			trailer.prev = theNode.prev;
			theNode = null;
			size--;
		}
	}
	
	
	public DNode find(String s){
		DNode theLink = header.next;
		
		if(isEmpty()) {
			System.out.println("Empty LinkedList.");
			return null;
		}else{
			
			while(theLink.element != s){
				if(theLink.next == null ){
					System.out.println("Can't find the element in the List.");
					return null;
				}else{
					theLink = theLink.next;
				}	
				
			}
			return theLink;
		}
		
	}
	
	
	public void addBefore(String oldEntry, String newEntry){
		DNode theNode = find(oldEntry);
		if(theNode == null){
			System.out.println("There is no such thing in the List. Try again!");
		}
		else{
			DNode newNode = new DNode(newEntry);
			newNode.prev = theNode.prev;
			newNode.next = theNode;
			theNode.prev.next = newNode;
			theNode.prev = newNode;
			size++;
		}
		
	}
	
	public void addBehind(String oldEntry, String newEntry){
		DNode theNode = find(oldEntry);
		if(theNode == null){
			System.out.println("There is no such thing in the List. Try again!");
		}
		else{
			DNode newNode = new DNode(newEntry);
			newNode.prev = theNode;
			newNode.next = theNode.next;
			theNode.next.prev = newNode;
			theNode.next = newNode;
			size++;
		}
	}
	
	public void removeEntry(String en){
		DNode theNode = find(en);
		if(theNode == null){
			System.out.println("There is no such thing in the List. Try again!");
		}
		else{
			theNode.prev.next = theNode.next;
			theNode.next.prev = theNode.prev;
			theNode = null;
			size--;
		}
	}
	
	
	public String toString(){
		String s="";
		DNode theList = header;
		long index = size;
		if(theList.next == trailer){
			return "The list is empty.";
		}
		else{
			while(theList.next != trailer){
				theList = theList.next;
				s += "The " + index +"th element: " + theList + ". \n";
				index--;
			}
			return s;
		}
	}
	
	
	public static void main(String[] args){
		DoubleLinkedList Dlist = new DoubleLinkedList();
		Dlist.addFirst("Jingguo Feng");
		Dlist.addFirst("Linshen Cheng");
		Dlist.addLast("GuoGuo");
		
		System.out.println(Dlist);
		
		DNode myNode = Dlist.find("GuoGuo");
		System.out.println(myNode.next);
		
		Dlist.addBefore("Jingguo Feng", "newEntry 1");
		
		System.out.println(Dlist);
		
		Dlist.addBehind("GuoGuo", "newEntry 2");
		System.out.println(Dlist);
		
		Dlist.removeEntry("Jingguo Feng");
		System.out.println(Dlist);
		
		Dlist.removeEntry("s123");
		
	}
	
	
	
	
	
}
