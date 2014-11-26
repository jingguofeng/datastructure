package stacks;

public class Node<E> {
	//Instance variable:
	protected E element;
	protected Node<E> next;
	
	public Node(){
		this(null);
	}
	
	public Node(E e){
		element = e;
		next = null;
	}
	
	public String toString(){
		return element.toString();
	}
	
	public E getElement(){
		return element;
	}
}
