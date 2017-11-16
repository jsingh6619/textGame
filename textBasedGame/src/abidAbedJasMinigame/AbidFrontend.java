package abidAbedJasMinigame;

public class AbidFrontend implements JasSupportFront , AbedSupportFront {
	
	private AbidSupportBack backend;
	private AbidSupportAI ai;
	
	
	public static final void main(String[] args) {
		AbidFrontend demo = new AbidFrontend();
		demo.play();
	//demo.displayBoard();
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

	
	public void displayBoard() {
		String board = "_";
		for(int i = 0; i < 4; i++) {
			board += "______";
		}
		for(int k = 0; k < 4; k++) {
			for(int i = 0; i < 2; i++) {
			board += "\n|";
			
				for(int j = 0; j < 4; j++) {
					board += "     |";
				}
			}
			board += "\n|";
			for(int i = 0;i < 4; i++) {
				board += "__ __|";
			}
		}
		System.out.println(board);
	/*	
	    _________________________
	    |  6  |     |     |     |
	    |6 S 6|     |     |     |
	    |__6__|__ __|__ __|__ __|
	    |	  |     |     |     |  
	    |	  |     |     |     |
	    |__ __|__ __|__ __|__ __|
	    |  6  |     |     |     |
	    |6 S 6|     |     |     |
	    |__6__|__ __|__ __|__ __|
	    | 	  |     |     |     |
	    |	  |     |     |     |
	    |__ __|__ __|__ __|__ __|
	*/
	}

	public void showCard(AbidCard stats) {
		String card = "_______\n";
		card += "|  "+stats.getTop() +"  |\n";
		card += "|"+stats.getLeft()+" "+stats.getOwns()+" "+stats.getRight()+"|\n";
		card += "|__"+stats.getBottom() +"__|";
		
		System.out.println(card);
		/*
		 _______
		 |  6  |
		 |6 S 6|
		 |__6__|
		 */
		
	}
	public void showHand() {
		AbidCard[] hand = JasBackend.getHand();
		for(int i = 0; i< hand.length; i++) {
			showCard(hand[i]);
		}
	}
	@Override
	public void displayScore() {
		String score = "Plankton:" ;
		
	}
}
