package General.utils;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;

import javax.swing.JOptionPane;

public class MyUtils {
	

	
	public static boolean silentLogging = false;
	
	public static DecimalFormat ZERO_DECIMAL = new DecimalFormat("#");
	public static DecimalFormat ONE_DECIMAL = new DecimalFormat("#.#");
	public static DecimalFormat TWO_DECIMAL = new DecimalFormat("#.##");
	public static DecimalFormat THREE_DECIMAL = new DecimalFormat("#.###");
	
	public static boolean ifNptVerV6OrHigher = false;
	
	public static int loginTimeOut = 10000; // 10 seconds
	public static int readTimeOut = 100*1000; //100 seconds
	public static int maxReadLength = 50000;
	public static boolean sendCommandTerminatorAfterTimeOut = false;
	
	public static String defaultSeverIp = "NOT_SET";
	public static String defaultServerUsername = "NOT_SET";
	public static String defaultServerpassword = "NOT_SET";
	
	public static int defaultTimeInSecToSleepAfterLinkRepairAndTrafficCheck = 20;
	public static int defaultTimeInSecToSleepAfterLinkRepair = 10;
	public static int defaultTimeInSecToPlayTrafficBeforeAction = 10;
	public static int defaultTimeInSecBeforeAnyAction = 10;
	public static int defaultTimeInSecBeforeOperationalCommandCheck = 3;
	
	public static String BANNER = " NOTICE ";
	

	public static String[]  getDateAndTime() {

		GregorianCalendar c = new GregorianCalendar();
		int offset=0; // gmt offset
		int dst=0; // daylight saving time

		if (!(c.get(Calendar.ZONE_OFFSET)==2)) {
			offset = 2;
		}

		c.get(Calendar.DST_OFFSET);

		String shortDate[] =new String[6];
		String hourStr ="", minStr="", secStr="", dayStr="", monthStr=""; 

		int hour = c.get(Calendar.HOUR_OF_DAY);		    
		if (hour <10) 	hourStr =  "0" + (hour);
		else hourStr = "" + hour;

		int minute = c.get(Calendar.MINUTE);
		if (minute <10) 	minStr =  "0" + minute;
		else minStr = "" + minute;

		int second = c.get(Calendar.SECOND);
		if (second <10) 	secStr =  "0" + second;
		else secStr = "" + second;

		int month = c.get(Calendar.MONTH) + 1; // starting from 0
		if (month <10) 	monthStr =  "0" + month;
		else monthStr = "" + month;

		int day = c.get(Calendar.DAY_OF_MONTH);
		if (day <10) 	dayStr =  "0" + day;
		else dayStr = "" + day;

		shortDate[0] = dayStr;
		shortDate[1] = monthStr;
		shortDate[2] = ""+ c.get(Calendar.YEAR);
		shortDate[3] = hourStr;
		shortDate[4] = minStr;
		shortDate[5] = secStr;

		return shortDate;
	}
	
	/**
	 * 
	 * To search in a Array. if present return true. If not present return false.
	 * 
	 * @param value
	 * @param Array
	 * @return
	 * @throws Exception
	 */
	public static boolean linearSearch(Object value, Object[] Array)throws Exception {
		boolean ifFound = false;
		for (Object current : Array) {
			if (current.equals(value)) {
				ifFound = true;
				break;
			} else {
				ifFound = false;
			}
		}
		return ifFound;
	}
	
	/**
	 * 
	 * To search in a Array. if present return true. If not present return false.
	 * 
	 * @param value
	 * @param Array
	 * @return
	 * @throws Exception
	 */
	public static boolean linearSearch(int value, int[] Array)throws Exception {
		boolean ifFound = false;
		for (int current : Array) {
			if (current == value) {
				ifFound = true;
				break;
			} else {
				ifFound = false;
			}
		}
		return ifFound;
	}
	
	/**
	 * 
	 * To search in a Array. if present return true. If not present return false.
	 * 
	 * @param value
	 * @param Array
	 * @return
	 * @throws Exception
	 */
	public static boolean linearSearch(String value, String[] Array)throws Exception {
		boolean ifFound = false;
		for (String current : Array) {
			if (current.equalsIgnoreCase(value)) {
				ifFound = true;
				break;
			} else {
				ifFound = false;
			}
		}
		return ifFound;
	}
	
	
	public static void printCentreAlignedExceptionTraceOnConsole(StackTraceElement [] trace) {
		
		ArrayList<String> temp = new ArrayList<>();
		
		BANNER = " !!! EXCEPTION TRACE !!! ";
		
		for(StackTraceElement traceTemp : trace){
			temp.add(traceTemp.toString());
		}
		
		printCentreAlignedBannerOnConsole(temp, true, 1,false );
		
		BANNER = " NOTICE ";
	}
	
