package General.designPatterns.structuralPatterns.adapter;

public class EnemyTank implements IEnemyAttacker {

	@Override
	public void fireWeapon() {
		System.out.println("Fire Enemy Tank Canon !!");
	}

	@Override
	public void driveForward() {
		System.out.println("Fire Enemy Tank Drive Forward !!");
	}

	@Override
	public void assignDriver(String driver) {
		System.out.println("Fire Enemy Tank Driver "+driver+" Assigned !!");
	}

}
