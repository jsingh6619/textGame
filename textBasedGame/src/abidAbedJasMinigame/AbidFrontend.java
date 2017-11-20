package abidAbedJasMinigame;

public class AbidFrontend implements JasSupportFront , AbedSupportFront {
	
	private AbidSupportBack backend;
	private AbidSupportAI ai;
	private AbidCard[][] board;
	private AbidCard[] hand;
	
	public static final void main(String[] args) {
		AbidFrontend demo = new AbidFrontend();
		demo.play();
		
	}
	
	public AbidFrontend() {
		this.backend = new JasBackend(this);
	}
	
	public void play(){
		//	ai.dealCards();
			board = backend.getBoard();
			displayBoard(board);
			hand = backend.getHand();
			displayHand(hand);
			while(backend.stillPlaying()){
		//		displayHand();
		        displayScore();
		        backend.getValidUserInput();
		        ai.computerMove();
		  //      analyzeBoard();
		  //      updateScore();
		    }
		   //     printGameOverMessage(backend.victorious());
		 	}

	
	public void displayBoard(AbidCard[][] backendBoard) {
		
		String board = "_";
		for(int i = 0; i < 4; i++) {
			board += "______";
		}
		board += "\n";
		for(int row = 0; row < 4; row++) {
			for(int col = 0; col < 4; col++) {
				if(backendBoard[row][col] != null) {
					board += "|  "+backendBoard[row][col].getTop()+"  ";
				}
				else {
					board += "|     ";
				}
			}
			board += "|\n";
			for(int col = 0; col < 4; col++) {
				if(backendBoard[row][col] != null) {
					board += "|"+backendBoard[row][col].getLeft()+" "+backendBoard[row][col].getOwner()+" "+backendBoard[row][col].getRight();
				}
				else {
					board += "|     ";
				}
			}
			board += "|\n";
			for(int col = 0; col < 4; col++) {
				if(backendBoard[row][col] != null) {
					board += "|__"+backendBoard[row][col].getBottom()+"__";
				}
				else {
					board += "|__ __";
				}
			}
			board += "|\n";
			
		}
		
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
/*public void displayCard(AbidCard stats) {
		String card = "_______\n";
		card += "|  "+stats.getTop() +"  |\n";
		card += "|"+stats.getLeft()+" "+stats.getOwner()+" "+stats.getRight()+"|\n";
		card += "|__"+stats.getBottom() +"__|";
		
		System.out.println(card);
		
		 _______
		 |  6  |
		 |6 S 6|
		 |__6__|
		 
		
	}
*/
	public void displayHand(AbidCard[] hand) {
		String board = "_";
		for(int i = 0; i < 5; i++) {
			board += "______";
		}
		board += "\n";
			for(int col = 0; col < 5; col++) {
				if(hand[col] != null) {
					board += "|  "+hand[col].getTop()+"  ";
				}
				else {
					board += "|     ";
				}
			}
			board += "|\n";
			for(int col = 0; col < 5; col++) {
				if(hand[col] != null) {
					board += "|"+hand[col].getLeft()+" "+hand[col].getOwner()+" "+hand[col].getRight();
				}
				else {
					board += "|     ";
				}
			}
			board += "|\n";
			for(int col = 0; col < 5; col++) {
				if(hand[col] != null) {
					board += "|__"+hand[col].getBottom()+"__";
				}
				else {
					board += "|__ __";
				}
			}
			board += "|\n";
		
		System.out.println(board);
	}
	@Override
	public void displayScore() {
		String score = "Plankton: "+backend.getPlanktonScore()+"\nSpongebob: "+backend.getSpongebobScore(); 
		System.out.println(score);
	}

}
