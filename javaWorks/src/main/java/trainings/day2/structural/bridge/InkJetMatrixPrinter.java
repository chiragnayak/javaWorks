package trainings.day2.structural.bridge;

public class InkJetMatrixPrinter implements IPrinter {

	@Override
	public void openPort() {
		System.out.println("Opening INK JET port");
		
	}

	@Override
	public void printPage() {
		System.out.println("Printing page in INK");
		
	}

	@Override
	public void closePort() {
		System.out.println("closing ink jet port");
		
	}

}
