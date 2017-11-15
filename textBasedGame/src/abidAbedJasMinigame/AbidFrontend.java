package abidAbedJasMinigame;

public class AbidFrontend implements JasSupportFront , AbedSupportFront {
	
	private AbidSupportBack backend;
	private AbidSupportAI ai;
	
	
	public static final void main(String[] args) {
		AbidFrontend demo = new AbidFrontend();
		demo.displayBoard();
	}
	

	
	public void displayBoard() {
		
		for(int i = 0; i < 4; i++) {
			System.out.print("_______\n|     |\n|     |\n|__ __|\n");
		}
		
	/*	_______
	    |  6  | 
	    |6 S 6|
	    |__6__|
	*/
	}

	@Override
	public void showCard() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void displayScore() {
		// TODO Auto-generated method stub
		
	}
}
