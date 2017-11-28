package abidAbedJasMinigame;

public interface AbidSupportBack {

	void setAI(AbedAI ai);

	void setFrontend(AbidFrontend abidFrontend);

	boolean stillPlaying();

	void getValidUserInput();

	void victorious();
	
	AbidCard[][] getBoard(); // the 2D board
	
	AbidCard[] getHand(); // the hand of the user 
	
	int getSpongebobScore(); //how many cards on the board spongebob owns
	
	int getPlanktonScore(); //how many cards on the board plankton owns

	void generateHand();

	void updateScore();

}
