package General.designPatterns.creationalPattern.factory;

public class TestFactory {
	
	public static void main(String[] args) throws ClassNotFoundException {
		
		ProductFactory factory = new ProductFactory();
		Class.forName(Maggi.class.getName());
		Class.forName(BornVita.class.getName());
		Class.forName(WheyProtein.class.getName());
		System.out.println(factory.getProduct(1).getName());
		System.out.println(factory.createNewProduct(2));
	}
 
}
