package General;

/**
 * 
 * Story: The Berlin Clock

The Berlin Uhr (Clock) is a rather strange way to show the time. On the top of the clock there is a yellow lamp that blinks on/off every two seconds. The time is calculated by adding rectangular lamps.

The top two rows of lamps are red. These indicate the hours of a day. In the top row there are 4 red lamps. Every lamp represents 5 hours. In the lower row of red lamps every lamp represents 1 hour. So if two lamps of the first row and three of the second row are switched on that indicates 5+5+3=13h or 1 pm.

The two rows of lamps at the bottom count the minutes. The first of these rows has 11 lamps, the second 4. In the first row every lamp represents 5 minutes. In this first row the 3rd, 6th and 9th lamp are red and indicate the first quarter, half and last quarter of an hour. The other lamps are yellow. In the last row with 4 lamps every lamp represents 1 minute.

Meta:
@scope interview

Narrative:
    As a clock enthusiast
    I want to tell the time using the Berlin Clock
    So that I can increase then number of ways that I can read the time

Scenario: Midnight
When the time is 00:00:00
Then the clock should look like
Y
OOOO
OOOO
OOOOOOOOOOO
OOOO

Scenario: Middle of the afternoon
When the time is 13:17:01
Then the clock should look like
O
RROO --> each represent five hours each
RRRO --> each represent 1 hour each
YYROOOOOOOO --> 11 lamps, each represents 5 minutes

1	2	3		4	5	6		7	8	9		10	11
		first			second 			third
		quarter			quarter			quarter
		

YYOO --> 4 lamps, 1 minute each

Scenario: Just before midnight
When the time is 23:59:59
Then the clock should look like
O
RRRR
RRRO
YYRYYRYYRYY
YYYY

Scenario: Midnight
When the time is 24:00:00
Then the clock should look like
Y
RRRR
RRRR
OOOOOOOOOOO
OOOO


 * 
 * @author cnayak
 *
 */
public class BerlinClock {
	
	public static void main(String[] args) {
		
		showTime("23:59:59");
		showTime("24:00:00");
		showTime("13:17:01");
		showTime("00:00:00");
	}
	
	public static void showTime(String time) {

		StringBuilder clock = new StringBuilder();
		
		clock.append(getRowData(time, EnumRow.BLINKER));
		clock.append(getRowData(time, EnumRow.FIVE_HOURS));
		clock.append(getRowData(time, EnumRow.ONE_HOUR));
		clock.append(getRowData(time, EnumRow.FIVE_MINUTES));
		clock.append(getRowData(time, EnumRow.ONE_MINUTE));
		
		System.out.println("***************** BERLIN CLOCK FOR "+time+" ******************");
		System.out.println(clock.toString());
		System.out.println("*******************************************************************");	
	}
	
	public enum EnumRow {
		BLINKER,
		FIVE_HOURS,
		ONE_HOUR,
		FIVE_MINUTES,
		ONE_MINUTE,
	}
	
	public static String getRowData(String timeString, EnumRow rowId){
		
		String rowData = "ERROR";
		
		String [] R1_Y_O = new String []{"O"}; // odd "O" even "Y"	
		String [] R2 = new String []{"O","O","O","O"};     // each represent five hours each
		String [] R3 = new String []{"O","O","O","O"};     // --> each represent 1 hour each	
		String [] R4 = new String []{"O","O","O","O","O","O","O","O", "O","O","O"};    //--> 11 lamps, each represents 5 minutes, 3 (first), 6 (half), 9 (last)
		String [] R5 = new String []{"O","O","O","O"};     // --> 4 lamps, each represents 1 minutes
		
		String data [] = timeString.split(":");
		int hours = Integer.valueOf(data[0]);
		int minutes = Integer.valueOf(data[1]);
		int seconds = Integer.valueOf(data[2]);
		
		switch (rowId) {
		case BLINKER:
			if(seconds%2==0){
				R1_Y_O [0]="Y";
			}else{
				R1_Y_O [0]="O";
			}
			rowData = merge(R1_Y_O);
			break;
		case FIVE_HOURS:
			int count = hours/5;
			for(int i=0; i<count;i++){
				R2[i]="R";
			}
			rowData = merge(R2);
			break;
		case ONE_HOUR:
			int remaining = hours%5;
			for(int i=0; i<remaining;i++){
				R3[i]="R";
			}
			rowData = merge(R3);
			break;
		case FIVE_MINUTES:
			count = minutes/5;
			for(int i=0; i<count;i++){
				R4[i]="Y";
			}
			
			if(minutes==0){
				//do nothing
			}else if(minutes/15==1){
				R4[2]="R";
			}else if(minutes/15==2){
				R4[2]="R";
				R4[5]="R";
			}else if(minutes/15==3){
				R4[2]="R";
				R4[5]="R";
				R4[8]="R";
			}
			
			rowData = merge(R4);
			break;
		case ONE_MINUTE:
			remaining = minutes%5;
			for(int i=0; i<remaining;i++){
				R5[i]="Y";
			}
			rowData = merge(R5);
			break;

		default:
			rowData = "NOT_FOUND";
		}
		
		return rowData.concat("\n");
	}

	private static String merge(String[] array) {
		
		StringBuilder sb = new StringBuilder();
		for(int iCount=0; iCount<array.length; iCount++){
			sb.append(array[iCount]);
		}
		return sb.toString();
	}

}
