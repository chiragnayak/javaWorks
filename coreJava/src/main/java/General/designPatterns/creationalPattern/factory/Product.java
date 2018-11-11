package General.designPatterns.creationalPattern.factory;

public abstract class Product {
	
	public int ID;
	public String name;

	
	/**
	 * This is to create a new instance of the product
	 * 
	 */
	public abstract Product createProduct();
	
	@Override
	public String toString() {
		return "I am "+name+" with ID as "+ID;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
