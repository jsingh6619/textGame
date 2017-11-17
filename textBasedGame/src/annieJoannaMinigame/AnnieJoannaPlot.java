	package annieJoannaMinigame;

public class AnnieJoannaPlot {
	
	private AnnieJoannaPlot[] borderingPlots;
	private Object[] connections;
	private boolean jellyfishPresent;
	private String contents;
	private String defaultContents;

	public static final int NORTH = 0;
	public static final int WEST = 1;
	public static final int SOUTH = 2;
	public static final int EAST = 3;
	
	public AnnieJoannaPlot(boolean jellyfishPresent) {
		borderingPlots = new AnnieJoannaPlot[4];
		connections = new Object[4];
		this.jellyfishPresent = jellyfishPresent;
		defaultContents = " ";
		setContents(jellyfishPresent);
	}

	private void setContents(boolean jellyfishPresent) {
		if(jellyfishPresent)
			contents = "O";
		else
			contents = defaultContents;
	}
	
	public String getContents() {
		return contents;
	}
	
	public void setContents(String contents) {
		this.contents = contents;
	}

	public boolean isJellyfishPresent() {
		return jellyfishPresent;
	}
	
	public void catchJellyfish() {
		jellyfishPresent = false;
	}

	public Object getConnection(int index) {
		return connections[index];
	}
	
	public AnnieJoannaPlot getPlot(int index) {
		return borderingPlots[index];
	}
	
	public void enter(String symbol) {
		contents = symbol;
	}
	
	public void leave() {
		contents = defaultContents;
	}
	
	public void setConnection(int direction, AnnieJoannaPlot otherPlot, Object connection) {
		addPlot(direction, otherPlot, connection);
		otherPlot.addPlot(oppositeDirection(direction), this, connection);
	}

	public void addPlot(int direction, AnnieJoannaPlot otherPlot, Object connection) {
		borderingPlots[direction] = otherPlot;
		connections[direction] = connection;
	}
	
	private int oppositeDirection(int direction) {
		return (direction + 2) % 4;
	}

}
