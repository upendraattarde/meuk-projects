package main.game.square;

import main.game.board.Board;
import main.game.player.Player;

public class SnakeSquare extends Square {
	
	
	

	public SnakeSquare(int ownPosition, Board board,int transfer) {
		super(ownPosition, board);
		setTransferFactor(transfer);
	}

	@Override
	public void transferTo(Player player) {
		
		//find and transform to another location
		System.out.println("Hey you are in snake mouth, Now got to tail");
		player.move(getTransferFactor()); 
		
		
	}

	

}
