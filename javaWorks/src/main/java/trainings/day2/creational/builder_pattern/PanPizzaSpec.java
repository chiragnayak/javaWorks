package trainings.day2.creational.builder_pattern;

import General.designPatterns.creationalPattern.builder.Robot;

public class PanPizzaSpec implements IPizzaSpec{
	
	Pizza pizza;
	
	public PanPizzaSpec() {
		this.pizza = new Pizza();
	}

	@Override
	public void crust() {
		pizza.selectCrust("PAN base");
		
	}

	@Override
	public void cheese() {
		pizza.addCheese("MOZARELLA");
		
	}

	@Override
	public void sause() {
		pizza.addSause("TOMATO MEDIUM SPICY");
		
	}

	@Override
	public void topping() {
		pizza.addTopping("PANEER CAPSICUM");
		
	}

	@Override
	public Pizza getPizza() {

		return this.pizza;
	}
}
