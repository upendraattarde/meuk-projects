package main.game.square;

import main.game.board.Board;
import main.game.player.Player;

public class RegularSquare extends Square {

	
	
	
	public RegularSquare(int ownPosition, Board board) {
		super(ownPosition, board);
		 
		setTransferFactor(0); 
	}

	@Override
	public void transferTo(Player player) {
		// Do Nothing because its a regular Square
		System.out.println("This is Regular Square Do Nothing");
	}
	
	

}
