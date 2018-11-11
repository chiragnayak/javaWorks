package General.hackerEarth.june18Challenges.countTheTriangles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeSet;

public class CountTheTriangles {
	
	static TreeSet<String> permutes = new TreeSet<>();
	
	static TreeSet<String> uniqueElm = new TreeSet<>();
	
	static ArrayList<String> inputArray = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(br.readLine().trim());                // Reading input from STDIN
        
    	//(x,y) E T
    	// x + y > D
        String xxxx = br.readLine();
        
        inputArray = getInts(xxxx);
        
        Collections.sort(inputArray);
        
        createCombinations("",inputArray.toArray(new String [inputArray.size()]),3);
        
//        for(String x : permutes) {
//        	System.out.println("-->"+x);
//        }
//        
       System.out.println((permutes.size()+uniqueElm.size()));
		
	}
	
	private static void createCombinations(String overlay, String [] current, int newSize) {
		
		if(newSize==1) {
			//char [] charArr = current.toCharArray();
			for(String c : current) {
				String data = (overlay+c);
				data = data.trim().replace(" ", "");
				System.out.println(data);
				int x = Integer.parseInt(data.substring(0, 1));
				int y = Integer.parseInt(data.substring(1,2));
				int z = Integer.parseInt(data.substring(2));
				
				if(x+y<=z) {
					int  l = inputArray.indexOf(x);
					int r = inputArray.indexOf(z);
					
					if(r-l==0 || r-l==1)
						permutes.add(data);
				}
			}
		}else {
			
			for(int i=0; i<current.length; i++) {
				
				StringBuilder sb = new StringBuilder();
				
				for(int y=0; y<current.length; y++) {
					if(y!=i) {
						sb.append(current[y]+" ");
					}
				}
				
				createCombinations(overlay+current[i], sb.toString().trim().split("\\s{1,}"), newSize-1);
			}
		}
		
	}

	
	private static boolean calculateLexoGraph(ArrayList<String> thisArray, ArrayList<String> previousArray) {
		
		if(previousArray.size()==thisArray.size()) {
			
			for(int position=0; position<thisArray.size(); position++) {
				if(Integer.parseInt(thisArray.get(position))<Integer.parseInt(previousArray.get(position))) {
					return true;
				}else if(Integer.parseInt(thisArray.get(position))==Integer.parseInt(previousArray.get(position))) {
					continue;
				}else {
					return false;
				}
			}
			
			return true;
			
		}else {
			return true;
		}
		
	}

	private static int getUgliness(ArrayList<String> inputArray ,int D) {
		
		int ugliness = -1;
		ArrayList<String> listing = new ArrayList<>();
		for(int xCount=0; xCount <inputArray.size(); xCount++) {
			for(int yCount=0; yCount <inputArray.size(); yCount++) {
				
				int sum = Integer.valueOf(inputArray.get(xCount))+Integer.valueOf(inputArray.get(yCount));
				
				if(sum>D) {
					
					String data = "("+inputArray.get(xCount)+","+inputArray.get(yCount)+")";
					String dataRev = "("+inputArray.get(yCount)+","+inputArray.get(xCount)+")";
					if(!(listing.contains(data) || listing.contains(dataRev))) {
						listing.add(data);
//						System.out.print(data);
						ugliness++;
					}
				}
			}
		}
		
		return ugliness;
		
	}

	public static ArrayList<String> getInts(String string) {
		
		String [] data = string.trim().split("\\s{1,}");
		
		ArrayList<String> xx = new ArrayList<>();  
		
		for(int iCount = 0; iCount<data.length;iCount++) {
			if(data[iCount].trim().length()!=0) {
				xx.add(data[iCount].trim());
				uniqueElm.add(data[iCount].trim());
			}
		}
		return xx;
		
	}

}
