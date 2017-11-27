package abidAbedJasMinigame;

import caveExplorer.CaveExplorer;
import caveExplorer.NPCRoom;

public class AbedRoom extends NPCRoom
{
	private boolean visited;
	public AbedRoom(String description)
	{
		super(description);
		visited = false;
	}
	public String validMoves()
	{
		return "wdsae";
	}
	public void printValidMoves() 
	{
		System.out.println("You can only enter 'w', 'a', 's', or 'd' to move "
		+ "or you can press 'e' to start the challenge.");
	}
	public void performAction(int direction)
	{
		if(direction == 4 && getNPC().isActive())
		{
			getNPC().interact();
		}
		else if(!visited)
		{
			visited = true;
			CaveExplorer.inventory.setTaskAtIndex(2, "Challenge Plankton");
		}
		else if(direction != -1)
		{
			super.performAction(direction);
		}
	}
	
}
