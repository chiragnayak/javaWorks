package General.designPatterns.creationalPattern.builder;


/**
 * 
 * Defines what Robot Has.
 * 
 * @author cnayak
 *
 */
public interface IRobotBuilder {
	
	void buildRobotHead(); // it knows how to build robot head (specifics)
	void buildRobotTorso(); //it knows how to build robot torso (specifics)
	void buildRobotArms(); //it knows how to build robot arms (specifics)
	void buildRobotLegs(); //it knows how to build robot legs (specifics)
	
	// can assemble and return the robot object (main object) in a way how Robot engineer guides to assemble it
	// this API is not exposed to cliet. 
	// Client gets robot object via Robot engineer, which internally calls builder's get robot. 
	Robot getRobot(); 

}
