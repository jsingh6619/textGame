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

	private int generateNum()
	{
		return (int)Math.random() * 9 + 1;
	}


	public void dealCards() 
	{
		hand = new AbidCard[5];
		for(int i = 0; i < hand.length;i++)
		{
			hand[i] = new AbidCard(generateNum(),generateNum(),generateNum(),generateNum());
		}
		
	}
	public void determineFirstMove()
	{
		backend.
	}






}
