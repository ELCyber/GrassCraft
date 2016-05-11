package control;

import dto.GameInfo;
import dto.Grassman;
import ui.mapPanel;

public class GameControl {

	private mapPanel mapP;
	private Grassman[] mans;
	private GameInfo info;
	private Grassman man;
	//人物坐标
	private int xPosition ;
	private int yPosition ;

	public GameControl(mapPanel mapP, Grassman[] mans, GameInfo info) {
		// 初始化，传入第一个grassman及所有grassman数组；
		this.mapP = mapP;
		this.mans = mans;
		this.info = info;
		this.man = mans[0];
		this.xPosition = man.getXPosition();
		this.yPosition = man.getYPosition();
	}

	// 地图数组：0 表示 无人 1-6 表示 player0-5 7 表示 攻击范围
	// Actions control
	// 移动：原理（交换地图数组数值）

	// 判断血量是否为0

	// 移动：原理（交换地图数组数值） 判断（边界、体力值、撞到人（将移动到的地方地图数组数值是否!0））
	public void KeyUp() {
		info.map[this.man.getXPosition()][this.man.getYPosition()] = 0;
		man.setY(1);
		if (this.isOverZone(man.getXPosition(), man.getYPosition())
				|| this.isCrashed(man.getXPosition(), man.getYPosition(), mans)) {
			man.setY(-1);
		} else {
			this.man.setCure(this.man.getCure() - 2);
			this.mapP.repaint();
		}
		info.map[this.man.getXPosition()][this.man.getYPosition()] =this.numOfMan()+1;
		System.out.println(this.numOfMan()+1);
	}

	public void KeyDown() {
		info.map[this.man.getXPosition()][this.man.getYPosition()] = 0;
		man.setY(-1);
		if (this.isOverZone(man.getXPosition(), man.getYPosition())
				|| this.isCrashed(man.getXPosition(), man.getYPosition(), mans)) {
			man.setY(1);
		} else {
			this.man.setCure(this.man.getCure() - 2);
			this.mapP.repaint();
		}
		info.map[this.man.getXPosition()][this.man.getYPosition()] =this.numOfMan()+1;
	}

	public void KeyLeft() {
		info.map[this.man.getXPosition()][this.man.getYPosition()] = 0;
		man.setX(-1);
		if (this.isOverZone(man.getXPosition(), man.getYPosition())
				|| this.isCrashed(man.getXPosition(), man.getYPosition(), mans)) {
			man.setX(1);
		} else {
			this.man.setCure(this.man.getCure() - 2);
			this.mapP.repaint();
		}
		info.map[this.man.getXPosition()][this.man.getYPosition()] = this.numOfMan()+1;
	}

	public void KeyRight() {
		info.map[this.man.getXPosition()][this.man.getYPosition()] = 0;
		man.setX(1);
		if (this.isOverZone(man.getXPosition(), man.getYPosition())
				|| this.isCrashed(man.getXPosition(), man.getYPosition(), mans)) {
			man.setX(-1);
		} else {
			this.man.setCure(this.man.getCure() - 2);
			this.mapP.repaint();
		}
		info.map[this.man.getXPosition()][this.man.getYPosition()] =this.numOfMan()+1;
	} 

