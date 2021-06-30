package General.leetCode.easy;

/**
 * 
 * Given two integers dividend and divisor, divide two integers without using multiplication, division and mod operator.

	Return the quotient after dividing dividend by divisor.

	The integer division should truncate toward zero.
 *
 */
public class Divide2Int {
	
	public static void main(String[] args) {
		
		System.out.println(divideMySol(-2147483648,2));
		
	}
	
	public static int divideMySol(int dividend, int divisor) {
        
        int q = 0;
        boolean isNegative = false;
        boolean divisorNeg = false;
        boolean dividendNeg = false;
        
		if (divisor<0) divisorNeg = true;
		if (dividend<0) dividendNeg = true;
        
        if (divisorNeg && dividendNeg){
            isNegative = false;
            
        }else if (divisorNeg || dividendNeg){
            isNegative = true;
        }
        
        if(divisor==Integer.MIN_VALUE) {
        	if(dividendNeg) {
        		divisor = 2147483647;
        	}
        }
        
        if(dividend==Integer.MIN_VALUE) {
        	if(divisorNeg) {
        		dividend = 2147483647;
        	}
        }
        
        divisor = Math.abs(divisor);
        dividend = Math.abs(dividend);
        
        if(divisor==1) {
        	
        	if(divisorNeg && dividendNeg) {
        		return dividend;
        	}else if(divisorNeg || dividendNeg){
        		return -dividend;
        	}else {
        		return dividend;
        	}
        }
        
        if(dividend <0) {
        	
        	while(dividend<=0){
                
                dividend = dividend+divisor;
                
                if(dividend>0){
                    break;
                }
                
                q++;
                
            }
            
             return isNegative ? -q : q;
        	
        }else {
        	
        	while(dividend>=0){
                
                dividend = dividend-divisor;
                
                if(dividend<0){
                    break;
                }
                
                q++;
                
            }
            
             return isNegative ? -q : q;
        	
        }
       
        
        
    }

}
