import java.applet.Applet;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class PlayerInfo extends Applet implements KeyListener {
	public int homeX, homeY; // ��ʼ���
	public int curX, curY; // ��ǰ���
	public int score, hidden; // ���� ���� ����
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

		if (curX < 0 || info.width <= curX || curY < 0 || info.height <= curY) { // ����
			return false;
		}
		for (int i = 0; i < GameInfo.PLAYER_NUM; ++i) { // �ص�
			if (curX == info.PlayerInfo[i].curX && curY == this.samuraiInfo[i].curY) {
				return false;
			}
			if (i != this.weapon && (curX == this.samuraiInfo[i].homeX && curY == this.samuraiInfo[i].homeY)) {
				return false; // ��ռ�����˵ļ���
			}
		}
	}

}
