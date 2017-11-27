package abidAbedJasMinigame;

public class AbedAI implements AbidSupportAI, JasSupportAI
{
	private AbedSupportFront frontend;
	private AbedSupportBack backend;
	private AbidCard[] hand;

	
	public AbedAI(AbedSupportFront front,AbedSupportBack back)
	{
		this.frontend = front;
		this.backend = back;
		dealCards();
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
	
	public void setMove(int row, int col,String p) 
	{
	
		backend.setCard(row,col,strongestCardIndex(p),hand);
		hand[strongestCardIndex("bottom")] = null;
		
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
		if(backend.getBoard()[0][3] == null)
		{
			setMove(0,3,"bottom");
		}
		if(backend.getBoard()[0][0] == null)
		{
			setMove(0,0,"bottom");
		}
		if(backend.getBoard()[3][3] == null)
		{
			setMove(3,3,"top");
		}
		if(backend.getBoard()[3][0] == null)
		{
			setMove(3,0,"top");
		}
		
		
	}


	
	





}
