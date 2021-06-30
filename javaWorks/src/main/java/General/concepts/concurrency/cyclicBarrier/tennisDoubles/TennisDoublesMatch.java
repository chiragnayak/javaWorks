package General.concepts.concurrency.cyclicBarrier.tennisDoubles;

import java.util.ArrayList;
import java.util.concurrent.CyclicBarrier;

public class TennisDoublesMatch {
	
	public static void main(String [] args) {
		
		CyclicBarrier cb = new CyclicBarrier(4);
		
		ArrayList<TennisPlayer> players =new ArrayList<>();
		players.add(new TennisPlayer(cb, "Chirag"));
		players.add(new TennisPlayer(cb, "Ram"));
		players.add(new TennisPlayer(cb, "Bharat"));
		players.add(new TennisPlayer(cb, "Shatrughna"));
		
		players.stream().forEach(x -> new Thread(x).start());
	}

}
