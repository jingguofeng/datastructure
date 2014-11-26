package queue;

public class Node<E> {
	
	protected E element;
	protected Node<E> next;
	
	public Node(){
		this(null);
	}
	
	public Node(E element){
		this.element = element;
		next = null;
	}
	
	public String toString(){
		return element.toString();
	}
}
