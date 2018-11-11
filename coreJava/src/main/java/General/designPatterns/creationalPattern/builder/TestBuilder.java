package General.designPatterns.creationalPattern.builder;

public class TestBuilder {
	
	public static void main(String[] args) {
		
		//get the builder/blueprint/specs
		IRobotBuilder robotBuilder = new HumanRobotBuilder();
		
		//call an engineer to use this builder/blueprint to build the robot
		RobotEngineer robotEngineer = new RobotEngineer(robotBuilder);
		
		robotEngineer.makeRobot();
		Robot robot = robotEngineer.getRobot();
		
		System.out.println(robot.toString());
		
	}

}
