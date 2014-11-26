package arraylist;

import java.util.Iterator;

public class ElementIterator<E> implements Iterator<E> {

	protected PositionList<E> list;        //the underlying list
	protected Position<E> cursor;          //the next position
	
	/**
	 * Creates an element iterator over the given list.
	 */
	public ElementIterator(PositionList<E> L){
		list = L;
		cursor = (list.isEmpty())? null : list.first();
	}
	
	public boolean hasNext(){
		return (cursor != null);
	}
	
	public E next() throws NoSuchElementException{
		if(cursor == null)
			throw new NoSuchElementException("No next element.");
		E toReturn = cursor.element();
		try {
			cursor = (cursor == list.last())? null : list.next(cursor);
		} catch (InvalidPositionException e) {
			// TODO Auto-generated catch block
			System.out.println("InvalidPositionException catch.");
			e.printStackTrace();
		} catch (BoundaryViolationException e) {
			// TODO Auto-generated catch block
			System.out.println("BoundaryViolationException catch.");
			e.printStackTrace();
		}
		return toReturn;
	}
	
 }
