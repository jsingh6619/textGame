package annieJoannaMinigame;

import caveExplorer.NPC;

public class JoannaNPC extends NPC {

	private boolean cake;
	public JoannaNPC() {
		// TODO Auto-generated constructor stub
	}

	public String getSymbol() {
		return "S";
	}
	public String getDescription() {
		return "Hi I'm Sandy! Press 'e' to interact with me.";
	}

	public boolean isCake() {
		return cake;
	}

	
	
}
