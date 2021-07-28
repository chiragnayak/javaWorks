package trainings.day2.creational.abstract_factory;

public interface IMenuFactory {
	
	public enum CUISINE {
		NORTH_INDIA,
		SOUTH_INDIAN,
		CHINESE,
	}
	
	public IMenu getMenu(CUISINE cuisine);

}



