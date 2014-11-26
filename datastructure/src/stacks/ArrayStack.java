/**
 * Implementation of the Stack ADT using a fixed-length array. An exception
 * is thrown if a push operation is attempted when the size of the stack is
 * equal to the length of the array. This class includes the main methods of 
 * the built-in class java.util.Stack.
 */

package stacks;

import java.util.Arrays;

public class ArrayStack<E> implements Stack<E> {
	protected int capacity;  //The actual capacity of the stack array
	public static final int CAPACITY = 1000;   //default array capacity
	protected E S[];                        //Generic array used to implement the stack
	protected int top = -1;         //index for the top of the stack
	
	public ArrayStack(){
		this(CAPACITY);    //default capacity
	}
	
	@SuppressWarnings("unchecked")
	public ArrayStack(int cap){
		capacity = cap;
		S = (E[]) new Object[capacity];
	}
	
	public int size(){
		return (top+1);
	}
	
	public boolean isEmpty(){
		return (top < 0);
	}
	
	public void push(E element) throws FullStackException{
		if(size() == capacity)
			throw new FullStackException("Stack is full.");
		S[++top] = element;
	}
	
	public E top() throws EmptyStackException{
		if(isEmpty())
			throw new EmptyStackException("Stack is empty.");
		return S[top];
	}
	
	public E pop() throws EmptyStackException{
		E element;
		if (isEmpty())
			throw new EmptyStackException("Stack is empty.");
		element = S[top];
		S[top--] = null;     //dereference S[top] for garbage collection.
		return element;
	}
	
	public String toString(){
		String s;
		s = "[";
		if (size()> 0) s+= S[0];
		if(size() > 1)
			for(int i = 1; i <= size() - 1; i++){s+="," + S[i];}
		return s + "]";
	}
	
	public static <E> void reverse(E[] a){
		ArrayStack<E> S = new ArrayStack<E>(a.length);
		for(int i = 0; i < a.length; i++)
			S.push(a[i]);
		for(int i = 0; i < a.length; i++)
			a[i] = S.pop();
	}
	
	//Prints status information about a recent operation and the stack.
	public void status(String op, Object element){
		System.out.print("------>" + op);     //print this operation
		System.out.println(", return " + element); //what was returned
		System.out.print("return: size = " + size() + ", isEmpty = "+ isEmpty());
		System.out.println(", stack: " + this);   //contents of the stack
	}
	
	public static void main(String[] args){
		Object o;
		ArrayStack<Integer> A = new ArrayStack<Integer>();
		A.status("new ArrayStack<Integer> A", null);
		A.push(7);
		A.status("A.push(7)", null);
		o = A.pop();
		A.status("A.pop()", o);
		A.push(9);
		A.status("A.push(9)", null);
		o = A.pop();
		A.status("A.pop()", o);
		ArrayStack<String> B = new ArrayStack<String>();
		B.status("new ArrayStack<String> B", null);
		B.push("Bob");
		B.status("B.push(\"Bob\")", null);
		B.push("Alice");
		B.status("B.push(\"Alice\")", null);
		o = B.pop();
		B.status("B.pop()", o);
		B.push("Eve");
		B.status("B.push(\"Eve\")", null);
		
		System.out.println("---------------------------------------------");
		
		Integer[] a = {4,8,15,16,23,42};
		String[]  s ={"Jack", "Kate", "Hurley", "Jin", "Boone"};
		System.out.println("a = " + Arrays.toString(a));
		System.out.println("s = " + Arrays.toString(s));
		System.out.println("Reversing.....");
		reverse(a);
		reverse(s);
		System.out.println("a = " + Arrays.toString(a));
		System.out.println("s = " + Arrays.toString(s));
		
	}
}
