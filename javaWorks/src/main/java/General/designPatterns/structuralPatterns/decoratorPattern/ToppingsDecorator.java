package General.designPatterns.structuralPatterns.decoratorPattern;

public abstract class ToppingsDecorator implements IPizza {
	
	IPizza tempPizza;
	
	public ToppingsDecorator(IPizza pizza) {
		this.tempPizza = pizza;
	}
	
	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return tempPizza.getDescription();
	}

	@Override
	public double getCost() {
		// TODO Auto-generated method stub
		return tempPizza.getCost();
	}

}
