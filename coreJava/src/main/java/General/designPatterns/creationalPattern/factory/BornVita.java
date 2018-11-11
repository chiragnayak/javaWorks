package General.designPatterns.creationalPattern.factory;

public class BornVita extends Product {
	
	static {
		ProductFactory.registeredProducts.put(2, new BornVita());
		System.out.println("BornVita Registered!");
	}
	
	public BornVita() {
		ID = 2;
		name = "BornVita";
		System.out.println("Constructor call -> "+name);
	}

	@Override
	public Product createProduct() {
		// TODO Auto-generated method stub
		return new BornVita();
	}

}
