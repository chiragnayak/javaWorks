package General.concepts.Threads.LeetCode;

/**
 * Suppose you are given the following code:

class ZeroEvenOdd {
  public ZeroEvenOdd(int n) { ... }      // constructor
  public void zero(printNumber) { ... }  // only output 0's
  public void even(printNumber) { ... }  // only output even numbers
  public void odd(printNumber) { ... }   // only output odd numbers
}
The same instance of ZeroEvenOdd will be passed to three different threads:

Thread A will call zero() which should only output 0's.
Thread B will call even() which should only ouput even numbers.
Thread C will call odd() which should only output odd numbers.
Each of the threads is given a printNumber method to output an integer. Modify the given program to output the series 010203040506... where the length of the series must be 2n.

 

Example 1:

Input: n = 2
Output: "0102"
Explanation: There are three threads being fired asynchronously. One of them calls zero(), the other calls even(), and the last one calls odd(). "0102" is the correct output.
Example 2:

Input: n = 5
Output: "0102030405"
 * 
 * @author cnayak
 *
 */
public class PrintZeroEvenOdd {
	
	    private int n;
	    
	    int next = 0;
	    int count = 0;
	    int nextOdd = 1;
	    int nextEven = 2;
	    boolean continue_ = true;
	    
	    public PrintZeroEvenOdd(int n) {
	        this.n = n;
	    }

	    // printNumber.accept(x) outputs "x", where x is an integer.
	    public synchronized void zero(PrintZeroEvenOdd obj) throws InterruptedException {
	      
	        while(continue_){
	             if(next==0){
	            	 obj.print(0);
	                count++;
	                if(count%2==0){
	                    next=2;
	                }else{
	                    next=1;
	                }
	                 notifyAll();
	            }else {
	               wait();
	            }   
	        }
	        
	    }

	    public synchronized  void odd(PrintZeroEvenOdd obj) throws InterruptedException {
	        
	        while(continue_) {
	           if(next==1){
	             obj.print(nextOdd);
	             nextOdd+=2;
	             next=0;
	             if(count==n){
	                 continue_=false;
	             }
	               notifyAll();
	        }else {
	            wait();
	        }
	 
	    }
	   }
	   private void print(int nextOdd2) {
			System.out.print(nextOdd2);
			
		}

	public synchronized  void even(PrintZeroEvenOdd obj) throws InterruptedException {
	       
	       while(continue_){
	            if(next==2){
	            obj.print(nextEven);
	             nextEven+=2;
	             next=0;
	             if(count==n){
	                 continue_=false;
	             }
	                notifyAll();
	        }else {
	            wait();
	        }
	       }
	        
	    }

}
