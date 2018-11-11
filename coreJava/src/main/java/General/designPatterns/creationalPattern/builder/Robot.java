package General.designPatterns.creationalPattern.builder;

public class Robot implements IRobotPlan {

	String robotHead;
	String robotTorso;
	String robotArms;
	String robotLegs;

	public String getRobotHead() {
		return robotHead;
	}

	@Override
	public void setRobotHead(String robotHead) {
		this.robotHead = robotHead;
	}

	public String getRobotTorso() {
		return robotTorso;
	}

	@Override
	public void setRobotTorso(String robotTorso) {
		this.robotTorso = robotTorso;
	}

	public String getRobotArms() {
		return robotArms;
	}

	@Override
	public void setRobotArms(String robotArms) {
		this.robotArms = robotArms;
	}

	public String getRobotLegs() {
		return robotLegs;
	}

	@Override
	public void setRobotLegs(String robotLegs) {
		this.robotLegs = robotLegs;
	}
	
	@Override
	public String toString() {
		return this.robotHead+" \n"+
				this.robotTorso+" \n"+
				this.robotArms+" \n"+
				this.robotLegs+" \n";
	}

}
