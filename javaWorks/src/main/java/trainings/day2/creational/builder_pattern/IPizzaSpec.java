package trainings.day2.creational.builder_pattern;

public interface IPizzaSpec {
	
	void crust();
	void cheese();
	void sause();
	void topping();
	Pizza getPizza();

}
