package General.leetCode.easy;

/**
 * 
 * The count-and-say sequence is the sequence of integers with the first five terms as following:

1.     1
2.     11
3.     21
4.     1211
5.     111221
	
	1 is read off as "one 1" or 11.
	11 is read off as "two 1s" or 21.
	21 is read off as "one 2, then one 1" or 1211.
	Given an integer n, generate the nth term of the count-and-say sequence.
	
	Note: Each term of the sequence of integers will be represented as a string.
	
	Example 1:
	
	Input: 1
	Output: "1"
	Example 2:
	
	Input: 4
	Output: "1211"

 * @author cnayak
 *
 */
public class CountNsay {
	
	public static void main(String[] args) {
		
		System.out.println(countAndSay(1));
		System.out.println(countAndSay(2));
		System.out.println(countAndSay(3));
		System.out.println(countAndSay(4));
		System.out.println(countAndSay(5));
	}
	
	 public static String countAndSay(int n) {
	     
		 //save first character
		 //count how many time it repeats
		 //push that count to new SB
		 //feed the iteration the final SB
		 //return SB if n is reached.
		 
		 String feed = "1";
		 if(n==1) {
			 return "1";
		 }
		 while(n!=1) {
			 
			 char [] feedArr = feed.toCharArray();
			 StringBuilder sb = new StringBuilder();
			 
			 int count = 0;
			 char charToCount =feedArr[0];
			 for(int x = 0; x < feedArr.length; x++) {
				 
				 if(feedArr[x]==charToCount) {
					 count++;
				 }else {
					 // my app : // sb.append(count+""+ Character.getNumericValue(charToCount));
					 sb.append(count+""+ (charToCount-48)); // can be -88 as well
					 charToCount = feedArr[x];
					 count=1;
				 }
			 }
			 
			 sb.append(count+""+ (charToCount-48));		 
			 feed = sb.toString();
//			 System.out.println(n+" ---> "+feed);
			 
			 n--;
			 
		 }
		 
		 
		 return feed ;
	 }
}
