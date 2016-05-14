package control;

import dto.GameInfo;
import dto.Grassman;
import ui.mapPanel;

public class GameControl {

	private mapPanel mapP;
//	private AiPanel aiP;
	private Grassman[] mans;
	private GameInfo info;
	private Grassman man;

	// 用来重置地块颜色时判断是哪个方向的攻击
	// 向上攻击则isOffendUp=true；
	private boolean isOffendUp = false;
	private boolean isOffendDown = false;
	private boolean isOffendLeft = false;
	private boolean isOffendRight = false;

	// 在先向上攻击的情况下，如果向下移动，那么isDown=true；
	private boolean isUp = false;
	private boolean isDown = false;
	private boolean isLeft = false;
	private boolean isRight = false;

	private BufferThread bt;
	public GameControl(mapPanel mapP, Grassman[] mans, GameInfo info) {
		// 初始化，传入第一个grassman及所有grassman数组；
		this.mapP = mapP;
		this.mans = mans;
		this.info = info;
		this.man = mans[0];
		this.man.whenIsChosen();
		this.mapP.repaint();
		
		
	}
	
	/**
	 * 人机
	 */
//	public GameControl(AiPanel aiP, Grassman[] mans, GameInfo info) {
//		// 初始化，传入第一个grassman及所有grassman数组；
//		this.aiP = aiP;
//		this.mans = mans;
//		this.info = info;
//		this.man = mans[0];
//		this.man.whenIsChosen();
//		this.aiP.repaint();
//	}
	// 地图数组：0 表示 无人 1-6 表示 player0-5 7 表示 攻击范围
	// Actions control
	// 移动：原理（交换地图数组数值）

	// 判断血量是否为0

	// 移动：原理（交换地图数组数值） 判断（边界、体力值、撞到人（将移动到的地方地图数组数值是否!0））
	public void KeyUp() {
		// 先攻击后移动
		if (isOffendUp || isOffendDown || isOffendLeft || isOffendRight) {
			reSetBlockColor();
			isUp = true;
		}
		info.map[this.man.getXPosition()][this.man.getYPosition()] = 0;
		man.setY(1);
		if (this.isOverZone(man.getXPosition(), man.getYPosition())
				|| this.isCrashed(man.getXPosition(), man.getYPosition(), mans)) {
			man.setY(-1);
		} else {
			this.man.setCure(this.man.getCure() - 2);
			this.mapP.repaint();
		}
		info.map[this.man.getXPosition()][this.man.getYPosition()] = this.numOfMan() + 1;

	}

	public void KeyDown() {
		// 先攻击后移动
		if (isOffendUp || isOffendDown || isOffendLeft || isOffendRight) {
			reSetBlockColor();
			isDown = true;
		}
		info.map[this.man.getXPosition()][this.man.getYPosition()] = 0;
		man.setY(-1);
		if (this.isOverZone(man.getXPosition(), man.getYPosition())
				|| this.isCrashed(man.getXPosition(), man.getYPosition(), mans)) {
			man.setY(1);
		} else {
			this.man.setCure(this.man.getCure() - 2);
			this.mapP.repaint();
		}
		info.map[this.man.getXPosition()][this.man.getYPosition()] = this.numOfMan() + 1;
	}

	public void KeyLeft() {
		// 先攻击后移动
		if (isOffendUp || isOffendDown || isOffendLeft || isOffendRight) {
			reSetBlockColor();
			isLeft = true;
		}
		info.map[this.man.getXPosition()][this.man.getYPosition()] = 0;
		man.setX(-1);
		if (this.isOverZone(man.getXPosition(), man.getYPosition())
				|| this.isCrashed(man.getXPosition(), man.getYPosition(), mans)) {
			man.setX(1);
		} else {
			this.man.setCure(this.man.getCure() - 2);
			this.mapP.repaint();
		}
		info.map[this.man.getXPosition()][this.man.getYPosition()] = this.numOfMan() + 1;
	}

