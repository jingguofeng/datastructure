package queue;

public class NodeDeque<E> implements Deque<E> {

	protected DNode<E> header, trailer;
	private int size;
	
	public NodeDeque(){
		header = null;
		trailer = null;
		size = 0;
	}
	
	public int size(){
		return size;
	}
	
	public boolean isEmpty(){
		if(size == 0)
			return true;
		return false;
	}
	
	public E getFirst() throws EmptyDequeException{
		if(isEmpty())
			throw new EmptyDequeException("Deque is empty.");
		return header.element;
	}
	
	public E getLast() throws EmptyDequeException{
		if(isEmpty())
			throw new EmptyDequeException("Deque is empty.");
		return trailer.element;
	}
	
	public void addFirst(E e){
		DNode<E> node = new DNode<E>(e);
		node.prev = null;
		node.next = header;
		header = node;
		size++;
	}
	
	public void addLast(E e){
		DNode<E> node = new DNode<E>(e);
		node.prev = trailer;
		node.next = null;
		trailer = node;
		size++;
	}
	
	public E removeFirst() throws EmptyDequeException{
		if(isEmpty())
			throw new EmptyDequeException("Deque is empty.");
		E o = header.element;
		DNode<E> node = header;
		header.next.prev = null;
		header = header.next;
		node.next = null;
		node.prev = null;
		size--;
		return o;
	}
	
	public E removeLast() throws EmptyDequeException{
		if(isEmpty())
			throw new EmptyDequeException("Deque is empty.");
		E o = trailer.element;
		DNode<E> node =  trailer;
		trailer.prev.next = null;
		trailer = trailer.prev;
		node.prev = null;
		node.next = null;
		return o;
	}

	
	
}
