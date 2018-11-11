package General.concepts.concurrency.Exchanger;

import java.util.concurrent.Exchanger;

public class Romeo implements Runnable {
	
	Exchanger<String> talk;
	
	public Romeo (Exchanger talk) {
		this.talk=talk;
	}

	@Override
	public void run() {
		
		String reply = "NO_REPLY";
		
		try {
			//-> This is sent out and reply is received
			reply = talk.exchange("Aie, Kya Bolti Tu !");
			
			System.out.println(" Juliet : "+reply);
			
			//-> This is sent out and reply is received
			reply = talk.exchange("Sun !");
			
			System.out.println(" Juliet : "+reply);
			
			reply = talk.exchange("Aati Kya Khandala !");
			
			System.out.println(" Juliet : "+reply);
			
			reply = talk.exchange("Aila !");
			
		}catch(InterruptedException e) {
			System.out.println("Baat Interrupt Ho gayi !!");
		}
		
	}
	
}
