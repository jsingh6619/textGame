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
		return (int)(Math.random() * multiplier);
	}


	public void dealCards() 
	{
		hand = new AbidCard[5];
		for(int i = 0; i < hand.length;i++)
		{
			hand[i] = new AbidCard(generateNum(9),generateNum(9),generateNum(9),generateNum(9),"P");
		}
		
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
				if(hand[i] == null)
				{
					i++;
				}
				else if(hand[i].getBottom() < hand[i + 1].getBottom())
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
				if(hand[i] != null && hand[i+1] !=null)
				{	
					if(hand[i].getTop() < hand[i + 1].getTop())
					{
						index = i;
					}
					return index;
				}
				else 
				{
					i++;
				}
			}
		}
		if(p.equals("left"))
		{
			for(int i = 0 ; i < hand.length;i++)
			{
				int index = 0;
				if(hand[i] == null)
				{
					i++;
				}
				else if(hand[i].getLeft() < hand[i + 1].getLeft())
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
				if(hand[i] == null)
				{
					i++;
				}
				else if(hand[i].getRight() < hand[i + 1].getRight())
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
		
		int row = generateNum(4);
		int col = generateNum(4);
		int index = generateNum(5);
		if(backend.getBoard()[row][col] != null)
		{
			 row = generateNum(4);
			 col = generateNum(4);
		}
		if(hand[index] == null)
		{
			index = generateNum(5);
		}
		backend.setCard(row,col,index,hand);
		hand[index] = null;
		/*if(hand.length == 5)
		{
			firstMove();
		}
		if(backend.getPlanktonScore() < backend.getSpongebobScore())
		{
			aggressivePlay();
		}
		else if(backend.getPlanktonScore() > backend.getSpongebobScore())
		{
			conservativePlay();
		}
		*/
	}
	private void conservativePlay() 
	{
		
	}
	private void aggressivePlay() 
	{
		     
	}
	public void firstMove()
	{
		if(backend.getBoard()[0][3] == null)
		{
			setMove(0,3,"bottom");
		}
		else if(backend.getBoard()[0][0] == null)
		{
			setMove(0,0,"bottom");
		}
		else if(backend.getBoard()[3][3] == null)
		{
			setMove(3,3,"top");
		}
		else if(backend.getBoard()[3][0] == null)
		{
			setMove(3,0,"top");
		}
		
	}
	
	





}
