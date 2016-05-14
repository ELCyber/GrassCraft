package Ai;

import control.GameControl;

public class Ai {
	
	private GameControl gameControl;
    private int aiAct;
    private int moveDirection;
    private int offendDirection;
	public Ai(GameControl gameControl){
		this.gameControl = gameControl;
	}
	
	public void judgeAction(){
		//aiAct为0或1
		aiAct=(int) (Math.random() * 2 );
		//随机移动方向 0 1 2 3 上 下 左 右
		moveDirection=(int) (Math.random() * 4);
		//随机攻击方向4 5 6 7 上 下 左 右
		offendDirection=(int) (Math.random() * 4+4);
		//aiAct为0时，先移动后攻击 否则 先攻击后移动
		if(aiAct==0){
			doAction(moveDirection);
			doAction(offendDirection);
		}else{
			doAction(offendDirection);
			doAction(moveDirection);
		}
		
	}
	
	
	public void doAction(int cmd){
		switch(cmd){		
		case 0: 	
			if (this.gameControl.canMove()) {
			this.gameControl.KeyUp();
//			System.out.println(0);
		}
		break;
		case 1:	
			if (this.gameControl.canMove()) {
			this.gameControl.KeyDown();
//			System.out.println(1);
		}
		break;
		case 2:
			if (this.gameControl.canMove()) {
			this.gameControl.KeyLeft();
//			System.out.println(2);
		}
		break;
		case 3:
			if (this.gameControl.canMove()) {
			this.gameControl.KeyRight();
//			System.out.println(3);
		}
		case 4: 
			if(this.gameControl.canOffend()){
			this.gameControl.KeyOffendUp();
//			System.out.println(4);
		}
		break;
		case 5: 
			if(this.gameControl.canOffend()){
			this.gameControl.KeyOffendDown();
//			System.out.println(5);
		}
		break;
		case 6: 
			if(this.gameControl.canOffend()){
        	this.gameControl.KeyOffendLeft();
//        	System.out.println(6);
		}
		break;
		case 7: 
			if(this.gameControl.canOffend()){
			this.gameControl.KeyOffendRight();
//			System.out.println(7);
		}
		break;
		default: System.out.println("出错啦! 你这个大笨蛋！"); break;
	  }
	}
}

