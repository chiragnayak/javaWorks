package General.designPatterns.creationalPattern.factoryMethod.factories;

import General.designPatterns.creationalPattern.factoryMethod.concreteClasses.IEntity;

public interface IFacilityfactory {
	
	public IEntity getFacility();
	public <T extends IEntity> T getFacility(Class facility);
	
	public abstract void setBaseCharges(double baseCharge);
	public abstract double getBaseCharges();
	
	public abstract void setDiscount(double discount);
	public abstract double getDiscount();
	
}
