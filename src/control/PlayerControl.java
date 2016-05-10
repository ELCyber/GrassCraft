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
		/*
		 * 移动方向
		 */
		case KeyEvent.VK_UP:
			if (this.gameControl.canMove()) {
				this.gameControl.KeyUp();
			}
			break;

		case KeyEvent.VK_DOWN:
			if (this.gameControl.canMove()) {
				this.gameControl.KeyDown();
			}
			break;

		case KeyEvent.VK_LEFT:
			if (this.gameControl.canMove()) {
				this.gameControl.KeyLeft();
			}
			break;

		case KeyEvent.VK_RIGHT:
			if (this.gameControl.canMove()) {
				this.gameControl.KeyRight();
			}
			break;
			/*
			 * 回车换回合
			 */
		case KeyEvent.VK_ENTER:
			//回车表示所有指令执行完毕，控制权交给下一人，重写
			//血量初始化为7；
//			this.gameControl.KeyNextPlayer();
			this.cure=7;
			break;
			
			/*
			 * 攻击方向
			 */
			//向上攻击
		case KeyEvent.VK_W:
			if(this.gameControl.canOffend()){
				
			}
			break;
			//向左攻击
		case KeyEvent.VK_A:
            if(this.gameControl.canOffend()){
				
			}
			break;
			//向下攻击
		case KeyEvent.VK_S:
			 if(this.gameControl.canOffend()){
					
				}
			break;
			//向右攻击
		case KeyEvent.VK_D:
			 if(this.gameControl.canOffend()){
					
				}
			break;
		default:
			break;
		}
	}
	

}