	public static void printCentreAlignedExceptionTraceOnGlobalLogger(StackTraceElement [] trace) {
		
		ArrayList<String> temp = new ArrayList<>();
		
		BANNER = " !!! EXCEPTION TRACE !!! ";
		
		for(StackTraceElement traceTemp : trace){
			temp.add(traceTemp.toString());
		}
		
		printCentreAlignedBanner(temp, true, 1,false );
		
		BANNER = " NOTICE ";
	}
	
	public static void printCentreAlignedBanner(String message) {
		
		ArrayList<String> temp = new ArrayList<>();
		
		temp.add(message);
		
		printCentreAlignedBanner(temp, false, -1,true );
	}
	
	public static void printCentreAlignedBanner(String [] messages) {
		
		ArrayList<String> temp = new ArrayList<>();
		
		for(String tempStr : messages){
			temp.add(tempStr.trim());
		}
		
		printCentreAlignedBanner(temp, false, -1,true );
	}
	
	public static void printCentreAlignedBanner(String message, boolean markGreen) {
		
		ArrayList<String> temp = new ArrayList<>();
		
		temp.add(message);
		
		printCentreAlignedBanner(temp, false, -1,markGreen );
	}
	
	public static void printCentreAlignedBanner(String message, boolean numbered, boolean markGreen) {
		
		ArrayList<String> temp = new ArrayList<>();
		
		for(String line : message.split("\\.")){
			temp.add(line);
		}
		
		printCentreAlignedBanner(temp, numbered, 1,markGreen );
	}
	
	public static void printCentreAlignedBanner(boolean markGreen, String... messages) {
		
		ArrayList<String> temp = new ArrayList<>();
		
		for(String message : messages){
			temp.add(message.trim());
		}
		
		printCentreAlignedBanner(temp, false, -1,markGreen );
	}
	
	public static void printCentreAlignedBanner(boolean numbered, boolean markGreen , int startNum, String... messages) {
		
		ArrayList<String> temp = new ArrayList<>();
		
		for(String message : messages){
			temp.add(message.trim());
		}
		
		printCentreAlignedBanner(temp, numbered, startNum, markGreen);
	}
	
	public static void printCentreAlignedBanner(ArrayList<String> messages, boolean markGreen) {
		printCentreAlignedBanner(messages, false, -1, markGreen);
	}
	
