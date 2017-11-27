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
		for(int i = 0; i < 5; i++){
			hand[i] = null;
		}
		victorious();
	}

	public boolean stillPlaying() {
		for(int i=0; i<hand.length;i++) {
			if(hand[i] != null) {
				return true;
			}
		}
			return false;
	}

	public void cardChosen(int index) {
		possiblePlace();
		setCard(getCardRow(), getCardCol(), index, hand);
		fightCards(getCardRow(), getCardCol(), index, hand);
		removeCard(index);
		updateScore();
	}
	
	public void updateScore() {
		setsScore(0);
		setpScore(0);
		for(int row = 0; row <  4; row++) {
			for(int col = 0; col < 4; col++) {
				if(board[row][col]!= null) {
					if(board[row][col].getOwner().equals("S")) {
						setsScore(getSpongebobScore() + 1);
					}
					else {
						setpScore(getPlanktonScore() + 1);
					}
				}
			}
		}
	}

	public void fightCards(int row, int col, int card, AbidCard[] hand) {
		attackTop(row, col, card, hand);
		attackLeft(row, col, card, hand);
		attackRight(row, col, card, hand);
		attackBottom(row, col, card, hand);
	}

	public void attackBottom(int row, int col, int card, AbidCard[] hand){
		if(row != 3) {
			if(!emptyCoordinates(row + 1, col)){
				AbidCard oppCard = board[row + 1][col];
				if(hand[card].getBottom() > oppCard.getTop()) {
					oppCard.setOwner(hand[card].getOwner());
				}
				else if(hand[card].getBottom() < oppCard.getTop()) {
					hand[card].setOwner(oppCard.getOwner());
				}
				else {
					if(Math.random() > .5) {
						hand[card].setOwner(oppCard.getOwner());
					}
					else {
						oppCard.setOwner(hand[card].getOwner());
					}
				}
			}
		}
	}

	public void attackRight(int row, int col, int card, AbidCard[] hand) {
		if(col != 3) {
			if(!emptyCoordinates(row, col + 1)) {
				AbidCard oppCard = board[row][col + 1];
				if(hand[card].getRight() > oppCard.getLeft()) {
					oppCard.setOwner(hand[card].getOwner());
				}
				else if(hand[card].getRight() < oppCard.getLeft()) {
					hand[card].setOwner(oppCard.getOwner());
				}
				else {
					if(Math.random() > .5) {
						hand[card].setOwner(oppCard.getOwner());
					}
					else {
						oppCard.setOwner(hand[card].getOwner());
					}
				}
			}
		}
	}

	public void attackLeft(int row, int col, int card, AbidCard[] hand) {
		if(col != 0) {
			if(!emptyCoordinates(row, col - 1)) {
				AbidCard oppCard = board[row][col - 1];
				if(hand[card].getLeft() > oppCard.getRight()) {
					oppCard.setOwner(hand[card].getOwner());
				}
				else if(hand[card].getLeft() < oppCard.getRight()) {
					hand[card].setOwner(oppCard.getOwner());
				}
				else {
					if(Math.random() > .5) {
						hand[card].setOwner(oppCard.getOwner());
					}
					else {
						oppCard.setOwner(hand[card].getOwner());
					}
				}
			}
		}
	}

	public void attackTop(int row, int col, int card, AbidCard[] hand) {
		if(row != 0) {
			if(!emptyCoordinates(row - 1, col)) {
				AbidCard oppCard = board[row - 1][col];
				if(hand[card].getTop() > oppCard.getBottom()) {
					oppCard.setOwner(hand[card].getOwner());
				}
				else if(hand[card].getTop() < oppCard.getBottom()) {
					hand[card].setOwner(oppCard.getOwner());
				}
				else {
					if(Math.random() > .5) {
						hand[card].setOwner(oppCard.getOwner());
					}
					else {
						oppCard.setOwner(hand[card].getOwner());
					}
				}
			}
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
		else if (num < 0 || num > 4 || hand[num] == null){
			invalidCard();
		}
		else {
			cardChosen(num);
		}
	}
	
	public void invalidCard() {
		CaveExplorer.print("Choose a different card.");
		getValidUserInput();
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
		return board[getCardRow()][getCardCol()];
	}

	public static void setUpBoard() {
		board = new AbidCard[4][4];
		for(int row = 0; row < board.length; row++)
			for(int col = 0; col < board[row].length; col++)
				board[row][col] = null;
	}
		
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
