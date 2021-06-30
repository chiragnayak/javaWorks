package General.interview.itenary;

public class Ticket {
	
	String source;
	String destination;
	
	Ticket nextTicket; //ideally it should be there.
	
	public Ticket(String s, String d) {
		source = s;
		destination = d;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		sb.append("["+this.source+"->"+this.destination+"]");
		
		return sb.toString();
	}
}
