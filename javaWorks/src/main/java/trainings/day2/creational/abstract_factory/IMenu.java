package trainings.day2.creational.abstract_factory;

import java.util.ArrayList;

public interface IMenu {
	
	enum DISH {
		VEG,
		NON_VEG
	}
	
	public ArrayList<String> getDishes(DISH type);

}
