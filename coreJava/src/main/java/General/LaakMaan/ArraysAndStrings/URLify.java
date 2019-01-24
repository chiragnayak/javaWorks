package General.LaakMaan.ArraysAndStrings;

/**
 
 URLify: Write a method to replace all spaces in a string with '%20'. You may assume that the string
has sufficient space at the end to hold the additional characters, and that you are given the "true"
length of the string. (Note: If implementing in Java, please use a character array so that you can
perform this operation in place.)
EXAMPLE
Input: "Mr John Smith    ", 13
Output: "Mr%20John%20Smith"
 
 * 
 * @author cnayak
 *
 */
public class URLify {
	
	public static void main(String[] args) {
		
		String url = "Mr John Smith    ";
		char [] urlArr = url.toCharArray();
		int originalLen = 13;
		
		improved(urlArr, originalLen);
		
	}
	
	private static void replaceString(char [] urlArr, int originalLen){
		
		String replaceString = "%20";
		char [] replacingMe = replaceString.toCharArray();
		
		int jumpLen  = replacingMe.length-1; //1 space of existing space in original string
		
		int [] newPos  = new int [originalLen];
		
		int jump = 0;
		for(int x = 0; x < newPos.length; x++){
			
			newPos[x] = x + jump;
			
			if(urlArr[x]==' '){
				jump = jump + jumpLen;
			}
			
		}
		
		for(int x = 0; x < newPos.length; x++){
			System.out.print(newPos[x]+" ");
		}

		for(int x = newPos.length-1, y = urlArr.length-1; x >= 0; x--, y--){
			if(urlArr[x]==' '){
				urlArr[y]='0';
				urlArr[y-1]='2';
				urlArr[y-2]='%';
				y-=2;
			}else{
				urlArr[newPos[x]] = urlArr[x];
			}
		}
		
		System.out.println("");
		
		for(int x = 0; x < urlArr.length; x++){
			System.out.print(urlArr[x]+" ");
		}
		
	}
	
	public static void improved(char [] urlArr, int trueLength){
		
		int spaceCount = 0;
		for (int i= 0; i < trueLength; i++) {
			if (urlArr[i] == ' ') {
				spaceCount++;
			}
		}
		
		int finalIndex = trueLength+ (spaceCount*2)-1;
		
		for(int x = trueLength-1; x >=0; x--){
			
			if(urlArr[x]==' '){
				urlArr[finalIndex]='0';
				urlArr[finalIndex-1]='2';
				urlArr[finalIndex-2]='%';
				finalIndex-=3;
			}else{
				urlArr[finalIndex] = urlArr[x];
				finalIndex--;
			}
		}
		

		for(int x = 0; x < urlArr.length; x++){
			System.out.print(urlArr[x]+" ");
		}
		
	}

}
