package General.designPatterns.creationalPattern.abstractFactory;

import General.designPatterns.creationalPattern.factoryMethod.concreteClasses.Gym;
import General.designPatterns.creationalPattern.factoryMethod.concreteClasses.Spa;
import General.designPatterns.creationalPattern.factoryMethod.concreteClasses.IEntity;
import General.designPatterns.creationalPattern.factoryMethod.factories.IFacilityfactory;

public class TestAbstractFactory {
	
	public static void main(String[] args) {
		
		AbstractFacilityFactory absFactory = new AbstractFacilityFactory();
		IFacilityfactory factory = absFactory.getFacilityFactory(Gym.class);
		IEntity someFacility = factory.getFacility(Spa.class);
		someFacility.toString();
		someFacility.useMe();
		System.out.println("Base charges :"+ factory.getBaseCharges());
		System.out.println("Discount :"+ factory.getDiscount());
		System.out.println("Update Discount to 20%:");
		factory.setDiscount(20);
		System.out.println("New Base charges :"+ factory.getBaseCharges());		
	}

}
