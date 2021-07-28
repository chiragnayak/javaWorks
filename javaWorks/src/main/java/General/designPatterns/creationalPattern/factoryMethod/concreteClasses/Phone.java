package General.designPatterns.creationalPattern.factoryMethod.concreteClasses;

public class Phone implements IEntity {
	
	public Phone() {
		System.out.println("Constructor call -> Phone Facility");
	}

	@Override
	public void useMe() {
		System.out.println("WOW !! I am using Phone, Tring !! Tring !!");		
	}

}
