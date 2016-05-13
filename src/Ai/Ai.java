package Ai;

import control.GameControl;

public class Ai {
	
	private GameControl gameControl;
	private int weapon;
	private int[] Action = {0,0,0,0};

	public Ai(GameControl gameControl){
		if(gameControl.isWhoseTurn() > 2)
		this.gameControl = gameControl;
	}
	
	public void judgeAction(){
		for(int i = 0; i < Action.length - 1; i++){
			if(this.gameControl.canMove()){
			this.Action[i] = (int) (Math.random() * 4 + 1); 
		}
		}
		}
	
	
	public void doAction(){
		
		for(int i = 0; i < Action.length - 1; i++){
		switch(Action[i]){		
		case 0: this.gameControl.KeyEnter(); System.out.println("做好啦！你这个大笨蛋！");break;
		case 1:	this.gameControl.KeyUp();break;
		case 2: this.gameControl.KeyDown();break;
		case 3: this.gameControl.KeyLeft();break;
		case 4: this.gameControl.KeyRight();break;
		case 5: this.gameControl.KeyOffendUp();break;
		case 6: this.gameControl.KeyOffendDown();break;
		case 7: this.gameControl.KeyOffendLeft();break;
		case 8: this.gameControl.KeyOffendRight();break;
		default: System.out.println("出错啦! 你这个大笨蛋！"); break;
		}	
		
	}
	
	
	
	}
}

