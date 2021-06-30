package General.concepts.concurrency.countDownLatch.Running;

import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;

public class RunningEvent {
	
	public static void main(String[] args) {
		
		CountDownLatch latch = new CountDownLatch(5);
		//we want : 5, 4 , 3, 2, 1 >>> GO !!
		
		ArrayList<Runner> runners = new ArrayList<>();
		runners.add(new Runner(latch, "Chirag"));
		runners.add(new Runner(latch, "Ram"));
		runners.add(new Runner(latch, "Laxman"));
		runners.add(new Runner(latch, "Bharat"));
		runners.add(new Runner(latch, "Shatrugn"));
		
		runners.stream().forEach(x -> new Thread(x).start());
		
		while(latch.getCount()!=0) {
			
			System.out.println("TIK TIK "+latch.getCount());
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			latch.countDown();
			
		}
	}

}

/*
  OUTPUT:
  
  Chirag is ready on start line !
Ram is ready on start line !
Laxman is ready on start line !
Bharat is ready on start line !
Shatrugn is ready on start line !
TIK TIK 5
TIK TIK 4
TIK TIK 3
TIK TIK 2
TIK TIK 1
Ram is running !! >>> 
Laxman is running !! >>> 
Chirag is running !! >>> 
Bharat is running !! >>> 
Shatrugn is running !! >>> 
Shatrugn has FINISHED +++ 
Bharat has FINISHED +++ 
Chirag has FINISHED +++ 
Ram has FINISHED +++ 
Laxman has FINISHED +++ 

  
 * 
 * */
