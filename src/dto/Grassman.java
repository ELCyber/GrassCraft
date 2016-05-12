package dto;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Grassman {
	private String manName;
	// public int[][] xPosition = new int[10][10];
	// public int[][] yPosition = new int[10][10];
	private int x;
	private int y;
	private Image grassMan;
	// private int newX;
	// private int newY;
	private int blood;
	private int cure;
	public boolean isKilled = false;
	private int[][] ox = { { 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 1, 1, 2, 0, 0 }, { -1, -1, -1, 0, 1, 1, 1 } };

	private int[][] oy = { { 1, 2, 3, 4, 0, 0, 0 }, { 1, 2, 0, 1, 0, 0, 0 }, { -1, 0, 1, -1, 1, -1, 0 } };

	public Grassman(int i) {
		this.blood = 3;
		this.cure = 6;
		switch (i) {
		case 0:
			this.manName = "Graphics/Characters/grassMan0.0.png";
			x = 0;
			y = 0;
			break;
		case 1:
			this.manName = "Graphics/Characters/grassMan0.1.png";
			x = 0;
			y = 4;
			break;
		case 2:
			this.manName = "Graphics/Characters/grassMan0.2.png";
			x = 4;
			y = 0;
			break;
		case 3:
			this.manName = "Graphics/Characters/grassMan1.0.png";
			x = 9;
			y = 9;
			break;
		case 4:
			this.manName = "Graphics/Characters/grassMan1.1.png";
			x = 9;
			y = 5;
			break;
		case 5:
			this.manName = "Graphics/Characters/grassMan1.2.png";
			x = 5;
			y = 9;
			break;
		default:
			break;
		}
		grassMan = new ImageIcon(manName).getImage();
	}

	public String getManName() {
		return this.manName;
	}

	public Image getManImage() {
		//grassMan = new ImageIcon(manName).getImage();
		return grassMan;
	}
	public void setManImageNull(){
		grassMan = null;
	}

	public int getXPosition() {
		return this.x;
	}

	public int getYPosition() {
		return this.y;
	}

	public int getBlood() {
		return this.blood;
	}

	public void setBlood(int blood) {
		this.blood = blood;
	}

	public int getCure() {
		return this.cure;
	}

	public void setCure(int cure) {
		this.cure = cure;
	}

	// 提供基本的操作，让GameControl引用（ 上下左右移动
	public void setX(int i) {
		// just change x by adding i;
		// i can be 1,-1,2,-2;
		this.x = this.x + i;

	}

	public void setY(int i) {
		// just change y by adding i;
		// i can be 1,-1,2,-2;
		this.y = this.y + i;
	}

	public int[][] getOx() {
		return ox;
	}

	public int[][] getOy() {
		return oy;
	}

}
