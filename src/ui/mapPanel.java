package ui;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class mapPanel extends JPanel {

	static ImageIcon back = new ImageIcon(
			"/Users/chengyunfei/Desktop/GrassCraft//Graphics/gameBG.jpeg");
	static Image im = back.getImage();
	static Block[][] blocks = new Block[10][10];
	public int[][] xPosition = new int[10][10];
	public int[][] yPosition = new int[10][10];
	public int x;
	public int y;

	public mapPanel() {

	}

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(im, 0, 0, getWidth(), getHeight(), this);

		for (int x = 0; x < 10; x++) {
			for (int y = 0; y < 10; y++) {
				blocks[x][y] = new Block();
			}
		}
		blocks[3][6].changeColor(1);
		blocks[4][7].changeColor(2);
		blocks[7][6].changeColor(1);
		blocks[2][9].changeColor(2);
		blocks[5][0].changeColor(1);
		blocks[9][3].changeColor(2);
		blocks[3][0].changeColor(3);
		blocks[7][7].changeColor(3);
		blocks[1][6].changeColor(1);
		blocks[6][7].changeColor(3);

		for (int x = 0; x < 10; x++) {
			int m = 0;
			int n = 0;
			for (int y = 0; y < 10; y++) {
				// Image name = new ImageIcon(blocks[x][y].name).getImage();

				g.drawImage((blocks[x][y]).getImage(), 100 + 50 * x + 50 * m,
						320 + 30 * x - 30 * n, 100, 60, this);
				xPosition[x][y] = 100 + 50 * x + 50 * m + 10;
				yPosition[x][y] = 320 + 30 * x - 30 * n - 35;
				m++;
				n++;
			}

		}

		// test code
		// ...
		/*
		 * ImageIcon cha = new ImageIcon(
		 * "/Users/chengyunfei/Desktop/GrassCraft/Graphics/el人物/人物1.0.png");
		 * Image first = cha.getImage(); ImageIcon cha2 = new ImageIcon(
		 * "/Users/chengyunfei/Desktop/GrassCraft/Graphics/el人物/人物4.png"); Image
		 * second = cha2.getImage(); ImageIcon cha3 = new ImageIcon(
		 * "/Users/chengyunfei/Desktop/GrassCraft/Graphics/el人物/人物3.png"); Image
		 * third = cha3.getImage();
		 */
		/*
		 * for(int x=0;x<10;x++){ for(int y=0;y<10;y++){
		 * g.drawImage(first,xPosition[x][y]+10,yPosition[x][y]-35,80,80,this);
		 * } }
		 */

		//
		// test code...
		//

		Grassman man0 = new Grassman(0);
		Grassman man1 = new Grassman(1);
		Grassman man2 = new Grassman(2);
		Grassman man3 = new Grassman(3);
		Grassman man4 = new Grassman(4);
		Grassman man5 = new Grassman(5);
		g.drawImage(man0.getManImage(),
				xPosition[man0.getXPosition()][man0.getYPosition()],
				yPosition[man0.getXPosition()][man0.getYPosition()], 80, 80,
				this);
		g.drawImage(man1.getManImage(),
				xPosition[man1.getXPosition()][man1.getYPosition()],
				yPosition[man1.getXPosition()][man1.getYPosition()], 80, 80,
				this);
		g.drawImage(man2.getManImage(),
				xPosition[man2.getXPosition()][man2.getYPosition()],
				yPosition[man2.getXPosition()][man2.getYPosition()], 80, 80,
				this);
		g.drawImage(man3.getManImage(),
				xPosition[man3.getXPosition()][man3.getYPosition()],
				yPosition[man3.getXPosition()][man3.getYPosition()], 80, 80,
				this);
		g.drawImage(man4.getManImage(),
				xPosition[man4.getXPosition()][man4.getYPosition()],
				yPosition[man4.getXPosition()][man4.getYPosition()], 80, 80,
				this);
		g.drawImage(man5.getManImage(),
				xPosition[man5.getXPosition()][man5.getYPosition()],
				yPosition[man5.getXPosition()][man5.getYPosition()], 80, 80,
				this);
		/*
		 * g.drawImage(first, 110, 290, 80, 80, this); g.drawImage(second, 310,
		 * 290, 80, 80, this); g.drawImage(third, 520, 170, 80, 80, this);
		 */
	}
}
