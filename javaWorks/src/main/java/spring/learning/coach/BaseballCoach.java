package spring.learning.coach;

public class BaseballCoach implements Coach {
	
	public BaseballCoach() {
		System.out.println("BaseballCoach: Inside BaseballCoach no-def constructor");
	}
	
	/* (non-Javadoc)
	 * @see spring.udemy.coach.Coach#getDailyWorkout()
	 */
	@Override
	public String getDailyWorkout() {
		return "BaseballCoach: Spend 30 mins in batting case ";
	}

}
