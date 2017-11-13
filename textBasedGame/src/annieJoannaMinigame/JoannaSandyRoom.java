package annieJoannaMinigame;

import caveExplorer.*;


public class JoannaSandyRoom extends NPCRoom{

	public JoannaSandyRoom(String description) {
		super(description);
		
	}
	
	public void performAction(int direction) {
		if( direction  == 4) {
			JoannaNPC.interact();
		for(int i=0; i < CaveExplorer.inventory.getHave().length; i++)
		{
			while(CaveExplorer.inventory.getHave()[i] == false) {
				
				System.out.println("You're missing either eggs,milk, or flour.");
			}
			
		}
		}
		else {
			System.out.println("Here's your cake!");
		}
		
			
		
		
	}
	public String validMoves() {
		return "wdsae";
	}
	
	
}
