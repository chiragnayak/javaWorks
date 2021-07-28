package trainings.day2.creational.abstract_factory;

import java.util.ArrayList;

public class NorthIndianMenu implements IMenu {

	@Override
	public ArrayList<String> getDishes(DISH type) {
		ArrayList<String> dishes = new ArrayList<>();
		switch (type) {
		case NON_VEG:
			dishes.add("Chicken Tikka");
			dishes.add("Chicken Masala");
			dishes.add("Tandoori Roti");
			break;
		case VEG:
			dishes.add("Paneer Tikka");
			dishes.add("Paneer Masala");
			dishes.add("Tandoori Roti");
			break;

		default:
			break;
		}
		
		return dishes;
	}
	

}
