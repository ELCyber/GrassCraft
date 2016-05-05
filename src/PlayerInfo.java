import java.applet.Applet;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class PlayerInfo extends Applet implements KeyListener {
	public int homeX, homeY; // 起始坐标
	public int curX, curY; // 当前坐标
	public int score, hidden; // 排名， 分数， 隐藏
	public int curBlood, curCure;

	public PlayerInfo() {
		this.homeX = 0;
		this.homeY = 0;
		this.curX = 0;
		this.curY = 0;
		this.score = 0;
		this.hidden = 0;
		this.curBlood = 3;
		this.curCure = 7;
	}

	public boolean action(KeyEvent e, GameInfo info) {
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

		if (curX < 0 || info.width <= curX || curY < 0 || info.height <= curY) { // 出界
			return false;
		}
		for (int i = 0; i < GameInfo.PLAYER_NUM; ++i) { // 重叠
			if (curX == info.PlayerInfo[i].curX && curY == this.samuraiInfo[i].curY) {
				return false;
			}
			if (i != this.weapon && (curX == this.samuraiInfo[i].homeX && curY == this.samuraiInfo[i].homeY)) {
				return false; // 侵占到别人的家里
			}
		}
	}

}
