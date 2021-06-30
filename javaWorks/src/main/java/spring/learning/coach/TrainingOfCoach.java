package spring.learning.coach;

import org.springframework.stereotype.Component;

@Component
public class TrainingOfCoach implements ITrainingOfCoach {
	
	public TrainingOfCoach() {
		System.out.println("TrainingOfCoach: inside no-def constructor");
	}

	@Override
	public String getTrained() {
		return "TrainingOfCoach: The Coach Is Now Trained";
	}
	
	public void startTrainingOfCoach() {
		System.out.println("TrainingOfCoach : START Training of Coach !! ");
	}
	
	public void endTrainingOfCoach() {
		System.out.println("TrainingOfCoach : END Training of Coach !! ");
	}

}
