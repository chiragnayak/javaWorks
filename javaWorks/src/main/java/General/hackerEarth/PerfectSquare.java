package General.hackerEarth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*package whatever //do not write package name here */
import java.util.ArrayList;

class PerfectSquare {
	public static void main (String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cases = Integer.parseInt(br.readLine().trim());
        
        ArrayList<Integer> numbers = new ArrayList<>();
        for(int x=1; x<=cases; x++){
            
            numbers.add(Integer.parseInt(br.readLine().trim()));
            
        }
        
        for(int temp : numbers){
            
             System.out.println(isPerFectSquare(temp));
            
            
        }
	}
	
	public static int isPerFectSquare(int num){
	    
	    if((num%3==0 || num-(3*(num/3))==1) && //divisible by 3 or "1" greater than multiple of three
	    		(num%4==0 || num-(4*(num/4))==1)){ //divisible by 4 or "1" greater than multiple of four
	        return 1;   
	    }else{
	        return 0;
	    }
	}
}