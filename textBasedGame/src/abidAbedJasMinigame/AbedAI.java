package abidAbedJasMinigame;

public class AbedAI implements AbidSupportAI, JasSupportAI
{
	private AbedSupportFront frontend;
	private AbedSupportBack backend;

	public void computerMove() {
		backend.getLastMove();
	}



	@Override
	public void dealCards() {
		// TODO Auto-generated method stub
		
	}

}
