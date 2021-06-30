package General;

import java.util.ArrayList;

/**
 * @author cnayak (325408)
 *
 */
public class UdemyChallenge2LightBulb {
	
	
	public static void main(String[] args) {
		
		int numbefOfLightBulbs = 1500;
		int numberOfPhases = 1500;
		
		String BULBS [] = new String [numbefOfLightBulbs];
		
		//Switch on the bulbs, Phase 1
		for(int iCount=0; iCount<numbefOfLightBulbs; iCount++){
			BULBS[iCount] = "ON";
		}
		print(1, BULBS);
		
		//Phase iPhase
		for(int iPhase = 2; iPhase<=numberOfPhases; iPhase++){
			//switch off the bulbs
			for(int iCount=0; iCount<(numbefOfLightBulbs/iPhase);iCount++){
				int position = iPhase*(iCount+1)-1;
				//FLIP STATE OF BULB AT POSITION
				if(BULBS[position].equalsIgnoreCase("OFF")){
					BULBS[position] = "ON";
				}else{
					BULBS[position] = "OFF";
				}
			}
			print(iPhase, BULBS);
		}
		
		ArrayList<String> listOfBulbsRemainOn = new ArrayList<>();
		for(int iCount=0;iCount<BULBS.length;iCount++){
			if(BULBS[iCount]=="ON"){
				listOfBulbsRemainOn.add("BULB #"+(iCount+1));
			}
		}
		
		System.out.println("\n\nAfter last round ["+listOfBulbsRemainOn.size()+" ] bulbs positioned as "+listOfBulbsRemainOn+" bulb remains ON.");
	}
	
	public static void print(int round, String [] bulbs){
		System.out.print("ROUND "+round+" => ");
		for(int iCount = 0;iCount<bulbs.length; iCount++){
			System.out.print((iCount+1)+":"+bulbs[iCount]+",");
		}
		System.out.println("");
	}

}
