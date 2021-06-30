package General.concepts.concurrency.cyclicBarrier.tennisDoubles;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class TennisPlayer implements Runnable {
	
	CyclicBarrier waitPoint;
	String name;
	
	public TennisPlayer(CyclicBarrier cycliBarrierObj, String name) {
		this.waitPoint=cycliBarrierObj;
		this.name=name;
		
		System.out.println(name+" -> in court !!");
	}
	
	@Override
	public void run() {
		
		try {
			
			//returns (kind of) index number of thread that called await on cyclic barrier object, starting 0
			waitPoint.await();
			
			System.out.println(name+" -> All are Ready !!");
			
		}catch(InterruptedException | BrokenBarrierException e) {
			e.printStackTrace();
		}
	}

}
