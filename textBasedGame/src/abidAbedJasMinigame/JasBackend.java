/*
 * have method that checks if card is there or not before placing
 */
package abidAbedJasMinigame;

import caveExplorer.CaveExplorer;

public class JasBackend implements AbidSupportBack, AbedSupportBack{

	private JasSupportFront frontend;
	private JasSupportAI ai;
	private int pScore;
	private int sScore;
	private int cardX;
	private int cardY;
	private AbidCard[] hand;
	private int xCoordinate;
	private int yCoordinate;

	public AbidCard[] getHand() {
		return hand;
	}

	public JasBackend() {
		setpScore(0);
		setsScore(0);
		cardX = -1;
		cardY = -1;
		xCoordinate = -1;
	}
	
	public void setCard(int x, int y) {
		
	}
	
	public int randomNum() {
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
		if(hand[index]!=null) {
			possiblePlace();
			placeCard(getCardX(), getCardY());
			removeCard(index);
		}
		else {
			CaveExplorer.print("Choose a different card.");
			cardChosen(Integer.parseInt(CaveExplorer.in.nextLine()));
		}
	}
	
	/*
	 * how to put card in the board?
	 * just fill out the 2d array but dont know what is called
	 */
	public void placeCard(int x, int y) {
		
	}

	public void possiblePlace() {
		setCardX();
		setCardY();
		if(!emptyCoordinates(getCardX(), getCardY())) {
			CaveExplorer.print("Those coordinates are not available. Choose other ones.");
			possiblePlace();
		}
	}
	
	public boolean emptyCoordinates(int inputx, int inputy) {
		return frontend.isEmpty(inputx,inputy);
	}
	
	public AbidCard getLastCard() {
		return null;
	}

	/*
	 * Talk to Abed and tell him to call backend.getCardY & backend.getCardX
	 public AbidCard[][] getBoard() {
		return getCardX();
		return getCardY();
	}
	*/
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
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
	
	public int getCardX() {
		return cardX;
	}

	public void setCardX() {
		CaveExplorer.print("Enter the y - coordinate of the board you want to place your card in");
		cardY = Integer.parseInt(CaveExplorer.in.nextLine());
	}
	
	public int getCardY() {
		return cardY;
	}

	public void setCardY() {
		CaveExplorer.print("Enter the y - coordinate of the board you want to place your card in");
		cardY = Integer.parseInt(CaveExplorer.in.nextLine());
	}
}
