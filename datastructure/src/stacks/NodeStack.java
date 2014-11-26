package stacks;

public class NodeStack<E> implements Stack<E> {
	protected Node<E> top;   //reference to the head node
	protected int size;      //number of elements in the stack
	public NodeStack(){
		top = null;
		size = 0;
	}
	
	public int size(){
		return size;
	}
	
	public boolean isEmpty(){
		if(top == null) return true;
		return false;
	}
	
	public void push(E elem){
		Node<E> v = new Node<E>(elem);
		v.next = top;
		top = v;
		size++;
	}
	
	public E top() throws EmptyStackException{
		if(isEmpty()) throw new EmptyStackException("Stack is empty.");
		return top.element;
	}
	
	public E pop() throws EmptyStackException{
		if(isEmpty()) throw new EmptyStackException("Stack is empty.");
		E temp = top.element;
		top = top.next;
		size --;
		return temp;
	}
	
	
}
