package control;

import Logi.TurnCounter;
import dto.GameInfo;
import dto.Grassman;
import ui.mapPanel;

public class GameControl {

	private mapPanel mapP;
	private Grassman[] mans;
	private GameInfo info;
	private Grassman man;
 
	public GameControl(mapPanel mapP, Grassman[] mans, GameInfo info) {
		// 初始化，传入第一个grassman及所有grassman数组；
		this.mapP = mapP;
		this.mans = mans;
		this.info = info;
		this.man = mans[0];
	}
	// 地图数组：0 表示 无人 1-6 表示 player0-5 7 表示 攻击范围
	// Actions control
	// 移动：原理（交换地图数组数值）

	// 判断血量是否为0
	public boolean isDead() {
		if (this.man.getBlood() == 0) {
			return true;
		} else
			return false;
	}

	// 移动：原理（交换地图数组数值） 判断（边界、体力值、撞到人（将移动到的地方地图数组数值是否!0））
	public boolean KeyUp() {
		info.map[this.man.getXPosition()][this.man.getYPosition()] = 0;
		man.setY(1);
		info.map[this.man.getXPosition()][this.man.getYPosition()] = 1;

		if (this.isOverZone(man.getXPosition(), man.getYPosition())
				|| this.isCrashed(man.getXPosition(), man.getYPosition(), mans) || this.canMove()) {
			info.map[this.man.getXPosition()][this.man.getYPosition()] = 0;
			man.setY(-1);
			info.map[this.man.getXPosition()][this.man.getYPosition()] = 1;
			return false;
		} else {
			this.mapP.repaint();
			return true;
		}
	}

	public boolean KeyDown() {
		info.map[this.man.getXPosition()][this.man.getYPosition()] = 0;
		man.setY(-1);
		info.map[this.man.getXPosition()][this.man.getYPosition()] = 1;
		if (this.isOverZone(man.getXPosition(), man.getYPosition())
				|| this.isCrashed(man.getXPosition(), man.getYPosition(), mans) || this.canMove()) {
			info.map[this.man.getXPosition()][this.man.getYPosition()] = 0;
			man.setY(1);
			info.map[this.man.getXPosition()][this.man.getYPosition()] = 1;
			return false;
		} else {
			this.mapP.repaint();
			return true;
		}
	}

	public boolean KeyLeft() {
		info.map[this.man.getXPosition()][this.man.getYPosition()] = 0;
		man.setX(-1);
		info.map[this.man.getXPosition()][this.man.getYPosition()] = 1;
		if (this.isOverZone(man.getXPosition(), man.getYPosition())
				|| this.isCrashed(man.getXPosition(), man.getYPosition(), mans) || this.canMove()) {
			info.map[this.man.getXPosition()][this.man.getYPosition()] = 0;
			man.setX(1);
			info.map[this.man.getXPosition()][this.man.getYPosition()] = 1;
			return false;
		} else {
			this.mapP.repaint();
			return true;
		}
	}

	public boolean KeyRight() {
		info.map[this.man.getXPosition()][this.man.getYPosition()] = 0;
		man.setX(1);
		info.map[this.man.getXPosition()][this.man.getYPosition()] = 1;
		if (this.isOverZone(man.getXPosition(), man.getYPosition())
				|| this.isCrashed(man.getXPosition(), man.getYPosition(), mans) || this.canMove()) {
			info.map[this.man.getXPosition()][this.man.getYPosition()] = 0;
			man.setX(-1);
			info.map[this.man.getXPosition()][this.man.getYPosition()] = 1;
			return false;
		} else {
			this.mapP.repaint();
			return true;
		}
	}

	// 攻击：判断：体力值 是不是攻击到（涉及到对成员数组的操作）
	public boolean KeyOffendUp() {

		return false;
	}

	public boolean KeyOffendDown() {
		return false;
	}

	public boolean KeyOffendLeft() {
		return false;
	}

	public boolean KeyOffendRight() {
		return false;
	}

	// 确认：判断是否回合完毕，若未， 回合+1
	public int KeyEnter() {
		if (this.isGameover()) {
			// 游戏结束；
			return 1;
		}
		info.setTurns();
        this.getNextPlayer();
		return 0;
	}

	// Turn control， 控制权交给下一个人，判断turn
	public void getNextPlayer() {
		man = mans[this.isWhoseTurn()];
		// return 0;
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
		case 1 | 8:
			System.out.println("A1's turn.");
			return 0;
		case 2 | 7:
			System.out.println("A2's turn.");
			return 3;
		case 4 | 9:
			System.out.println("B1's turn.");
			return 1;
		case 3 | 10:
			System.out.println("B2's turn.");
			return 4;
		case 0 | 5:
			System.out.println("C1's turn.");
			return 2;
		case 6 | 11:
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
}
