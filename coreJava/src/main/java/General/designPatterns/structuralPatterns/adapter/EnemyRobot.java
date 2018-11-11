package General.designPatterns.structuralPatterns.adapter;

//Adaptee
public class EnemyRobot {
	
	public void punchWithHand() {
		System.out.println("Robot punches 1-2-1 !!");
	}
	public void walkForward() {
		
		System.out.println("Robot Walks Forward !!");
		
	}
	public void setDriver(String driver) {
		System.out.println("Robot is driven by "+driver+" !!");
	}

}
