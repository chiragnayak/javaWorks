package trainings.day2.structural.bridge;

public class BridgeDemo {
	
	public static void main(String[] args) {
		
		
		IPrinter dotMatrix = new DotMatrixPrinter();
		PrintJob printjob = new PrintJob(dotMatrix);
		printjob.open();
		printjob.doPrint();
		printjob.close();
	}
	

}
