package General.concepts.concurrency.Exchanger;

import java.util.concurrent.Exchanger;

public class Juliet implements Runnable {
	
	Exchanger<String> talk;
	
	public Juliet (Exchanger<String> talk) {
		this.talk=talk;
	}

	@Override
	public void run() {
		
		String reply = "NO_REPLY";
		
		try {
			
			//-> This is sent out and reply is received
			reply = talk.exchange("Aie, Kya main Bolu !");
			
			System.out.println(" Romeo : "+reply);
			
			//-> This is sent out and reply is received
			reply = talk.exchange("Suna !");
			
			System.out.println(" Romeo : "+reply);
			
			//-> This is sent out and reply is received
			reply = talk.exchange("LoL, chal hatt !");
			
			System.out.println(" Romeo : "+reply);
			
			//this is to get the final message from romeo thread
			reply = talk.exchange("");
			
			System.out.println(" Romeo : "+reply);
			
		}catch(InterruptedException e) {
			System.out.println("Baat Interrupt Ho gayi !!");
		}
		
	}
	
	
}
