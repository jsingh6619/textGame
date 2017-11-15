package annieJoannaMinigame;

import caveExplorer.*;

public class JoannaFrontend implements AnnieSupport{

	private JoannaSupport backend;
	private int playerCount;
	private int opponentCount;
	private boolean won;
	private String opponentName;
	
	public JoannaFrontend() {
		backend = new AnnieBackend(this);
		playerCount = opponentCount = 0;
		won = false;
		opponentName = "Kevin C Cucumber";
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
		CaveExplorer.print("");
	}

	private void printGameOverMessage(boolean victorious) {
		
		String s = "GAME OVER";
	if(victorious) {
		won = true;
		s+= determineWinner("Spongebob", getPlayerCount());
		CaveExplorer.print(s);
	} else {
		s+= determineWinner(opponentName, getOpponentCount());
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
		
	}

	
	public int getPlayerCount() {
		
		return playerCount;
	}

	
	public int getOpponentCount() {
		return opponentCount;
	}

	
	
	
	

}
