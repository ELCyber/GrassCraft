package control;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import music.Player;
/**
 *实现基本的上下左右、攻击（注意有四个方向，所以是四个按键WASD）、确认 等 键盘 操作 and 重新开始游戏、返回主界面、退出游戏等 鼠标 操作
 */
public class PlayerControl implements KeyListener{

	private GameControl gameControl;
	
	public boolean tryOffendUp=false;
	public boolean tryOffendDown=false;
	public boolean tryOffendLeft=false;
	public boolean tryOffendRight=false;

	public PlayerControl(GameControl gameControl) {
		this.gameControl = gameControl;
	}



	
	/*
	 * 键盘监听
	 */
	@Override
	public void keyPressed(KeyEvent e) {
		 
		switch (e.getKeyCode()) {
		/*
		 * 移动方向
		 */
		case KeyEvent.VK_UP:
			
			if (this.gameControl.canMove()) {
				if(tryOffendUp||tryOffendDown||tryOffendLeft||tryOffendRight){
					this.gameControl.reSetBlockColor();
					tryOffendUp=false;
					tryOffendDown=false;
					tryOffendLeft=false;
					tryOffendRight=false;
				}
				Player.playSound("移动");
				this.gameControl.KeyUp();
			}else{
				Player.playSound("warning");
			}
			break;

		case KeyEvent.VK_DOWN:
			if (this.gameControl.canMove()) {
				if(tryOffendUp||tryOffendDown||tryOffendLeft||tryOffendRight){
					this.gameControl.reSetBlockColor();
					tryOffendUp=false;
					tryOffendDown=false;
					tryOffendLeft=false;
					tryOffendRight=false;
				}
				Player.playSound("移动");
				this.gameControl.KeyDown();
			}else{
				Player.playSound("warning");
			}
			break;

		case KeyEvent.VK_LEFT:
			if (this.gameControl.canMove()) {
				if(tryOffendUp||tryOffendDown||tryOffendLeft||tryOffendRight){
					this.gameControl.reSetBlockColor();
					tryOffendUp=false;
					tryOffendDown=false;
					tryOffendLeft=false;
					tryOffendRight=false;
				}
				Player.playSound("移动");
				this.gameControl.KeyLeft();
			}else{
				Player.playSound("warning");
			}
			break;

		case KeyEvent.VK_RIGHT:
			if (this.gameControl.canMove()) {
				if(tryOffendUp||tryOffendDown||tryOffendLeft||tryOffendRight){
					this.gameControl.reSetBlockColor();
					tryOffendUp=false;
					tryOffendDown=false;
					tryOffendLeft=false;
					tryOffendRight=false;
				}
				Player.playSound("移动");
				this.gameControl.KeyRight();
			}else{
				Player.playSound("warning");
			}
			break;
			/*
			 * 回车换回合
			 */
		case KeyEvent.VK_ENTER:
			//回车表示所有指令执行完毕，控制权交给下一人
			if(!gameControl.isGameover()){
				Player.playSound("确定");
			    this.gameControl.KeyEnter();
			}else{
				System.out.println("game over");
				gameControl.getMapP().removeKeyListener(PlayerControl.this);
			}
			break;
			
			/*
			 * 尝试攻击方向
			 */
			//向上攻击
		case KeyEvent.VK_W:
			if(this.gameControl.canOffend()){
				if(tryOffendDown||tryOffendLeft||tryOffendRight){
					this.gameControl.reSetBlockColor();
					tryOffendDown=false;
					tryOffendLeft=false;
					tryOffendRight=false;
				}
				this.gameControl.offendUpScope();
				tryOffendUp=true;
				
			}else{
				Player.playSound("warning");
			}
			break;
			//向左攻击
		case KeyEvent.VK_A:
            if(this.gameControl.canOffend()){
            	if(tryOffendDown||tryOffendUp||tryOffendRight){
					this.gameControl.reSetBlockColor();
					tryOffendDown=false;
					tryOffendUp=false;
					tryOffendRight=false;
				}
            	this.gameControl.offendLeftScope();
            	tryOffendLeft=true;
                
			}else{
				Player.playSound("warning");
			}
			break;
			//向下攻击
		case KeyEvent.VK_S:
			 if(this.gameControl.canOffend()){
				 if(tryOffendUp||tryOffendLeft||tryOffendRight){
	                	this.gameControl.reSetBlockColor();
	                	tryOffendUp=false;
						tryOffendLeft=false;
						tryOffendRight=false;
					}
				this.gameControl.offendDownScope();
				tryOffendDown=true;
                
			}else{
				Player.playSound("warning");
			}
			break;
			//向右攻击
		case KeyEvent.VK_D:
			 if(this.gameControl.canOffend()){
				 if(tryOffendDown||tryOffendLeft||tryOffendUp){
	                	this.gameControl.reSetBlockColor();
	                	tryOffendDown=false;
						tryOffendLeft=false;
						tryOffendUp=false;
					}
				this.gameControl.offendRightScope();
				tryOffendRight=true;
			}else{
				Player.playSound("warning");
			}
			break;
		case KeyEvent.VK_SPACE:
			Player.playSound("攻击");
			if(tryOffendUp){
				this.gameControl.KeyOffendUp();
				tryOffendUp=false;
			}
			if(tryOffendDown){
				this.gameControl.KeyOffendDown();
				tryOffendDown=false;
			}
			if(tryOffendLeft){
				this.gameControl.KeyOffendLeft();
				tryOffendLeft=false;
			}
			if(tryOffendRight){
				this.gameControl.KeyOffendRight();
				tryOffendRight=false;
			}
		default:
			break;
		}
	}




	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}




	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	

}
