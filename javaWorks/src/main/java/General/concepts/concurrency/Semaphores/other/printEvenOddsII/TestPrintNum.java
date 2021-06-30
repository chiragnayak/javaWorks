package General.concepts.concurrency.Semaphores.other.printEvenOddsII;

public class TestPrintNum {
	
	public static void main(String[] args) {
		
		PrintNum odd = new PrintNum(1);
		PrintNum even = new PrintNum(2);
		
		Thread t1 = new Thread(odd);
		Thread t2 = new Thread(even);
		
		t1.start();
		t2.start();
	}
}
