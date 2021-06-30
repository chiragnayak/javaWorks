package General.hackerEarth.june18Challenges;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.TreeSet;

public class MinFruitCalorieCostCombi {
	
	public static void main(String[] args) throws IOException {
		
		//get total calorie
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int totalcalorie = Integer.parseInt(br.readLine().trim());  
        
        //get counts
        String fruitCount [] = br.readLine().split("\\s{1,}"); 
        int Cnt1 = Integer.parseInt(fruitCount[0].trim());
        int Cnt2 = Integer.parseInt(fruitCount[1].trim());
        int Cnt3 = Integer.parseInt(fruitCount[2].trim());
        
        //get costs
        String fruitCost [] = br.readLine().split("\\s{1,}"); 
        int Cst1 = Integer.parseInt(fruitCost[0].trim());
        int Cst2 = Integer.parseInt(fruitCost[1].trim());
        int Cst3 = Integer.parseInt(fruitCost[2].trim());
        
        //tree-set for sorted list (unique costs)
        TreeSet<Integer> costing = new TreeSet<>();
        
        for(int iCount1=0;iCount1<=Cnt1; iCount1++) {
        	
        	for(int iCount2=0;iCount2<=Cnt2; iCount2++) {
            	
        		for(int iCount3=0;iCount3<=Cnt3; iCount3++) {
        			
        			int cost = getCosting(totalcalorie, iCount1, Cst1, iCount2, Cst2, iCount3, Cst3);
        			
        			if(cost!=-1) {
        				costing.add(cost);
        			}
                }
            }
        }
        
        if(costing.size()>0) {
        	 Iterator<Integer> values = costing.iterator();
             while(values.hasNext()){
             	System.out.println(values.next());
             	break;
             }
        }else {
        	System.out.println("-1");
        }
        
       
	}

	private static Integer getCosting(int totalcalorie, int iCount1, int cst1, int iCount2, int cst2, int iCount3,
			int cst3) {
		
		int calorie = (iCount1*2) + (iCount2*3) + (iCount3*5);
		
		if(calorie==totalcalorie) {
			int totalCost = (iCount1*cst1) + (iCount2*cst2) + (iCount3*cst3);
			return totalCost;
		}else {
			return -1;
		}
	}



}
