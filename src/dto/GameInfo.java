package dto;

public class GameInfo {
	private int turns;
	private Grassman[] grassmans;
	public int[][] map;
	
	public GameInfo(int turns, Grassman[] grassmans, int[][] map){
		this.turns = turns;
		this.grassmans = grassmans;
		this.map = map;
	}
	
	public GameInfo(Grassman[] grassmans){
		this.turns = 96;
		this.grassmans = grassmans;
	}
	
	public int getTurns(){
		return this.turns;
	}
	
	public Grassman[] getGrassmans(){
		return this.grassmans;
	}
	
    public void setTurns(){
    	turns++;
    }
	


}
