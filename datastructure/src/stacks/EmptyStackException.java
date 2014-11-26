package stacks;

public class EmptyStackException extends RuntimeException{


	/**
	 * 
	 */
	private static final long serialVersionUID = -4818441835589471576L;

	public EmptyStackException(String err){
		super(err);
	}
}
