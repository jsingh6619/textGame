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
		return "Hi I'm Sandy! Press 'e' to interact with me. hehe";
	}

	public boolean isCake() {
		return cake;
	}

	public void interact() {
		if(!checkBookleanList())
		{
			CaveExplorer.print("You're missing either eggs,milk, or flour.");
			
		}
		else {
			CaveExplorer.inventory.setCake(true);
			CaveExplorer.print("Here's the cake!");
			
			
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
	


