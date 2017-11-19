package abidAbedJasMinigame;

public class AbidFrontend implements JasSupportFront , AbedSupportFront {
	
	private AbidSupportBack backend;
	private AbidSupportAI ai;
	
	
	public static final void main(String[] args) {
		AbidFrontend demo = new AbidFrontend();
		
		demo.play();
		demo.displayHand();
		demo.displayBoard();
		
	}
	public void play(){
			ai.dealCards();
			backend.generateHand();
			while(backend.stillPlaying()){
				displayBoard();
				displayHand();
		        displayScore();
		        backend.getValidUserInput();
		        ai.computerMove();
		        analyzeBoard();
		        updateScore();
		    }
		        printGameOverMessage(backend.victorious());
		 	}

	
	public void displayBoard(AbidCard[][] backendBoard) {
		
		String board = "_";
		for(int i = 0; i < 4; i++) {
			board += "______";
		}
		for(int row = 0; row < 4; row++) {
			for(int col = 0; col < 4; col++) {
				if(backendBoard[row][col] != null) {
					board += "|  "+backendBoard[row][col].getTop()+"  ";
				}
				else {
					board += "|    ";
				}
			}
			board += "|\n";
			for(int col = 0; col < 4; col++) {
				if(backendBoard[row][col] != null) {
					board += "|"+backendBoard[row][col].getLeft()+" "+backendBoard[row][col].getOwner()+" "+backendBoard[row][col].getRight();
				}
				else {
					board += "|    ";
				}
			}
			board += "|\n";
			for(int col = 0; col < 4; col++) {
				if(backendBoard[row][col] != null) {
					board += "|__"+backendBoard[row][col].getBottom()+"__";
				}
				else {
					board += "|    ";
				}
			}
			board += "|\n";
			
		}
		/*for(int k = 0; k < 4; k++) {
			for(int i = 0; i < 2; i++) {
			board += "\n|";
			
				for(int j = 0; j < 4; j++) {
					board += "     |";
				}
			}
			board += "\n|";
			for(int i = 0;i < 4; i++) {
				board += "__"++" __|";
			}
	*/	
		System.out.println(board);
	/*	
	    _________________________
	    |  6  |     |     |     |
	    | 0,0 | 0,1 |     | 0,4 |
	    |__6__|__ __|__ __|__ __|
	    |	  |     |     |     |  
	    |1,0  |     |     |     |
	    |__ __|__ __|__ __|__ __|
	    |  6  |     |     |     |
	    |6 S 6|     |     |     |
	    |__6__|__ __|__ __|__ __|
	    | 	  |     |     |     |
	    |4,  0|     |     | 4,4 |
	    |__ __|__ __|__ __|__ __|
	*/
	}
	
		/*
		 _______
		 |  6  |
		 |6 S 6|
		 |__6__|
		 */
		
	public void displayHand(AbidCard[] hand) {
		for(int i = 0; i< hand.length; i++) {
			displayCard(hand[i]);
		}
	}
	@Override
	public void displayScore() {
		String score = "Plankton: "+backend.getPlanktonScore()+"\nSpongebob: "+backend.getSpongebobScore(); 
		System.out.println(score);
	}

}
