package annieJoannaMinigame;

public class AnnieJoannaPlot {
	
	private boolean jellyfishPresent;
	private String defaultContents;
	private String contents;
	

	public AnnieJoannaPlot(boolean value) {
		this.jellyfishPresent = value;
		defaultContents=" ";
		if(value)
		{
			setContents("J");
		}
		else {
			setContents(defaultContents);
		}
	}

	public String getDefaultContents() {
		return defaultContents;
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
