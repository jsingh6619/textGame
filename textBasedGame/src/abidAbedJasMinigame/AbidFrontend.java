package abidAbedJasMinigame;

import java.util.Scanner;

import caveExplorer.*;

public class AbidFrontend implements JasSupportFront , AbedSupportFront {
	
	private AbidSupportBack backend;
	private AbidSupportAI ai;

	
	public static final void main(String[] args) {
		AbidFrontend demo = new AbidFrontend();
		demo.play();
		
	}
	
	public AbidSupportBack getBackend()
	{
		return backend;
	}
	public AbidFrontend() {
		this.backend = new JasBackend(this);
		this.ai = new AbedAI(this);
		CaveExplorer.in = new Scanner(System.in);
	}
	
	public void play(){
		//	ai.dealCards();
			while(backend.stillPlaying()){
				displayBoard(backend.getBoard());
				displayHand(backend.getHand());
		        displayScore();
		        backend.getValidUserInput();
		        ai.computerMove();
		    }
		   //     printGameOverMessage(backend.victorious());
		 	}

	
	public void displayBoard(AbidCard[][] backendBoard) {
		String board = " _______________________\n";
		int y = 0;
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
			board += "|"+y+"\n";
			y++;
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
		board += "   0     1     2     3\n";
		System.out.println(board);
	/*	
	     ________________________
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
		String board = " _____________________________";
		
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
			board += "   1     2     3     4     5\n";
		
		System.out.println(board);
	}
	@Override
	public void displayScore() {
		String score = "Plankton: "+backend.getPlanktonScore()+"\nSpongebob: "+backend.getSpongebobScore(); 
		System.out.println(score);
	}

	@Override
	public void displayCard(AbidCard stats) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void displayBoard() {
		// TODO Auto-generated method stub
		
	}

}
