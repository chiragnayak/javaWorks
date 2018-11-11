package General.designPatterns.creationalPattern.builder;

/**
 * 
 * Director Class 
 * 
 * 	Creates a robot with the fields set by builder
 * 
 * @author cnayak
 *
 */
public class RobotEngineer {
	
	//define type of robot you want to create
	private IRobotBuilder robotBuilder;
	
	public RobotEngineer(IRobotBuilder robotBuilder) {
		this.robotBuilder = robotBuilder;
	}
	
	public Robot getRobot() {
		return robotBuilder.getRobot();
	}
	
	/*this is the way/sequence/mechanism how robot enginner defines to create the sub-objects 
	that required to create main object.
	
	these sub-objects are anyways created by the builder.
	
	enginner is director here (something like a manager)
	
	this sequence/mechanism can change in future. But, in that case no need to change builder. Engineer (or manager) will
	define the new sequence/mechanism. 
	
	*/
	public void makeRobot() {
		this.robotBuilder.buildRobotHead();
		this.robotBuilder.buildRobotTorso();
		this.robotBuilder.buildRobotArms();
		this.robotBuilder.buildRobotLegs();
	}

}
