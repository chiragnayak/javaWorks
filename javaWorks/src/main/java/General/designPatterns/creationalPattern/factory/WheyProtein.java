package General.designPatterns.creationalPattern.factory;

public class WheyProtein extends Product {
	
	static {
		ProductFactory.registeredProducts.put(3, new WheyProtein());
		System.out.println("WheyProtein Registered!");
	}
	
	public WheyProtein() {
		ID = 3;
		name = "WheyProtein";
		System.out.println("Constructor call -> "+name);
	}

	@Override
	public Product createProduct() {
		return new WheyProtein();
	}

}
