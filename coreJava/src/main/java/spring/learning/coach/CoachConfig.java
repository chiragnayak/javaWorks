package spring.learning.coach;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CoachConfig {
	
	@Bean
	public Coach getCoach() {
		return new TrackCoach(getTraining());
	}
	
	@Bean
	public TrainingOfCoach getTraining() {
		return new TrainingOfCoach();
	}

}
