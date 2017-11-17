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
	public static AbidCard[][] board; 
	private static AbidCard[] hand;
	private int rowCoordinate;
	private int colCoordinate;

	public AbidCard[] getHand() {
		return hand;
	}
	
	public static void main(String[] args)
	{
		JasBackend a  = new JasBackend();
		a.generateHand();
		System.out.println(hand[1].getTop());
	}

	public JasBackend() {
		setpScore(0);
		setsScore(0);
		cardRow = -1;
		cardCol = -1;
		rowCoordinate = -1;
		colCoordinate = -1;
	}
	
	public String toString() {
			return hand[1].getOwner(); 
	}
	
	public void setCard(int row, int col, int index) {
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
			hand[i] = new AbidCard(1, 2, 1, 4, "S");
		}
	}
	
	/*
	 * index is the number the user inputs
	 */
	public void removeCard(int index) {
		hand[index] = null;
	}
	
	public String victorious() {
		if(getSpongebobScore() > getPlanktonScore()) {
			return "Spnogebob is the winner!";
		}
		else {
			return "Plankton is the winner!";
		}
	}

	public boolean stillPlaying() {
		if(hand == null) {
			return false;
		}
		return true;
	}

	public void cardChosen(int index) {
		possiblePlace();
		setCard(getCardRow(), getCardCol(), index);
		removeCard(index);
	}
	
	public void getValidUserInput() {
		CaveExplorer.print("What card do you want to play?");
		if(hand[Integer.parseInt(CaveExplorer.in.nextLine())]!=null) {
			CaveExplorer.print("Choose a different card.");
			getValidUserInput();
		}
		else {
			cardChosen(Integer.parseInt(CaveExplorer.in.nextLine()));
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
		CaveExplorer.print("Enter the y - coordinate of the board you want to place your card in");
		cardCol = Integer.parseInt(CaveExplorer.in.nextLine());
	}
	
	public int getCardCol() {
		return cardCol;
	}

	public void setCardCol() {
		CaveExplorer.print("Enter the y - coordinate of the board you want to place your card in");
		cardCol = Integer.parseInt(CaveExplorer.in.nextLine());
	}
	
	public AbidCard[][] getBoard() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
