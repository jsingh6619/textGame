package annieJoannaMinigame;

import caveExplorer.*;

public class ShopKeeper extends NPC {
	private boolean active;
	private String activeDescription;
	private String inactiveDescription;

	public ShopKeeper() {
		this.activeDescription = "There is a fish merchant here. Press 'e' to talk.";
		this.inactiveDescription = "No new items in stock right now.";
		active = true;
				 setPosition(2,2);
	}
	public String getDescription() {
		return activeDescription;
	}

	public String getInactiveDescription() {
		return inactiveDescription;
	}
	public String getSymbol() {
		return "F";
	}
	public boolean isActive() {
		return active;
	}
	public boolean buyNet() {
		//if(money>=50) {
			
		return true;	
		
		
	}
	
}
