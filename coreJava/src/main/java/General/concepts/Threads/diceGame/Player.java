package General.concepts.Threads.diceGame;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Player implements Runnable{
	
	int [] diceNums = {1,2,3,4,5,6,6,5,4,3,2,1,1,1,2,3,4,3,5,6};
	
	int chances = 1;
	
	//lock, the one has it rolls the dice.
	static Object dice = new Object();
	
	//list to remember and toggle turns. 
	//in enhance version, we can have a map with (turn, Player)
	static ArrayList<Player> playerList = new ArrayList<>();
	//next position to play
	static int positionToPlay = 0;
	
	int id;
	
	public Player(int id) {
		this.id=id;
		playerList.add(this);
	}

	@Override
	public void run() {
		
		while(chances<=6) {
			
			synchronized (dice) {
				
				//if thread has lock, but is not the player who is to roll the dice, it has to wait for certain time and again check. 
				//we cannot use wait() here (i.e. without timeout, becuase in certain random cases, all three threads will enter wait
				//for infinite time. Hence, a timout, to give up the lock and try again to check condition after sometime (once notifyAll() is called from 
				//other thread)
				if(!playerList.get(positionToPlay).equals(this)) {
					try {
						System.out.println("Player "+id+" waiting ..");
						Player.dice.wait(500);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}else {
					//if thread is the player to roll the dice
					System.out.println("Chance : "+chances+" -> Player "+id+" : Rolling Dice !!... Got "+diceNums[ThreadLocalRandom.current().nextInt(0, diceNums.length)]);
					chances++;
					
					//if thread is the last player, need to toggle to first player. 
					if(playerList.indexOf(this)==(playerList.size()-1)) {
						positionToPlay=0;
					}else {
						
					//else pass of the dice (next player)
						positionToPlay++;
					}
					System.out.println("Player "+id+" -> Next to Play -> "+playerList.get(positionToPlay).id);
					Player.dice.notify();
				}
				
			}
		}
		
	}

}
