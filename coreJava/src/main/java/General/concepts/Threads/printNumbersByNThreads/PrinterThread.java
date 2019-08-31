package General.concepts.Threads.printNumbersByNThreads;

public class PrinterThread implements Runnable {
	
	int position;
	NumberManager numObj;
	
	public PrinterThread(int position, NumberManager numObj){
		this.position=position;
		this.numObj = numObj;
	}
	
	@Override
	public String toString() {
		return "Thread << "+this.position+" >>";
	}
	
	@Override
	public void run () {

		while(true){
			numObj.incrementAndPrint(position);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
