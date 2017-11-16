/*
 * have method that checks if card is there or not before placing
 */
package abidAbedJasMinigame;

public class JasBackend implements AbidSupportBack, AbedSupportBack{

	private JasSupportFront frontend;
	private JasSupportAI ai;
	private int pScore;
	private int sScore;
	private AbidCard[] hand;

	public AbidCard[] getHand() {
		return hand;
	}

	public JasBackend() {
		setpScore(0);
		setsScore(0);
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
	public void sLoses() {
		setsScore(getSpongebobScore() - 1);
	}
	
	public void pLoses() {
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

	/*
	 * checks to see if hand is finished
	 * it'll be your turn 
	 */
	public boolean stillPlaying() {
		if(hand == null) {
			return false;
		}
		return true;
	}

	/*
	 * user enters what they can
	 */
	public String getValidUserInput() {
		return "";
	}

	/*
	 * give the user 5 cards
	 * give AI 5 cards
	 */
	public void dealCards() {
		
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

	public AbidCard getLastCard() {
		// TODO Auto-generated method stub
		return null;
	}

	public void getLastMove() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getUserScore() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getAiScore() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getLastMoveX() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getLastMoveY() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public AbidCard[][] getBoard() {
		// TODO Auto-generated method stub
		return null;
	}

}
