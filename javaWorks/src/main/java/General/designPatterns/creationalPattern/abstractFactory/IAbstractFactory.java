package General.designPatterns.creationalPattern.abstractFactory;

import General.designPatterns.creationalPattern.factoryMethod.factories.IFacilityfactory;

public interface IAbstractFactory {
	
	public IFacilityfactory getFacilityFactory(Class facility);

}
