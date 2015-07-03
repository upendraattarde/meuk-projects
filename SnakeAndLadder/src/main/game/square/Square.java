package main.game.square;

import main.game.board.Board;
import main.game.player.Player;

import java.util.ArrayList;


public abstract class Square {

	private int ownPosition;
	private int transferFactor;
	private ArrayList<Player> players  ;
	private Board board ;
	 
	
	public Square(int ownPosition, Board board){
		this.ownPosition = ownPosition;
		this.board = board;
		this.players = new ArrayList<Player>();
	}
	
	public int getOwnPosition() {
		return ownPosition;
	}

	public void setOwnPosition(int ownPosition) {
		this.ownPosition = ownPosition;
	}

	 

	public int getTransferFactor() {
		return transferFactor;
	}

	public void setTransferFactor(int transferFactor) {
		this.transferFactor = transferFactor;
	}

	public Board getBoard() {
		return board;
	}

	public void setBoard(Board board) {
		this.board = board;
	}

	
	
	
	public abstract void transferTo(Player player);
	
	public void enter(Player player){
		players.add(player);
		player.setPosition(ownPosition); 
		player.setSquare(this); 
		System.out.println("Player "+player.getName()+" enterd to "+player.getCurrentPosition() );
		this.transferTo(player);
	}
	
	public void leave(Player player){
		players.remove(player);
	}

	public Square movePlayerTo(int move){
		int newPosition = this.ownPosition + move;
		if(newPosition > board.getBoardLength()){
			return board.getSquareAtPosition(board.getBoardLength());
		}
		
		return board.getSquareAtPosition(newPosition);
	};

	
	public boolean isLastSquare(){
		return this.ownPosition == board.getBoardLength();
	}
	
	
	
	
}