	// 攻击：判断：体力值 是不是攻击到（涉及到对成员数组的操作）
    // 因为攻击范围数组的增加或减少会使map[][]出现越界情况 ：大于10或小于0 所以增加对map[x][y]的判断
	// 说明：第一个判断（是不是攻击范围） 第二个判断（有没有 敌 人在，若有，扣血），最后体力-4
	
	
	//方向坐标旋转
	/*
	 * if (direction == 0){
	    res[0] = -x0;
	    res[1] = -y0;              //向下
	}
	if (direction == 1){
	    res[0] = y0;       
	    res[1] = -x0;             //向右
	}
	if (direction == 2){
	    res[0] = x0;
	    res[1] = y0;             //向上
	}
	if (direction == 3){
	    res[0] = -y0;
	    res[1] = x0;              //向左
	}
	 */
	public void KeyOffendUp() {
		for (int i = 0; i < 6; i++) {
			if(man.getOx()[this.judgeWeapon()][i] != 0 || man.getOy()[this.judgeWeapon()][i] != 0){
				if(xPosition + man.getOx()[this.judgeWeapon()][i]<0
						||xPosition + man.getOx()[this.judgeWeapon()][i]>9
						||yPosition + man.getOy()[this.judgeWeapon()][i]<0
						||yPosition + man.getOy()[this.judgeWeapon()][i]>9){
					continue;
				}
				System.out.println(this.numOfMan());
				System.out.println((info.map[xPosition + man.getOx()[this.judgeWeapon()][i]][yPosition + man.getOy()[this.judgeWeapon()][i]]));
				System.out.println((this.numOfMan() < 3 && (info.map[xPosition + man.getOx()[this.judgeWeapon()][i]][yPosition + man.getOy()[this.judgeWeapon()][i]] >= 4)));
//					|| this.numOfMan() > 2 && (info.map[xPosition + man.getOx()[this.judgeWeapon()][i]][yPosition + man.getOy()[this.judgeWeapon()][i]] < 4)
//					&&(info.map[xPosition + man.getOx()[this.judgeWeapon()][i]][yPosition + man.getOy()[this.judgeWeapon()][i]] >0));
				if((this.numOfMan() < 3 && (info.map[xPosition + man.getOx()[this.judgeWeapon()][i]][yPosition + man.getOy()[this.judgeWeapon()][i]] >= 4))
					|| (this.numOfMan() > 2 && (info.map[xPosition + man.getOx()[this.judgeWeapon()][i]][yPosition + man.getOy()[this.judgeWeapon()][i]] < 4)
					&&(info.map[xPosition + man.getOx()[this.judgeWeapon()][i]][yPosition + man.getOy()[this.judgeWeapon()][i]] >0))
					)
				{
				mans[info.map[xPosition + man.getOx()[this.judgeWeapon()][i]][yPosition + man.getOy()[this.judgeWeapon()][i]]-1].setBlood
				(mans[info.map[xPosition + man.getOx()[this.judgeWeapon()][i]][yPosition + man.getOy()[this.judgeWeapon()][i]]-1].getBlood() - 1);
				System.out.println(mans[info.map[xPosition + man.getOx()[this.judgeWeapon()][i]][yPosition + man.getOy()[this.judgeWeapon()][i]]-1].getManName()+"was hit");
				System.out.println(mans[info.map[xPosition + man.getOx()[this.judgeWeapon()][i]][yPosition + man.getOy()[this.judgeWeapon()][i]]-1].getBlood());
				}else{
					System.out.println("攻击无效");
				}
			}
		}
		this.man.setCure(this.man.getCure() - 4);
	}

	public void KeyOffendDown() {
		for (int i = 0; i < 6; i++) {
			if(man.getOx()[this.judgeWeapon()][i] != 0 || man.getOy()[this.judgeWeapon()][i] != 0){
				if(xPosition -man.getOx()[this.judgeWeapon()][i]<0
						||xPosition - man.getOx()[this.judgeWeapon()][i]>9
						||yPosition - man.getOy()[this.judgeWeapon()][i]<0
						||yPosition - man.getOy()[this.judgeWeapon()][i]>9){
					continue;
				}
				if((this.numOfMan() < 3 && (info.map[xPosition - man.getOx()[this.judgeWeapon()][i]][yPosition - man.getOy()[this.judgeWeapon()][i]] >= 4))
					|| this.numOfMan() > 2 && (info.map[xPosition - man.getOx()[this.judgeWeapon()][i]][yPosition - man.getOy()[this.judgeWeapon()][i]] < 4)
					&&(info.map[xPosition - man.getOx()[this.judgeWeapon()][i]][yPosition - man.getOy()[this.judgeWeapon()][i]] >0)
					)
				{
				mans[info.map[xPosition - man.getOx()[this.judgeWeapon()][i]][yPosition - man.getOy()[this.judgeWeapon()][i]]].setBlood
				(mans[info.map[xPosition - man.getOx()[this.judgeWeapon()][i]][yPosition - man.getOy()[this.judgeWeapon()][i]]].getBlood() - 1);
				System.out.println(mans[info.map[xPosition - man.getOx()[this.judgeWeapon()][i]][yPosition - man.getOy()[this.judgeWeapon()][i]]-1].getManName()+"was hit");
				System.out.println(mans[info.map[xPosition - man.getOx()[this.judgeWeapon()][i]][yPosition - man.getOy()[this.judgeWeapon()][i]]-1].getBlood());
				}else{
					System.out.println("攻击无效");
				}
				}
		}
		this.man.setCure(this.man.getCure() - 4);
	}

