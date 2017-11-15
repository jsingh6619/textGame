package abidAbedJasMinigame;

public interface AbidSupportBack {

	void setAI(AbedAI ai);

	void setFrontend(AbidFrontend abidFrontend);

	boolean stillPlaying();

	String getValidUserInput();

	boolean victorious();

	void dealCards();
	
	AbidCard[] getBoard();

}
