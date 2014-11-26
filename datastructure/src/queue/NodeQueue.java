package queue;

public class NodeQueue<E> implements Queue<E> {

	protected Node<E> head;
	protected Node<E> tail;
	protected int size;
	
	public NodeQueue(){
		head = null;
		tail = null;
		size = 0;
	}
	
	public int size(){
		return size;
	}
	
	public boolean isEmpty(){
		if(head == null) return true;
		return false;
	}
	
	public E front() throws EmptyQueueException{
		if(isEmpty())
			throw new EmptyQueueException("Queue is empty.");
		return head.element;
	}

	public void enqueue(E element){
		Node<E> node = new Node<E>(element);
		if(size() == 0)
			head = node;
		else
			tail.next = node;
		tail = node;
		size++;
	}

	public E dequeue() throws EmptyQueueException{
		if(isEmpty())
			throw new EmptyQueueException("Queue is empty.");
		E temp;
		temp = head.element;
		head = head.next;
		size--;
		if(size == 0)
			tail = null;
		return temp;
	}	
	
	public String toString() throws EmptyQueueException{
		if(isEmpty())
			throw new EmptyQueueException("Queue is empty.");
		String s = "[";
		Node<E> index = head;
		if(size == 1)
			return s += index.element + "]";
		else{
			s += index.element;
			while(index.next != null){
				index = index.next;
				s += ", " + index.element; 
			}
			
			return s += "]";
		}
		
	}
	
	public static void main(String[] args){
		NodeQueue<Integer> n = new NodeQueue<Integer>();
		NodeQueue<String>  s = new NodeQueue<String>();
		
		n.enqueue(23);
		n.enqueue(13);
		n.enqueue(84);
		n.enqueue(42);
		
		s.enqueue("Jing");
		s.enqueue("Mu");
		s.enqueue("Tom");
		s.enqueue("Kaka");
		
		System.out.println(n);
		System.out.println(s);
		
		while(n.size() != 0){
			int k = n.dequeue();
			System.out.println(k + " has been moved out from list n");
			System.out.print("The rest of the list is: ");
			System.out.println(n);
		}
		
 	}
	
}
