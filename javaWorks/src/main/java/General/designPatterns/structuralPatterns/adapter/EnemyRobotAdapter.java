package General.designPatterns.structuralPatterns.adapter;

//Adapter
public class EnemyRobotAdapter implements IEnemyAttacker {
	
	/*
	 * The adapter pattern is called Object Adapter Pattern
	 * because the adapter holds an instance of adaptee. In this case EnemyRobot
	 * 
	 * */
	private EnemyRobot enemyRobot;
	
	public EnemyRobotAdapter(EnemyRobot enemyRobot) {
		this.enemyRobot = enemyRobot;
	}

	@Override
	public void fireWeapon() {
		enemyRobot.punchWithHand();		
	}

	@Override
	public void driveForward() {
		enemyRobot.walkForward();
		
	}

	@Override
	public void assignDriver(String driver) {
		enemyRobot.setDriver(driver);
		
	}

}
