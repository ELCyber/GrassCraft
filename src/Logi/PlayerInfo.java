package Logi;

public class PlayerInfo {
	public int homeX, homeY;
	public int curX, curY;
	public int hidden;
	public int curBlood;
	
	public PlayerInfo(){
		this.homeX = 0;
		this.homeY = 0;
		this.curX = 0;
		this.curY = 0;
		this.hidden = 0;
		this.curBlood = GameInfo.MAXBLOOD;
	}
}
