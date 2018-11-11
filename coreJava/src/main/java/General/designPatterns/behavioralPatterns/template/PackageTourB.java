package General.designPatterns.behavioralPatterns.template;

public class PackageTourB extends PackagedTour{

	@Override
	public void reachDestination() {
		System.out.println("Reached Destination Tour B");
		
	}

	@Override
	public void doDayA() {
		System.out.println("Go To City !");
		
	}

	@Override
	public void doDayB() {
		System.out.println("Go To Castle !");
		
	}

	@Override
	public void doDayC() {
		System.out.println("Go To Port Area !");
		
	}

	@Override
	public void returnToHome() {
		System.out.println("Return Home : Tour B !");
	}

}
