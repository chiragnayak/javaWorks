package General.designPatterns.creationalPattern.builder;

/**
 * 
 * Set fields for Robot built using specifications set by interface
 * IRobotBuilder
 * 
 * @author cnayak
 *
 */
public class HumanRobotBuilder implements IRobotBuilder {

	Robot robot;

	public HumanRobotBuilder() {
		this.robot = new Robot();
	}

	@Override
	public void buildRobotHead() {
		robot.setRobotHead("Humanoid Tin Head !");
	}

	@Override
	public void buildRobotTorso() {
		robot.setRobotTorso("Humanoid Digital Metal Torso !");

	}

	@Override
	public void buildRobotArms() {
		robot.setRobotArms("Humanoid Big Fork Arms !");
	}

	@Override
	public void buildRobotLegs() {
		robot.setRobotLegs("Humanoid Legs with Skates !");
	}

	@Override
	public Robot getRobot() {

		return this.robot;
	}

}
