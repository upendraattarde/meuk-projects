package main.game;

import main.game.board.Board;
import main.game.player.Player;
import main.game.square.Square;

import java.util.LinkedList;

public class Game {

	LinkedList<Player> players = new LinkedList<Player>();
	Board board = null;
	Player winner = null;
	
	public Game(){
		
	}
	
	public Game(String[] playerNames, int[][] snakes, int ladder[][], int totalSquares){
		makeBoard(totalSquares, ladder, snakes); 
		makePlayer(playerNames);
		
	}
	
	private void initPlayerPositions() {
		for(Player player:players){
		
			Square square = board.getSquareAtPosition(1);
			square.enter(player);
			
		}
	}

	private void makePlayer(String[] playerNames) {
		
		for(String name:playerNames){
			Player player = new Player(name);
			players.add(player);
		
			
		}
		
		
	}

	private void makeBoard(int numSquares, int ladder[][], int[][] snakes){
		board = new Board(numSquares, ladder, snakes);
	}
	
	private void movePlayer(int roll) {
		Player currentPlayer = players.remove(); // from the head 
		currentPlayer.move(roll); 
		players.add(currentPlayer); // to the tail
		if (currentPlayer.wins()) {
			winner = currentPlayer;
		}
	}
	 
	
	public void play () {
		
		Dice die = new Dice(); 
		initPlayerPositions();
	
		while (notOver()) {
			
		int roll = die.roll();
		System.out.println("Current player is " + currentPlayer()
		+ " and rolls " + roll);
		movePlayer(roll);
		 
		}
		System.out.println(winner + " has won."); }
	
	
	private Player currentPlayer() {
		
		return players.peek();
	}

	private boolean notOver() {
		// TODO Auto-generated method stub
		return winner==null;
	}

   // Dice is made public for test case as avoiding Reflection API 
	public final class Dice { 
		
		private static final int MINVALUE = 1;
		private static final int MAXVALUE = 6;
		// Dice roll returns random between 1 and 6
		public int roll () {
		 return random(MINVALUE ,MAXVALUE);
		}
		
		private int random(int min, int max) {
		
			return (int) (min + Math.round((max-min) * Math.random()));
			
		}
	}
	
}