	public void KeyOffendLeft() {
		for (int i = 0; i < 6; i++) {
			if(man.getOx()[this.judgeWeapon()][i] != 0 || man.getOy()[this.judgeWeapon()][i] != 0){
				if(xPosition + man.getOx()[this.judgeWeapon()][i]<0
						||xPosition + man.getOx()[this.judgeWeapon()][i]>9
						||yPosition - man.getOy()[this.judgeWeapon()][i]<0
						||yPosition - man.getOy()[this.judgeWeapon()][i]>9){
					continue;
				}
				if((this.numOfMan() < 3 && (info.map[yPosition - man.getOy()[this.judgeWeapon()][i]][xPosition + man.getOx()[this.judgeWeapon()][i]] >= 4))
					|| this.numOfMan() > 2 && (info.map[yPosition - man.getOy()[this.judgeWeapon()][i]][xPosition + man.getOx()[this.judgeWeapon()][i]] < 4)
					&&(info.map[yPosition - man.getOy()[this.judgeWeapon()][i]][xPosition + man.getOx()[this.judgeWeapon()][i]]>0)
					)
				{
				mans[info.map[yPosition - man.getOy()[this.judgeWeapon()][i]][xPosition + man.getOx()[this.judgeWeapon()][i]]].setBlood
				(mans[info.map[yPosition - man.getOy()[this.judgeWeapon()][i]][xPosition + man.getOx()[this.judgeWeapon()][i]]].getBlood() - 1);
				System.out.println(mans[info.map[yPosition - man.getOy()[this.judgeWeapon()][i]][xPosition + man.getOx()[this.judgeWeapon()][i]]-1].getManName()+"was hit");
				System.out.println(mans[info.map[yPosition - man.getOy()[this.judgeWeapon()][i]][xPosition + man.getOx()[this.judgeWeapon()][i]]-1].getBlood());
				}else{
					System.out.println("攻击无效");
				}
				}
		}

		this.man.setCure(this.man.getCure() - 4);
	}

