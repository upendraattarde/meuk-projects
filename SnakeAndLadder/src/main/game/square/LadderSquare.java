package main.game.square;

import main.game.board.Board;
import main.game.player.Player;

public class LadderSquare extends Square {
	
 
	

	public LadderSquare(int ownPosition, Board board, int transfer) {
		super(ownPosition, board);
		setTransferFactor(transfer); 
	}

	@Override
	public void transferTo(Player player) {
		
		//find and transform to another location 
		System.out.println("Hey you are on ladder now go top of the ladder");
		player.move(getTransferFactor()); 
		
	}

	

}
