package ui;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Grassman {
	private String manName;
	// public int[][] xPosition = new int[10][10];
	// public int[][] yPosition = new int[10][10];
	public int x;
	public int y;

	public Grassman(int i) {

		// i = 0,1,2 are in a team
		// i = 3,4,5 are in another
		switch (i) {
		case 0:
			manName = "/Users/chengyunfei/Desktop/GrassCraft/GrassCraft/Graphics/Characters/grassMan0.0.png";
			x = 0;
			y = 0;
			break;
		case 1:
			manName = "/Users/chengyunfei/Desktop/GrassCraft/GrassCraft/Graphics/Characters/grassMan0.1.png";
			x = 0;
			y = 4;
			break;
		case 2:
			manName = "/Users/chengyunfei/Desktop/GrassCraft/GrassCraft/Graphics/Characters/grassMan0.2.png";
			x = 4;
			y = 0;
			break;
		case 3:
			manName = "/Users/chengyunfei/Desktop/GrassCraft/GrassCraft/Graphics/Characters/grassMan1.0.png";
			x = 9;
			y = 9;
			break;
		case 4:
			manName = "/Users/chengyunfei/Desktop/GrassCraft/GrassCraft/Graphics/Characters/grassMan1.1.png";
			x = 9;
			y = 5;
			break;
		case 5:
			manName = "/Users/chengyunfei/Desktop/GrassCraft/GrassCraft/Graphics/Characters/grassMan1.2.png";
			x = 5;
			y = 9;
			break;
		default:
			break;
		}
	}

	public Image getManImage() {
		Image grassMan = new ImageIcon(manName).getImage();
		return grassMan;
	}

	public int getXPosition() {
		return x;
	}

	public int getYPosition() {
		return y;
	}

	public void xSetter(int i) {
		// just change x by adding i;
		// i can be 1,-1,2,-2;
		this.x = this.x + i;

	}

	public void ySetter(int i) {
		// just change y by adding i;
		// i can be 1,-1,2,-2;
		this.y = this.y + i;
	}
}
