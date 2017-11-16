package annieJoannaMinigame;

public class AnnieAI {
	
	private AnnieJoannaPlot[] visited;
	private AnnieJoannaPlot currentPlot;
	private String name;
	private String symbol;
	private int currentRow;
	private int currentCol;
	private int jellyfishCount;

	public AnnieAI(String name, String symbol) {
		visited = new AnnieJoannaPlot[0];
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
			addToVisited(currentPlot);
			if(currentPlot.isJellyfishPresent()) {
				currentPlot.catchJellyfish();
				jellyfishCount++;
			}
			currentPlot.enter(symbol);
		}
	}
		
	private void addToVisited(AnnieJoannaPlot plot) {
		AnnieJoannaPlot[] temp = new AnnieJoannaPlot[visited.length + 1];
		for(int i = 0; i < visited.length; i++)
			temp[i] = visited[i];
		temp[temp.length - 1] = plot;
		visited = temp;
	}

	public int getJellyfishCount() {
		return jellyfishCount;
	}
	
	public String getName() {
		return name;
	}
	
	public void move() {
		AnnieJoannaPlot[][] plots = JoannaFrontend.plots;
		int[] move = calcMove();
		int newRow = move[0];
		int newCol = move[1];
		int loopCount = 0;
		while(alreadyVisited(plots[newRow][newCol]) && loopCount < 4) {
			move = calcMove();
			newRow = move[0];
			newCol = move[1];
			loopCount++;
		}
		setPosition(newRow, newCol);
	}

	private boolean alreadyVisited(AnnieJoannaPlot plot) {
		for(int i = 0; i < visited.length; i++)
			if(visited[i].equals(plot))
				return true;
		return false;
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
