package abidAbedJasMinigame;

public class AbedAI implements AbidSupportAI, JasSupportAI
{
	private AbedSupportFront frontend;
	private AbedSupportBack backend;
	private AbidCard[] hand;

	public int getLastUserX() 
	{
		return backend.getCardX();
	}
	public int getLastUserY()
	{
		return backend.getCardY();
	}
	public AbidCard getLastUserCard()
	{
		return backend.getLastCard();
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
			hand[i] = new AbidCard(generateNum(),generateNum(),generateNum(),generateNum(),"P");
		}
		
	}
	public AbidCard[] strongestTop(AbidCard[] hand)
	{
		for(int i = 0; i < hand.length;i++)
		{
			if(hand[i].getTop() < hand[i+1].getTop())
			
		}
		return hand;
	}
	
	public void play()
	{
		dealCards();
		computerMove();
	}
	@Override
	public void computerMove() 
	{
		
	}
	

	
	





}
