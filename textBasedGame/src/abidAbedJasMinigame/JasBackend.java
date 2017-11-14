package abidAbedJasMinigame;

public class JasBackend implements AbidSupportBack, AbedSupportBack{

	private JasSupportFront frontend;
	private JasSupportAI ai;
	
	
	public JasBackend() {
		
	}

	public void setFrontend(AbidFrontend abidFrontend) {
		this.frontend = frontend;
	}


	public void setAI(AbedAI ai) {
		this.ai= ai;
	}
	
	public String winner() {
		
	}
	/*
	 * call the hasHigher() and whoever had that value is the winner --> need a method to get their scores
	 * if computer wins return 'computer wins'
	 * else 'user wins'
	 */
	
	
	public int hasHigher(int score1, int score2) {
		if(score1 > score2) {
			return score1;
		}
		else {
			return score2;
		}
	}

	@Override
	public boolean stillPlaying() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getValidUserInput() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean victorious() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void dealCards() {
		// TODO Auto-generated method stub
		
	}
}
