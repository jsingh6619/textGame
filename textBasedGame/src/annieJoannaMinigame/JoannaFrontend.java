package annieJoannaMinigame;

public class JoannaFrontend implements AnnieSupport{

	private JoannaSupport backend;
	private int playerCount;
	private int opponentCount;
	private boolean won;
	
	public JoannaFrontend() {
		backend = new AnnieBackend(this);
		playerCount = opponentCount = 0;
		won = false;
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
// print how game works		
	}

	private void printGameOverMessage(boolean victorious) {
	if(victorious){
				//print 	
		}
	else {
		
	}
	}

	private void updateScore() {
		
	}

	private void respondToInput(String input) {
		
	}

	private void displayScore() {

	}

	private void displayBoard() {
		
	}

	@Override
	public int getPlayerCount() {
		
		return playerCount;
	}

	@Override
	public int getOpponentCount() {
		// TODO Auto-generated method stub
		return opponentCount;
	}
	
	

}
