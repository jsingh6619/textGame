/*
 * have method that checks if card is there or not before placing
 */
package abidAbedJasMinigame;

import caveExplorer.*;

public class JasBackend implements AbidSupportBack, AbedSupportBack{

	private JasSupportFront frontend;
	private JasSupportAI ai;
	private int pScore;
	private int sScore;
	private int cardRow;
	private int cardCol;
	private boolean sWinner;
	public static AbidCard[][] board; 
	private static AbidCard[] hand;


	public AbidCard[] getHand() {
		return hand;
	}

	public JasBackend(JasSupportFront frontend,JasSupportAI ai) {
		this.frontend = frontend;
		this.ai = new AbedAI((AbedSupportFront) frontend, this); 
		sWinner = false;
		setpScore(0);
		setsScore(0);
		cardRow = -1;
		cardCol = -1;
		generateHand();
		hand = getHand();
		setUpBoard();
		board = getBoard();
	}
	
	public String toString() {
			return hand[1].getOwner(); 
	}
	
	public void setCard(int row, int col, int index, AbidCard[] hand) {
		board[row][col] = hand[index];
	}
	
	public static int randomNum() {
		return (int)(Math.random() * 9);
	}
	
	public void sScores() {
		setsScore(getSpongebobScore() + 1);
	}
	
	public void pScores() {
		setpScore(getPlanktonScore() + 1);
	}
	public void sLosesCard() {
		setsScore(getSpongebobScore() - 1);
	}
	
	public void pLosesCard() {
		setpScore(getPlanktonScore() - 1);
	}
	
	public void generateHand() {
		hand = new AbidCard[5];
		for (int i = 0; i < hand.length; i++) {
			hand[i] = new AbidCard(randomNum(), randomNum(), randomNum(), randomNum(), "S");
		}
	}
	
	/*
	 * index is the number the user inputs
	 */
	public void removeCard(int index) {
		hand[index] = null;
	}
	
	public void victorious() {
		if(getSpongebobScore() > getPlanktonScore()) {
			sWinner = true;
			CaveExplorer.print("Spongebob is the winner!");
		}
		else {
			CaveExplorer.print("Plankton is the winner!");
		}
	}
	
	public void cheat() {
		hand = null;
		victorious();
	}

	public boolean stillPlaying() {
		if(hand == null) {
			return false;
		}
		return true;
	}

	public void cardChosen(int index) {
		possiblePlace();
		setCard(getCardRow(), getCardCol(), index, hand);
		//fightCards(getCardRow(), getCardCol(), index, hand);
		removeCard(index);
		//updateScore();
	}
	
	//have booleans to see if card is at the 
	public void fightCards(int row, int col, int card, AbidCard[] hand) {
		if(row == 0) {
			attackLeft();
			attackRight();
			attackBottom();
		}
		else {
			attackTop();
			attackLeft();
			attackRight()
			attackBottom();
		}
	}

	public void getValidUserInput() {
		CaveExplorer.print("What card do you want to play?");
		int num = Integer.parseInt(CaveExplorer.in.nextLine()) - 1;
		//CHEAT
		if(num == 9998) {
			setsScore(9999);
			cheat();
		}
		else {
			if(hand[num] == null) {
				CaveExplorer.print("Choose a different card.");
				getValidUserInput();
			}
			else {
				cardChosen(num);
			}
		}
	}

	public void possiblePlace() {
		setCardRow();
		setCardCol();
		if(!emptyCoordinates(getCardRow(), getCardCol())) {
			CaveExplorer.print("Those coordinates are not available. Choose other ones.");
			possiblePlace();
		}
	}
	
	public boolean emptyCoordinates(int row, int col) {
		if(board[row][col] == null) {
			return true;
		}
		else {
			return false;
		}
	}

	public AbidCard getLastCard() {
		return null;
	}

	public static void setUpBoard() {
		board = new AbidCard[4][4];
		for(int row = 0; row < board.length; row++)
			for(int col = 0; col < board[row].length; col++)
				board[row][col] = null;
	}
		
	
	//GETTERS & SETTERS
	public int getPlanktonScore() {
		return pScore;
	}

	public void setpScore(int pScore) {
		this.pScore = pScore;
	}

	public int getSpongebobScore() {
		return sScore;
	}

	public void setsScore(int sScore) {
		this.sScore = sScore;
	}
	
	public void setFrontend(AbidFrontend abidFrontend) {
		this.frontend = abidFrontend;
	}

	public void setAI(AbedAI ai) {
		this.ai= ai;
	}
	
	public int getCardRow() {
		return cardRow;
	}

	public void setCardRow() {
		CaveExplorer.print("Enter the row of the board you want to place your card in");
		int num = Integer.parseInt(CaveExplorer.in.nextLine());
		if(num >= 0 && num < 4) {
			cardRow = num;
		}
		else {
			setCardRow();
		}
	}
	
	public int getCardCol() {
		return cardCol;
	}

	public void setCardCol() {
		CaveExplorer.print("Enter the column of the board you want to place your card in");
		int num = Integer.parseInt(CaveExplorer.in.nextLine());
		if(num >= 0 && num < 4) {
			cardCol = num;
		}
		else {
			setCardCol();
		}
	}
	
	public AbidCard[][] getBoard() {
		return board;
	}
	
	public boolean getSWinner() {
		return sWinner;
	}
}
