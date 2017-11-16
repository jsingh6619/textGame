package annieJoannaMinigame;

public class AnnieAI {
	
	private AnnieJoannaPlot currentPlot;
	private String name;
	private String symbol;
	private int currentRow;
	private int currentCol;
	private int jellyfishCount;

	public AnnieAI(String name, String symbol) {
		currentPlot = null;
		this.name = name;
		this.symbol = symbol;
		currentRow = currentCol = -1;
		jellyfishCount = 0;
	}
	
	public void setPosition(int row, int col) {
		AnnieJoannaPlot[][] plots = JoannaFrontend.plots;
		if(row >= 0 && row < plots.length && col >= 0 && col < plots[row].length) {
			if(currentPlot != null)
				currentPlot.leave();
			currentRow = row;
			currentCol = col;
			currentPlot = plots[row][col];
			if(currentPlot.isJellyfishPresent()) {
				currentPlot.catchJellyfish();
				jellyfishCount++;
			}
			currentPlot.enter(symbol);
		}
	}
		
	public int getJellyfishCount() {
		return jellyfishCount;
	}
	
	public String getName() {
		return name;
	}
	
	public void move() {
		int[] move = calcMove();
		int newRow = move[0];
		int newCol = move[1];
		setPosition(newRow, newCol);
	}

	private int[] calcMove() {
		int[][] possible = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
		int index = (int)(Math.random() * possible.length);
		int[] newPosition = new int[2];
		newPosition[0] = currentRow + possible[index][0];
		newPosition[1] = currentCol + possible[index][1];
		while(currentPlot.getConnection(index) == null) {
			index = (int)(Math.random() * possible.length);
			newPosition[0] = currentRow + possible[index][0];
			newPosition[1] = currentCol + possible[index][1];
		}
		return newPosition;
	}

}
