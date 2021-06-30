package General.designPatterns.creationalPattern.factoryMethod.factories;

import General.designPatterns.creationalPattern.factoryMethod.concreteClasses.IFacility;
import General.designPatterns.creationalPattern.factoryMethod.concreteClasses.PhoneFacility;

public class PhoneFacilityFactory extends FacilityFactory {
	
	double discount = 0;
	double baseCharge = 10;

	@Override
	public IFacility getFacility() {
		return new PhoneFacility();
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
		if(class_.isAssignableFrom(PhoneFacility.class)) {
			return new PhoneFacility();
		}else {
			return null;
		}
	}

}
