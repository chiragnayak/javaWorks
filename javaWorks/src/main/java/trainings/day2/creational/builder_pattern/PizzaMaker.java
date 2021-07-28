package trainings.day2.creational.builder_pattern;


public class PizzaMaker {
	
		//define type of Pizza you want to create
		private IPizzaSpec pizzaSpec;
		
		public PizzaMaker(IPizzaSpec pizzaSpec) {
			this.pizzaSpec = pizzaSpec;
		}
		
		public Pizza getPizza() {
			return pizzaSpec.getPizza();
		}
		
		public void makePizza() {
			this.pizzaSpec.crust();
			this.pizzaSpec.sause();
			this.pizzaSpec.cheese();
			this.pizzaSpec.topping();
		}

}
