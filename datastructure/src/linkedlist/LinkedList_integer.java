package linkedlist;

public class LinkedList_integer {

		protected int size;
		protected Node_integer firstnumber;
		
		public LinkedList_integer(){
			firstnumber = null;
			size = 0;
		}
		
		public void addFirst(int n){
			Node_integer newNode = new Node_integer(n);
			newNode.next = firstnumber;
			firstnumber = newNode;
			size++;
		}
		
		public boolean isEmpty(){
			return (size == 0);
		}

		public void insertionsort(){
			
			if(isEmpty()){
				System.out.println("Empty List!");
			}
			else{
				Node_integer newHead = new Node_integer(firstnumber.val);   //The new firstnumber for sorted list
				Node_integer pointer = firstnumber.next;          //pointer for the insertion value
				
				while(pointer != null){
					
					Node_integer innerPointer = newHead;      //inner pointer for comparison 
					Node_integer next_pointer = pointer.next;  //move the pointer to the next insertion value
					
					if(pointer.val <= newHead.val){
						Node_integer oldHead = newHead;
						newHead = pointer;
						newHead.next = oldHead;
					}
					else{
						
						while(innerPointer.next != null){
							if(pointer.val <= innerPointer.next.val){
								pointer.next = innerPointer.next;
								innerPointer.next = pointer;
								break;
							}
								
								innerPointer = innerPointer.next;
						}
						
						if(innerPointer.next == null){
							innerPointer.next = pointer;
							pointer.next = null;
						}
						
					}
					
					pointer = next_pointer;
					
					
				}
				
				this.firstnumber = newHead;
			}
			
			
			  
		}
		
		
		public String toString(){
			Node_integer theNode = firstnumber;
			if(isEmpty()){
				return "The list is empty.";
			}
			else{
				String s ="[...";
				while(theNode.next != null){
					s += theNode.val + ", ";
					theNode = theNode.next;
				}
				s += theNode.val+ "...]";
				return s;
			}
			
		}
		
		public static void main(String[] args){
			LinkedList_integer mylist = new LinkedList_integer();
			mylist.addFirst(10);
			mylist.addFirst(9);
			mylist.addFirst(1);
			mylist.addFirst(45);
			mylist.addFirst(3);
			mylist.addFirst(7);
			mylist.addFirst(11);
			mylist.addFirst(1);
			mylist.addFirst(1234);
			mylist.addFirst(5);
			mylist.addFirst(6);
			mylist.addFirst(34);
			mylist.addFirst(45);
			mylist.addFirst(23);
			mylist.addFirst(111);
			System.out.println(mylist);

			
			mylist.insertionsort();
			
			System.out.println(mylist);
			
		}
		
}
