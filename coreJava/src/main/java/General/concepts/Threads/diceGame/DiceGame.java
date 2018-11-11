package General.concepts.Threads.diceGame;

/**
 * 
 * Problem Statement: 
 * 
 * Assume that you need to implement a dice player game. This is a two player
game (say the players are �Joe� and �Jane�) where the players throw the dice on their turns. When
one player throws the dice, another player waits. Once the player completes throwing, he/she
informs the other player to play; after that, he/she starts waiting for the other player to throw the
dice. You need to implement these two players as two threads working together. The game ends after
each player throws 6 times (so there will be a total of 12 throws in the game).
 * 
 * @author cnayak
 *
 */
public class DiceGame {
	
	public static void main(String[] args) {
		
		Thread tP1 = new Thread(new Player(1));
		Thread tP2 = new Thread(new Player(2));
		Thread tP3 = new Thread(new Player(3));
		
		tP1.start();
		tP2.start();
		tP3.start();
	}

}
