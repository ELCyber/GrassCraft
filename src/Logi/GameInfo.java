package Logi;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GameInfo implements KeyListener{
	public static final int PLAYER_NUM = 6;
	public static final int MAXBLOOD = 3;
	public int turns;
	public int side;
	public int weapon;
	public int width, height;
	public int turn;
	public int[][] field;
	public PlayerInfo[] playerInfo;
	
	public GameInfo(GameInfo info){
		this.turns = info.turns;
		this.side = info.side;
		this.weapon = info.weapon;
		this.width = info.width;
		this.height = info.height;	
		this.playerInfo = info.playerInfo;
		this.turn = info.turn;
		this.field = info.field;
	}
	
	public GameInfo(){
		this.turns = 96;
		this.side = 1;
		this.weapon = 0;
		this.width = 15;
		this.height = 15;
		
		this.playerInfo = new PlayerInfo[GameInfo.PLAYER_NUM];
		for (int i = 0; i < GameInfo.PLAYER_NUM; ++i){		
		    this.playerInfo[i] = new PlayerInfo();
		}
		
		this.playerInfo[0].homeX = 0;
		this.playerInfo[0].homeY = 9;
		this.playerInfo[1].homeX = 0;
		this.playerInfo[1].homeY = 14;
		this.playerInfo[2].homeX = 5;
		this.playerInfo[2].homeY = 14;
		for(int i = 3; i < 6; i++){
			this.playerInfo[i].homeX = this.playerInfo[5-i].homeY;
			this.playerInfo[i].homeY = this.playerInfo[5-i].homeX;
		}
		
		this.turn = 0;
		this.field = new int[this.height][this.width];
		System.out.println("Begin!");
	}
	
	public void keyPressed(KeyEvent e) {
		PlayerInfo myself = this.playerInfo[this.weapon];
		int curX = myself.curX;
		int curY = myself.curY;

		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			curX = curX;
			curY = curY + 1;
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			curX = curX + 1;
			curY = curY;
		}
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			curX = curX;
			curY = curY - 1;
		}
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			curX = curX - 1;
			curY = curY;
		}
	
		
}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}