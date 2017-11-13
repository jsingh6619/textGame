package annieJoannaMinigame;

public class JoannaFrontend implements AnnieSupport{

	private JoannaSupport backend;
	
	public JoannaFrontend() {
		backend = new AnnieBackend(this);
	}

	public static void main(String[] args) {
		JoannaFrontend demo = new JoannaFrontend();
		demo.play();
	}

	private void play() {
		
	}
	
	

}
