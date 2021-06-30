package General.concepts.Threads.LeetCode;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PrintEvenOddDriver {
	
	public static void main(String[] args) {
		
		PrintZeroEvenOdd obj = new PrintZeroEvenOdd(6);
		
		ExecutorService service = Executors.newFixedThreadPool(3);
		
		service.submit(() -> {
			try {
				obj.zero(obj);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		
		service.submit(() -> {
			try {
				obj.odd(obj);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		
		service.submit(() -> {
			try {
				obj.even(obj);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
	}

}
