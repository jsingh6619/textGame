package abidAbedJasMinigame;

public interface AbedSupportBack 
{



	int getSpongebobScore();
	int getPlanktonScore();
	int getCardRow();//returns where the card was on board Xcoordinate
	int getCardCol();//returns where the card was on board Ycoordinate
	AbidCard getLastCard();///returns the class
	void setCard(int row, int col, int index);


}
