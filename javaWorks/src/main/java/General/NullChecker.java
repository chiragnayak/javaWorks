package General;

import java.util.ArrayList;

public class NullChecker {
	
	public static void main(String[] args) {
		
		ArrayList<String> xx = new ArrayList<>();
		xx.add("chirag");
		xx.add("nayak");
		
		System.out.println(nullCheck(xx, ArrayList.class).toString());
		
		String nullxx = null;
		System.out.println(nullCheck(nullxx, String.class).toString());
		
		ArrayList<String> nullAl = null;
		System.out.println(nullCheck(nullAl, ArrayList.class));
		
	}
	
	@SuppressWarnings("unchecked")
	public static <T extends Object> T nullCheck(T xx, Class<T> type) {
		
		if(xx==null){
			System.out.println("OBJECT OF CLASS "+type.getSimpleName()+" IS NULL !!!");
			Class<?> clazz = null;
			Object object = null;
			try {
				clazz = Class.forName(type.getName());
				object = clazz.newInstance();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return (T) object;
		}
		
		 return  type.cast(xx);
		
	}

}
