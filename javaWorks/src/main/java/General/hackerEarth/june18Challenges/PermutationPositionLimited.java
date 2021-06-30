package General.hackerEarth.june18Challenges;

import java.util.ArrayList;

//Java program to print all permutations of a
//given string.
public class PermutationPositionLimited
{
	static ArrayList<String> permutes = new ArrayList<>();
	
	public static void main(String[] args)
	{
		ArrayList<String> temp = new ArrayList<>();
		temp.add("A");
		temp.add("B");
		temp.add("C");
		
		int newSize = 3;
		
		for(int i=0; i<temp.size(); i++) {
			
			StringBuilder sb = new StringBuilder();
			
			for(int y=0; y<temp.size(); y++) {
				if(y!=i) {
					sb.append(temp.get(y));
				}
			}
			
			PermutationPositionLimited permutation = new PermutationPositionLimited();
			permutation.fillPosition(temp.get(i),sb.toString(), newSize-1);
		}
		
//		for(String permutesTemp : permutes) {
//			System.out.println(permutesTemp.toString());
//			
//		}
		
		System.out.println("---- > "+permutes.size());
		
	}

	private void fillPosition(String overlay, String current, int newSize) {
		
		if(newSize==1) {
			char [] charArr = current.toCharArray();
			for(char c : charArr) {
				System.out.println(overlay+c);
				permutes.add(overlay+c);
			}
		}else {
			fillPosition(overlay+current.substring(0,1), current.substring(1), newSize-1);
		}
		
	}


	

}

//This code is contributed by Mihir Joshi

