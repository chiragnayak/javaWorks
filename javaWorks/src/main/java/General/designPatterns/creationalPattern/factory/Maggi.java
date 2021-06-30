package General.designPatterns.creationalPattern.factory;

public class Maggi extends Product {
	
	static {
		ProductFactory.registeredProducts.put(1, new Maggi());
		System.out.println("Maggi Registered!");
	}
	
	public Maggi() {
		ID = 1;
		name = "Maggi";
		System.out.println("Constructor call -> "+name);
	}
	
	@Override
	public Product createProduct() {
		// TODO Auto-generated method stub
		return new Maggi();
	}

}
