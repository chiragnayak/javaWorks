package General.designPatterns.behavioralPatterns.strategy;

public class Bird extends Animal {

	public Bird(String name) {
		super(name);
		
		setFlyType(new canFly());
	}

}
