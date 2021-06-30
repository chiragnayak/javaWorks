package spring.learning.annotations;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import General.PrintUtility;
import spring.learning.coach.Coach;

public class AnnotationApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		PrintUtility.printInfo("Reading XML and creating Beans");
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("contextFileAnnotation.xml");
		
//		//code : 1
//		Coach physioCoach = context.getBean("physioCoach",Coach.class);
//		System.out.println(physioCoach.getDailyWorkout());
		
		//code : 2
		PhysioCoach physioCoach2 = (PhysioCoach) context.getBean("physioCoach",Coach.class);
		
		physioCoach2.getTrainingOfCoach().getTrained();
		
		context.close();
	}

}
