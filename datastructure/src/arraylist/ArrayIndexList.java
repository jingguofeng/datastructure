package arraylist;

public class ArrayIndexList<E> implements IndexList<E>{

	private E[] A;   //array storing the elements of the indexed list
	private int capacity = 16; //initial length of array A
	private int size;            //number of elements stored in the indexed list
	
	@SuppressWarnings("unchecked")
	public ArrayIndexList(){
		A = (E[]) new Object[capacity];
		size = 0;
	}

	
	public int size(){
		return size;
	}
	/**
	 * 
	 */
	public boolean isEmpty(){
		if(size() == 0)
			return true;
		return false;
	}
	/**
	 * Checking whether the index is out of boundary
	 * 
	 * @param i : input index
	 * @param n : current capacity of the list
	 * @throws IndexOutOfBoundsException
	 */
	public void checkIndex(int i,int n) throws IndexOutOfBoundsException{
		if(isEmpty()){
			if(i != 0)
				throw new IndexOutOfBoundsException("Index is out of boundary!");
		}
		else{
			if(i < 0 || i > n-1 )
				throw new IndexOutOfBoundsException("Index is out of boundary!");	
		}
	}
	/**
	 * 
	 */
	public void add(int i, E e) throws IndexOutOfBoundsException{
		checkIndex(i,size());
		if(size() == capacity){
			capacity *=2;              //increase the list if not enough large
			@SuppressWarnings("unchecked")
			E[] B = (E[]) new Object[capacity];
			for(int j = 0; j < size(); j++)
				B[j] = A[j];
			A = B;
		}
		
		for(int j = size(); j > i; j--)
			A[j] = A[j-1];
		A[i] = e;
		
		size++;
	}
	/**
	 * 
	 */
	public E get(int i) throws IndexOutOfBoundsException{
		checkIndex(i, size());
		return A[i];
	}
	
	public void set(int i, E e) throws IndexOutOfBoundsException{
		checkIndex(i, size());
		A[i] = e;
	}
	
	public E remove(int i) throws IndexOutOfBoundsException{
		checkIndex(i, size());
		E o = A[i];
		for(int k = i; k < size()-1; k++)
			A[k] = A[k+1];
		size--;
		return o;
	}
	
	public String toString() throws EmptyListException{
		if(isEmpty())
			throw new EmptyListException("List is empty.");
		String s = "[";
		for(int i = 0; i < size(); i++){
			if(i==0){
				s += A[i];
			}
			else{
				s +=", " + A[i];
			}
		}
		
		return s += "]";
	}
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args){
		ArrayIndexList<String> list = new ArrayIndexList<String>();
		list.add(0, "Jingguo");
		list.add(0,"mumu");
		list.add(1, "Mike");
		System.out.println(list);
		list.set(2, "Jingguo Feng");
		System.out.println(list);
	}
}
