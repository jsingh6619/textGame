package annieJoannaMinigame;

public class AnnieJoannaPlot {
	
	private int row;
	private int col;
	private boolean jellyfishPresent;
	private String contents;

	public AnnieJoannaPlot(int row, int col, boolean value) {
		this.row = row;
		this.col = col;
		this.jellyfishPresent = value;
		if(jellyfishPresent)
			this.setContents("J");
		else
			this.setContents(" ");
	}

	public int getRow() {
		return row;
	}

	public int getCol() {
		return col;
	}

	public boolean isJellyfishPresent() {
		return jellyfishPresent;
	}

	public void setJellyfishPresent(boolean jellyfishPresent) {
		this.jellyfishPresent = jellyfishPresent;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}
	
}
