package abidAbedJasMinigame;

public class AbedAI implements AbidSupportAI, JasSupportAI
{
	private AbedSupportFront frontend;
	private AbedSupportBack backend;
	private AbidCard[] hand;

	public int getLastUserRow() 
	{
		return backend.getCardRow();
	}
	public int getLastUserCol()
	{
		return backend.getCardCol();
	}
	public AbidCard getLastUserCard()
	{
		return backend.getLastCard();
	}
	
	private int generateNum(int multiplier)
	{
		return (int)Math.random() * multiplier + 1;
	}


	public void dealCards() 
	{
		hand = new AbidCard[5];
		for(int i = 0; i < hand.length;i++)
		{
			hand[i] = new AbidCard(generateNum(9),generateNum(9),generateNum(9),generateNum(9),"P");
		}
		
	}
	
	public void play()
	{
		dealCards();
		computerMove();
	}
	
	public void firstMove() 
	{
		
		int row = backend.getCardRow();
		int col = backend.getCardCol();
		AbidCard opponentCard = backend.getLastCard();
		if(opponentCard == null)
		{
			backend.setCard(0,3,strongestCardBottom());
		}
		
	}
	private AbidCard strongestCardBottom() 
	{
		for(int i = 0 ; i < hand.length;i++)
		{
			AbidCard a = null;
			if(hand[i].getBottom() < hand[i + 1].getBottom())
			{
				a = hand[i];
			}
			return a;
		}
		return null; 
	}

	public void computerMove()
	{
		
	}


	
	





}
