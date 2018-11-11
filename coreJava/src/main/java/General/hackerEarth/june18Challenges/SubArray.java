package General.hackerEarth.june18Challenges;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeSet;

public class SubArray {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String test = br.readLine();       
        
        
        String counts [] = br.readLine().trim().split("\\s{1,}");   
        
        int N_length = Integer.parseInt(counts[0]);
        int M = Integer.parseInt(counts[1]);
        
        
        Integer array [] = getInts(br.readLine());
        
        TreeSet<Integer> subArraysAndSum = new TreeSet<>();
        
        for(int L=0; L < array.length; L++) {
        	 for(int R=L; R < array.length; R++) {
        		 subArraysAndSum.add(getSum(array, L, R));
             }
        }
        
        Iterator<Integer> values = subArraysAndSum.iterator();
        while(values.hasNext()){
        	System.out.println("-->"+values.next());
        }
        
        int i = 0;
       // Iterator<Integer> 
        values = subArraysAndSum.iterator();
        while(values.hasNext()){
        	if(i==M) {
        		System.out.println(values.next());
        		break;
        	}
        	values.next();
        	i++;
        }
	}
	
	private static Integer getSum(Integer[] array, int l, int r) {
		
		int sum = 0;
		
		for(int iCount=l; iCount<=r; iCount++) {
			sum = sum+array[iCount];
		}
		
		int ret = sum*sum;
		
		System.out.println(l+","+r+"-"+ret);
		
		return ret;
	}

	public static Integer [] getInts(String string) {
		
		String [] data = string.trim().split("\\s{1,}");
		
		ArrayList<Integer> xx = new ArrayList<>();  
		
		for(int iCount = 0; iCount<data.length;iCount++) {
			if(data[iCount].trim().length()!=0) {
				xx.add(Integer.parseInt(data[iCount].trim()));
			}
		}
		return xx.toArray(new Integer [xx.size()]);
		
	}

}
