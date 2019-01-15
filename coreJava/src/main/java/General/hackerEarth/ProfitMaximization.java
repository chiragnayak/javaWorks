package General.hackerEarth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

public class ProfitMaximization {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numberOfVillages = Integer.parseInt(br.readLine().trim());
        String eachCost [] = br.readLine().trim().split("\\s");
        
        int N = eachCost.length;
        
        if(numberOfVillages!=N){
        	System.out.println("0");
        	return;
        }
        
        HashMap<Integer, Integer> totalValues = new HashMap<>();
        Integer costs [] = new Integer[N];
        
        for(int x = 0; x < N; x++ ){
        	costs [x] = Integer.parseInt(eachCost[x]);
        	totalValues.put(x, costs[x]);
        }

        for(int x = N-1; x >=0; x-- ){
        	
        	int startPoint = x;
        	int newPathCost = costs[startPoint];
        	
        	int nextDownVillage = ifHasMultiple(costs, startPoint);
        	
        	while(nextDownVillage!=-1){
        	
        		newPathCost = newPathCost + costs[nextDownVillage];
            	
            	totalValues.put(x, newPathCost);
            	
            	startPoint = nextDownVillage;
            	
            	nextDownVillage = ifHasMultiple(costs, startPoint);
        		
        	}
        }
        
        Integer xx [] = totalValues.values().toArray(new Integer [totalValues.size()]);
        
        Arrays.sort(xx);
        
        System.out.println(xx[xx.length-1]);
	}
	
	public static int ifHasMultiple(Integer [] a, int index){
		
		int num = a [index];
		int hi = index-1;
		int low = 0;
		
		if(hi<0) return -1;
		
		while(hi>=0){
			
			if(num%a[hi]==0){
				return hi;
			}
			
			hi--;
		}
		
		return -1;
		
	}

}
