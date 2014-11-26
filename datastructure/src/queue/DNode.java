package queue;

public class DNode<E> {

	protected E element;
	protected DNode<E> next;
	protected DNode<E> prev;
	
	public DNode(){
		this(null);
	}
	
	public DNode(E e){
		element = e;
		next = null;
		prev = null;
	}
	
	public String toString(){
		return element.toString();
	}
}
