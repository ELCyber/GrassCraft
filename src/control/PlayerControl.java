package control;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class PlayerControl extends KeyAdapter{
	
    private GameControl gameControl;
    
    public PlayerControl(GameControl gameControl){
    	this.gameControl=gameControl;
    }
    
	/*
	 * ���̰����¼�
	 */
	
	
	@Override
	public void keyPressed(KeyEvent e) {
		switch(e.getKeyCode()){
		  case KeyEvent.VK_UP:
			this.gameControl.KeyUp();
		         break;
		     
		  case KeyEvent.VK_DOWN:
			  this.gameControl.KeyDown();
			     break;
			     
			     
		  case KeyEvent.VK_LEFT:
			  this.gameControl.KeyLeft();
			     break;
			     
			     
		  case KeyEvent.VK_RIGHT:
			  this.gameControl.KeyRight();
			     break;
		  case KeyEvent.VK_ENTER  :
			  this.gameControl.KeyNextPlayer();
			  break;
	    default:
		     	 break;
		}
	}

}
