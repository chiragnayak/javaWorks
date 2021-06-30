package spring.learning.coach;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import General.PrintUtility;

public class myApp {
	
	public static void main(String[] args) {
		
		PrintUtility.printBanner("Inversion of Control");
		
		PrintUtility.printInfo("Reading XML and creating Beans (IOC) and performing Constructor DI");
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//create the object (bean)
		PrintUtility.printInfo("Getting Bean : myCoachBean");
		Coach myCoach = context.getBean("myCoachBean",Coach.class);
		
		//use the object (bean)
		PrintUtility.printInfo("Using Bean : myCoach");
		System.out.println(myCoach.getDailyWorkout());
		
		PrintUtility.printInfo("Using Bean : cricketCoachBean");
		CricketCoach cricketCoach = (CricketCoach) context.getBean("cricketCoachBean",Coach.class);
		cricketCoach.getDailyWorkout();
		
		PrintUtility.printInfo("Using Bean : value from configFile");
		System.out.println(cricketCoach.getEmailAddress());
		
		PrintUtility.printInfo("Using Bean : value from properties file");
		System.out.println(cricketCoach.getTeamName());
		
		//close the context
		context.close();
		
	}

}
