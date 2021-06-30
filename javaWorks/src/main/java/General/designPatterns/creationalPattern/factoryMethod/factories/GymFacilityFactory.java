package General.designPatterns.creationalPattern.factoryMethod.factories;

import General.designPatterns.creationalPattern.factoryMethod.concreteClasses.GymFacility;
import General.designPatterns.creationalPattern.factoryMethod.concreteClasses.GymWithSpaFacility;
import General.designPatterns.creationalPattern.factoryMethod.concreteClasses.IFacility;

public class GymFacilityFactory extends  FacilityFactory {
	
	double discount = 0;
	double baseCharge = 1000;

	@Override
	public IFacility getFacility() {
		return new GymFacility();
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
	public IFacility getFacility(Class class_) {
		
		if(class_.isAssignableFrom(GymFacility.class)) {
			setBaseCharges(1000);
			return new GymFacility();
		}else if(class_.isAssignableFrom(GymWithSpaFacility.class)) {
			setBaseCharges(2000);
			return new GymWithSpaFacility();
		}else {
			return null;
		}
		
	}
}
