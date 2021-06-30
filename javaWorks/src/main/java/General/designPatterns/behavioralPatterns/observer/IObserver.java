package General.designPatterns.behavioralPatterns.observer;

public interface IObserver {
	
	public void update(double iBMPrice, double applePrice, double googlePrice);
	
	public int getId();

}
