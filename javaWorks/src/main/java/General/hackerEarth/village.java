package General.hackerEarth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class village {
	
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine().trim());
        
        String list [] = br.readLine().trim().split("\\s");
        
        Arrays.sort(list);
        
        int value = 0;
        
        boolean doNotexecute = false;
        
        if(size !=list.length) {
        	System.out.println(0);
        }else {
               int previous = Integer.parseInt(list[0].trim());
               
               int start = 1;
               
               for(int x=0; x<list.length; x++) {
            	   
                 if(Integer.parseInt(list[x].trim())<=0){
                	 
                	 if(x == list.length-1) {
              		   doNotexecute = true;
              		   break;
              	   	  }
                     
                      previous = Integer.parseInt(list[x+1].trim());
                     
                      start = x+2;
                      
                 }
                   
               } 
               
               if(!doNotexecute) {
            	   value = previous;
                   
                   for(int x=start; x<list.length; x++) {
                   	
                       int temp = Integer.parseInt(list[x].trim());
                       
                       if(temp<=0){
                           continue;
                       }
                   	
    	               	if(temp%previous==0) {
    	               		 value = value + temp;
    	               		 
//    	               		 System.out.println(temp+" "+previous);
    	               		 
    	               		 previous = temp;
    	               	}
                   }
                   
               }
              
               System.out.println(value);
        }
        
     }

}
