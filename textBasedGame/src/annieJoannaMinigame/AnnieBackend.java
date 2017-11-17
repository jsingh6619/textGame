package annieJoannaMinigame;

import caveExplorer.*;

public class AnnieBackend implements JoannaSupport {
	
	private AnnieSupport frontend;
	private AnnieJoannaPlot[][] plots;
	private AnnieAI opponent;
	
	public AnnieBackend(AnnieSupport frontend) {
		this.frontend = frontend;
		JoannaFrontend.plots = new AnnieJoannaPlot[6][6];
		plots = JoannaFrontend.plots;
		setUpPlots();
		setUpConnections();
		setUpAI();
	}
	
	private void setUpAI() {
		opponent = new AnnieAI("Kevin C. Cucumber", "K");
		opponent.setPosition(plots.length - 1, plots[plots.length - 1].length - 1);
	}

	private void setUpConnections() {
		setBlock(new int[] {0, 0}, new int[] {5, 5});
	}
	
	public void setBlock(int[] topLeft, int[] bottomRight) {
		for(int row = topLeft[0]; row < bottomRight[0]; row++)
			for(int col = topLeft[1]; col < bottomRight[1]; col++) {
				plots[row][col].setConnection(AnnieJoannaPlot.SOUTH, plots[row + 1][col], new Object());	
				plots[row][col].setConnection(AnnieJoannaPlot.EAST, plots[row][col + 1], new Object());
			}
		for(int row = topLeft[0]; row < bottomRight[0]; row++)
			plots[row][bottomRight[1]].setConnection(AnnieJoannaPlot.SOUTH, plots[row + 1][bottomRight[1]], new Object());	
		for(int col = topLeft[1]; col < bottomRight[1]; col++)
			plots[bottomRight[0]][col].setConnection(AnnieJoannaPlot.EAST, plots[bottomRight[0]][col + 1], new Object());
	}

	private void setUpPlots() {
		for(int row = 0; row < plots.length; row++)
			for(int col = 0; col < plots[row].length; col++)
				if(row == 0 && col == 0 || row == plots.length - 1 && col == plots[row].length - 1)
					plots[row][col] = new AnnieJoannaPlot(false);
				else
					plots[row][col] = new AnnieJoannaPlot(Math.random() < .33);
	}

	public boolean stillPlaying() {
		return getJellyfishNum() > 0;
	}

	public int getJellyfishNum() {
		int count = 0;
		for(int row = 0; row < plots.length; row++)
			for(int col = 0; col < plots[row].length; col++)
				if(plots[row][col].isJellyfishPresent())
					count++;
		return count;
	}
	
	public String getValidUserInput() {
		String input = CaveExplorer.in.nextLine();
		while(!isValid(input)) {
			CaveExplorer.print("Try again! You can only use 'w', 'a', 's', or 'd' to move.");
			input = CaveExplorer.in.nextLine();
			if(input.equals("cheat"))
				break;
		}
		return input;
	}

	private boolean isValid(String input) {
		return "wasd".indexOf(input) > -1 && input.length() == 1;
	}

	public void computerMove() {
		opponent.move();
	}

	public boolean victorious() {
		return frontend.getJellyfishCount() > opponent.getJellyfishCount();
	}

	public AnnieAI getOpponent() {
		return opponent;
	}

}
