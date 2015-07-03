package main.game.board;

import main.game.square.LadderSquare;
import main.game.square.RegularSquare;
import main.game.square.SnakeSquare;
import main.game.square.Square;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class Board {

	private ArrayList <Square > squares = new ArrayList <Square >(); 
	
	public Board(int numSquares, int[][] ladders, int[][] snakes) {
	   
	     
			createBoard(numSquares, ladders, snakes);
	}
	
	
	private void createBoard(int numSquares, int[][] ladders, int[][] snakes) {
		  Map<Integer,Integer> ladersPosition = getLadders( ladders);
		  Map<Integer,Integer> snakePosition = getSnakes(snakes ); 
		
		for(int index = 0; index<numSquares; index++ ){
			int position = index+1;
			Square square = getSquareForIndex(position,ladersPosition,snakePosition);
			squares.add(square);
		}
		
	}


	private Square getSquareForIndex(int position,
			Map<Integer, Integer> ladersPosition,
			Map<Integer, Integer> snakePosition) {
		
		if(ladersPosition.containsKey(Integer.valueOf(position))){
			
			int tranfer = ladersPosition.get(Integer.valueOf(position)) - position;
			return new LadderSquare(position, this, tranfer);
			
		}else if(snakePosition.containsKey(Integer.valueOf(position))){
			
			int transfer = snakePosition.get(Integer.valueOf(position)) - position;
			return new SnakeSquare(position, this, transfer);
			
		}else{
			return new RegularSquare(position, this);
		}
		
	}


	private Map<Integer, Integer> getSnakes(int[][] snakes) {
		 Map<Integer,Integer> snakeMap = new HashMap<Integer,	Integer>();
			for(int index=0; index< snakes.length;index++ ){
				snakeMap.put(snakes[index][0], snakes[index][1]);
			}
			return snakeMap;
	}


	private Map<Integer, Integer> getLadders(int[][] ladders) {
		 Map<Integer,Integer> laddersMap = new HashMap<Integer,	Integer>();
		for(int index=0; index< ladders.length;index++ ){
			laddersMap.put(ladders[index][0], ladders[index][1]);
		}
		return laddersMap;
	}


	


	public Square getSquareAtPosition(int newPosition) {
		 
		return squares.get(newPosition-1);
		
	}
	
	public int getBoardLength(){
		return squares.size();
	}


	 

}
