package abidAbedJasMinigame;

public class AbidFrontend implements JasSupportFront , AbedSupportFront {
	
	private AbidSupportBack backend;
	private AbedAI ai;
	
	
	public static final void main(String[] args) {
		AbidFrontend demo = new AbidFrontend();
		demo.play();
	}
	
	private void play() {
		
	}

	public AbidFrontend() {
		backend = new JasBackend();
		ai = new AbedAI();
		backend.setAI((AbedAI)ai);
		ai.setBackend((JasBackend)backend);
		backend.setFrontend(this);
		ai.setFrontend(this);
	}
}
