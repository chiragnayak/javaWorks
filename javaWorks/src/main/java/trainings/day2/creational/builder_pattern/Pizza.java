package trainings.day2.creational.builder_pattern;

public class Pizza implements IPizza {

	String crust;
	String cheese;
	String sause;
	String topping;
	
	@Override
	public String toString() {
		return this.crust+" \n"+
				this.cheese+" \n"+
				this.sause+" \n"+
				this.topping+" \n";
	}

	@Override
	public void selectCrust(String crust) {
		this.crust=crust;
		
	}

	@Override
	public void addCheese(String cheese) {
		this.cheese=cheese;
		
	}

	@Override
	public void addSause(String sause) {
		this.sause=sause;
		
	}

	@Override
	public void addTopping(String topping) {
		this.topping=topping;
		
	}

}
