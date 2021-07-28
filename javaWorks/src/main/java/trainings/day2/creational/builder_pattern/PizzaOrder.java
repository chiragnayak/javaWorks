package trainings.day2.creational.builder_pattern;

public class PizzaOrder {
	
	public static void main(String[] args) {
		
		//get specs
		IPizzaSpec pan_pizzaSpec = new PanPizzaSpec();
		
		//get specs
		IPizzaSpec cheeseburst_pizzaSpec = new CheeseBurstPizzaSpec();
		
		//call the builder
		PizzaMaker chef = new PizzaMaker(pan_pizzaSpec);
		chef.makePizza();
		
		//get the product
		Pizza pizza = chef.getPizza();
		
		System.out.println(pizza.toString());
		
		System.out.println("======================");
		
		//call the builder
		chef = new PizzaMaker(cheeseburst_pizzaSpec);
		chef.makePizza();
		
		//get the product
		pizza = chef.getPizza();
		
		System.out.println(pizza.toString());
				
		
	}

}
