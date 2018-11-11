package General.concepts.concurrency.Semaphores.atmRoom;

import java.util.ArrayList;
import java.util.concurrent.Semaphore;

public class AtmRoom {
	
	public static void main(String[] args) {
		
		Semaphore machines = new Semaphore(2);
		
		ArrayList<People> peopleInQueue = new ArrayList<>();
		
		peopleInQueue.add(new People(machines, "Chirag"));
		peopleInQueue.add(new People(machines, "Ram"));
		peopleInQueue.add(new People(machines, "Bharat"));
		peopleInQueue.add(new People(machines, "Laxman"));
		peopleInQueue.add(new People(machines, "Shatrughn"));
		
		peopleInQueue.stream().forEach(x -> new Thread(x).start());
	}

}


/*
  OUTPUT :
  
Chirag : Waiting to access ATM.
Chirag : Got access to ATM ------------->>>
Bharat : Waiting to access ATM.
Bharat : Got access to ATM ------------->>>
Ram : Waiting to access ATM.
Laxman : Waiting to access ATM.
Shatrughn : Waiting to access ATM.
Chirag : ATM Task complete +++
Bharat : ATM Task complete +++
Ram : Got access to ATM ------------->>>
Laxman : Got access to ATM ------------->>>
Ram : ATM Task complete +++
Laxman : ATM Task complete +++
Shatrughn : Got access to ATM ------------->>>
Shatrughn : ATM Task complete +++

 * 
 * 
 * */
