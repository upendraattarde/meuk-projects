package main;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import main.game.Game;


public class Main {

	public static void main(String args[]) throws IOException{
		
		String[] playerNames = getPlayers(); 
		
		if(playerNames==null){
			return;
		}
		int numSquares = 120;
		// for the user first square is at position 1 but
		// internally is at 0
		int[][] snakesFromTo = { {17,7},{87,24},{93,73},{99,78},{62,19},{64,60},{54,34} };
		int[][] laddersFromTo = { {4,14}, {9,31}, {28,84}, {51,67}, {40,59}, {63,81}, {71,91} };
		Game game = new Game(playerNames, snakesFromTo, laddersFromTo, numSquares);
		game.play();
	}
	
	public static String[] getPlayers() throws IOException{
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 String[] playerNames = new String[2];
		System.out.println("Enter how many players want to play ?");
		Integer totalPlayer = Integer.parseInt(br.readLine());
		if(isPlayersValid(totalPlayer)){
			switch (totalPlayer) {
			case 1:
				System.out.println("Enter Player Name: ");
				playerNames[0] = br.readLine();
				playerNames[1] = "Computer";
				
				break;
			case 2:
				System.out.println("Enter Player1 Name: ");
				playerNames[0] = br.readLine();
				System.out.println("Enter Player2 Name: ");
				playerNames[1] = br.readLine();
				break;
			default:
			     playerNames[0] = "Rafa";
			     playerNames[1] = "Roger";
				break;
			}
			
			return playerNames;
		}else{
			System.out.println("Maximum Two Players are allowed");
			return null;
		}
		
	}

	
	public static boolean isPlayersValid(Integer totalPlayer) {
		return	totalPlayer<=2 && totalPlayer >0;
	}
	
	
}
