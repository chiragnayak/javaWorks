package spring.learning.coach;

public class TrackCoach implements Coach {
	
	TrainingOfCoach trainingOfCoach;
	
	public TrackCoach() {
		System.out.println("TrackCoach: Inside TrackCoach no-def constructor");
	}
	
	public TrackCoach (TrainingOfCoach trainingOfCoach){
		System.out.println("TrackCoach: Inside parameterised (trainingOfCoach) TrackCoach constructor");
		this.trainingOfCoach = trainingOfCoach;
	}

	@Override
	public String getDailyWorkout() {
		System.out.println(trainingOfCoach.getTrained());
		return "TrackCoach: Spend 15 LAPS on Track";
	}
	
	

}
