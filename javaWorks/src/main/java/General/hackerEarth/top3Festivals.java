package General.hackerEarth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.TreeMap;

/**
 * x -> number of cases
 * y -> number of spendings
 * festival-x spending
 * festival-y spending
 * festival-x spending
 * festival-x spending
 * festival-z spending
 * 
 * Program needs to find the highest of sum of top three spending in a festival.  
 * 
 * @author cnayak
 *
 */
public class top3Festivals   {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        int cases = Integer.parseInt(br.readLine().trim());  
	        ArrayList<String> output = new ArrayList<>();
	        
	        for(int x=0; x<cases; x++) {
	        	
	        	int spendings = Integer.parseInt(br.readLine().trim());
	        	HashMap<String, Integer> total = new HashMap<>();
	        	TreeMap<String, ArrayList<Integer>> individual = new TreeMap<>();
	        	for(int y=0; y<spendings; y++) {
	        		
	        		String pair [] = br.readLine().trim().split("\\s");
	        		
//	        		System.out.println("----------"+pair[0]+" "+pair[1]);
	        		
	        		if(individual.get(pair[0])!=null) {
	        			
	        			ArrayList<Integer> list = individual.get(pair[0]);
	        			list.add(Integer.parseInt(pair[1].trim()));

	        		}else {
	        			
	        			ArrayList<Integer> xxx = new ArrayList<>();
	        			xxx.add(Integer.parseInt(pair[1].trim()));
	        			individual.put(pair[0],xxx);
	        		}
	        	}
	        	
	        	for(Entry<String, ArrayList<Integer>> ccc : individual.entrySet()) {
	        		
	        		String key = ccc.getKey();
	        		
	        		ArrayList<Integer> vvv = ccc.getValue();
	        		
	        		Collections.sort(vvv);
	        		
	        		int count = 0;
	        		int totalval = 0;
	        		for(int iRev = vvv.size()-1; iRev >=0; iRev--){
	        			if(count==3) {
	        				break;
	        			}
	        			totalval = totalval+vvv.get((iRev));
	        			count++;
	        		}
	        		
	        		total.put(key, totalval);
	        		
	        	}
	        	
	        	String finalKey = "-1";
	        	int finalVal = -1;
	        	for(Entry<String, Integer> compare : total.entrySet()) {
	        		
	        		String tempKey = compare.getKey();
	        		int value = compare.getValue();
	        		
	        		if(finalKey.equalsIgnoreCase("-1")) {
	        			finalKey = tempKey;
	        			finalVal = value;
	        		}else {
	        			
	        			if(value > finalVal) {
	        				finalKey = tempKey;
		        			finalVal = value;
	        			}else if(value==finalVal) {
	        				
	        				if(tempKey.compareTo(finalKey)<0) {
	        					finalKey = tempKey;
	    	        			finalVal = value;
	        				}
	        			}
	        			
	        		}
	        	}
	        	
	        	output.add(finalKey+" "+finalVal);
	        }
	        
	        for(String temp : output) {
	        	System.out.println(temp);
	        }
		
	}

}
