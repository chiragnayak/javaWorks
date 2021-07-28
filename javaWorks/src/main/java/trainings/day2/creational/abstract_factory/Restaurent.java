package trainings.day2.creational.abstract_factory;

import trainings.day2.creational.abstract_factory.IMenu.DISH;
import trainings.day2.creational.abstract_factory.IMenuFactory.CUISINE;

public class Restaurent {
	
	public static void main(String[] args) {
		
		MenuFactory restaurent = new MenuFactory();
		IMenu menu = restaurent.getMenu(CUISINE.NORTH_INDIA);
		System.out.println(menu.getDishes(DISH.VEG));
	}


}
