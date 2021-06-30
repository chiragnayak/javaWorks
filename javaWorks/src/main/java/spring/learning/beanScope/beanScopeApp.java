package spring.learning.beanScope;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import General.PrintUtility;
import spring.learning.coach.Coach;

public class beanScopeApp {
	
	public static void main(String[] args) {
		
		PrintUtility.printBanner("Bean Scope");
		
		PrintUtility.printInfo("Reading XML and creating Beans (IOC) and performing Constructor DI");
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//create the object (bean)
		PrintUtility.printInfo("Getting Bean : myCoachBean");
		Coach myCoach1 = context.getBean("myCoachBean",Coach.class);
		
		//create the object (bean)
		PrintUtility.printInfo("Getting Bean : myCoachBean");
		Coach myCoach2 = context.getBean("myCoachBean",Coach.class);
		
		compareRef(myCoach1, myCoach2);
		
		//create the object (bean)
		PrintUtility.printInfo("Getting Bean : prototypeCoachBean");
		Coach myCoach3 = context.getBean("prototypeCoachBean",Coach.class);
		
		//create the object (bean)
		PrintUtility.printInfo("Getting Bean : prototypeCoachBean");
		Coach myCoach4 = context.getBean("prototypeCoachBean",Coach.class);

		compareRef(myCoach3, myCoach4);
				
		//close the context
		context.close();
		
	}
	
	public static void compareRef(Object o1, Object o2) {
		
		if(o1==o2) {
			PrintUtility.printInfo("Object references are --> SAME");
		}else {
			PrintUtility.printInfo("Object references are --> DIFFERENT ");
		}
	}

}
