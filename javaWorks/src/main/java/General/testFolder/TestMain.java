package General.testFolder;

import java.util.ArrayList;

public class TestMain {
	
	public static void main(String[] args) {
		
		ArrayList<? super IMarker> xx = new ArrayList<>();
		
		xx.add(new B());
//		xx.add(new A()); --> compilation error
		xx.add(new C());
		
		
	}

}
