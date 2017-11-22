package abidAbedJasMinigame;

import caveExplorer.NPCRoom;

public class AbedRoom extends NPCRoom
{
	private AbedPlankton p;
	public AbedRoom(String description)
	{
		super(description);
	}
	public String validMoves()
	{
		return "wdsaz";
	}
	public void printValidMoves() 
	{
		System.out.println("You can only enter 'w', 'a', 's', or 'd' to move "
		+ "or you can press 'e' to start challenge..");
	}
	public void performAction(int direction)
	{
		if(direction == 5)
		{
			p.interact();
		}
		else
		{
			super.performAction(direction);
		}
	}
	
}
