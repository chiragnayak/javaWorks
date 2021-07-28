package trainings.day2.structural.bridge;

public class DotMatrixPrinter implements IPrinter {

	@Override
	public void openPort() {
		System.out.println("Opening DOT MATRIX port");
		
	}

	@Override
	public void printPage() {
		System.out.println("Printing page in dot matrix");
		
	}

	@Override
	public void closePort() {
		System.out.println("closing DOT MATRIX port");
		
	}

}
