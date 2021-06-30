package General.designPatterns.behavioralPatterns.strategy;

public class Dog extends Animal {
	
	public Dog(String name) {
		super(name);
		
		setFlyType(new canNotFly());
	}

}
