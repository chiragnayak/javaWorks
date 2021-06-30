package General.designPatterns.structuralPatterns.decoratorPattern;

public class PlainPizza implements IPizza{

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return "Thin Dough";
	}

	@Override
	public double getCost() {
		// TODO Auto-generated method stub
		return 4.00;
	}
	
	

}
