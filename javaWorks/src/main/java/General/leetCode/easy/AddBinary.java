package General.leetCode.easy;

/**
 * Given two binary strings, return their sum (also a binary string).
 * 
 * The input strings are both non-empty and contains only characters 1 or 0.
 * 
 * Example 1:
 * 
 * Input: a = "11", b = "1" Output: "100" Example 2:
 * 
 * Input: a = "1010", b = "1011" Output: "10101"
 * 
 * Rules :
 * 
 * input A, B 
 * previous carry C
 * Result R 
 * new carry C
 * 
 * ABC = RC
 * 000   00  
 * 001   10
 * 010   10
 * 011   01
 * 100   10
 * 101   01
 * 110   01
 * 111   11
 * 
 * 
 * @author cnayak
 *
 */
public class AddBinary {

	public static void main(String[] args) {
		
		System.out.println(addBinary("111", "101111"));

	}

	public static String addBinary(String a, String b) {
		
		char [] A = a.toCharArray();
		char [] B = b.toCharArray();
		
		int aLen = A.length-1;
		int bLen = B.length-1;
		
		StringBuilder buffer = new StringBuilder();
		
		char a1='0', b1='0', r1='0', c1='0'; //do not write just a zero, it will be blank then
		
		while(aLen>=0 || bLen >=0) {
			
			if(aLen>=0) {
				a1 = A[aLen];
				aLen--;
			}else {
				a1='0';
			}
			
			if(bLen>=0) {
				b1 = B[bLen];
				bLen--;
			}else {
				b1='0';
			}
			
			char [] curr = getResult(a1, b1, c1);
			
			buffer.append(String.valueOf(curr[0]));
			c1 = curr[1];
					
		}
		
		if(c1!='0') {
			buffer.append(c1);
		}
		
		return buffer.reverse().toString();

	}
	
	public static char [] getResult(char a, char b, char c) {
		
		char [] r = new char[2];
		
		String x = a+""+b+""+c;
		
		switch (x) {
		case "000":
				return new char [] {'0','0'};		
		case "001":
		case "010":
		case "100":
			return new char [] {'1','0'};
		case "011":
		case "110":
		case "101":
			return new char [] {'0','1'};
		case "111":
			return new char [] {'1','1'};
		default:
			break;
		}
		
		return r;
		
	}
	
	  public String addBinary2Ms(String a, String b) {
		    StringBuilder s =new StringBuilder();
		        char[] aChararray=a.toCharArray();
		        char[] bChararray=b.toCharArray();
		        int carry = 0, i = aChararray.length - 1, j = bChararray.length - 1,sum=0;
		       while (i>=0||j>=0){
		           sum=0;
		           sum+=carry;
		           if(i>=0) sum+=aChararray[i--]-'0'; // why - '0' in both the cases
		           if(j>=0) sum+=bChararray[j--]-'0';
		           s.append((char)(sum%2+'0'));
		           carry=sum/2;
		       }
		        if(carry==1) s.append('1');
		        return s.reverse().toString();
		    }

}
