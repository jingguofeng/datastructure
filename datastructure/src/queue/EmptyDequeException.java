package queue;

public class EmptyDequeException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5945417909784200775L;

	public EmptyDequeException(String err){
		super(err);
	}
}
