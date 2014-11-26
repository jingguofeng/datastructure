package queue;

public class FullQueueException extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2766266919237371609L;

	public FullQueueException(String err){
		super(err);
	}

}
