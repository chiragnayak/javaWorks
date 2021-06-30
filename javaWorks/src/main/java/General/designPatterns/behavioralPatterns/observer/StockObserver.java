package General.designPatterns.behavioralPatterns.observer;

public class StockObserver implements IObserver {
	
	int observerID;
	
	double iBMPrice, applePrice, googlePrice;
	
	StockGrabber grabber;
	
	public StockObserver(StockGrabber grabber, int observerId) {
		
		this.grabber = grabber;

		this.observerID = observerId;
		
		grabber.register(this);
	}


	@Override
	public void update(double iBMPrice, double applePrice, double googlePrice) {
		
		this.iBMPrice = iBMPrice;
		this.applePrice = applePrice;
		this.googlePrice = googlePrice;


		System.out.println("Message For "+this.getId()+". \n"
				+ "Stock Price Updated : \n"
				+ "IBM Price : "+iBMPrice+"\n"
				+ "Apple Price : "+applePrice+"\n"
				+ "Google Price : "+googlePrice+"\n");
		
	}

	@Override
	public int getId() {
		// TODO Auto-generated method stub
		return this.observerID;
	}

}
