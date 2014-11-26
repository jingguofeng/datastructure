package arraylist;

public class EmptyListException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3913676557200069503L;

	public EmptyListException(String err){
		super(err);
	}
}
