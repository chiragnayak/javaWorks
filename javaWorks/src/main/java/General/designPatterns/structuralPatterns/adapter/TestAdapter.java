package General.designPatterns.structuralPatterns.adapter;

public class TestAdapter {
	
	public static void main(String[] args) {
		
		//This is client class
		//It needs EnemyAttacker - Target
		//We want to adopt : EnemyRobot (hence this is adaptee)
		//adapter will convert adaptee to target.
		
		EnemyTank rx7Tanl = new EnemyTank();
		
		EnemyRobot myRobot = new EnemyRobot();
		
		EnemyRobotAdapter adapter = new EnemyRobotAdapter(myRobot);
		
		System.out.println("The Tank--->");
		rx7Tanl.fireWeapon();
		rx7Tanl.driveForward();
		rx7Tanl.assignDriver("Chirag");
		
		System.out.println("The Robot--->");
		myRobot.punchWithHand();
		myRobot.walkForward();
		myRobot.setDriver("Panda");
		
		System.out.println("The Robot with adapter--->");
		adapter.fireWeapon();
		adapter.driveForward();
		adapter.assignDriver("Master Shifu");
		
	}

}
