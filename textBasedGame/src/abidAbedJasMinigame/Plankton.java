package abidAbedJasMinigame;

import caveExplorer.CaveExplorer;
import caveExplorer.NPC;
import abidAbedJasMinigame.PlanktonFight;

public class Plankton extends NPC
{
	private String activeDescription;
	private String inactiveDescription;
	private boolean active;
	public Plankton()
	{
		active = true;
		this.activeDescription = "HAHAHA THE FORMULA WILL BE MINE";
		this.inactiveDescription = "Leave me alone, plan  xyz hasn't started yet.";
		
	}
	public String getSymbol() 
	{
		return "P";
	}
	public void interact()
	{
		
		PlanktonFight game = new PlanktonFight();
		CaveExplorer.print("So you think you can stop me?");
		String s = CaveExplorer.in.nextLine();
		while(!s.equals("yes")) 
		{
			CaveExplorer.print("Cmon i want a challenge try AGAIN!!!!!");
		}
		game.start();
		active = falsed
				;
		
	}
	public boolean isActive()
	{
		return active;
	}
}