	public void KeyRight() {
		// 先攻击后移动
		if (isOffendUp || isOffendDown || isOffendLeft || isOffendRight) {
			reSetBlockColor();
			isRight = true;
		}
		info.map[this.man.getXPosition()][this.man.getYPosition()] = 0;
		man.setX(1);
		if (this.isOverZone(man.getXPosition(), man.getYPosition())
				|| this.isCrashed(man.getXPosition(), man.getYPosition(), mans)) {
			man.setX(-1);
		} else {
			this.man.setCure(this.man.getCure() - 2);
			this.mapP.repaint();
		}
		info.map[this.man.getXPosition()][this.man.getYPosition()] = this.numOfMan() + 1;
	}

	// 攻击：判断：体力值 是不是攻击到（涉及到对成员数组的操作）
	// 因为攻击范围数组的增加或减少会使map[][]出现越界情况 ：大于10或小于0 所以增加对map[x][y]的判断
	// 说明：第一个判断（是不是攻击范围） 第二个判断（有没有 敌 人在，若有，扣血），最后体力-4

	// 方向坐标旋转
	/*
	 * if (direction == 0){ res[0] = -x0; res[1] = -y0; //向下 } if (direction ==
	 * 1){ res[0] = y0; res[1] = -x0; //向右 } if (direction == 2){ res[0] = x0;
	 * res[1] = y0; //向上 } if (direction == 3){ res[0] = -y0; res[1] = x0; //向左
	 * }
	 */
	public void KeyOffendUp() {
		for (int i = 0; i < 7; i++) {
			if (man.getOx()[this.judgeWeapon()][i] != 0 || man.getOy()[this.judgeWeapon()][i] != 0) {
				// 该判断为攻击范围是否越界
				if (this.man.getXPosition() + man.getOx()[this.judgeWeapon()][i] < 0
						|| this.man.getXPosition() + man.getOx()[this.judgeWeapon()][i] > 9
						|| this.man.getYPosition() + man.getOy()[this.judgeWeapon()][i] < 0
						|| this.man.getYPosition() + man.getOy()[this.judgeWeapon()][i] > 9) {
					continue;
				}
				// 改变地图颜色
				this.mapP.getBlocks()[this.man.getXPosition() + man.getOx()[this.judgeWeapon()][i]][this.man
						.getYPosition() + man.getOy()[this.judgeWeapon()][i]].changeColor(1);
				this.mapP.repaint();
				// 向上攻击了
				isOffendUp = true;
				if ((this.numOfMan() < 3
						&& (info.map[this.man.getXPosition() + man.getOx()[this.judgeWeapon()][i]][this.man
								.getYPosition() + man.getOy()[this.judgeWeapon()][i]] >= 4))
						|| (this.numOfMan() > 2
								&& (info.map[this.man.getXPosition() + man.getOx()[this.judgeWeapon()][i]][this.man
										.getYPosition() + man.getOy()[this.judgeWeapon()][i]] < 4)
								&& (info.map[this.man.getXPosition() + man.getOx()[this.judgeWeapon()][i]][this.man
										.getYPosition() + man.getOy()[this.judgeWeapon()][i]] > 0))) {
					mans[info.map[this.man.getXPosition() + man.getOx()[this.judgeWeapon()][i]][this.man.getYPosition()
							+ man.getOy()[this.judgeWeapon()][i]] - 1].setBlood(
									mans[info.map[this.man.getXPosition() + man.getOx()[this.judgeWeapon()][i]][this.man
											.getYPosition() + man.getOy()[this.judgeWeapon()][i]] - 1].getBlood() - 1);
					System.out.println(
							mans[info.map[this.man.getXPosition() + man.getOx()[this.judgeWeapon()][i]][this.man
									.getYPosition() + man.getOy()[this.judgeWeapon()][i]] - 1].getManName()
									+ "was hit");
					System.out.println(
							mans[info.map[this.man.getXPosition() + man.getOx()[this.judgeWeapon()][i]][this.man
									.getYPosition() + man.getOy()[this.judgeWeapon()][i]] - 1].getBlood());
				} else {
//					System.out.println("攻击无效");
				}
			}
		}
		isKilled();
		this.man.setCure(this.man.getCure() - 4);
	}

