import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.applet.*;

public class GameInfo{
	
	public static final int PLAYER_NUM = 6;
	public int turns;
	public int side;
	public int weapon;
	public int width, height;
	public int maxCure;
	public int maxBlood;
	public int turn;
	public int[][] field;
	public int money;   // Money used for buying stuff at store; 
	public PlayerInfo[] playerInfo;
	
	public GameInfo(int turn){
		this.turns = 96;
		this.side = 2;
		this.weapon = 3;
		this.width = 15;
		this.height = 15;
		this.maxCure = 7;
		this.maxBlood = 3;
		this.field = new int[width][height];
		this.turn = turn;
	}
	

}
