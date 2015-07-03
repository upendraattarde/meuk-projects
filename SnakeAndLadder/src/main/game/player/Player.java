package main.game.player;

import main.game.square.Square;

public class Player {

	private int currentPosition ;
	private String name ;
	private Square square;
	private boolean isWinner = false;
	
	public Player(String name){
		this.name = name;
		
	}
	
	
	public int getCurrentPosition() {
		return currentPosition;
	}

	public void setCurrentPosition(int currentPosition) {
		this.currentPosition = currentPosition;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Square getSquare() {
		return square;
	}

	public void setSquare(Square square) {
		this.square = square;
	}

	
	
	public void move(int move){
		square.leave(this);
		square = square.movePlayerTo(move);
		
		square.enter(this); 
		if(square.isLastSquare()){
			System.out.println("Cant Move Forward Because Its Last Square");
			this.isWinner = true;
		}
	}
	
	public void setPosition(int currentPosition){
		this.currentPosition = currentPosition;
	}
	
	public int getPosition(){
		return this.currentPosition;
	}
	
	public boolean wins(){
		return this.isWinner;
	}
	
	public String toString(){
		return "Name: "+this.name+" at position "+this.currentPosition;
		
	}
	
}
