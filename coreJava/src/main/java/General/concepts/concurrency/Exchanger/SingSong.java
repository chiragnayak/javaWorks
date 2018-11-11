package General.concepts.concurrency.Exchanger;

import java.util.concurrent.Exchanger;

public class SingSong {
	
	public static void main(String[] args) throws InterruptedException {
		
		Exchanger<String> singSong = new Exchanger<>();
		
		Thread tRomeo = new Thread(new Romeo(singSong));
		Thread tJuliet = new Thread(new Juliet(singSong));
		
		tRomeo.start();
		tJuliet.start();
		
		//issue with System.out being single threaded.
	}

}
