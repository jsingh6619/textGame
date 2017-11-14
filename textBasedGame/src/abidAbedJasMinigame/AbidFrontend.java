package abidAbedJasMinigame;

public class AbidFrontend implements JasSupportFront , AbedSupportFront {
	
	private AbidSupportBack backend;
	private AbidSupportAI ai;
	
	
	public static final void main(String[] args) {
		AbidFrontend demo = new AbidFrontend();
		demo.play();
	}
	
	public void play(){
		ai.dealCards();
		backend.dealCards();
	    while(backend.stillPlaying()){
	        displayBoard();
	        displayHand();
	        displayScore();
	        String input = backend.getValidUserInput();
	        respondToInput(input);
	        ai.computerMove();
	        analyzeBoard();
	        updateScore();
	    }
	        printGameOverMessage(backend.victorious());
	}

	private void displayHand() {
		// TODO Auto-generated method stub
		
	}

	private void updateScore() {
		// TODO Auto-generated method stub
		
	}

	private void analyzeBoard() {
		// TODO Auto-generated method stub
		
	}

	private void respondToInput(String input) {
		// TODO Auto-generated method stub
		
	}

	public AbidFrontend() {
		backend = new JasBackend();
		ai = new AbedAI();
		backend.setAI((AbedAI)ai);
		ai.setBackend((JasBackend)backend);
		backend.setFrontend(this);
		ai.setFrontend(this);
	}

	@Override
	public void displayBoard() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void showCard() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void displayScore() {
		// TODO Auto-generated method stub
		
	}
}