	public void KeyOffendDown() {
		for (int i = 0; i < 7; i++) {
			if (man.getOx()[this.judgeWeapon()][i] != 0 || man.getOy()[this.judgeWeapon()][i] != 0) {
				if (this.man.getXPosition() - man.getOx()[this.judgeWeapon()][i] < 0
						|| this.man.getXPosition() - man.getOx()[this.judgeWeapon()][i] > 9
						|| this.man.getYPosition() - man.getOy()[this.judgeWeapon()][i] < 0
						|| this.man.getYPosition() - man.getOy()[this.judgeWeapon()][i] > 9) {
					continue;
				}
				// 改变地图颜色
				this.mapP.getBlocks()[this.man.getXPosition() - man.getOx()[this.judgeWeapon()][i]][this.man
						.getYPosition() - man.getOy()[this.judgeWeapon()][i]].changeColor(1);
				this.mapP.repaint();
				// 向下攻击了
				isOffendDown = true;
				if ((this.numOfMan() < 3
						&& (info.map[this.man.getXPosition() - man.getOx()[this.judgeWeapon()][i]][this.man
								.getYPosition() - man.getOy()[this.judgeWeapon()][i]] >= 4))
						|| this.numOfMan() > 2
								&& (info.map[this.man.getXPosition() - man.getOx()[this.judgeWeapon()][i]][this.man
										.getYPosition() - man.getOy()[this.judgeWeapon()][i]] < 4)
								&& (info.map[this.man.getXPosition() - man.getOx()[this.judgeWeapon()][i]][this.man
										.getYPosition() - man.getOy()[this.judgeWeapon()][i]] > 0)) {
					mans[info.map[this.man.getXPosition() - man.getOx()[this.judgeWeapon()][i]][this.man.getYPosition()
							- man.getOy()[this.judgeWeapon()][i]] - 1].setBlood(
									mans[info.map[this.man.getXPosition() - man.getOx()[this.judgeWeapon()][i]][this.man
											.getYPosition() - man.getOy()[this.judgeWeapon()][i]] - 1].getBlood() - 1);
					System.out.println(
							mans[info.map[this.man.getXPosition() - man.getOx()[this.judgeWeapon()][i]][this.man
									.getYPosition() - man.getOy()[this.judgeWeapon()][i]] - 1].getManName()
									+ "was hit");
					System.out.println(
							mans[info.map[this.man.getXPosition() - man.getOx()[this.judgeWeapon()][i]][this.man
									.getYPosition() - man.getOy()[this.judgeWeapon()][i]] - 1].getBlood());
				} else {
//					System.out.println("攻击无效");
				}
			}
		}
		isKilled();
		this.man.setCure(this.man.getCure() - 4);
	}

	public void KeyOffendLeft() {
		for (int i = 0; i < 7; i++) {
			if (man.getOx()[this.judgeWeapon()][i] != 0 || man.getOy()[this.judgeWeapon()][i] != 0) {
				if (this.man.getYPosition() + man.getOx()[this.judgeWeapon()][i] < 0
						|| this.man.getYPosition() + man.getOx()[this.judgeWeapon()][i] > 9
						|| this.man.getXPosition() - man.getOy()[this.judgeWeapon()][i] < 0
						|| this.man.getXPosition() - man.getOy()[this.judgeWeapon()][i] > 9) {
					continue;
				}
				// 改变地图颜色
				this.mapP.getBlocks()[this.man.getXPosition() - man.getOy()[this.judgeWeapon()][i]][this.man
						.getYPosition() + man.getOx()[this.judgeWeapon()][i]].changeColor(1);
				this.mapP.repaint();
				// 向左攻击了
				isOffendLeft = true;
				if ((this.numOfMan() < 3
						&& (info.map[this.man.getXPosition() - man.getOy()[this.judgeWeapon()][i]][this.man
								.getYPosition() + man.getOx()[this.judgeWeapon()][i]] >= 4))
						|| this.numOfMan() > 2
								&& (info.map[this.man.getXPosition() - man.getOy()[this.judgeWeapon()][i]][this.man
										.getYPosition() + man.getOx()[this.judgeWeapon()][i]] < 4)
								&& (info.map[this.man.getXPosition() - man.getOy()[this.judgeWeapon()][i]][this.man
										.getYPosition() + man.getOx()[this.judgeWeapon()][i]] > 0)) {
					mans[info.map[this.man.getXPosition() - man.getOy()[this.judgeWeapon()][i]][this.man.getYPosition()
							+ man.getOx()[this.judgeWeapon()][i]] - 1].setBlood(
									mans[info.map[this.man.getXPosition() - man.getOy()[this.judgeWeapon()][i]][this.man
											.getYPosition() + man.getOx()[this.judgeWeapon()][i]] - 1].getBlood() - 1);
					System.out.println(
							mans[info.map[this.man.getXPosition() - man.getOy()[this.judgeWeapon()][i]][this.man
									.getYPosition() + man.getOx()[this.judgeWeapon()][i]] - 1].getManName()
									+ "was hit");
					System.out.println(
							mans[info.map[this.man.getXPosition() - man.getOy()[this.judgeWeapon()][i]][this.man
									.getYPosition() + man.getOx()[this.judgeWeapon()][i]] - 1].getBlood());
				} else {
//					System.out.println("攻击无效");
				}
			}
		}
		isKilled();
		this.man.setCure(this.man.getCure() - 4);
	}

