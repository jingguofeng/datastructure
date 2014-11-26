package linkedlist;

public class DNode {

	protected String element;
	protected DNode next, prev;
	
	public DNode(){
		this("nothing there");
	}
	
	public DNode(String s){
		element = s;
		next = null;
		prev = null;
	}
	
	public void setElement(String s){
		element = s;
	}
	
	public String toString(){
		
		return element;
		
	}
}
