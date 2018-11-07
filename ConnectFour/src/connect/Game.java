package connect;

import java.util.ArrayList;
import java.util.Scanner;

public class Game {
	Board board= new Board();
	private boolean noWinner=true;
	ArrayList<Player> players= new ArrayList<Player>();
	Scanner scan= new Scanner(System.in);
	
	public void start(){
		Player tempPlayer;
		initPlayers();
		while(noWinner) {
			board.displayBoard();
			playDisk();
			tempPlayer=players.remove(0);
			players.add(tempPlayer);
		}
	}
	
	public void playDisk() {
		int col;
		boolean dropped;
		
		do {
		col=getInput()-1;
		if(board.isFull()) {
			System.out.println("Full board! Exit the game");
			return;
		}
		dropped=board.dropDisk(col, players.get(0).playDisk());
		if(!dropped) System.out.println("Pick a valid row");
		}while(!dropped);
		
		if(board.checkWin(board.getLastRow(), col)) {
			System.out.println("Congratulations! " + players.get(0).getName()+ "! You won!");
			board.displayBoard();
			noWinner=false;
			return;
		}
		
	}
	
	public int getInput() {
		String input;
		int col;
		System.out.println(players.get(0).getName() + " Which column would you like to drop your disk in?");
		input= scan.nextLine();
		if(!isInt(input)) {
			System.out.println("You must enter a positive number");
			
			do {
				System.out.println(players.get(0).getName() + " Which column would you like to drop your disk in?");
				input= scan.nextLine();
				
			}while(!isInt(input));
			
		}
		col= Integer.parseInt(input);
		if(col<1|| col>7) {
			System.out.println("Must between 1 and 7");
			col=getInput();
		}
		return col;
		
	}
	
	public boolean isInt(String s) {
		try {
			Integer.parseInt(s);
			return true;
		}catch(NumberFormatException e) {
			return false;
		}
	}
	
	public void initPlayers() {
		Player player1= new Player("Player 1");
		Player player2= new Player("Player 2");
		
		players.add(player1);
		players.add(player2);
	}
	
}