	public void KeyOffendRight() {
		for (int i = 0; i < 7; i++) {
			if (man.getOx()[this.judgeWeapon()][i] != 0 || man.getOy()[this.judgeWeapon()][i] != 0) {
				if (this.man.getYPosition() - man.getOx()[this.judgeWeapon()][i] < 0
						|| this.man.getYPosition() - man.getOx()[this.judgeWeapon()][i] > 9
						|| this.man.getXPosition() + man.getOy()[this.judgeWeapon()][i] < 0
						|| this.man.getXPosition() + man.getOy()[this.judgeWeapon()][i] > 9) {
					continue;
				}
				// 改变地图颜色
				this.mapP.getBlocks()[this.man.getXPosition() + man.getOy()[this.judgeWeapon()][i]][this.man
						.getYPosition() - man.getOx()[this.judgeWeapon()][i]].changeColor(1);
				this.mapP.repaint();
				// 向右攻击了
				isOffendRight = true;
				if ((this.numOfMan() < 3
						&& (info.map[this.man.getXPosition() + man.getOy()[this.judgeWeapon()][i]][this.man
								.getYPosition() - man.getOx()[this.judgeWeapon()][i]] >= 4))
						|| this.numOfMan() > 2
								&& (info.map[this.man.getXPosition() + man.getOy()[this.judgeWeapon()][i]][this.man
										.getYPosition() - man.getOx()[this.judgeWeapon()][i]] < 4)
								&& (info.map[this.man.getXPosition() + man.getOy()[this.judgeWeapon()][i]][this.man
										.getYPosition() - man.getOx()[this.judgeWeapon()][i]] > 0)) {
					mans[info.map[this.man.getXPosition() + man.getOy()[this.judgeWeapon()][i]][this.man.getYPosition()
							- man.getOx()[this.judgeWeapon()][i]] - 1].setBlood(
									mans[info.map[this.man.getXPosition() + man.getOy()[this.judgeWeapon()][i]][this.man
											.getYPosition() - man.getOx()[this.judgeWeapon()][i]] - 1].getBlood() - 1);
					System.out.println(
							mans[info.map[this.man.getXPosition() + man.getOy()[this.judgeWeapon()][i]][this.man
									.getYPosition() - man.getOx()[this.judgeWeapon()][i]] - 1].getManName()
									+ "was hit");
					System.out.println(
							mans[info.map[this.man.getXPosition() + man.getOy()[this.judgeWeapon()][i]][this.man
									.getYPosition() - man.getOx()[this.judgeWeapon()][i]] - 1].getBlood());
				} else {
//					System.out.println("攻击无效");
				}
			}
		}
		isKilled();
		this.man.setCure(this.man.getCure() - 4);
	}