	public static void printCentreAlignedBanner(ArrayList<String> messages, boolean numbered, int startNum, boolean markGreen) { 
		
		int lineLmit = 100;
		int margin = 5;
		int tempNum = startNum;
		
		StringBuilder line = new StringBuilder();
		
		if(numbered){
			line.append("("+(startNum++)+") ");
		}
		
		ArrayList<StringBuilder> paras = new ArrayList<>();
		
		for(String message : messages) {
			
			message = message.trim();
			
			for(String word : message.split("\\s")){
				
				StringBuilder currentState = new StringBuilder(line.toString());
				
				line.append(word+" ");
				
				int remaining = lineLmit - line.length();
				
				if(remaining < margin){
					paras.add(currentState);
					line=new StringBuilder();
					line.append(word+" ");
				}
			}
			
			paras.add(line);
			paras.add(new StringBuilder(""));
			line=new StringBuilder();
			if(numbered){
				line.append("("+startNum+++") ");
			}
		}
		
		String title = " "+BANNER+" ";
		
		int totalLength = lineLmit+20;
		
		StringBuffer titleSpaces = new StringBuffer();
		for(int iSpaces=0;iSpaces<((totalLength/2)-(title.length()/2)); iSpaces++){
			titleSpaces.append("=");
		}
		String finaltitle = "["+titleSpaces+ title + titleSpaces+" ]";
		
		int finalTitleLen = finaltitle.length();
		
		StringBuffer blankLine = new StringBuffer();
		for(int iCount=2;iCount<finaltitle.length();iCount++){
			blankLine.append(" ");
		}
		
		/* NO BLANK LINE 
		 * 
		 * GlobalLogger.logInfoMessage("[" + blankLine.toString() + "]","",markGreen);
		 * 
		 * */
		
		for(StringBuilder cutLine : paras){
			
			String message= cutLine.toString();
			
			if(message.trim().length()==0){
				continue;
			}
			
			StringBuffer messsageSpaces = new StringBuffer();
			for(int iSpaces=0;iSpaces<((totalLength/2)-(message.length()/2)); iSpaces++){
				messsageSpaces.append(" ");
			}
			
			String finalMessage = messsageSpaces+ message + messsageSpaces;
			
			int diff = finalTitleLen - finalMessage.length();
			if(diff > 0){
				for(int x = 0;x<(diff-2);x++){
					 finalMessage= finalMessage+" ";
				}
			}

			finalMessage = "["+finalMessage+"]";
			
		}
		
		/* NO BLANK LINE 
		 * GlobalLogger.logInfoMessage("[" + blankLine.toString() + "]","",markGreen);
		 */
		
		//by default redirect to console
		printCentreAlignedBannerOnConsole(messages,  numbered,  tempNum,  markGreen);
	}
	
public static void main(String[] args) {
		
//		String message = "This is your Error Message. Just a Print. No cascade";
//		MyUtils.printErrorMessage(message);
//		
//		message = "Small One";
//		printErrorMessage(message);
		
//		String listStr [] = {"Chirag", "Nayak", "G B ROAD", "THANE"};
//		
//		System.out.println(convertToStringRepresentation(listStr));
	
		printCentreAlignedBanner("Enable IGP (OSPFv2 and OSPFv3) between R1, R2, R3 and verify OSPFv2 and OSPFv3 are up.Enable LDP between R1, R2, R3 and verify LDP is up.R1 is DUT.R1P1 and R2P1 are vlan tagged port.", true, true);
	
		String xxx = "The file ACL_CONFIG_Site-2_1200i_With_AmxePorts.xml was saved in C:\\Users\\cnayak\\Desktop\\configFiles\\ACL_CONFIG_Site-2_1200i_With_AmxePorts.xml S A V E D";
		
		printCentreAlignedBannerOnConsole(xxx, true);
		
	
		String substep1 = "Configure PE-B as Local RP for Group = 224.0.10.0/24 & Configure Static RP at PE-A & PE-C";
		String substep2 = "Send the IGMP Join for Group � G1 = 224.0.10.1 from Hosts towards PE-C & check that *,G1 entry is formed in Database (run show igmp group detail)";
		String substep3 = "Check *,G1 entry is formed in PIM Database at PE-C & PE-B (run show pim join detail) ";
		
		printCentreAlignedBanner(true,new String []{substep1, substep2, substep3}); // unnumbered
		printCentreAlignedBanner(false,new String []{substep1, substep2, substep3}); // unnumbered
		printCentreAlignedBanner(true, false, 1, new String []{substep1, substep2, substep3}); // numbered

		
		ArrayList<String> list  = new ArrayList<>();
		list.add("Configure PE-B as Local RP for Group = 224.0.10.0/24 & Configure Static RP at PE-A & PE-C");
		list.add("Send the IGMP Join for Group � G1 = 224.0.10.1 from Hosts towards PE-C & check that *,G1 entry is formed in Database (run show igmp group detail");
		list.add("Check *,G1 entry is formed in PIM Database at PE-C & PE-B (run show pim join detail) ");
		printCentreAlignedBanner(list, true);
		printCentreAlignedBanner(list,true,20, false);
		printCentreAlignedBanner(list,false,-1, true);
		
	}

public static void printCentreAlignedBannerOnConsole(String message) {
	
	ArrayList<String> temp = new ArrayList<>();
	
	temp.add(message);
	
	printCentreAlignedBannerOnConsole(temp, false, -1,true );
}

public static void printCentreAlignedBannerOnConsole(String [] messages) {
	
	ArrayList<String> temp = new ArrayList<>();
	
	
	for(String tempStr : messages){
		temp.add(tempStr);
	}
	
	printCentreAlignedBannerOnConsole(temp, false, -1,true );
}

public static void printCentreAlignedBannerOnConsole(String message, boolean markGreen) {
	
	ArrayList<String> temp = new ArrayList<>();
	
	temp.add(message);
	
	printCentreAlignedBannerOnConsole(temp, false, -1,markGreen );
}

public static void printCentreAlignedBannerOnConsole(boolean markGreen, String... messages) {
	
	ArrayList<String> temp = new ArrayList<>();
	
	for(String message : messages){
		temp.add(message);
	}
	
	printCentreAlignedBannerOnConsole(temp, false, -1,markGreen );
}

public static void printCentreAlignedBannerOnConsole(boolean numbered, boolean markGreen , int startNum, String... messages) {
	
	ArrayList<String> temp = new ArrayList<>();
	
	for(String message : messages){
		temp.add(message);
	}
	
	printCentreAlignedBannerOnConsole(temp, numbered, startNum, markGreen);
}

public static void printCentreAlignedBannerOnConsole(ArrayList<String> messages, boolean markGreen) {
	printCentreAlignedBannerOnConsole(messages, false, -1, markGreen);
}

public static void printCentreAlignedBannerOnConsole(ArrayList<String> messages, boolean numbered, int startNum, boolean markGreen) { 
	
	int lineLmit = 100;
	int margin = 5;
	
	StringBuilder line = new StringBuilder();
	
	if(numbered){
		line.append("("+startNum+++") ");
	}
	
	ArrayList<StringBuilder> paras = new ArrayList<>();
	
	for(String message : messages) {
		
		message = message.trim();
		
		for(String word : message.split("\\s")){
			
			StringBuilder currentState = new StringBuilder(line.toString());
			
			line.append(word+" ");
			
			int remaining = lineLmit - line.length();
			
			if(remaining < margin){
				paras.add(currentState);
				line=new StringBuilder();
				line.append(word+" ");
			}
		}
		
		paras.add(line);
		paras.add(new StringBuilder(""));
		line=new StringBuilder();
		if(numbered){
			line.append("("+startNum+++") ");
		}
	}
	
	String title = " "+BANNER+" ";
	
	int totalLength = lineLmit+20;
	
	StringBuffer titleSpaces = new StringBuffer();
	for(int iSpaces=0;iSpaces<((totalLength/2)-(title.length()/2)); iSpaces++){
		titleSpaces.append("=");
	}
	String finaltitle = "["+titleSpaces+ title + titleSpaces+" ]";
	
	int finalTitleLen = finaltitle.length();
	
	StringBuffer blankLine = new StringBuffer();
	for(int iCount=2;iCount<finaltitle.length();iCount++){
		blankLine.append(" ");
	}
	
	if(markGreen){
		System.out.println(finaltitle);
		/*System.out.println("[" + blankLine.toString() + "]");*/
	}else{
		System.err.println(finaltitle);
		/*System.err.println("[" + blankLine.toString() + "]");*/
	}
	
	
	for(StringBuilder cutLine : paras){
		
		String message= cutLine.toString();
		
		if(message.trim().length()==0){
			continue;
		}
		
		StringBuffer messsageSpaces = new StringBuffer();
		for(int iSpaces=0;iSpaces<((totalLength/2)-(message.length()/2)); iSpaces++){
			messsageSpaces.append(" ");
		}
		
		String finalMessage = messsageSpaces+ message + messsageSpaces;
		
		int diff = finalTitleLen - finalMessage.length();
		if(diff > 0){
			for(int x = 0;x<(diff-2);x++){
				 finalMessage= finalMessage+" ";
			}
		}

		finalMessage = "["+finalMessage+"]";
		
		if(markGreen){
			System.out.println(finalMessage);
		}else{
			System.err.println(finalMessage);
		}
		
		
	}
	
	if(markGreen){
		/*System.out.println("[" + blankLine.toString() + "]");*/
		System.out.println("["+finaltitle.trim().replaceAll("[\\[\\]]+", "").replaceAll(".", "=")+ "]");
	}else{
		/*System.err.println("[" + blankLine.toString() + "]");*/
		System.err.println("["+finaltitle.trim().replaceAll("[\\[\\]]+", "").replaceAll(".", "=")+ "]");
	}
	
	
	
}
	
