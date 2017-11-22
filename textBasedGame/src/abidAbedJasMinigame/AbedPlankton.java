package abidAbedJasMinigame;

import caveExplorer.*;

public class AbedPlankton extends NPC
{
	private String description;
	private boolean active;
	public AbedPlankton()
	{
		active = true;	
		this.description = "Plankton is waitng to challenge you! Press e to interact.";
		
	}
	public String getInactiveDescription()
	{
		return "Plankton has left to chum bucket.";
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
		

		CaveExplorer.print("So you think you can win ?");
		String s = CaveExplorer.in.nextLine();
		while(!s.equals("yes")) 
		{
			CaveExplorer.print("C'mon you bafoon, Say yes or else I am putting your brain in the robot!!!!!");
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
		CaveExplorer.print("hahaha lets begin.");
		a.play();
		JasBackend backend = (JasBackend) a.getBackend();
		if(backend.getSWinner() == true)
		{
			CaveExplorer.print("Alright Spongebob you can go back to the Krusty Krab.");
			CaveExplorer.inventory.setBooleanAtIndex(CaveExplorer.inventory.getDone(),2,true);
			setActive(false);
			

		}
		else
		{
			CaveExplorer.print("Alright you bafoon, since i feel nice I will give you another chance to win");
			a.play();;
		}
	}
	
}