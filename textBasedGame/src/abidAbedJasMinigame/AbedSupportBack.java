package abidAbedJasMinigame;

public interface AbedSupportBack 
{



	int getUserScore();
	int getAiScore();
	
	int getLastMoveX();//returns where the card was on board Xcoordinate
	int getLastMoveY();//returns where the card was on board Ycoordinate
	AbidCard getLastCard();///returns the class


}
