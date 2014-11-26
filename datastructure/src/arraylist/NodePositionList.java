/**
 *  A Node List Implementation in Java
 *  
 */
package arraylist;

import java.util.Iterator;

public class NodePositionList<E> implements PositionList<E> {
	
	protected int numElts;           //Number of elements in the list
	protected DNode<E> header, trailer;   //header and trailer actually don't have meaningful element, they are just pointers
	/**
	 * Constructor that creates an empty list; O(1) time
	 */
	public NodePositionList(){
		numElts = 0;
		header = new DNode<E>();
		trailer = new DNode<E>();
		header.next = trailer;
		trailer.prev = header;
	}
	
	/**
	 * Check if position is valid for this list and converts it to
	 * DNode if it is valid; O(1) time
	 * @param p
	 * @return
	 * @throws InvalidPositionException
	 */
	protected DNode<E> checkPosition(Position<E> p) throws InvalidPositionException{
		if(p == null)
			throw new InvalidPositionException("Null position passed to NodeList.");
		if(p == header)
			throw new InvalidPositionException("The header node is not a valid position");
		if(p == trailer)
			throw new InvalidPositionException("The trailer node is not a valid position.");
		try{
			DNode<E> temp = (DNode<E>) p;
			if( (temp.prev == null) || (temp.next ==  null))
				throw new InvalidPositionException("Position does not belong to a valid NodeList.");
			return temp;
		}catch(ClassCastException e){
			throw new InvalidPositionException("Position is of wrong type for this list.");
		}
	}
	/**
	 * Returns the number of elements in this list.
	 * O(1) time
	 */
	public int size(){
		return numElts;
	}
	/**
	 * Returns whether the list is empty.
	 * O(1) time
	 */
	public boolean isEmpty(){
		return (numElts == 0);
	}
	/**
	 * Returns the first node in the list.
	 * O(1) time
	 */
	public Position<E> first() throws EmptyListException{
		if(isEmpty())
			throw new EmptyListException("List is empty.");
		return header.next;
	}
	/**
	 * Returns the last node in the list.
	 * O(1) time
	 */
	public Position<E> last() throws EmptyListException{
		if(isEmpty())
			throw new EmptyListException("List is empty.");
		return trailer.prev;
	}
	/**
	 * Returns the node after a given node in the list.
	 * O(1) time
	 */
	public Position<E> next(Position<E> p) throws InvalidPositionException, BoundaryViolationException{
		DNode<E> v = checkPosition(p);
		DNode<E> next = v.getNext();
		if(next == trailer)
			throw new BoundaryViolationException("Cannot advance past the end of the list.");
		return next;
	}
	/**
	 * Returns the node before a given node in the list.
	 */
	public Position<E> prev(Position<E> p) throws InvalidPositionException, BoundaryViolationException{
		DNode<E> v = checkPosition(p);
		DNode<E> prev = v.getPrev();
		if(prev == header)
			throw new BoundaryViolationException("Cannot advance past the beginning of the list.");
		return prev;
	}
	/**
	 * Inserts an element at the front of the list, returning new position.
	 * O(1) time
	 */
	public void addFirst(E e){
		DNode<E> newNode = new DNode<E>(header, header.getNext(),e);
		header.getNext().setPrev(newNode);
		header.next = newNode;
		numElts++;
	}
	/**
	 * Inserts an element at the back of the list, returning new position.
	 * O(1) time
	 */
	public void addLast(E e){
		DNode<E> newNode = new DNode<E>(trailer.prev, trailer,e);
		trailer.prev.next = newNode;
		trailer.prev = newNode;
		numElts++;
	}
	/**
	 * Inserts an element after the given node in the list.
	 * O(1) time
	 */
	public void addAfter(Position<E> p, E e) throws InvalidPositionException{
		DNode<E> v = checkPosition(p);
		numElts++;
		DNode<E> newNode = new DNode<E>(v, v.next, e);
		v.next.prev = newNode;
		v.next = newNode;
	}
	/**	
	 * Inserts an element before the given node in the list.
	 * O(1) time
	 */
	public void addBefore(Position<E> p, E e) throws InvalidPositionException{
		DNode<E> v = checkPosition(p);
		numElts++;
		DNode<E> newNode = new DNode<E>(v.prev, v, e);
		v.prev.next = newNode;
		v.prev = newNode;
	}
	/**
	 * Removes a node from the list, returning the element stored there.
	 */
	public E remove(Position<E> p) throws InvalidPositionException{
		DNode<E> v = checkPosition(p);
		numElts--;
		DNode<E> vPrev = v.prev;
		DNode<E> vNext = v.next;
		vPrev.next = vNext;
		vNext.prev = vPrev;
		E vElem = v.element;
		//unlink the position from the list and make it invalid
		v.next = null;
		v.prev = null;
		return vElem;
	}
	/**
	 * Replaces the element stored at the given node, returning old element.
	 * O(1) time
	 */
	public E set(Position<E> p, E e) throws InvalidPositionException{
		DNode<E> v = checkPosition(p);
		E oldElt = v.element;
		v.setElement(e);
		return oldElt;
	}
	
