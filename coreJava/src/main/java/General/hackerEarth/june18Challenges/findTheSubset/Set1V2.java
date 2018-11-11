package General.hackerEarth.june18Challenges.findTheSubset;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Set1V2 {
	
	static ArrayList<ArrayList<String>> permutes = new ArrayList<>();
	
	static ArrayList<String> result = new ArrayList<>();
	
	static int N, M, D, thisUgliness, resultUgliness, count=-1, upperLimit = 10;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String data [] = br.readLine().trim().split("\\s{1,}");                // Reading input from STDIN
        
        if(data.length==3) {
        	
        	N = Integer.parseInt(data[0]); // output array length
        	M = Integer.parseInt(data[1]); // input array length
        	D = Integer.parseInt(data[2]); // sum
        	
        	//(x,y) E T
        	// x + y > D
            String xxxx = br.readLine();
            
            ArrayList<String> inputArray = getInts(xxxx);
            
            ArrayList<String> sortedInputArray = getInts(xxxx);
            Collections.sort(sortedInputArray);
            
            createCombinations("",sortedInputArray.toArray(new String [sortedInputArray.size()]),N);
            
           StringBuilder sb = new StringBuilder();
           
           for(String x : inputArray) {
        	   if(result.contains(x)) {
        		   sb.append(x+" ");
        	   }
           }
           System.out.println(sb.toString().trim());
            
        }
		
		
	}
	
	private static boolean calculate( ArrayList<String> thisArray) {
		
		if(result.size()==0) {
			result = thisArray;
			return false;
		}

    	boolean lexoSmall = calculateLexoGraph(thisArray, result);
    	
    	if(lexoSmall) {
    		
    		thisUgliness = getUgliness(thisArray, D);
        	resultUgliness = getUgliness(result, D);
        	
//        	System.out.println(thisUgliness+" #> "+thisArray.toString()+" -> "+lexoSmall);
//        	System.out.println(resultUgliness+" $> "+result.toString()+" -> "+lexoSmall);
        	
        	if(resultUgliness!=-1) {
        		
				if(thisUgliness < resultUgliness) {
					result = thisArray;
					return true;
				}else {
					return false;
				}
        			
        	}else {
        		result = thisArray;
        	}
        	
        	return true;
        	
    	}else {
    		return false;
    	}
		
    
	}
	
	private static void createCombinations(String overlay, String [] current, int newSize) {
		
		if(newSize==1) {
			
			//char [] charArr = current.toCharArray();
			for(String c : current) {
				
				if(count==upperLimit) {
					return;
				}
				
//				System.out.println(overlay+c+" ");
				String [] data = (overlay+c).split("\\s{1}");
				ArrayList<String> temp = new ArrayList<>();
				for(String tempC : data) {
					temp.add(tempC);
				}

				if(!calculate(temp)) {
					count++;
				}else {
					count=0;
				}
			}
		}else {
			
			for(int i=0; i<current.length; i++) {
				
				if(count==upperLimit) {
					return;
				}
				
				StringBuilder sb = new StringBuilder();
				
				for(int y=0; y<current.length; y++) {
					if(y!=i) {
						sb.append(current[y]+" ");
					}
				}
				
				createCombinations(overlay+current[i]+" ", sb.toString().trim().split("\\s{1,}"), newSize-1);
			}
		}
		
		return;
		
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
			return false;
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
			}
		}
		return xx;
		
	}

}
