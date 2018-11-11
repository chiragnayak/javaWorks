package General.designPatterns.creationalPattern.factoryMethod.factories;

import General.designPatterns.creationalPattern.factoryMethod.concreteClasses.IFacility;

public interface IFacilityfactory {
	
	public IFacility getFacility();
	public <T extends IFacility> T getFacility(Class facility);
	
	public abstract void setBaseCharges(double baseCharge);
	public abstract double getBaseCharges();
	
	public abstract void setDiscount(double discount);
	public abstract double getDiscount();
	
}