	public static void printErrorMessage(String message, boolean sendToConsoleAsWell) {
		
		String title = " ERROR MESSAGE - NO CASCADE ";
		
		int totalLength = message.length()+10;
		
		if(totalLength < title.length()){
			totalLength = message.length()+title.length()+20;
		}
		
		
		StringBuffer messsageSpaces = new StringBuffer();
		for(int iSpaces=0;iSpaces<((totalLength/2)-(message.length()/2)); iSpaces++){
			messsageSpaces.append(" ");
		}
		String finalMessage = "NOT_SET";

		if(totalLength%2==0){
			finalMessage = "["+messsageSpaces+ message + messsageSpaces+" ]";
		}else{
			finalMessage = "["+messsageSpaces+ message + messsageSpaces+"]";
		}
		
		
		StringBuffer titleSpaces = new StringBuffer();
		for(int iSpaces=0;iSpaces<((totalLength/2)-(title.length()/2)); iSpaces++){
			titleSpaces.append("=");
		}
		String finaltitle = "["+titleSpaces+ title + titleSpaces+" ]";
		
		
		
		StringBuffer blankLine = new StringBuffer();
		for(int iCount=2;iCount<finalMessage.length();iCount++){
			blankLine.append(" ");
		}
		
		System.err.println(finaltitle);
		System.err.println("[" + blankLine.toString() + "]");
		System.err.println(finalMessage);
		System.err.println("[" + blankLine.toString() + "]");
		System.err.println("["+finaltitle.trim().replaceAll("[\\[\\]]+", "").replaceAll(".", "=")+ "]");
		
		
	}
	
	
	public static void sleep(long value, EnumTimeUnit unit) {
		
		try {

			switch (unit) {
			case HOUR:
				MyUtils.printMessage("SLEEP FOR "+value+" HOURS");
				TimeUtils.delay(value*60*60);
				break;
			case MINUTES:
				MyUtils.printMessage("SLEEP FOR "+value+" MINUTES");
				TimeUtils.delay(value*60);
				break;
			case SECONDS:
				MyUtils.printMessage("SLEEP FOR "+value+" SECONDS");
				TimeUtils.delay(value);
				break;
			case MILLISEC:
				MyUtils.printMessage("SLEEP FOR "+value+" MILLI-SECONDS");
				TimeUtils.delay(value/1000);
				break;

			default:
				break;
			}
			
		}catch (Throwable e){
			 MyUtils.printCentreAlignedExceptionTraceOnConsole(e.getStackTrace());
		}
		
	}
	
