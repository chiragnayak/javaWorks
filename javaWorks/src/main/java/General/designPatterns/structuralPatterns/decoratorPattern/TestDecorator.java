package General.designPatterns.structuralPatterns.decoratorPattern;

public class TestDecorator {
	
	public static void main(String[] args) {
		
		IPizza myPizza =new PlainPizza();
				
		System.out.println("Plain Pizza, It is : "+myPizza.getDescription());
		System.out.println("Cost  : "+myPizza.getCost());
		
		myPizza = new TomatoSause(new Mozerilla(myPizza));
		
		System.out.println("Plain Pizza with Moz and TOmato Sause It is : "+myPizza.getDescription());
		System.out.println("Cost  : "+myPizza.getCost());
	}

}
