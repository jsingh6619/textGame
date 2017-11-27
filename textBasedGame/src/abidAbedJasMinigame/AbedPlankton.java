package abidAbedJasMinigame;

import caveExplorer.*;

public class AbedPlankton extends NPC
{
	private String description;
	private boolean active;
	public AbedPlankton()
	{
		active = true;	
		this.description = "Plankton is waiting to challenge you! Press 'e' to interact.";
		
	}
	public String getInactiveDescription()
	{
		return "Plankton has gone back to the Chum Bucket.";
	}
	public String getDescription()
	{
		return description;
	}
	public String getSymbol() 
	{
		return "P";
	}
	public void interact()
	{
		

		CaveExplorer.print("Plankton: So you think you can win?");
		String s = CaveExplorer.in.nextLine();
		while(!s.equals("yes")) 
		{
			CaveExplorer.print("Plankton: C'mon you bafoon, say 'yes' or else I am putting your brain in the robot!");
			s = CaveExplorer.in.nextLine();
		}
		start();
		
	}
	public boolean isActive()
	{
		return active;
	}
	public void setActive(boolean a)
	{
		this.active = a;
	}
	public void start() 
	{  
		AbidFrontend a = new AbidFrontend();
		CaveExplorer.print("Plankton: Hahaha, let's begin.");
		a.play();
		JasBackend backend = (JasBackend) a.getBackend();
		if(backend.getSWinner() == true)
		{
			CaveExplorer.print("Plankton: Alright SpongeBob, you can go back to doing work.");
			CaveExplorer.inventory.setBooleanAtIndex(CaveExplorer.inventory.getDone(),2,true);
			setActive(false);
			

		}
		else
		{
			CaveExplorer.print("Plankton: Alright you bafoon, since I'm feel nice, I'll give you another chance to win.");
			CaveExplorer.inventory.setTaskAtIndex(2,"Beat Plankton at Tetra");
			CaveExplorer.print("Press 'e' to challenge Plankton.");
		}
	}
	
}