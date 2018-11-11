package General.designPatterns.creationalPattern.factoryMethod.concreteClasses;

public class GymFacility implements IFacility {
	
	public GymFacility() {
		System.out.println("Constructor call -> GYM Facility");
	}

	@Override
	public void useMe() {
		System.out.println("WOW !! I am using GYM, 1..2..3..4..5");		
	}
	

}
