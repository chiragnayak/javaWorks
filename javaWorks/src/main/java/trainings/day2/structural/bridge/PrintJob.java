package trainings.day2.structural.bridge;

public class PrintJob implements IPrintJob{
	
	IPrinter printer;
	
	public PrintJob(IPrinter printer) {
		this.printer = printer;
	}

	@Override
	public void open() {
		this.printer.openPort();
		
	}

	@Override
	public void doPrint() {
		this.printer.printPage();
		
	}

	@Override
	public void close() {
		this.printer.closePort();
		
	}

}
