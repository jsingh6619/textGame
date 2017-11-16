package annieJoannaMinigame;

import java.util.Scanner;

import caveExplorer.*;

public class JoannaFrontend implements AnnieSupport{

	private JoannaSupport backend;
	private int playerCount;
	private int opponentCount;
	private boolean won;
	
	public static AnnieJoannaPlot[][] plots;
	
	public JoannaFrontend() {
		backend = new AnnieBackend(this);
		playerCount = opponentCount = 0;
		won = false;
		
		plots = backend.getPlots();
		CaveExplorer.in = new Scanner(System.in);
	} 

	public static void main(String[] args) {
		JoannaFrontend demo = new JoannaFrontend();
		demo.play();
	}

	public void play() {
		instructions();
		while(backend.stillPlaying()){
	        displayBoard();
	        displayScore();
	        String input = backend.getValidUserInput();
	        respondToInput(input);
	        backend.computerMove();
	        updateScore();
		}
        printGameOverMessage(backend.victorious());
	}

	private void instructions() {
		
	}

	private void printGameOverMessage(boolean victorious) {
		
		String s = "GAME OVER";
	if(victorious) {
		won = true;
		s+= determineWinner("Spongebob", getPlayerCount());
		CaveExplorer.print(s);
	} else {
		s+= determineWinner(backend.getName(), getOpponentCount());
		CaveExplorer.print(s);
	}
	
	}

	private String determineWinner(String name, int n) {
		return "The winner is " + name +" with a total of " + n + " jellyfish.";
	}

	private void updateScore() {
		
	}

	private void respondToInput(String input) {
		if( input.equals("")){
			
		}
	}

	private void displayScore() {
	
	}

	private void displayBoard() {
		CaveExplorer.print(updateBoard());
		for(int row = 0; row< plots.length; row++){
			for(int col = 0; col< plots[row].length ; col ++){
				System.out.print(plots[row][col].getContents());
				}
			System.out.print("\n");
		}
		
	}

	
	private String updateBoard() {
		String map ="";
		for(int i = 0; i < CaveExplorer.caves[0].length - 1; i++)
			map += "____";
		for(int row = 0; row< plots.length; row++){
			for(int col = 0; col< plots[row].length ; col ++){
				map += "|";
				}
			map += "__";
			System.out.print("\n");
		}
		return map;
	}

	
	/***
	 *    
	 *  
	 *    
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 */
	public int getPlayerCount() {
		
		return playerCount;
	}

	
	public int getOpponentCount() {
		return opponentCount;
	}

	
	
	
	

}
