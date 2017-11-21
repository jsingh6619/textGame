package annieJoannaMinigame;

import caveExplorer.CaveExplorer;
import caveExplorer.NPC;

public class JoannaNPC extends NPC {

	private boolean cake;
	
	public JoannaNPC() {
		cake = true;
	}

	public String getSymbol() {
		return "S";
	}
	
	public String getDescription() {
		return "Sandy is standing here. Press 'e' to interact.";
	}

	public boolean isCake() {
		return cake;
	}

	public void interact() {
		if(!checkBookleanList()) {
			CaveExplorer.print("Hi SpongeBob! I can't make a cake unless you have all 3 ingredients. You're missing either eggs, milk, or flour.");	
			CaveExplorer.inventory.setTaskAtIndex(3, "Buy everything you need for the cake");
		} else {
			CaveExplorer.inventory.setCake(true);
			CaveExplorer.inventory.setBooleanAtIndex(CaveExplorer.inventory.getDone(), 3, true);
			CaveExplorer.print("Here's your cake!");
			for(int i = 0; i <= 2; i++) {
				CaveExplorer.inventory.setBooleanAtIndex(CaveExplorer.inventory.getHave(), i, false);
				
			}
			
		}				
		
	}
	
	public boolean checkBookleanList() {
			for(int i=0; i < CaveExplorer.inventory.getHave().length; i++)
			{
				if(CaveExplorer.inventory.getHave()[i] == false)
					return false;
			}
			return true;
	}
		
}
	


