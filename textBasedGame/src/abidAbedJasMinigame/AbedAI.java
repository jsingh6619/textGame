package abidAbedJasMinigame;

public class AbedAI implements AbidSupportAI, JasSupportAI
{
	private AbedSupportFront frontend;
	private AbedSupportBack backend;
	private AbidCard[] hand;

	public int getLastUserX() 
	{
		return backend.getLastMoveX();
	}
	public int getLastUserY()
	{
		return backend.getLastMoveY();
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
			hand[i] = new AbidCard(generateNum(),generateNum(),generateNum(),generateNum());
		}
		
	}
	public void determineFirstMove()
	{
		if()
	}
	private void determineNextMove() 
	{
		
		
	}
	public void play()
	{
		dealCards();
		determineFirstMove();
		determineNextMove();
	}
	@Override
	public void computerMove() {
		// TODO Auto-generated method stub
		
	}
	

	
	





}
