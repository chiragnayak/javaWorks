package General.hackerEarth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*package whatever //do not write package name here */
import java.util.ArrayList;

public class primes {
	public static void main (String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cases = Integer.parseInt(br.readLine().trim());
        
        ArrayList<Integer> numbers = new ArrayList<>();
        for(int x=1; x<=cases; x++){
            
            numbers.add(Integer.parseInt(br.readLine().trim()));
            
        }
        
        for(int temp : numbers){
            
            printPrimeList(temp);
            
            System.out.println("");
        }
		
	}
	
	public static void printPrimeList(int to){
	    
	    for(int from=1; from <=to; from++){
	        if(isPrime(from)){
	            System.out.print(from+" ");
	        }
	    }
	}
	
	public static boolean isPrime(int num){
	    
	    int count=0;
	    for(int from=1; from <=num; from++){
	        if(num%from==0){
	            count++;
	        }
	    }
	    
	    if(count==2){
	        return true;
	    }else{
	        return false;
	    }
	}
}