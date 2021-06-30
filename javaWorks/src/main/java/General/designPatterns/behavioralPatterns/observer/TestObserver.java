package General.designPatterns.behavioralPatterns.observer;

public class TestObserver {
	
	public static void main(String[] args) {
		
		StockGrabber subject = new StockGrabber();
		
		StockObserver observer1 = new StockObserver(subject, 1);
		
		subject.setiBMPrice(200.90);
		subject.setApplePrice(100.00);
		subject.setGooglePrice(500.99);

		StockObserver observer2 = new StockObserver(subject, 2);
		
		subject.setApplePrice(101.01);
		
	}

}
