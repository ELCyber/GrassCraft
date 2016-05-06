package Logi;

public class TurnCounter {
	public static int turn;
	
	public TurnCounter(){    		
		TurnCounter.turn = 0;
	}
	
	public TurnCounter(int newTurn){
		TurnCounter.turn = newTurn;
	}
	
	public boolean isGameover(){
		if(TurnCounter.turn == 96)
			return true;
		else
			return false;
	}
	
	public int isWhoseTurn(){
		switch(TurnCounter.turn % 12){
		case 1 | 8 : System.out.println("A1's turn."); return 0;
		case 2 | 7 : System.out.println("A2's turn."); return 3;
		case 4 | 9 : System.out.println("B1's turn."); return 1;
		case 3 | 10 : System.out.println("B2's turn."); return 4;
		case 0 | 5 : System.out.println("C1's turn."); return 2;
		case 6 | 11 : System.out.println("C2's turn."); return 5;
		default : System.out.println("Error!");	return -1;
		}
	}
}
