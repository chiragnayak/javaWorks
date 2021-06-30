	package General.leetCode;
	
	/**
	 * Given a 32-bit signed integer, reverse digits of an integer.

		Example 1:
		
		Input: 123
		Output: 321
		Example 2:
		
		Input: -123
		Output: -321
		Example 3:
		
		Input: 120
		Output: 21
		Note:
		Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1]. 
		For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.
	 * 
	 * @author cnayak
	 *
	 */
	public class ReverseNumber {
	
		public static void main(String[] args) {
				 					   
			System.out.println(reverseMySol(101));
			System.out.println(reverseMySol(120));
			System.out.println(reverseMySol(-1234));
			System.out.println(reverseMySol(1234567899));
		}
	
		public static int reverseMySol(int x) {
			
			String str = String.valueOf(x);
			
			//2147483648
			
			boolean negative = false;
			
			if (x < 0) {
				negative = true;
				str = str.substring(1);
			}
	
			int size = str.length();
	
			StringBuilder sb = new StringBuilder();
	
			while (size != 0) {
				size--;
				sb.append(String.valueOf(str.charAt(size)));
			}
			
			String sbToStr = sb.toString();
			
			if(Long.parseLong(sbToStr) > 2147483647 || Long.parseLong(sbToStr) < -2147483647 ) {
				return 0;
			}
	
			if(negative)
				return -Integer.parseInt(sbToStr);
			else 	
				return Integer.parseInt(sbToStr); 
	
		}
		
		    public int reverse20msRef(int x) {
		        try{
		            boolean isNeg = (x<0);
		            if(isNeg){x=Math.abs(x);}  // Get rid of the negative sign
		            String num = "";
		            while(x!=0){
		                num += String.valueOf(x%10);  // Add string value of the last digit to the result
		                x=x/10;  // Chop the last digit off of the int
		            }
		            if(isNeg){num = "-"+num;}  // If the input was negative reattach the sign
		            return Integer.parseInt(num);  // Parse the string for the int value
		        }
		        // If integer is out of range: [−231,  231 − 1] return 0
		        catch(Exception e){
		            return 0;
		        }
		    }
		    
		    public int reverse21msRef(int x) {
		        if(x == Integer.MIN_VALUE){
		            return 0;
		        }
		        int y = x < 0 ? -x : x;
		        double ret = 0;
		        while(y != 0){
		            int m = y % 10;
		            ret = 10.0*ret + m;
		            if(ret > Integer.MAX_VALUE || -ret < Integer.MIN_VALUE){
		                return 0;
		            }
		            y = y / 10;
		        }
		        int r = (int)ret;
		        return x < 0 ? -r : r;
		    }
		    
		    public int reverse20msII(int x) {
		        if(x == Integer.MIN_VALUE){
		            return 0;
		        }
		        int y = x < 0 ? -x : x;
		        double ret = 0;
		        while(y != 0){
		            int m = y % 10;
		            ret = 10.0*ret + m;
		            if(ret > Integer.MAX_VALUE || -ret < Integer.MIN_VALUE){
		                return 0;
		            }
		            y = y / 10;
		        }
		        int r = (int)ret;
		        return x < 0 ? -r : r;
		    }
	}
