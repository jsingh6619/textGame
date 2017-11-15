package annieJoannaMinigame;

public class AnnieBackend implements JoannaSupport {

	private AnnieSupport frontend;
	private AnnieJoannaPlot[][] plots;
	private AnnieJoannaPlot[] jellyfishPlots;

	public AnnieBackend(AnnieSupport frontend) {
		this.frontend = frontend;
		jellyfishPlots = new AnnieJoannaPlot[0];
		plots = new AnnieJoannaPlot[5][5];
		for(int row = 0; row < plots.length; row++)
			for(int col = 0; col < plots[row].length; col++)
				if(row == 0 && col == 0 || row == plots.length - 1 && col == plots[row].length - 1)
					plots[row][col] = new AnnieJoannaPlot(false);
				else {
					boolean jellyfishPresent = random();
					plots[row][col] = new AnnieJoannaPlot(jellyfishPresent);
					if(jellyfishPresent)
						addJellyfishPlot(plots[row][col]);
				}
	}

	private void addJellyfishPlot(AnnieJoannaPlot plot) {
		AnnieJoannaPlot[] temp = new AnnieJoannaPlot[jellyfishPlots.length + 1];
		for(int i = 0; i < jellyfishPlots.length; i++)
			temp[i] = jellyfishPlots[i];
		temp[temp.length - 1] = plot;
		jellyfishPlots = temp;
	}

	private boolean random() {
		if(Math.random() < .5)
			return true;
		return false;
	}

	public AnnieJoannaPlot[] getJellyfishPlots() {
		return jellyfishPlots;
	}

	public boolean stillPlaying() {
		for(int i = 0; i < jellyfishPlots.length; i++)
			if(jellyfishPlots != null)
				return true;
		return false;
	}

	public String getValidUserInput() {
		return "";
	}

	public void computerMove() {
		
	}

	public boolean victorious() {
		return frontend.getPlayerCount() > frontend.getOpponentCount();
	}
	
	public AnnieJoannaPlot[][] getPlots() {
		return plots;
	}

}
