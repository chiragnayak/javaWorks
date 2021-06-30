package General.designPatterns.creationalPattern.factoryMethod.concreteClasses;

public class PhoneFacility implements IFacility {
	
	public PhoneFacility() {
		System.out.println("Constructor call -> Phone Facility");
	}

	@Override
	public void useMe() {
		System.out.println("WOW !! I am using Phone, Tring !! Tring !!");		
	}

}
