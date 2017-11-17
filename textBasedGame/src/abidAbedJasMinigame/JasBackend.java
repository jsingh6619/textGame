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

	public AbidCard[] getHand() {
		return hand;
	}

	public JasBackend() {
		setpScore(0);
		setsScore(0);
		cardX = -1;
		cardY = -1;
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
			if(possiblePlace()) {
				placeCard(getXCoordinate(), getYCoordinate());
				removeCard(index);
			}
			else {
				while(!possib)
			}
		}
		else {
			//asks the user to choose a different card
		}
	}
	
	public boolean possiblePlace() {
		return emptyCoordinates(getXCoordinate(), getYCoordinate());
	}
	
	public int getXCoordinate() {
		CaveExplorer.print("Enter the x - coordinate of the board you want to place your card in");
		return Integer.parseInt(CaveExplorer.in.nextLine());
	}
	
	public int getYCoordinate() {
		CaveExplorer.print("Enter the y - coordinate of the board you want to place your card in");
		return Integer.parseInt(CaveExplorer.in.nextLine());
	}
	
	public boolean emptyCoordinates(int inputx, int inputy) {
		return frontend.isEmpty(inputx,inputy);
	}
	
	public AbidCard getLastCard() {
		// TODO Auto-generated method stub
		return null;
	}

	public AbidCard[][] getBoard() {
		// TODO Auto-generated method stub
		return null;
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
	
	public int getCardX() {
		return cardX;
	}

	public void setCardX(int cardX) {
		this.cardX = cardX;
	}
	
	public int getCardY() {
		return cardY;
	}

	public void setCardY(int cardY) {
		this.cardY = cardY;
	}
}
