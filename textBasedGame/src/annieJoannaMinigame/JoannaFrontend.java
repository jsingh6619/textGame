package annieJoannaMinigame;

import java.util.Scanner;

import caveExplorer.*;

public class JoannaFrontend implements AnnieSupport{

	
	private JoannaSupport backend;
	private int jellyfishCount;
	private AnnieJoannaPlot currentRoom;
	private boolean won;
	private AnnieAI opponent;
	
	
	private AnnieJoannaPlot[][] plots;
	
	public JoannaFrontend() {
		backend = new AnnieBackend(this);
		opponent = backend.getOpponent();
		plots = backend.getPlots();
		jellyfishCount = 0;
		won = false;
		currentRoom = plots[0][0];
		currentRoom.enter("X");
		CaveExplorer.in = new Scanner(System.in);
	} 

	public static void main(String[] args) {
			JoannaFrontend demo = new JoannaFrontend();
			demo.play();
	}

	public void play() {
		instructions();
		while(backend.stillPlaying()){
	        displayBoard();
	        displayScore();
	        String input = backend.getValidUserInput();
	        if(input.equals("cheat")) {
	        	winGame();
	        	break;
	        }
	        respondToInput(input);
	        backend.computerMove();
	        updateScore();
		}
		 displayBoard();
        displayScore();
        printGameOverMessage(backend.victorious());
	}

	private void winGame() {
		jellyfishCount += backend.getJellyfishNum();
		opponent.setJellyfishCount(0);
		backend.catchAllJellyfish();
    }

	private void instructions() {
		CaveExplorer.print("Compete against " + opponent.getName() + " in jellyfishing. Whoever catches the most jellyfish wins.\nIf you win, you get to keep 1 of every 3 jellyfish caught; if you tie, you don't get anything.");
	}

	private void printGameOverMessage(boolean victorious) {
		String s = "\n----- GAME OVER -----\n\n";
		if(victorious) {
			won = true;
			s+= determineWinner("You", getJellyfishCount());
		}else {
			if(opponent.getJellyfishCount() != jellyfishCount)
				s+= determineWinner(opponent.getName(), opponent.getJellyfishCount());
			else
				s+= "You tied with " +opponent.getName(); 
		}
		CaveExplorer.print(s);
	}

	private String determineWinner(String name, int n) {
		return  name +" won with a total of " + n + " jellyfish.";
	}

	private void updateScore() {
		AnnieJoannaPlot opponentPlot = opponent.getCurrentPlot();
		if(!currentRoom.equals(opponentPlot)) {
			if(currentRoom.isJellyfishPresent()) {
				currentRoom.catchJellyfish();
				jellyfishCount++;
			}
			if(opponentPlot.isJellyfishPresent()) {
				opponentPlot.catchJellyfish();
				opponent.setJellyfishCount(opponent.getJellyfishCount() + 1);
			}
		} else
			currentRoom.catchJellyfish();
	}

	private void respondToInput(String input) {
		int dir = changeToDir(input);
		if(currentRoom.getConnection(dir) != null) {
			currentRoom.leave();
			currentRoom = currentRoom.getPlot(dir);
			currentRoom.enter("X");			
		}else {
			CaveExplorer.print("You can't do that!");
		}
	}
	
	private int changeToDir(String input) {
		String s = "wasd"; // 0 
		return s.indexOf(input); 
	}

	private void displayScore() {
		CaveExplorer.print("You: " + jellyfishCount + "\n" + opponent.getName() +": "+ opponent.getJellyfishCount() );
	}

	private void displayBoard() {
		CaveExplorer.print(updateBoard());	
	}

	private String updateBoard() {
		String map = "\n ";
		for(int i = 0; i < plots[0].length - 1; i++)
			map += "____";
		map += "___\n";
		for(AnnieJoannaPlot[] row: plots)
			for(int i = 0; i < 3; i++) {
				String text = "";
				for(AnnieJoannaPlot plot: row) {
					if(plot.getConnection(AnnieJoannaPlot.WEST) != null )
						text += " ";
					else
						text += "|";
					if(i == 0)
						text += "   ";
					else if(i == 1)
						text += " " + plot.getContents() + " ";
					else if(i == 2)
						if(plot.getConnection(AnnieJoannaPlot.SOUTH) != null)
							text += "   ";
						else
							text += "___";
				}
				text += "|";
				map += text + "\n";
			}
		return map;
	}
	
	public int getJellyfishCount() {
		return jellyfishCount;
	}

	public boolean isWon() {
		return won;
	}

	

	public String getOpponentName() {
		return opponent.getName();
	}
}

