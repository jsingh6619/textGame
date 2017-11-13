package abidAbedJasMinigame;

public class JasBackend implements AbidSupportBack, AbedSupportBack{

	private JasSupportFront frontend;
	private JasSupportAI ai;
	
	
	public JasBackend() {
		
	}


	@Override
	public void setFrontend(AbidFrontend abidFrontend) {
		this.frontend = frontend;
		
	}


	@Override
	public void setAI(AbedAI ai) {
		this.ai= ai;
		
	}
}
