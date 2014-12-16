package tutorial18_thread2;

import java.util.concurrent.locks.ReentrantLock;


public class PerformSystemCheck implements Runnable{
	
	private String checkWhat;
	
	ReentrantLock lock = new ReentrantLock();
	
	public PerformSystemCheck(String checkWhat){
		this.checkWhat = checkWhat;
	}
	
	/**
	 * protect method:
	 * 1. synchronized public void run(){ } it will slow down
	 * 
	 */
	public void run(){
		lock.lock();
		System.out.println("Checking " + this.checkWhat);
		
		lock.unlock();
	}

}
