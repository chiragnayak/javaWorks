package General.leetCode.easy;

public class LemonadeChange {
	
	public static void main(String[] args) {
		
		/*
		 
		[5,5,5,10,20] -> true
        [5,5,10] -> true
        [10,10] -> false [directly returns false, as we don't have change]
        [5,5,10,10,20] -> false
        [5,5,5,5,20,10,5,10] -> true
		 
		 * 
		 * */
		
		System.out.println(lemonadeChange(new int [] {5,5,5,10,20}));
		System.out.println(lemonadeChange(new int [] {5,5,10}));
		System.out.println(lemonadeChange(new int [] {10,10}));
		System.out.println(lemonadeChange(new int [] {5,5,10,10,20}));
		System.out.println(lemonadeChange(new int [] {5,5,5,5,20,10,5,10}));
		
	}
	
	 public static boolean lemonadeChange(int[] bills) {
		 
		    if(bills.length==0) {
		    	return true;
		    }
	        
	        /**
	       Approach #1: 
	       your first bill MUST be $5 else return false
	       
	        list holding $5, $10 and $20 bills
	        updated them as and when they are collected.
	        once higher order bill is received, 
	             -> calculate diff
	             -> if == 20
	                    - do you have $ 10 bill
	                    - do you have $ 5 bill
	                if == 10 
	                    - do you have $ 5 bill 
	                if == 5
	                    - :) 
	                    
	             + for each case diff % $x = remaining amount $y, diff = $y, reiterate
	             + finally if diff == 0 , return true, else false for that case.
	             
	        Test cases:
	        [5,5,5,10,20] -> true
	        [5,5,10] -> true
	        [10,10] -> false [directly returns false, as we don't have change]
	        [5,5,10,10,20] -> false
	        [5,5,5,5,20,10,5,10] -> true
	        */ 
	        
	        if(bills[0]!=5){
	                return false;
	        }
	        
	        int dollar5 = 0;
	        int dollar10 = 0;
	        int dollar20 = 0;
	        
	        boolean result = true;
	        
	        for(int i=0; i<bills.length; i++){
	            
	                if(bills[i]==5){
	                  dollar5++;  
	                }else if(bills[i]==10){
	                  dollar10++;  
	                  if(dollar5==0){
	                      return false;
	                  }else{
	                      dollar5--;
	                  }
	                }else if(bills[i]==20){
	                  dollar20++;
	                    if(dollar5==0){
	                      return false;
	                    }
	                    
	                    if (dollar10==0) {
	                      if((5*dollar5) >= 15){ //$5 in excess or exact
	                          dollar5 = dollar5 - 3;
	                      }else{ //$5 not suffecient
	                          return false;
	                      }
	                    }else{
	                       
	                        //imp condition : we have both $10 and $5
	                          /*
	                         - consume 10 first
	                         - consume 5 on remaining
	                         
	                        */
	                        
	                          dollar10 = dollar10 - 1;
	                          dollar5 = dollar5 - 1;
	                        
	                    }
	                }
	                
	            }

	        return result;
	    }

}
