package abidAbedJasMinigame;

import caveExplorer.CaveExplorer;
import caveExplorer.NPC;
import abidAbedJasMinigame.AbedPlanktonFight;

public class AbedPlankton extends NPC
{
	private String activeDescription;
	private String inactiveDescription;
	private boolean active;
	public AbedPlankton()
	{
		active = true;
		this.activeDescription = "HAHAHA THE FORMULA WILL BE MINE";
		this.inactiveDescription = "Leave me alone, plan z hasn't started yet.";
		
	}
	public String getSymbol() 
	{
		return "P";
	}
	public void interact()
	{
		
		AbedPlanktonFight game = new AbedPlanktonFight();
		CaveExplorer.print("So you think you can ?");
		String s = CaveExplorer.in.nextLine();
		while(!s.equals("yes")) 
		{
			CaveExplorer.print("Cmon you bafoon, 	!!!!!");
		}
		game.start();
		active = false;
		
	}
	public boolean isActive()
	{
		return active;
	}
}