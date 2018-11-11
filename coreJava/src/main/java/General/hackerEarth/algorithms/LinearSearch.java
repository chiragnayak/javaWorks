package General.hackerEarth.algorithms;

import java.io.BufferedReader;
import java.io.InputStreamReader;


/* * @author cnayak
 *
 */
class LinearSearch {
    public static void main(String args[] ) throws Exception {
        // Sample code to perform I/O:
        //Use either of these methods for input
    	
    	// System.out.println("Enter Data \n"); 

        //BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name = br.readLine();                // Reading input from STDIN

       int val = Integer.parseInt(name.split("[\\s]{1,}")[1]);
       int length = Integer.parseInt(name.split("[\\s]{1,}")[0]);
       
       String data = br.readLine();              // Reading input from STDIN

       String [] dataArr = data.split("[\\s]{1,}");
       int position = -1;
      if(dataArr.length==length) {
    	  // Write your code here
         
          for(int iCount=0;iCount<length; iCount++) {
       	   if(val==Integer.parseInt(dataArr[iCount])) {
       		position=iCount;
       	   }
          }
      }
      
      if(position!=-1) {
    	  System.out.println(++position);
      }else {
    	  System.out.println(position);
      }
     

    }
}