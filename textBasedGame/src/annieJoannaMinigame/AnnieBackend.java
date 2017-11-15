package annieJoannaMinigame;

public class AnnieBackend implements JoannaSupport {

	private AnnieSupport frontend;
	private AnnieJoannaPlot[][] plots;
	private AnnieJoannaPlot[] jellyfishCoords;

	public AnnieJoannaPlot[][] getPlots() {
		return plots;
	}

	public AnnieBackend(AnnieSupport frontend) {
		this.frontend = frontend;
		plots = new AnnieJoannaPlot[5][5];
		for(int row = 0; row < plots.length; row++)
			for(int col = 0; col < plots[row].length; col++)
				if(row == 0 && col == 0 || row == plots.length - 1 && col == plots[row].length - 1)
					plots[row][col] = new AnnieJoannaPlot(false);
				else
					plots[row][col] = new AnnieJoannaPlot(random());
	}

	private boolean random() {
		if(Math.random() < .5)
			return true;
		return false;
	}

	public AnnieJoannaPlot[] getJellyfishCoords() {
		return jellyfishCoords;
	}

	public boolean stillPlaying() {
		return false;
	}

	public String getValidUserInput() {
		return null;
	}

	public void computerMove() {
		
	}

	public boolean victorious() {
		return frontend.getPlayerCount() > frontend.getOpponentCount();
	}
	
}
