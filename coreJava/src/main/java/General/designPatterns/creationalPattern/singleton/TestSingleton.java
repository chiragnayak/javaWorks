package General.designPatterns.creationalPattern.singleton;

public class TestSingleton {

	public static void main(String[] args) throws ClassNotFoundException {
		
		
		Logger.getInstance().logInfoMessage("This is first Log!");
		Logger.getInstance().logInfoMessage("This is Second Log!");		
		Logger.getInstance().logInfoMessage("This is Third Log!");
		
		

	}
}
