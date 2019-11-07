package General.interview.itenary;

import java.util.ArrayList;

public class ItenaryClient {
	
	public static void main(String[] args) {
		
		ArrayList<Ticket> processMe = new ArrayList<>();
		processMe.add(new Ticket("Mumbai", "Pune"));
		processMe.add(new Ticket("Hongkong", "Delhi"));
		processMe.add(new Ticket("Pune", "Patna"));
		processMe.add(new Ticket("Delhi", "Indore"));
		processMe.add(new Ticket("Patna", "Delhi"));
		processMe.add(new Ticket("Indore", "Hongkong"));
		processMe.add(new Ticket("Delhi", "Kolkata"));
		
		/*	processMe.add(new Ticket("Mumbai", "Pune"));
		processMe.add(new Ticket("Pune", "Patna"));
		processMe.add(new Ticket("Patna", "Delhi"));
		processMe.add(new Ticket("Delhi", "Mumbai"));*/
		
		ItenaryV1 it = new ItenaryV1();
		
		while(processMe.size()!=0){
			ArrayList<Ticket> pending = new ArrayList<>();
			for(Ticket t : processMe){
				System.out.print("try : "+t.toString());
				if(!it.addTicket(t)){
					pending.add(t);
					System.out.println("..nope");
				}else{
					System.out.println("");
				}
			}
			
			System.out.println("-------");
			it.printAll();
			
			processMe = pending;
		}
		
		it.printAll();
	}

}
