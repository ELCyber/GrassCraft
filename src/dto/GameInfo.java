package dto;

public class GameInfo {
	private int turns;
	private Grassman[] grassmans;
	private int[][] map;
	
	public GameInfo(int turns, Grassman[] grassmans, int[][] map){
		this.turns = turns;
		this.grassmans = grassmans;
		this.map = map;
	}
	
	public int getTurns(){
		return this.turns;
	}
	
	public Grassman[] getGrassmans(){
		return this.grassmans;
	}
	
	public int[][] getMap(){
		return this.map;
	}
	

}
