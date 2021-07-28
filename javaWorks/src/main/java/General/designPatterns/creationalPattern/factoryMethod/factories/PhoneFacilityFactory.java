package General.designPatterns.creationalPattern.factoryMethod.factories;

import General.designPatterns.creationalPattern.factoryMethod.concreteClasses.IEntity;
import General.designPatterns.creationalPattern.factoryMethod.concreteClasses.Phone;

public class PhoneFacilityFactory extends FacilityFactory {
	
	double discount = 0;
	double baseCharge = 10;

	@Override
	public IEntity getFacility() {
		return new Phone();
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
		if(class_.isAssignableFrom(Phone.class)) {
			return new Phone();
		}else {
			return null;
		}
	}

}
