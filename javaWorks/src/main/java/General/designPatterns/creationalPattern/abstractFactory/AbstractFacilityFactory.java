package General.designPatterns.creationalPattern.abstractFactory;

import General.designPatterns.creationalPattern.factoryMethod.concreteClasses.Gym;
import General.designPatterns.creationalPattern.factoryMethod.concreteClasses.Phone;
import General.designPatterns.creationalPattern.factoryMethod.factories.GymFacilityFactory;
import General.designPatterns.creationalPattern.factoryMethod.factories.IFacilityfactory;
import General.designPatterns.creationalPattern.factoryMethod.factories.PhoneFacilityFactory;

public class AbstractFacilityFactory  implements IAbstractFactory{

	@Override
	public IFacilityfactory getFacilityFactory(Class facility) {
		
		if(facility.isAssignableFrom(Gym.class)) {
			return new GymFacilityFactory();
		}else if(facility.isAssignableFrom(Phone.class)) {
			return new PhoneFacilityFactory();
		}else {
			System.err.println("NO SUCH FACTORY FOUND FOR -> "+facility.getClass().getName());
			return null;
		}
	}

}
