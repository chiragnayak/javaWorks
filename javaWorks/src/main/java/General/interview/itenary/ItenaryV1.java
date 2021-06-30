package General.interview.itenary;

public class ItenaryV1 {
	
	Ticket head;
	
	public boolean addTicket(Ticket t) {
		
		if(head == null){
			head = t;
			return true;
		}
		
		if(head.nextTicket==null){
			if(t.destination.equalsIgnoreCase(head.source)){
				t.nextTicket = head;
				head = t;
				return true;
			}else if(t.source.equalsIgnoreCase(head.destination)){
				head.nextTicket=t;
				return true;
			}
			
		}else{

			Ticket previous = null;
			Ticket current = head;
			Ticket next = head.nextTicket;
			
			while(current!=null){ 
			
				System.out.println("List Previous "+(previous!=null ? previous.toString() :"null")+" Current "+current.toString()+" Next : "+(next!=null ? next.toString() :"null"));
				if(t.destination.equalsIgnoreCase(current.source)){//inserting before
					
					if(previous!=null && previous.destination.equalsIgnoreCase(t.source)){
						t.nextTicket = current;
						previous.nextTicket=t;
						return true;
					}
					
				}else if(t.source.equalsIgnoreCase(current.destination)){ //inserting afterwards
					if(next!=null && next.source.equalsIgnoreCase(t.destination)){
						Ticket temp = current.nextTicket;
						current.nextTicket = t;
						t.nextTicket = temp;
						return true;
					}else if(next == null){
						current.nextTicket = t;
						return true;
					}
					
				}
				previous = current;
				current = current.nextTicket;
				if (current != null) {
					next = current.nextTicket;
				}
			}
		}
		
		return false;
	}
	
	public void printAll() {
		
		StringBuilder sb = new StringBuilder();
		
		if(head!=null){
			sb.append(head.toString());
			Ticket temp = head;
			while(temp.nextTicket!=null){
				sb.append(temp.nextTicket.toString());
				temp = temp.nextTicket;
			}
		}
		
		System.out.println(sb.toString());
	}

}
