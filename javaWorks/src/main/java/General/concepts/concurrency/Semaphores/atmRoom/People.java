package General.concepts.concurrency.Semaphores.atmRoom;

import java.util.concurrent.Semaphore;

public class People implements Runnable {
	
	String name ;
	Semaphore machines;
	
	public People(Semaphore machines, String name) {
		this.machines=machines;
		this.name=name;
	}

	@Override
	public void run() {

			try {
				
				System.out.println(name+" : Waiting to access ATM.");
				machines.acquire();
				System.out.println(name+" : Got access to ATM ------------->>>");
				Thread.sleep(2000);
				System.out.println(name+" : ATM Task complete +++");
				machines.release();
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
	}

}
