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
		if(!checkBookleanList())
		{
			CaveExplorer.print("Hi Spongebob! It seems like you're missing either eggs,milk, or flour. I can't give you the cake unless you have all 3 ingredients.");
			
		}
		else {
			CaveExplorer.inventory.setCake(true);
			CaveExplorer.inventory.setBooleanAtIndex(CaveExplorer.inventory.getDone(), 3, true);
			CaveExplorer.print("Looks like you have all the ingredients so here's the cake!");
			
			
		}				
		
	}
	
			//System.out.println("Here's your cake!");
		
		public boolean checkBookleanList() {
			for(int i=0; i < CaveExplorer.inventory.getHave().length; i++)
			{
				if(CaveExplorer.inventory.getHave()[i] == false) {
					
					return false;
				}
				
			}
			
			return true;
		}
		
	}
	


