package General;

public class PrintUtility {
	
		public static void printBanner(String someString) {
		    
		    String plus="+";
		    for(int i=0;i<someString.length();i++){
		       plus=plus+"+" ;
		    }
		    
		   System.out.println(plus);
		   System.out.println(someString);
		   System.out.println(plus);
		}



		public static void printInfo(String someString){
		  System.out.println("--> "+someString);
		}
		
		public static void printBanner(String someString, boolean makeItGreen) {
		    
		    String plus="+";
		    for(int i=0;i<someString.length();i++){
		       plus=plus+"+" ;
		    }
		   if(makeItGreen) {
			   System.out.println(plus);
			   System.out.println(someString);
			   System.out.println(plus);
		   }else {
			   System.err.println(plus);
			   System.err.println(someString);
			   System.err.println(plus);
		   }
		  
		}

}
