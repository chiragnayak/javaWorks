package General.concepts.Threads.printNumbersByNThreads;

public class NumberManager {

	int num;
	int maxPlayers;
	int nextPosition = 1;

	/**
	 * @param num : number to start with
	 * @param maxPlayers : max players (representing number of thread it can handle for relevant result)
	 */
	public NumberManager(int num, int maxPlayers) {
		this.num = num;
		this.maxPlayers=maxPlayers;
	}

	public synchronized boolean incrementAndPrint(int position) {
		if (nextPosition == position) {
			
			System.out.println("T-"+nextPosition+" -> "+num);
			
			num++;
			nextPosition++;
			
			if(nextPosition==(maxPlayers+1)){
				nextPosition=1;
			}
			
			return true;

		}else{
			notifyAll();
			return false;
		}
	}
}