	public enum EnumTimeUnit {
		HOUR,
		MINUTES,
		SECONDS,
		MILLISEC;
	}
	
	public enum EnumEmbProtocolDelay{
		
		ISIS(35), 
		ISISHoldTimer(30),
		OSPF_PTP(15),
		OSPF_BROADCAST(35),
		LDP(25), 
		PIM(15), 
		BGP(35), 
		IGMP(15),
		DHCP(20),
		GENERIC(10);
		
		int delay;
		
		EnumEmbProtocolDelay(int delay){
			this.delay=delay;
		}

		public int getDelay() {
			return delay;
		}

		public void setDelay(int delay) {
			this.delay = delay;
		}
		
	}
	
	public static int getTotalProtocolDelay(EnumEmbProtocolDelay... protocolList){
		
		int totalDelay = 0;
		
		StringBuilder sb = new StringBuilder("Add Delay for : ");
		
		for(EnumEmbProtocolDelay protocol : protocolList){
			totalDelay = totalDelay+protocol.getDelay();
			sb.append("[ "+protocol.toString()+" : "+protocol.getDelay()+" ]");
		}
		
		sb.append("  =  TOTAL : "+totalDelay+" seconds");
		
		printMessage(sb.toString());
		
		return totalDelay;
	}
	
	public static  <T> String convertToStringRepresentation( T list) {
		
		StringBuilder sb = new StringBuilder();
		
		sb.append("[");
		
		if(list instanceof ArrayList){
			
			Iterator<T> xx = ((ArrayList) list).iterator();
			
			while(xx.hasNext()){
				sb.append((xx.next().toString()+", "));
			}
			
			sb.append("]");
			
			return sb.toString();
			
		}else if(list instanceof String []){

			String temp [] = (String []) list;
			
			for(String xx : temp){
				sb.append((xx+", "));
			}
			
			sb.append("]");
			
			return sb.toString();
			
		} else if(list instanceof int []){

			int temp [] = (int []) list;
			
			for(int xx : temp){
				sb.append((xx+", "));
			}
			
			sb.append("]");
			
			return sb.toString();
			
		} else{
			
			Object temp [] = (Object []) list;
			
			for(Object xx : temp){
				sb.append((xx.toString()+", "));
			}
			
			sb.append("]");
			
			return sb.toString();
		}
		
	}

	public static String makeItFlat(String string) {
		
		StringBuilder sb = new StringBuilder();
		
		for(String line : string.split("\\n")){
			sb.append(line.trim().replace(",", " ")+" <NEWLINE> ");
		}
		
		return sb.toString();
		
	}
	
	public static void pauseTest(String message){
		JOptionPane.showMessageDialog(null,  message);
	}
	
	public static void printMessage(String message) {
		
		message = message.trim();
		
		System.out.println("--- INFO --> "+message);
		
	}

}
