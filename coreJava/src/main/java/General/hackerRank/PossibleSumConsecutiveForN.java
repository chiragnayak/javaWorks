package General.hackerRank;

import java.util.ArrayList;

public class PossibleSumConsecutiveForN {
	
	static boolean isTimer = true;
	
	public static void main(String[] args) {

		long xx = System.currentTimeMillis();
		System.out.println(consecutive_O_n2(210000));
		long yy = System.currentTimeMillis();
		
		System.out.println(yy-xx);
		
		xx = System.currentTimeMillis();
		System.out.println(consecutive_O_n(210000));
		yy = System.currentTimeMillis();
		
		System.out.println(yy-xx);
		
	}
	
	public static int consecutive_O_n2(long num) {
		
		if(num < 0){
			return 0;
		}
		   
        if(num==0){
        	return 0;
        }
        
        if(num==1){
        	return 1;
        }
        
      int count = 0;
      long start = 1;
      long end = num/2+1;
      
      long sum = start;
      ArrayList<Long> list = new ArrayList<>();
     
      for(long x=start; x <=end; x++){
    	  if(!isTimer)  list.add(x);
    	  sum = x;
    	  for(long y=x+1; y <=end; y++){
    		  
    		  sum = sum + y;
    		  if(!isTimer) list.add(y);
        	  if (sum == num){
        		  count++;
        		  if(!isTimer)  System.out.println(list.toString()); 
        		  if(!isTimer)  list = new ArrayList<>();
        		  break;
        	  }
    	  }
    	  
    	  if(!isTimer)list = new ArrayList<>();
      }
       
       return count;
       
    }
	
	public static int consecutive_O_n(long N) {
		
		long start = 1;
		long end = 1;
		long sum = start;
		int count = 0;
		
		ArrayList<Long> list = new ArrayList<>();
		if(!isTimer)list.add(end);
		while(start < ((N/2)+1)){
			
			if(sum < N){
				end+=1;
				if(!isTimer)list.add(end);
				sum+=end;
			}
			else if( sum > N){
				sum -= start; //delete currect start from your sum
				if(!isTimer)list.remove(start);
				start +=1; //move your start to next position
			}
			else if( sum == N){
				count++;
				if(!isTimer)System.out.println(list.toString());
               sum -= start; 
               if(!isTimer)list.remove(start);
               start += 1; 
			}
			
		}
		
		return count;
		
	}

}
