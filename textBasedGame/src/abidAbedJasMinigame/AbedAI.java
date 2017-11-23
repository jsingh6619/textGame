package abidAbedJasMinigame;

public class AbedAI implements AbidSupportAI, JasSupportAI
{
	private AbedSupportFront frontend;
	private AbedSupportBack backend;
	private AbidCard[] hand;

	public AbedAI(AbedSupportFront front)
	{
		this.frontend = front;
	}
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
			backend.setCard(0,3,strongestCardIndex("bottom"),hand);
			hand[strongestCardIndex("bottom")] = null;
		}
		
	}
	private int strongestCardIndex(String p) 
	{
		if(p.equals("bottom"))
		{
			for(int i = 0 ; i < hand.length;i++)
			{
				int index = 0;
				if(hand[i].getBottom() < hand[i + 1].getBottom())
				{
					index = i;
				}
				return index;
			}
		}
		if(p.equals("top"))
		{
			for(int i = 0 ; i < hand.length;i++)
			{
				int index = 0;
				if(hand[i].getTop() < hand[i + 1].getTop())
				{
					index = i;
				}
				return index;
			}
		}
		if(p.equals("left"))
		{
			for(int i = 0 ; i < hand.length;i++)
			{
				int index = 0;
				if(hand[i].getLeft() < hand[i + 1].getLeft())
				{
					index = i;
				}
				return index;
			}
		}
		if(p.equals("right"))
		{
			for(int i = 0 ; i < hand.length;i++)
			{
				int index = 0;
				if(hand[i].getRight() < hand[i + 1].getRight())
				{
					index = i;
				}
				return index;
			}
		}
		return 0; 
	}
	
	public void computerMove()
	{
		firstMove();
		
	}


	
	





}
