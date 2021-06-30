package spring.learning.annotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import spring.learning.coach.Coach;
import spring.learning.coach.TrainingOfCoach;

@Component("physioCoach")
@Scope("singleton")
public class PhysioCoach implements Coach {
	
	TrainingOfCoach trainingOfCoach;
	
	@Autowired
	/* if TrainingOfCoach class (or some implementation in case it is an interface) :
	 * 
	 *  ---> Is defined as @Component than that will be used as parameter here.
	 * 
	 *  ---> If it is not defined as @Component, than frame work will look for bean
	 *   with id "trainingOfCoach" in app-context-XML.
	*/
	public PhysioCoach(TrainingOfCoach trainingOfCoach) {
		System.out.println("PhysioCoach: bean constructor");
		this.trainingOfCoach=trainingOfCoach;
	}
	
	@Override
	public String getDailyWorkout() {
		return "PhysioCoach : Perfom Core Crunch, 15 mins";
	}
	
	public void initPhysio() {
		System.out.println("PhysioCoach : @Before kick start physio");
	}
	
	public void destroyPhysio() {
		System.out.println("PhysioCoach : @Before kick start physio");
	}

	public TrainingOfCoach getTrainingOfCoach() {
		return trainingOfCoach;
	}
}
