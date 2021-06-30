package General;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

/******************************************************************************
 * 
 * Online Java Compiler. Code, Compile, Run and Debug java program online. Write
 * your code in this editor and press "Run" button to execute it.
 * 
 *******************************************************************************/

public class Tickets {
	public static void main(String[] args) {

		List<Integer> xxx = new ArrayList<>();
		xxx.add(2);
		xxx.add(3);
		xxx.add(1);
		xxx.add(2);
		waitingTime(xxx, 2);
	}

	public static long waitingTime(List<Integer> tickets, int p) {
		// Write your code here

		HashMap<Integer, Integer> map = new HashMap<>();
		int position = 1;
		for (Integer tkt : tickets) {
			map.put(position, tkt);
			position++;
		}

		int time = p;
		int remaining = map.get(p)-1;
		
		System.out.println("Time : "+time);
		System.out.println("Remaining : "+remaining);
		
		for (Entry<Integer, Integer> kv : map.entrySet()) {
			
			int pos = kv.getKey();
			int val = kv.getValue();
			
			int req = remaining-val;
			
			if(req==0){
				time++;
			}else if (req>=1){
				time = time + req;
			}
			
		}
		return position;
	}

}
