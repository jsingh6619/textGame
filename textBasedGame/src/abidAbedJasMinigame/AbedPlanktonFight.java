package abidAbedJasMinigame;
import caveExplorer.CaveExplorer;

public class AbedPlanktonFight 
{

	public void start() 
	{
		JasBackend a = new JasBackend(null);
		CaveExplorer.print("hahaha lets begin.");
		
		
		AbidFrontend.main(null);
		if(a.getSWinner() == true)
		{
			///run winner text
		}
		else
		{
			CaveExplorer.print("Alright you bafoon, since i feel nice I will give you another chance to win");
			AbidFrontend.main(null);
		}
	}
	

	
	

}
