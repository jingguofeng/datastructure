package queue;

public class ArrayQueue<E> implements Queue<E>{

	protected int capacity;  //The actual capacity of the queue array is (capacity - 1)
	public static final int CAPACITY = 1000;   //default array capacity
	protected E Q[];                        //Generic array used to implement the queue
	protected int f = 0;         //index for the front of the queue
	protected int r = 0;         //index for the first empty cell after the rear of the queue
	
	public ArrayQueue(){
		this(CAPACITY);    //default capacity
	}
	
	@SuppressWarnings("unchecked")
	public ArrayQueue(int cap){
		capacity = cap;
		Q = (E[]) new Object[capacity];
	}
	

	public int size(){
		return (capacity - f + r)%capacity;
	}

	public boolean isEmpty(){
		return (f == r);
	}

	public E front() throws EmptyQueueException{
		if(isEmpty())
			throw new EmptyQueueException("Queue is empty.");
		return Q[f];
	}

	public void enqueue(E element){
		if(size() == capacity - 1)
			throw new FullQueueException("Queue is full.");
		Q[r] = element;
		r = (r+1)%capacity;
	}

	public E dequeue() throws EmptyQueueException{
		if(isEmpty())
			throw new EmptyQueueException("Queue is empty.");
		E temp;
		temp = Q[f];
		Q[f] = null;
		f = (f+1)%capacity;
		return temp;
	}
	
	public String toString() throws EmptyQueueException{
		if(isEmpty())
			throw new EmptyQueueException("Queue is empty.");
		String s = "[" + Q[f];
		int n = f + 1;
		for(int i = 0; i < size() - 1; i++){
			s += ", " + Q[n];
			n = (n+1)%capacity;
		}
		return s += "]";
	}
	
	public static void main(String[] args){
		ArrayQueue<Integer> n = new ArrayQueue<Integer>();
		ArrayQueue<String>  s = new ArrayQueue<String>();
		n.enqueue(21);
		n.enqueue(31);
		n.enqueue(1);
		n.enqueue(4);
		n.enqueue(45);
		n.enqueue(234);
		
		System.out.println(n);
		
		s.enqueue("Mike");
		s.enqueue("Lily");
		s.enqueue("Jing");
		System.out.println(s);
		
		String s1 = s.dequeue();
		System.out.println("After pop(), the element: \"" + s1 + "\" has been moved out from the list and the remainder is: ");
		System.out.println(s);
		System.out.println("and the size of the list is " + s.size());
		
		s.dequeue();
		System.out.println("After pop(), the element: \"" + s1 + "\" has been moved out from the list and the remainder is: ");
		System.out.println(s);
		System.out.println("and the size of the list is " + s.size());
		s.dequeue();		
		System.out.println("After pop(), the element: \"" + s1 + "\" has been moved out from the list and the remainder is: ");
		s.dequeue();
	}
}
