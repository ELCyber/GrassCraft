package ui;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import control.GameControl;
import control.PlayerControl;
import dto.GameInfo;
import dto.Grassman;

public class mapPanel extends JPanel {
	private static final long serialVersionUID = 1L;

	static ImageIcon back = new ImageIcon("Graphics/gameBG.jpeg");

	static Image im = back.getImage();
	static Block[][] blocks = new Block[10][10];
	public int[][] xPosition = new int[10][10];
	public int[][] yPosition = new int[10][10];
	public int x;
	public int y;
	public Grassman[] mans = new Grassman[6];
	public GameInfo info;
	public int[][] map;
	public mapPanel() {
		 //man0 = new Grassman(0);
		//test
		for(int i =0;i<6;i++){
			mans[i]=new Grassman(i);
		}
		//初始化地块
				for (int x = 0; x < 10; x++) {
					for (int y = 0; y < 10; y++) {
						blocks[x][y] = new Block();
					}
				}
		map=new int[10][10];
		info=new GameInfo(96,mans,map);
		GameControl gameControl=new GameControl(this,mans,info);
		PlayerControl playControl=new PlayerControl(gameControl);
		this.addKeyListener(playControl);
	}

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		//绘制背景
		g.drawImage(im, 0, 0, getWidth(), getHeight(), this);
		this.requestFocus();
		
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

				//绘制地块
				g.drawImage((blocks[x][y]).getImage(), 100 + 50 * x + 50 * m,
						320 + 30 * x - 30 * n, 100, 60, this);
				xPosition[x][y] = 100 + 50 * x + 50 * m + 10;
				yPosition[x][y] = 320 + 30 * x - 30 * n - 35;
				m++;
				n++;
			}

		}

		for(int i =0;i<6;i++){
		g.drawImage(mans[i].getManImage(),
				xPosition[mans[i].getXPosition()][mans[i].getYPosition()],
				yPosition[mans[i].getXPosition()][mans[i].getYPosition()], 80, 80,
				this);
		}
	}
}
