package annieJoannaMinigame;

public interface JoannaSupport {

	boolean stillPlaying();

	String getValidUserInput();

	void computerMove();

	boolean victorious();

	AnnieAI getOpponent();

	int getJellyfishNum();

	AnnieJoannaPlot[][] getPlots();

	void catchAllJellyfish();

	

}
