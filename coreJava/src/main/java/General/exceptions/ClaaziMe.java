package General.exceptions;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class ClaaziMe {
	
	public static void main(String[] args) throws Throwable {
		
		Map<String, String> x = new HashMap<>();
		
		x.put(null, "chira");
		x.put("US", "chirag");
		x.put("US", "chirag");
		x.put("india", "chirag");
		
		System.out.println(x.size());

		HashSet<B> xxx =new HashSet<>();
		xxx.add(new B());
		xxx.add(new B());
		
		System.out.println(xxx.size());
		
	}
}
