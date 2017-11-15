package abidAbedJasMinigame;

public class AbedAI implements AbidSupportAI, JasSupportAI
{
	private AbedSupportFront frontend;
	private AbedSupportBack backend;
	private AbidCard[] hand;

	public void computerMove() 
	{
		backend.getLastMove();
	}




	public void dealCards() 
	{
		// TODO Auto-generated method stub
		
	}






}