	// 重置被攻击的地块颜色
	public void reSetBlockColor() {
		for (int i = 0; i < 7; i++) {
			// if（攻击范围）
			if (man.getOx()[this.judgeWeapon()][i] != 0 || man.getOy()[this.judgeWeapon()][i] != 0) {
				// if（判断方向）
				if (isOffendUp) {
					// 该判断为攻击范围是否越界
					if (this.man.getXPosition() + man.getOx()[this.judgeWeapon()][i] < 0
							|| this.man.getXPosition() + man.getOx()[this.judgeWeapon()][i] > 9
							|| this.man.getYPosition() + man.getOy()[this.judgeWeapon()][i] < 0
							|| this.man.getYPosition() + man.getOy()[this.judgeWeapon()][i] > 9) {
						continue;
					}
					// 重置地图颜色
					this.mapP.getBlocks()[this.man.getXPosition() + man.getOx()[this.judgeWeapon()][i]][this.man
							.getYPosition() + man.getOy()[this.judgeWeapon()][i]].changeColor(0);
					this.mapP.repaint();

				}

				if (isOffendDown) {
					if (this.man.getXPosition() - man.getOx()[this.judgeWeapon()][i] < 0
							|| this.man.getXPosition() - man.getOx()[this.judgeWeapon()][i] > 9
							|| this.man.getYPosition() - man.getOy()[this.judgeWeapon()][i] < 0
							|| this.man.getYPosition() - man.getOy()[this.judgeWeapon()][i] > 9) {
						continue;
					}
					// 改变地图颜色
					this.mapP.getBlocks()[this.man.getXPosition() - man.getOx()[this.judgeWeapon()][i]][this.man
							.getYPosition() - man.getOy()[this.judgeWeapon()][i]].changeColor(0);
					this.mapP.repaint();

				}

				if (isOffendLeft) {
					if (this.man.getYPosition() + man.getOx()[this.judgeWeapon()][i] < 0
							|| this.man.getYPosition() + man.getOx()[this.judgeWeapon()][i] > 9
							|| this.man.getXPosition() - man.getOy()[this.judgeWeapon()][i] < 0
							|| this.man.getXPosition() - man.getOy()[this.judgeWeapon()][i] > 9) {
						continue;
					}
					// 改变地图颜色
					this.mapP.getBlocks()[this.man.getXPosition() - man.getOy()[this.judgeWeapon()][i]][this.man
							.getYPosition() + man.getOx()[this.judgeWeapon()][i]].changeColor(0);
					this.mapP.repaint();

				}
				if (isOffendRight) {
					if (this.man.getYPosition() - man.getOx()[this.judgeWeapon()][i] < 0
							|| this.man.getYPosition() - man.getOx()[this.judgeWeapon()][i] > 9
							|| this.man.getXPosition() + man.getOy()[this.judgeWeapon()][i] < 0
							|| this.man.getXPosition() + man.getOy()[this.judgeWeapon()][i] > 9) {
						continue;
					}
					// 改变地图颜色
					this.mapP.getBlocks()[this.man.getXPosition() + man.getOy()[this.judgeWeapon()][i]][this.man
							.getYPosition() - man.getOx()[this.judgeWeapon()][i]].changeColor(0);
					this.mapP.repaint();

				}
			}
		}
		// 重置攻击方向
		isOffendUp = false;
		isOffendDown = false;
		isOffendLeft = false;
		isOffendRight = false;
	}

	// 被杀则设置iskilled
	public void isKilled() {
		for (int i = 0; i < 6; i++) {
			if(mans[i]==null){
				continue;
			}
			if (mans[i].getBlood() == 0) {
				//把被杀死的map[][]设为0
				info.map[mans[i].getXPosition()][mans[i].getYPosition()]=0; 
				//位置也要改一改，防止死了之后占着茅坑不拉粑粑,因为isCrashed会判断他的XY
				mans[i]=null;
			}
		}
	}

	public void KeyEnter() {
		// 重置被攻击的地块颜色
		if (!isUp || !isDown || !isLeft || !isRight) {
			reSetBlockColor();
		}
		isUp = false;
		isDown = false;
		isLeft = false;
		isRight = false;
		
		// 回合数加一
	    info.setTurns();
		// 控制权交给下一个
		this.getNextPlayer();

	}

