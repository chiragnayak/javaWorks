package spring.learning.coach;

public class CricketCoach implements Coach {
	
	TrainingOfCoach trainigOfCoach;
	
	private String emailAddress;
	private String teamName;
	
	public CricketCoach() {
		System.out.println("CricketCoach: Inside CricketCoach no-def constructor");
	}

	@Override
	public String getDailyWorkout() {
		return "CricketCoach: Perform 50 push ups, 50 jump squats, 50 lunges";
	}

	/*
	 * Setter for training-of-coach
	 * */
	public void setTrainigOfCoach(TrainingOfCoach trainigOfCoach) {
		System.out.println("CricketCoach: Inside setTrainingOfCoach of Cricket coach");
		this.trainigOfCoach = trainigOfCoach;
	}

	public void setEmailAddress(String emailAddress) {
		System.out.println("CricketCoach: Inside setEmailAddress() of Cricket coach");
		this.emailAddress = emailAddress;
	}

	public void setTeamName(String teamName) {
		System.out.println("CricketCoach: Inside setTeamName() of Cricket coach");
		this.teamName = teamName;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public String getTeamName() {
		return teamName;
	}
	
}
