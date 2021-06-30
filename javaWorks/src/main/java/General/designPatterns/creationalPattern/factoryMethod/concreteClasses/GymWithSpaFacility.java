package General.designPatterns.creationalPattern.factoryMethod.concreteClasses;

public class GymWithSpaFacility implements IFacility {
	
	public GymWithSpaFacility() {
		System.out.println("Constructor call -> GYM & SPA Facility");
	}

	@Override
	public void useMe() {
		System.out.println("WOW !! I am using GYM with SPA, 1..2..3..4..5");		
	}
	

}
