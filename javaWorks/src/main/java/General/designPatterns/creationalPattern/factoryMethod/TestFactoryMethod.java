package General.designPatterns.creationalPattern.factoryMethod;

import General.designPatterns.creationalPattern.factoryMethod.factories.GymFacilityFactory;
import General.designPatterns.creationalPattern.factoryMethod.factories.IFacilityfactory;

public class TestFactoryMethod {
	
	public static void main(String[] args) {
		IFacilityfactory factory = new GymFacilityFactory();
		factory.getFacility().useMe();
		System.out.println("Charges are : "+factory.getBaseCharges());
	}

}
