package abidAbedJasMinigame;

import caveExplorer.NPCRoom;
import caveExplorer.Inventory;


public class AbedMarket extends NPCRoom 
{
	private Inventory a;
	public AbedMarket(String description) 
	{
		super(description);
		
	}
	public String validMoves()
	{
		return "wasdzxcvb";
	}
	public void printValidMoves()
	{
		System.out.println("\"You can only enter 'w', 'a', 's', or 'd' to move. 'z' to buy eggs, 'x' to buy flour, 'c' to buy milk, 'v' to buy a clarinet and 'b' for to buy a net");
	}
	public void performAction(int direction)
	{
		if(direction == 9)
		{
			a.setNets(1);
		}
		else if(direction == 8)
		{
			a.setGotClarinet(true);
		}
		else if(direction == 7)
		{
			a.setBooleanAtIndex(a.getHave(),1,true);
		}
		else if(direction == 6)
		{
			a.setBooleanAtIndex(a.getHave(),2,true);
		}
		else if(direction == 5)
		{
			a.setBooleanAtIndex(a.getHave(),0,true);
		}
		else
		{
			super.performAction(direction);
		}
		
	}

}
