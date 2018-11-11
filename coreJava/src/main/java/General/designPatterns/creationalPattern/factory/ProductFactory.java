package General.designPatterns.creationalPattern.factory;

import java.util.HashMap;

public class ProductFactory {
	
	public static HashMap<Integer, Product> registeredProducts = new HashMap<>();
	
	public Product getProduct(int id) {
		
//		//way 1
//		switch (id) {
//		case 1:
//			return new Maggi();			
//		case 2:
//			return new BornVita();
//			
//		case 3:
//			return new WheyProtein();
//
//		default:
//			return null;
//		}
		
		//way 2 (factory and product (type) classes associativity is decoupled. Reduced coupling. 	
		//product instantiation logic is not here (in simple terms)
		//it is kept in the static block of respective product classes
		Product product = registeredProducts.get(id);
		if(product!=null) {
			return product;
		}
		
		//way 3
		
		
		
		return null;
			
	}

	
	public Product createNewProduct(int i) {
		
		return registeredProducts.get(i).createProduct();
	}
}