	public void getNextPlayer() {
		// 控制权交给下一个人，上一个人需要恢复体力
		this.man.setCure(6);
		this.man.notChosen();
		// 判断下一个人有没有被杀，被杀则回合加一继续判断
		while (true) {
			if (mans[this.isWhoseTurn()]==null) {
				info.setTurns();
			} else {
				break;
			}
		}
		this.man = mans[this.isWhoseTurn()];
		this.man.whenIsChosen();
		this.mapP.repaint();
		
		//判断是否是人机模式
		if(isAiGame()){
			//判断是否是人机的回合
			if(isAiControl()){
				//创建新线程  
				bt=new BufferThread();
				//移除键盘监听
				mapP.removeKeyListener(mapP.getPlayerControl());
				//将控制权交给Ai
				this.AiController();
			
			}
		}
	
	}

	// 判断回合的两个方法；
	public boolean isGameover() {
		System.out.println(info.getTurns());
		if ((info.getTurns() >96) || oneSideDead()) {
			return true;
		} else{
			return false;
		}
	}

	// 判断是否一方死掉；
	public boolean oneSideDead() {
		int i=0;
		int blueDeadNum=0;
		int redDeadNum=0;
		for (i = 0; i < 3; i++) {
			if (mans[i]==null) {
				blueDeadNum++;
			}
		}
		for ( i = 3; i < 6; i++) {
			if (mans[i]==null) {
				redDeadNum++;
			}
		}
		if(blueDeadNum==3){
			//红方胜，调用红方胜利的方法
			//TODO method
			reSetBlockColor();
			System.out.println("red win");
			this.mapP.showRedWinPicture();
			return true;
		}
		if(redDeadNum==3){
			//蓝方胜，调用蓝方胜利的方法
			//TODO method
			reSetBlockColor();
			System.out.println("blue win");
			this.mapP.showBlueWinPicture();
			return true;
		}
		return false;
	}
/*
 * 谁的回合
 */
	public int isWhoseTurn() {
		switch (info.getTurns() % 12) {
		case 1:
			return 0;
		case 8:
			return 0;
		case 2:
			return 3;
		case 7:
			return 3;
		case 4:
			return 1;
		case 9:
			return 1;
		case 3:
			return 4;
		case 10:
			return 4;
		case 0:
			return 2;
		case 5:
			return 2;
		case 6:
			return 5;
		case 11:
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
			if(mans[i]==null){
				continue;
			}
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
				case 0:
					return 0;
				case 3:
					return 0;
				case 1:
					return 1;
				case 4:
					return 1;
				case 2:
					return 2;
				case 5:
					return 2;
				}
			}
		}
		return -1;
	}

	public mapPanel getMapP() {
		return mapP;
	}

	public int numOfMan() {
		for (int i = 0; i < 6; i++) {
			if (this.man.equals(mans[i])) {
				return i;
			}
		}

		return -1;
	}
	/*
	 * 判断是否是人机
	 */
	public boolean isAiGame(){
		if(this.mapP.getAiControl()==null){
			return false;
		}
		return true;
	}
	/*
	 * 判断该回合是否由玩家控制
	 */
	public boolean isPlayerControl(){
		if(this.isWhoseTurn()==0||this.isWhoseTurn()==1||this.isWhoseTurn()==2){
			return true;
		}
		return false;
	}
	/*
	 * 判断该回合是否由人机控制
	 */
	public boolean isAiControl(){
		if(this.isWhoseTurn()==3||this.isWhoseTurn()==4||this.isWhoseTurn()==5){
			
			return true;
		}
		return false;
	}
	/*
	 * Ai控制器
	 */
	public void AiController(){
		//要攻击还是移动
		this.mapP.getAiControl().judgeAction();
		//Ai回合结束，恢复键盘，自动调用KeyEnter方法
//		if(isStart){
//		bt.run();
//		}else{
//			bt.start();
//			isStart=true;
//		}
		bt.start();
	}
	/*
	 * 两个ai之间需要一定的停留时间，运用线程
	 */
	class BufferThread extends Thread{ 
		public void run() {
			try {
				sleep(1000);
				KeyEnter();
				//判断是否是玩家控制
				if(isPlayerControl()){
					mapP.addKeyListener(mapP.getPlayerControl());
				}
				}catch (InterruptedException e) {
				 e.printStackTrace();
			}
			
			}
	}
	
}
