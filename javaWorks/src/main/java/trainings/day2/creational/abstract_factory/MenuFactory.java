package trainings.day2.creational.abstract_factory;

public class MenuFactory implements IMenuFactory {

	@Override
	public IMenu getMenu(CUISINE cuisine) {
		
		switch (cuisine) {
			case NORTH_INDIA:
				return new NorthIndianMenu();
			
			default:
				break;
		}
		return null;
	}

}
