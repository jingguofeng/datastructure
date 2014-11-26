package queue;

public class EmptyQueueException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6005613600247835251L;

	public EmptyQueueException(String err){
		super(err);
	}
}
