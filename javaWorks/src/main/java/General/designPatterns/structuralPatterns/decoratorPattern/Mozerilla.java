package General.designPatterns.structuralPatterns.decoratorPattern;

public class Mozerilla extends ToppingsDecorator {
	
	public Mozerilla(IPizza pizza) {
		super(pizza);
		
		System.out.println("Add Dough");
		
		System.out.println("Add Moz");
	}
	
	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return tempPizza.getDescription()+" , Mozrilla";
	}

	@Override
	public double getCost() {
		// TODO Auto-generated method stub
		return tempPizza.getCost() + 0.50;
	}


}
