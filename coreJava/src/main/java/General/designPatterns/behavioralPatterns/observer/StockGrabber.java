package General.designPatterns.behavioralPatterns.observer;

import java.util.ArrayList;

public class StockGrabber implements ISubject {
	
	ArrayList<IObserver> observers = new ArrayList<>();
	
	private double iBMPrice, applePrice, googlePrice;
	
	@Override
	public void register(IObserver O) {

		System.out.println("New Subscriber Alert ! -> ID : "+ O.getId()+" has Registered.\n\n");
		this.observers.add(O);
	}

	@Override
	public void deregister(IObserver O) {
		System.out.println("Subscriber De register Alert ! -> ID : "+ O.getId()+" has de-Registered.\n\n");
		int index = observers.indexOf(O);
		this.observers.remove(index);		
	}

	@Override
	public void notifyObservers() {
		
		observers.stream().forEach(x -> x.update(iBMPrice, applePrice, googlePrice));
		
	}

	public void setiBMPrice(double iBMPrice) {
		this.iBMPrice = iBMPrice;
		notifyObservers();
	}

	public void setApplePrice(double applePrice) {
		this.applePrice = applePrice;
		notifyObservers();
	}

	public void setGooglePrice(double googlePrice) {
		this.googlePrice = googlePrice;
		notifyObservers();
	}

	

}
