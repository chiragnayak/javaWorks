package General.designPatterns.creationalPattern.factoryMethod.concreteClasses;

public class Gym implements IEntity {
	
	public Gym() {
		System.out.println("Constructor call -> GYM");
	}

	@Override
	public void useMe() {
		System.out.println("WOW !! I am using GYM, 1..2..3..4..5");		
	}
	

}
