package abidAbedJasMinigame;

import caveExplorer.CaveExplorer;

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
		
		int index = 0;
		int firstB = hand[0].getBottom();
		int firstT = hand[0].getTop();
		int firstL = hand[0].getLeft();
		int firstR = hand[0].getRight();
		
		if(p.equals("bottom"))
		{
			
			for(int i = 0 ; i < hand.length;)
			{
				
				
				if(hand[i] == null)
				{
					i++;
				}
				else if(firstB < hand[i].getBottom())
				{
					firstB = hand[i].getBottom();
					index = i;
				}
				return index;
			}
		}
		if(p.equals("top"))
		{
			
			for(int i = 0 ; i < hand.length;)
			{
				
				
				if(hand[i] == null)
				{
					i++;
				}
				else if(firstT < hand[i].getTop())
				{
					firstT = hand[i].getTop();
					index = i;
				}
				return index;
			}
		}
		if(p.equals("left"))
		{
			
			for(int i = 0 ; i < hand.length;)
			{
				
				if(hand[i] == null)
				{
					i++;
				}
				else if(firstL < hand[i].getLeft())
				{
					firstL = hand[i].getLeft();
					index = i;
				}
				return index;
			}
		}
		if(p.equals("right"))
		{
		
			for(int i = 0 ; i < hand.length;)
			{
				
				if(hand[i] == null)
				{
					i++;
				}
				else if(firstR < hand[i].getRight())
				{
					firstR = hand[i].getRight();
					index = i;
				}
				return index;
			}
		}
		return 0; 
	}
	
	private int nullCounter(AbidCard[] a)
	{
		int x = 0;
		for(int i = 0; i < a.length;i++)
		{
			if(hand[i] == null)
			{
				x++;
			}
		}
		return x;
	}
	
	public void computerMove()
	{

		if(nullCounter(hand) == 0)

		{
			firstMove();
		}
		else
		{
			if(backend.getPlanktonScore() < backend.getSpongebobScore())
			{
				aggressivePlay();
			}
			else if(backend.getPlanktonScore() > backend.getSpongebobScore())
			{
				conservativePlay();
			}
		}
		
	}
	private void conservativePlay() 
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
	}
	private void aggressivePlay() 
	{
		AbidCard lastCard = backend.getLastCard();
		if(weakLink(lastCard) == "top" && backend.getCardRow() !=0)
		{
			setMove(backend.getCardRow()-1,backend.getCardCol(),"bottom");
		}
		else if (weakLink(lastCard) == "top" && backend.getCardRow() == 0)
		{
			conservativePlay();
		}
		if(weakLink(lastCard) == "bottom" && backend.getCardRow() !=3)
		{
			setMove(backend.getCardRow()+1,backend.getCardCol(),"top");
		}
		else if(weakLink(lastCard) == "bottom" && backend.getCardRow() ==3)
		{
			conservativePlay();
		}
		if(weakLink(lastCard) == "left" && backend.getCardCol() !=0)
		{
			setMove(backend.getCardRow(),backend.getCardCol()-1,"right");
		}
		else if(weakLink(lastCard) == "left" && backend.getCardCol() ==0)
		{
			conservativePlay();
		}
		if(weakLink(lastCard) == "right" && backend.getCardCol() !=3)
		{
			setMove(backend.getCardRow(),backend.getCardCol()+1,"left");
		}
		else if(weakLink(lastCard) == "right" && backend.getCardCol() ==3)
		{
			conservativePlay();
		}
	}
	
	private String weakLink(AbidCard lastCard) 
	{
		int[] cardNum = new int[4];
		int carry = 0;
		cardNum[0] = lastCard.getTop();
		cardNum[1] = lastCard.getBottom();
		cardNum[2] = lastCard.getLeft();
		cardNum[3] = lastCard.getRight();
		int min  = cardNum[0];;
		for(int i = 0; i < cardNum.length;i++)
		{
			if(cardNum[i] < min)
			{
				min = cardNum[i];
				min = carry;
			}
			else
			{
				i++;
			}
		}
		if(carry == cardNum[0])
		{
			return "top";
			
		}
		if(carry == cardNum[1])
		{
			return "bottom";
			
		}
		if(carry == cardNum[2])
		{
			return "left";
			
		}
		if(carry == cardNum[3])
		{
			return "right";
			
		}
		return " ";
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