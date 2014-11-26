package linkedlist;

public class LinkedList {

	public Node head;
	public long size;
	
	public LinkedList(){
		head = null;
		size = 0;
	}
	
	public void addFirst(String s){
		Node newNode = new Node(s);
		newNode.next = head;
		head = newNode;
		size++;
	}
	
	public String toString(){
		String s = "";
		long index = size;
		Node showhead = head;
		if(size == 0){
				s +="The linkedlist is empty.";
				return s;
		}
		else{
			
				while(showhead != null){
					s += "The " + index + "th element: " + showhead + ". \n";
					index--;
					showhead = showhead.next;
				}
				return s;
			}
	}
	
	public void removeFirst() {
		if (head == null)
				System.out.println("Empty LinkedList! \n");
			else{	
				Node awayList = new Node();
				awayList = head;
				head = head.next;
				size--;
				System.out.println( "Element " + "\""+awayList + "\" has been removed! \n");
			}
	}
	
	public static void main(String[] args){
		LinkedList myList = new LinkedList();
		
		myList.addFirst("Jingguo Feng");
		myList.addFirst("Linshen Cheng");
		myList.addFirst("guoguo");
		myList.addFirst("Mumu");
		
		System.out.println(myList.head);
		
		System.out.println(myList);
		
		myList.removeFirst();
		
		System.out.println(myList);
		
		myList.removeFirst();
		
		System.out.println(myList);
		myList.removeFirst();
		
		System.out.println(myList);

		myList.removeFirst();
		
		System.out.println(myList);
		
		myList.removeFirst();
		
		System.out.println(myList);
	}
}
