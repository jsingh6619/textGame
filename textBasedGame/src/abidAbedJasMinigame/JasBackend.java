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

	public JasBackend() {
		setpScore(0);
		setsScore(0);
	}
	
	public int randomNum() {
		return (int)(Math.random() * 9 + 1);
	}
	
	public void sScores() {
		setsScore(getsScore() + 1);
	}
	
	public void pScores() {
		setpScore(getpScore() + 1);
	}
	public void sLoses() {
		setsScore(getsScore() - 1);
	}
	
	public void pLoses() {
		setpScore(getpScore() - 1);
	}
	
	public void generateHand() {
		hand = new AbidCard[5];
		for (int i = 0; i < hand.length; i++) {
			hand[i] = new AbidCard(randomNum(), randomNum(), randomNum(), randomNum());
		}
	}
	
	/*
	 * index is the number the user inputs
	 */
	public void removeCard(int index) {
		hand[index] = null;
	}
	
	public String victorious() {
		if(getsScore() > getpScore()) {
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
	
	public int getpScore() {
		return pScore;
	}

	public void setpScore(int pScore) {
		this.pScore = pScore;
	}

	public int getsScore() {
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

	@Override
	public AbidCard[][] getLastMove() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AbidCard getLastCard() {
		// TODO Auto-generated method stub
		return null;
	}

}
