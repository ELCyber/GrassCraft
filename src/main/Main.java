package main;

import com.sun.awt.AWTUtilities;

import music.Player;
import ui.FrameGame;

public class Main {

	public static void main(String[] args) {
		FrameGame frame=new FrameGame();
		//设置窗体透明,调用jdk本身已有的jar包,目的是使开场动画效果更好
		AWTUtilities.setWindowOpaque(frame, false);
		//TODO 播放音乐,随便放的,好像播放音乐的比特率要在128kbps以下，因为bgm04是320kbps，放不了
	    Player.playMusic("game");
	}

}
