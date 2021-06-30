package General.designPatterns.behavioralPatterns.observer;

public interface ISubject {
	
	public void register(IObserver O);
	public void deregister(IObserver O);
	public void notifyObservers();

}
