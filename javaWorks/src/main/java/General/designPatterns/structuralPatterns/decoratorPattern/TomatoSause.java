package General.designPatterns.structuralPatterns.decoratorPattern;

public class TomatoSause extends ToppingsDecorator {
	
	public TomatoSause(IPizza pizza) {
		super(pizza);
		
		System.out.println("Add Sause");
	}
	
	@Override
	public String getDescription() {
		return tempPizza.getDescription()+" , Tomato Sause";
	}

	@Override
	public double getCost() {
		return tempPizza.getCost() + 0.35;
	}


}
