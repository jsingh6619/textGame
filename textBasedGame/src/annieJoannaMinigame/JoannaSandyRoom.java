package annieJoannaMinigame;

import caveExplorer.NPCRoom;

public class JoannaSandyRoom extends NPCRoom{

	public JoannaSandyRoom(String description) {
		super(description);
		
	}
	
	public void performAction(int direction) {
		if(direction ==  4)
			if(npc != null && npc.isActive())
				npc.interact();
		
	}

	public String validMoves() {
		return "wdsae";
	}
	
	
}
