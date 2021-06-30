package General;

public class TestMe {
	
	
	public static void main (String [] args){
		
		System.out.println(dnaComplement("ACCGGGTTTT"));
		
	}
	
	 public static String dnaComplement(String s) {
		   
		 if(s==null){
			 return s;
		 }
		 
		 char [] arr = s.toCharArray();
		 
		 if(arr.length==0){
			 return s;
		 }
		 
		 int i = 0;
		 int j = arr.length-1;
		 
		 while(i>j){
			 
			 arr[i] = get(arr[i]);
			 arr[j] = get(arr[j]);
			 
			 swap(i, j, arr);
			 
			 i++;
			 j--;
			 
			 System.out.println(arr[i]);
			 System.out.println(arr[j]);
		 }
		 
		 return String.valueOf(arr);

	 }
	 
	 public static void swap(int i, int j, char [] arr){
		 
		 char temp = arr[i];
		 arr[i] = arr[j];
		 arr[j] = temp;
	 }
	 
	 public static char get(char c){
		 
		 if(c=='A'){
			 return 'T';
		 }else if(c=='C'){
			 return 'G';
		 }else {
			 return 'X';
		 }
	 }
}
