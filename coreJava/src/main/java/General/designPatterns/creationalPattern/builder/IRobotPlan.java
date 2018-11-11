package General.designPatterns.creationalPattern.builder;

/**
 * 
 * Qualities that we want our robot to have. 
 * 
 * @author cnayak
 *
 */
public interface IRobotPlan {
	
	void setRobotHead(String robotHead);
	void setRobotTorso(String robotTorso);
	void setRobotArms(String robotArms);
	void setRobotLegs(String robotLegs);

}
