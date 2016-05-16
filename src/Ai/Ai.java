package Ai;

import control.GameControl;
import dto.GameInfo;
import dto.Grassman;
import music.Player;

public class Ai {
	
	private GameControl gameControl;
	private GameInfo info;
	private Grassman aiMan;
    private int moveDirection;
    private int offendDirection;
	public Ai(GameControl gameControl){
		this.gameControl = gameControl;
		
	}
	/*
	 * 默认先移动后攻击
	 */
	public void judgeAction(){
		//获取游戏信息
		this.info=gameControl.getGameInfo();
		//获得当前人物
		this.aiMan=gameControl.getGrassman();
		//随机移动方向 0 1 2 3 上 下 左 右
		moveDirection=(int) (Math.random() * 4);
		doAction(moveDirection);
		
		//攻击方向
		//随机攻击方向4 5 6 7 上 下 左 右
		    offendDirection=(int) (Math.random() * 4+4);
		//判断四个方向是否有敌人
		if(isExistUpEnemy(this.gameControl.judgeWeapon())){
			offendDirection=4;
		}
        if(isExistDownEnemy(this.gameControl.judgeWeapon())){
        	offendDirection=5;
		} 
        if(isExistLeftEnemy(this.gameControl.judgeWeapon())){
        	offendDirection=6;
		}
        if(isExistRightEnemy(this.gameControl.judgeWeapon())){
        	offendDirection=7;
		}
        doAction(offendDirection);
	}
	/*
	 * 判断攻击范围内是否有敌人
	 */
	private boolean isExistUpEnemy(int weapon){
		//向上有敌人
		for (int i = 0; i < 7; i++) {
			if (aiMan.getOx()[weapon][i] != 0 || aiMan.getOy()[weapon][i] != 0) {
				// 该判断为攻击范围是否越界
				if (this.aiMan.getXPosition() + aiMan.getOx()[weapon][i] < 0
						|| this.aiMan.getXPosition() +aiMan.getOx()[weapon][i] > 9
						|| this.aiMan.getYPosition() +aiMan.getOy()[weapon][i] < 0
						|| this.aiMan.getYPosition() +aiMan.getOy()[weapon][i] > 9) {
					continue;
				}
				if ((info.map[this.aiMan.getXPosition() + this.aiMan.getOx()[weapon][i]][this.aiMan.getYPosition() + this.aiMan.getOy()[weapon][i]] < 4)
				 && (info.map[this.aiMan.getXPosition() + this.aiMan.getOx()[weapon][i]][this.aiMan.getYPosition() + this.aiMan.getOy()[weapon][i]] > 0))
				     {
					    return true;
				  } else {
					    return false;
				  }
			}
		}
		return false;
	}
	private boolean isExistDownEnemy(int weapon){
		//向下有敌人
		for (int i = 0; i < 7; i++) {
			if (aiMan.getOx()[weapon][i] != 0 || aiMan.getOy()[weapon][i] != 0) {
				// 该判断为攻击范围是否越界
				if (this.aiMan.getXPosition() - aiMan.getOx()[weapon][i] < 0
						|| this.aiMan.getXPosition() -aiMan.getOx()[weapon][i] > 9
						|| this.aiMan.getYPosition() -aiMan.getOy()[weapon][i] < 0
						|| this.aiMan.getYPosition() -aiMan.getOy()[weapon][i] > 9) {
					continue;
				}
				if ((info.map[this.aiMan.getXPosition() - this.aiMan.getOx()[weapon][i]][this.aiMan.getYPosition() - this.aiMan.getOy()[weapon][i]] < 4)
				 && (info.map[this.aiMan.getXPosition() - this.aiMan.getOx()[weapon][i]][this.aiMan.getYPosition() - this.aiMan.getOy()[weapon][i]] > 0))
				     {
					    return true;
				  } else {
					    return false;
				  }
			}
		}
		return false;
	}
	
	private boolean isExistLeftEnemy(int weapon){
		//向左有敌人
		for (int i = 0; i < 7; i++) {
			if (aiMan.getOx()[weapon][i] != 0 || aiMan.getOy()[weapon][i] != 0) {
				// 该判断为攻击范围是否越界
				if (this.aiMan.getXPosition() - aiMan.getOy()[weapon][i] < 0
						|| this.aiMan.getXPosition() -aiMan.getOy()[weapon][i] > 9
						|| this.aiMan.getYPosition() +aiMan.getOx()[weapon][i] < 0
						|| this.aiMan.getYPosition() +aiMan.getOx()[weapon][i] > 9) {
					continue;
				}
				if ((info.map[this.aiMan.getXPosition() - this.aiMan.getOy()[weapon][i]][this.aiMan.getYPosition() + this.aiMan.getOx()[weapon][i]] < 4)
				 && (info.map[this.aiMan.getXPosition() - this.aiMan.getOy()[weapon][i]][this.aiMan.getYPosition() + this.aiMan.getOx()[weapon][i]] > 0))
				     {
					    return true;
				  } else {
					    return false;
				  }
			}
		}
		return false;
	}	
	
	private boolean isExistRightEnemy(int weapon){
		//向右有敌人
		for (int i = 0; i < 7; i++) {
			if (aiMan.getOx()[weapon][i] != 0 || aiMan.getOy()[weapon][i] != 0) {
				// 该判断为攻击范围是否越界
				if (this.aiMan.getXPosition() + aiMan.getOy()[weapon][i] < 0
						|| this.aiMan.getXPosition() +aiMan.getOy()[weapon][i] > 9
						|| this.aiMan.getYPosition() -aiMan.getOx()[weapon][i] < 0
						|| this.aiMan.getYPosition() -aiMan.getOx()[weapon][i] > 9) {
					continue;
				}
				if ((info.map[this.aiMan.getXPosition() + this.aiMan.getOy()[weapon][i]][this.aiMan.getYPosition() - this.aiMan.getOx()[weapon][i]] < 4)
				 && (info.map[this.aiMan.getXPosition() + this.aiMan.getOy()[weapon][i]][this.aiMan.getYPosition() - this.aiMan.getOx()[weapon][i]] > 0))
				     {
					    return true;
				  } else {
					    return false;
				  }
			}
		}
		return false;
	}
	public void doAction(int cmd){
		Player.playSound("攻击");
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