	/**
	 * Returns an iterator of all the elements in the list.
	 */
	public Iterator<E> iterator() {
		return new ElementIterator<E>(this);
	}
	
	public Position<E> find(E e) throws NoSuchElementException, EmptyListException{
		if(isEmpty())
			throw new EmptyListException("List is empty.");
		DNode<E> pointer = header.next;
		while(pointer != trailer){
			if(pointer.element.equals(e))
				return pointer;
			pointer = pointer.next;
		}
		throw new NoSuchElementException("No Such Element.");
		
	}
	/**
	 * Returns a textual representation of a given node list
	 */
	public String toString(){
		Iterator<E> k = this.iterator();
		String s = "[";
		while(k.hasNext()){
			s += k.next();
			if(k.hasNext())
				s += "; ";
		}
		return s += "]";
	}
	
	/**
	 * Returns an iterable collection of all the nodes in the list.
	 * @throws BoundaryViolationException 
	 * @throws InvalidPositionException 
	 */
	public Iterable<Position<E>> position() throws InvalidPositionException, BoundaryViolationException{
		PositionList<Position<E>> P = new NodePositionList<Position<E>>();
		if(!isEmpty()){
			Position<E> p = first();
			while(true){
				P.addLast(p);  //add position p as the last element of list P
				if(p == last())
					break;
				p = next(p);
			}
		}
		return P;
	}
	
	public static void main(String[] args) throws InvalidPositionException, BoundaryViolationException{
		NodePositionList<MyContact> list1 = new NodePositionList<MyContact>();
		list1.addFirst(new MyContact("jingguo","feng","everjgfeng@gmail.com","24"));
		list1.addFirst(new MyContact("linshen","cheng","lydia01234@gmail.com","23"));
		list1.addFirst(new MyContact("Malishkevich", "Jake","jake@promodealer.com","29"));
		list1.addFirst(new MyContact("xiaolan", "chang", "xlchang@stu.edu.cn", "50"));
		
		
		System.out.println(list1);
		NodePositionList<Integer> list2 = new NodePositionList<Integer>();
		list2.addFirst(123);
		list2.addFirst(342);
		list2.addFirst(2);
		list2.addFirst(11);
		list2.addFirst(3454);
		
		System.out.println(list2);
		
		Position<Integer> newNode = list2.find(2);
		list2.set(newNode, 45);
		System.out.println(list2);
		
		String s1 = "nice";
		String s2 = "nice";
		System.out.println(s1.equals(s2));
		
		MyContact n1 = new MyContact("Malishkevich", "Jake","jake@promodealer.com","29");
		MyContact n2 = new MyContact("Malishkevich", "Jake","jake@promodealer.com","29");
		
		System.out.println(n1.equals(n2));
		
		NodePositionList<String> list3 = new NodePositionList<String>();
		list3.addFirst("Jingguo");
		list3.addFirst("mumu");
		list3.addFirst("kk");
		list3.addFirst("aa");
		list3.addFirst("nn");
		
		Position<String> newNode3 = list3.find("kk");
		list3.set(newNode3, "sdfsdf");
		System.out.println(list3);
		
		MyContact n3 = new MyContact("jingguo","feng","everjgfeng@gmail.com","24");
		
		Position<MyContact> newNode2 = list1.find(n3);
		System.out.println(newNode2.element());
		list1.set(newNode2, new MyContact("Mumu", "big","mumu@promodealer.com","20"));
		System.out.println(list1);
		
		Iterable<Position<String>> iterable_list = list3.position();
		for(Position<String> s: iterable_list)
			System.out.println(s.element());
	}
	

}
