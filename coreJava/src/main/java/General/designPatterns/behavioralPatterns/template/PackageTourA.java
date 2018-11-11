package General.designPatterns.behavioralPatterns.template;

public class PackageTourA extends PackagedTour{

	@Override
	public void reachDestination() {
		System.out.println("Reached Destination Tour A");
		
	}

	@Override
	public void doDayA() {
		System.out.println("Go To Mountains !");
		
	}

	@Override
	public void doDayB() {
		System.out.println("Go To Sea !");
		
	}

	@Override
	public void doDayC() {
		System.out.println("Go To Disnyland !");
		
	}

	@Override
	public void returnToHome() {
		System.out.println("Return Home : Tour A !");
	}

}
