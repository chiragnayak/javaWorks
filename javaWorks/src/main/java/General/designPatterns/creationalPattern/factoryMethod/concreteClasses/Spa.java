package General.designPatterns.creationalPattern.factoryMethod.concreteClasses;

public class Spa implements IEntity {
	
	public Spa() {
		System.out.println("Constructor call -> GYM & SPA Facility");
	}

	@Override
	public void useMe() {
		System.out.println("WOW !! I am using SPA, 1..2..3..4..5");		
	}
	

}
