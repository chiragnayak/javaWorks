package General.hackerEarth.june18Challenges;

import java.util.ArrayList;

//Java program to print all permutations of a
//given string.
public class PermutationPostion2
{
	static ArrayList<String> permutes = new ArrayList<>();
	
	public static void main(String[] args)
	{
		ArrayList<String> temp = new ArrayList<>();
		temp.add("A");
		temp.add("B");
		temp.add("C");
		temp.add("D");
		
		int newSize = 4;
	
		StringBuilder sb = new StringBuilder();
		
		for(int y=0; y<temp.size(); y++) {
			sb.append(temp.get(y));
		}
		
		fillPosition("", sb.toString(), newSize);
		
//		for(String permutesTemp : permutes) {
//			System.out.println(permutesTemp.toString());
//			
//		}
		
		System.out.println("---- > "+permutes.size());
		
	}

	private static void fillPosition(String overlay, String current, int newSize) {
		
		if(newSize==1) {
			char [] charArr = current.toCharArray();
			for(char c : charArr) {
				System.out.println(overlay+c);
				permutes.add(overlay+c);
			}
		}else {
			
			for(int i=0; i<current.length(); i++) {
				
				StringBuilder sb = new StringBuilder();
				
				for(int y=0; y<current.length(); y++) {
					if(y!=i) {
						sb.append(current.charAt(y));
					}
				}
				
				fillPosition(overlay+current.charAt(i), sb.toString(), newSize-1);
			}
		}
		
	}


	

}

//This code is contributed by Mihir Joshi

