package trainings.day2.creational.builder_pattern;

public class CheeseBurstPizzaSpec implements IPizzaSpec{
	
	Pizza pizza;
	
	public CheeseBurstPizzaSpec() {
		this.pizza = new Pizza();
	}

	@Override
	public void crust() {
		pizza.selectCrust("Deep Dish base");
		
	}

	@Override
	public void cheese() {
		pizza.addCheese("3x MOZARELLA");
		
	}

	@Override
	public void sause() {
		pizza.addSause("TOMATO MEDIUM SPICY");
		
	}

	@Override
	public void topping() {
		pizza.addTopping("PANEER CAPSICUM ONION");
		
	}

	@Override
	public Pizza getPizza() {

		return this.pizza;
	}
}