	public void KeyOffendRight() {
		for (int i = 0; i < 6; i++) {
			if(man.getOx()[this.judgeWeapon()][i] != 0 || man.getOy()[this.judgeWeapon()][i] != 0){
				if(xPosition - man.getOx()[this.judgeWeapon()][i]<0
						||xPosition - man.getOx()[this.judgeWeapon()][i]>9
						||yPosition + man.getOy()[this.judgeWeapon()][i]<0
						||yPosition + man.getOy()[this.judgeWeapon()][i]>9){
					continue;
				}
				if((this.numOfMan() < 3 && (info.map[yPosition + man.getOy()[this.judgeWeapon()][i]][xPosition - man.getOx()[this.judgeWeapon()][i]] >= 4))
					|| this.numOfMan() > 2 && (info.map[yPosition + man.getOy()[this.judgeWeapon()][i]][xPosition - man.getOx()[this.judgeWeapon()][i]] < 4)
					&&(info.map[yPosition + man.getOy()[this.judgeWeapon()][i]][xPosition - man.getOx()[this.judgeWeapon()][i]] >0)
					)
				{
				mans[info.map[yPosition + man.getOy()[this.judgeWeapon()][i]][xPosition - man.getOx()[this.judgeWeapon()][i]]].setBlood
				(mans[info.map[yPosition + man.getOy()[this.judgeWeapon()][i]][xPosition - man.getOx()[this.judgeWeapon()][i]]].getBlood() - 1);
				System.out.println(mans[info.map[yPosition + man.getOy()[this.judgeWeapon()][i]][xPosition - man.getOx()[this.judgeWeapon()][i]]-1].getManName()+"was hit");
				System.out.println(mans[info.map[yPosition + man.getOy()[this.judgeWeapon()][i]][xPosition - man.getOx()[this.judgeWeapon()][i]]-1].getBlood());
				}else{
					System.out.println("攻击无效");
				}
			}
		}

		this.man.setCure(this.man.getCure() - 4);
	}

	// 确认：判断是否回合完毕，若未， 回合+1
	public void KeyEnter() {
		if (this.isGameover()) {
			System.out.println("game over");
		}
		info.setTurns();
		this.getNextPlayer();
	}

	// Turn control， 控制权交给下一个人，判断turn
	public void getNextPlayer() {
		//控制权交给下一个人，上一个人需要恢复体力
		this.man.setCure(6);
		this.man = mans[this.isWhoseTurn()];
	}

	// 判断回合的两个方法；
	public boolean isGameover() {
		if (info.getTurns() == 96)
			return true;
		else
			return false;
	}

	public int isWhoseTurn() {
		switch (info.getTurns() % 12) {
		case 1 :
			System.out.println("A1's turn.");
			return 0;
		case 8 :
			System.out.println("A1's turn.");
			return 0;
		case 2 :
			System.out.println("A2's turn.");
			return 3;
		case 7 :
			System.out.println("A2's turn.");
			return 3;
		case 4 :
			System.out.println("B1's turn.");
			return 1;
		case 9 :
			System.out.println("B1's turn.");
			return 1;
		case 3 :
			System.out.println("B2's turn.");
			return 4;
		case 10:
			System.out.println("B2's turn.");
			return 4;
		case 0 :
			System.out.println("C1's turn.");
			return 2;
		case 5 :
			System.out.println("C1's turn.");
			return 2;
		case 6 :
			System.out.println("C2's turn.");
			return 5;
		case 11:
			System.out.println("C2's turn.");
			return 5;
		default:
			System.out.println("Error!");
			return -1;
		}
	}

	// 各种判断的方法
	public boolean isOverZone(int newX, int newY) {
		if (newX < 0 || newX > 9 || newY < 0 || newY > 9) {
			return true;
		}
		return false;
	}

	public boolean isCrashed(int newX, int newY, Grassman[] mans) {
		for (int i = 0; i < 6; i++) {
			if (this.man != mans[i]) {
				if (newX == mans[i].getXPosition() && newY == mans[i].getYPosition()) {
					return true;
				}
			}
		}
		return false;
	}

	public boolean canMove() {
		if (this.man.getCure() >= 2) {
			return true;
		} else {
			return false;
		}
	}

	public boolean canOffend() {
		if (this.man.getCure() >= 4) {
			return true;
		} else {
			return false;
		}
	}

	public int judgeWeapon() {
		for (int i = 0; i < 6; i++) {
			if (this.man == mans[i]) {
				switch (i) {
				case 0 :
					return 0;
				case 3 :
					return 0;
				case 1 :
					return 1;
				case 4 :
					return 1;
				case 2 :
					return 2;
				case 5 :
					return 2;
				}
			}
		}
		return -1;
	}

	public int numOfMan() {
		for (int i = 0; i < 6; i++) {
			if (this.man.equals(mans[i])) {
				return i;
			}
		}

		return -1;
	}
}
