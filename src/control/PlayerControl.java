package control;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class PlayerControl extends KeyAdapter {

	private GameControl gameControl;
	private int cure = 7;
	//体力设置；

	public PlayerControl(GameControl gameControl) {
		this.gameControl = gameControl;
	}

	

	@Override
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_UP:
			if (cureChange("move")) {
				this.gameControl.KeyUp();
			}
			break;

		case KeyEvent.VK_DOWN:
			if (cureChange("move")) {
				this.gameControl.KeyDown();
			}
			break;

		case KeyEvent.VK_LEFT:
			if (cureChange("move")) {
				this.gameControl.KeyLeft();
			}
			break;

		case KeyEvent.VK_RIGHT:
			if (cureChange("move")) {

				this.gameControl.KeyRight();
			}
			break;
		case KeyEvent.VK_ENTER:
			//回车表示所有指令执行完毕，控制权交给下一人；
			//血量初始化为7；
			this.gameControl.KeyNextPlayer();
			this.cure=7;
			break;
		default:
			break;
		}
	}

	public boolean cureJudge(int cureAfterAction) {
		if (cureAfterAction >= 0) {
			return true;
		}
		return false;
	}

	public boolean cureChange(String action) {
		//判断血量是否足够
		//足够则返回true并且血量实现相应的减少
		boolean canAct = false;
		switch (action) {
		case "move":
			if (cureJudge(this.cure - 2)) {
				this.cure -= 2;
				canAct = true;
			}
			break;
		case "hide":
			if (cureJudge(this.cure - 1)) {
				this.cure -= 1;
				canAct = true;
			}

			break;
		case "appear":
			if (cureJudge(this.cure - 1)) {
				this.cure -= 1;
				canAct = true;
			}
			break;
		case "attack":
			if (cureJudge(this.cure - 3)) {
				this.cure -= 3;
				canAct = true;
			}
			break;
		default:
			break;
		}
		return canAct;
	}

}
