package annieJoannaMinigame;

import java.util.Scanner;

import caveExplorer.*;

public class JoannaFrontend implements AnnieSupport{

	private JoannaSupport backend;
	private int playerCount;

	private boolean won;
	
	
	public static AnnieJoannaPlot[][] plots;
	
	public JoannaFrontend() {
		backend = new AnnieBackend(this);
		playerCount  = 0;
		won = false;
		
		
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
	        if(input.equals("cheat")) {
	        	
	        	winGame();
	        	break;
	        }
	        respondToInput(input);
	        backend.computerMove();
	        updateScore();
		}
        printGameOverMessage(backend.victorious());
	}

	private void winGame() {
      		playerCount += backend.getJellyfishNum();
      		
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
		s+= determineWinner(backend.getOpponent().getName(), getOpponentCount());
		CaveExplorer.print(s);
	}
	
	}

	private String determineWinner(String name, int n) {
		return "The winner is " + name +" with a total of " + n + " jellyfish.";
	}

	private void updateScore() {
		
	}

	private void respondToInput(String input) {
		
	}

	private void displayScore() {
	
	}

	private void displayBoard() {
		CaveExplorer.print(updateBoard());
		
		
	}

	
	private String updateBoard() {
		String map = "\n ";
		for(int i = 0; i < plots[0].length - 1; i++)
			map += "____";
		map += "___\n";
		for(AnnieJoannaPlot[] row: plots)
			for(int i = 0; i < 3; i++) {
				String text = "";
				for(AnnieJoannaPlot plot: row) {
					if(plot.getConnection(1) != null )
						text += " ";
					else
						text += "|";
					if(i == 0)
						text += "   ";
					else if(i == 1)
						text += " " + plot.getContents() + " ";
					else if(i == 2)
						if(plot.getConnection(2) != null)
							text += "   ";
						else
							text += "___";
				}
				text += "|";
				map += text + "\n";
			}
	
		
		
		return map;
}

	
	/***
	 *   ___ ___ ___ ___ ___ 
	 *  | 
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
