package control;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class PlayerControl implements KeyListener, MouseListener{

	private GameControl gameControl;
	private int cure = 7;
	//体力设置；

	public PlayerControl(GameControl gameControl) {
		this.gameControl = gameControl;
	}

	
	// 实现基本的上下左右、攻击（注意有四个方向，所以是四个按键WASD）、确认 等 键盘 操作 and 重新开始游戏、返回主界面、退出游戏等 鼠标 操作
	// 判断的时候引用gameControl来判断，注意Enter
	


	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	// 重写哦，里面代码（或思想）提供了一些思路，所以没改动，暂时会报错
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
			//回车表示所有指令执行完毕，控制权交给下一人，重写
			//血量初始化为7；
//			this.gameControl.KeyNextPlayer();
			this.cure=7;
			break;
		default:
			break;
		}
	}
	
	
	
	
	
// 放到GameControl里面
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
