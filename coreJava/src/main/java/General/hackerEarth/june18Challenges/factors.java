package General.hackerEarth.june18Challenges;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * @author cnayak
 *
 */
public class factors {
	
	public static void main(String[] args) throws IOException {
		
		 //BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name = br.readLine();                // Reading input from STDIN

       int num1 = Integer.parseInt(name.split("[\\s]{1,}")[1]);
       int num2 = Integer.parseInt(name.split("[\\s]{1,}")[0]);
       
       ArrayList<String> divisors = new ArrayList<>();
       int num=1;
       while (num <= num1 || num <=num2) {
    	   
    	   if(num1%num==0 && num2%num==0) {
    		   divisors.add(String.valueOf(num));
    	   }
    	   
    	   num++;
    	   
       }
       
       System.out.println(divisors.size());
		
	}

}
