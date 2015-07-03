package test.game;

import static org.junit.Assert.*;
import main.Main;
import main.game.Game;

import org.junit.Test;

public class SnakeLadderTestCase {

// Check Roll if Between 1 to 6
// Check 2 Roll to make sure probability	
	@Test
	public void testDiceRoll() {
		Game.Dice dice = new Game().new Dice();
		int roll1 = dice.roll();
		int roll2 = dice.roll();
		
		assertTrue(roll1<= 6 && roll1>=1 && roll2>=1 && roll2<=6);
		
	}
	
	
	@Test
	public void testisPlayersValid(){
		int totalPlayer1 = 2;
		int totalPlayer2 = 3;
		
		assertTrue(Main.isPlayersValid(totalPlayer1));
		assertFalse(Main.isPlayersValid(totalPlayer2));
	}

}
