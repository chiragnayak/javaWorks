package General.designPatterns.behavioralPatterns.strategy;

public class TestStrategy {
	
	public static void main(String[] args) {
		
		Animal woofy = new Dog("Woofy");
		Animal tweety = new Bird("tweety");
		
		System.out.println("Dog : "+woofy.getFlyType().fly());
		System.out.println("Bird : "+tweety.getFlyType().fly());
	}

}
