package arraylist;

public interface ArrayList<E> {
	/**
	 * Returns the number of elements in this list.
	 */
	public int size();
	/**
	 * Returns whether the list is empty.
	 */
	public boolean isEmpty();
	/**
	 * Inserts an element e to be at index i, shifting all elements after this.
	 */
	public void add(int i, E e);

}
