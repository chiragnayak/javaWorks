package trainings.day2.creational.singleton.singletonpattern;

public class SingletonEager {
	private static SingletonEager sc = new SingletonEager();
	private SingletonEager(){}
	public static SingletonEager getInstance(){
		return sc;
	}
}

