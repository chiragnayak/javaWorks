package General.concepts.collections.queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class CircularQUsingArray {
	
	public static int Q [] ;
	
	public static int head = 0;
	
	public static int tail = 0;
	
	public static ArrayList<String> processStack = new ArrayList<>();
	
	public static int step =0;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int option = 100;
		while(option!=5) {
			
			System.out.println("-------------------------");
			System.out.println("---------- MENU ---------");
			System.out.println("-------------------------");
			System.out.println("1. Add Element to Q (EN-Q)");
			System.out.println("2. Delete Element to Q (D-Q)");
			System.out.println("3. Print Q");
			System.out.println("4. Resize/Set-Size Q");
			System.out.println("5. Exit");
			
			if(Q==null) {
				
				option = 4;
				
			}else {
				String input= br.readLine().trim();
				if(input.trim().length()!=0) {
					option = Integer.parseInt(input); 
				}else {
					option = 1111;
				}
			}
			
			String stepName = "NOT_SET";
			
			switch (option) {
			case 1:
				stepName = "EN-Q : ";
				System.out.println(stepName);
				int element = Integer.parseInt(br.readLine().trim()); 
				en_Q(element);
				break;
			case 2:
				stepName = "D-Q -> Element Removed : ";
				System.out.println(stepName+d_q());
				break;
			case 3:
				stepName = "Print Q";
				printQ(true);
				break;
			case 4:
				stepName = "Size of Q : ";
				System.out.println(stepName);
				int size = Integer.parseInt(br.readLine().trim()); 
				if(Q!=null) {
					int qLen = Q.length;
					if(qLen > size) {
						System.err.println(" !! ERROR OLD LEN > NEW LEN !! ");
					}else if(qLen==size) {
						System.out.println(" !! ERROR OLD LEN = NEW LEN, NOT CHANGE !! ");
					}else {
						
						int new_Q [] = new int[size];
						
						//initialize them to -1
						for(int x = 0; x< new_Q.length; x++) {
							new_Q[x] = -1;
						}
						
						//copy values index to index
						for(int x = 0; x< Q.length; x++) {
							new_Q[x] = Q[x];
						}
						
						Q = new_Q;
					}
				}else {
					Q = new int [size];
					//initialize all to -1
					for(int x = head; x< Q.length; x++) {
						Q[x] = -1;
					}
				}
				break;
			case 5:
				stepName = "EXIT";
				System.out.println( "+++++++++++++ BYE ++++++++++++");
				break;

			default:
				System.err.println(" !! ENTER CORRECT OPTION !! <1 .. 5>");
				break;
			}
			
			processStack.add("Step : "+step+++" "+stepName+" -> Option : "+option+" -> Q : "+printQ(false));
			
		}
		
		for(String x : processStack) {
			System.out.println(x);
		}
		
	}

	private static String printQ(boolean print) {
		
		
		StringBuilder sb = new StringBuilder();
		
		//start from head (wherever it is)
		int pos = head;
		
		//if head is != tail, only case : 0,0 (start pos)
		if(head!=tail) {
			do {
				// if -1 do not print
				if (Q[pos] != -1) {
					sb.append(Q[pos] + " ");
				}
				
				//increment position
				pos++;
				
				//if position is eq to q length and tail is somewhere before head (circular thing happened)
				//reset the pos to 0 and start iterating till it reaches tail
				if (pos == (Q.length) && (tail < Q.length - 1)) {
					pos = 0;
					if (Q[pos] != -1) {
						sb.append(Q[pos] + " ");
					}
				}
				
			} while (pos != tail); //iterate till pos reaches (or matches) tail, whereever tail is
		}else {
			//print position 0 if it is there
			if (Q[pos] != -1) {
				sb.append(Q[pos] + " ");
			}
		}
		//display queue
		if(print) {
			System.out.println("Your Queue : [START] "+sb.toString()+" [END]");
		}
		
		return sb.toString();
	}

	private static int d_q() {
		
		if(head==tail) { //if only 1 is in queue, and that is being deleted.
			int temp = Q[head];
			 Q[head] = -1;
			return temp;
			
		}else {
			int temp = Q[head];
			 Q[head] = -1;
			 //re-position head
			head++;
			if(head==Q.length) { //revert head to start if it crosses q capacity length
				head=0;
				
				if(tail==Q.length) {
					tail=0; //to cover case, when all is removed (head resets) from a full queue, in one go, then we need to reset the tail as well 
				}
			}
			return temp;
		}
		
		
	}

	private static void en_Q(int element) {

		/*
		 * First analogy draft : (actual implementation differs w.r.t debugging and cases)
		 * 
		 * if head is at START
		 * 	 if tail < (qLen -1)
		 * 	 	add element at tail pos
		 * 		tail++
		 	 else
		 	 	mess -> q full
		  else
		  	  if tail QLen-1
		  	  	add element at START
		  	  	tail = START
		  	  if tail < head-1
		  	    add element at tail pos
		 * 		tail++
		  	  else
		 	 	mess -> q full

		 * 
		*/
		
		
		if(head==0) {
			//for cases where head is at start  (i.e. = 0)
			
			if(tail <= (Q.length-1)) { // -> if circular thing has not happened, usual case (simplest)
				Q[tail]=element;
				tail++;
			}else if (tail== (Q.length)){ // -> tail reached beyond q length, head is still 0, no free space, error
				System.err.println("Case Err.1 -> Q IS FULL !!");
			}else {
				//to have some missing case
				System.out.println("head "+head+" -> tail "+tail);
				System.out.println(">> THIS IS SOMETHING NEW");
			}
			
		}else { //circular cases
			if(tail== (Q.length)) {//tail has crossed length, reset it to zero as head has moved, there is free space
				tail = 0;
				Q[tail]=element;
			}else if(tail < (head-1)) { //fill if tail < head-1, you cannot fill on head
				Q[tail]=element;
				tail++;
			}else {
				System.err.println("Case Err.2 -> Q IS FULL !!");
			}
			
		}
	}

}
