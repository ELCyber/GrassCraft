package control;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class PlayerControl extends KeyAdapter {

	private GameControl gameControl;
	private int blood = 7;
	//血量设置；

	public PlayerControl(GameControl gameControl) {
		this.gameControl = gameControl;
	}

	/*
	 * ���̰����¼�
	 */

	@Override
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_UP:
			if (bloodChange("move")) {
				this.gameControl.KeyUp();
			}
			break;

		case KeyEvent.VK_DOWN:
			if (bloodChange("move")) {
				this.gameControl.KeyDown();
			}
			break;

		case KeyEvent.VK_LEFT:
			if (bloodChange("move")) {
				this.gameControl.KeyLeft();
			}
			break;

		case KeyEvent.VK_RIGHT:
			if (bloodChange("move")) {

				this.gameControl.KeyRight();
			}
			break;
		case KeyEvent.VK_ENTER:
			//回车表示所有指令执行完毕，控制权交给下一人；
			//血量初始化为7；
			this.gameControl.KeyNextPlayer();
			this.blood=7;
			break;
		default:
			break;
		}
	}

	public boolean bloodJudge(int bloodAfterAction) {
		if (bloodAfterAction >= 0) {
			return true;
		}
		return false;
	}

	public boolean bloodChange(String action) {
		//判断血量是否足够
		//足够则返回true并且血量实现相应的减少
		boolean canAct = false;
		switch (action) {
		case "move":
			if (bloodJudge(this.blood - 2)) {
				this.blood -= 2;
				canAct = true;
			}
			break;
		case "hide":
			if (bloodJudge(this.blood - 1)) {
				this.blood -= 1;
				canAct = true;
			}

			break;
		case "appear":
			if (bloodJudge(this.blood - 1)) {
				this.blood -= 1;
				canAct = true;
			}
			break;
		case "attack":
			if (bloodJudge(this.blood - 3)) {
				this.blood -= 3;
				canAct = true;
			}
			break;
		default:
			break;
		}
		return canAct;
	}

}
