package General.designPatterns.creationalPattern.factoryMethod.factories;

import General.designPatterns.creationalPattern.factoryMethod.concreteClasses.Gym;
import General.designPatterns.creationalPattern.factoryMethod.concreteClasses.Spa;
import General.designPatterns.creationalPattern.factoryMethod.concreteClasses.IEntity;

public class GymFacilityFactory extends  FacilityFactory {
	
	double discount = 0;
	double baseCharge = 1000;

	@Override
	public IEntity getFacility() {
		return new Gym();
	}

	@Override
	public void setDiscount(double discount) {
		this.discount = discount;		
	}

	@Override
	public double getDiscount() {
		// TODO Auto-generated method stub
		return discount;
	}

	@Override
	public void setBaseCharges(double baseCharge) {
		this.baseCharge=baseCharge;
		
	}

	@Override
	public double getBaseCharges() {
		// TODO Auto-generated method stub
		return baseCharge-((discount*baseCharge)/100);
	}

	@Override
	public IEntity getFacility(Class class_) {
		
		if(class_.isAssignableFrom(Gym.class)) {
			setBaseCharges(1000);
			return new Gym();
		}else if(class_.isAssignableFrom(Spa.class)) {
			setBaseCharges(2000);
			return new Spa();
		}else {
			return null;
		}
		
	}
}
