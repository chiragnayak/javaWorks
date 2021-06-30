package General.designPatterns.behavioralPatterns.template;

public abstract class PackagedTour {
	
	/**
	 * "preset format : algorithm that we don't want to redefine"
	 * 
	 *  A template method defines an algorithm in a base class
	 *  using abstract operations that subclasses override to provide concrete behavior.
	 * 
	 * used as a starting point for a particular application so that the 
	 * format does not have to be recreated each time class is used/instantiated
	 * 
	 * the template method should be implemented only in the base class, 
	 * and the primitive method should be implemented in the subclasses.
	 * 
	 */
	public final void performTrip3DayTour() { //template of 3 day tour
		
		reachDestination();
		doDayA();
		doDayB();
		doDayC();
		returnToHome();
	}
	
	//primitive methods that will be overridden and implemented in sub classes.
	//abstract operations
	public abstract void reachDestination();
	public abstract void doDayA();
	public abstract void doDayB();
	public abstract void doDayC();
	public abstract void returnToHome();

}
