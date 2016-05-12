package ui;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import control.GameControl;
import control.PlayerControl;
import dto.GameInfo;
import dto.Grassman;

public class mapPanel extends JPanel {
	private static final long serialVersionUID = 1L;

	static ImageIcon back = new ImageIcon("Graphics/gameBG.jpeg");

	static Image im = back.getImage();
	private Block[][] blocks = new Block[10][10];
	public int[][] xPosition = new int[10][10];
	public int[][] yPosition = new int[10][10];
	public int x;
	public int y;
	public Grassman[] mans = new Grassman[6];
	public GameInfo info;
	public int[][] map;
	
	
	//TODO 换图片
	public JLabel blueWinPicture;
	public JLabel redWinPicture;
	private ImageIcon blueWin = new ImageIcon("Graphics/gameBG.jpeg");
	private ImageIcon redWin = new ImageIcon("Graphics/gameBG.jpeg");

	public mapPanel() {
        
		for(int i =0;i<6;i++){
			mans[i]=new Grassman(i);
		}
		//初始化地块
				for (int x = 0; x < 10; x++) {
					for (int y = 0; y < 10; y++) {
						blocks[x][y] = new Block();
					}
				}
		//初始化地图，因为攻击的范围使得
		//info.map[xPosition + man.getOx()[this.judgeWeapon()][i]][yPosition + man.getOy()[this.judgeWeapon()][i]]		
		//会出现IndexOutOfBoundsException 在gamecontrol需增加判断
	    map=new int[10][10];
		info=new GameInfo(1,mans,map);
		GameControl gameControl=new GameControl(this,mans,info);
		PlayerControl playControl=new PlayerControl(gameControl);
		this.addKeyListener(playControl);
	}
	
	//蓝方胜
	public void showBlueWinPicture(){
		blueWinPicture = new JLabel(blueWin);
		blueWinPicture.setBounds(300, 175, 600, 350);
		blueWinPicture.setVisible(true);
		mapPanel.this.add(blueWinPicture);
	}
	//红方胜
    public void showRedWinPicture(){
    	redWinPicture = new JLabel(redWin);
		redWinPicture.setBounds(300, 175, 600, 350);
		redWinPicture.setVisible(true);
		mapPanel.this.add(redWinPicture);
	}
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		//绘制背景
		g.drawImage(im, 0, 0, getWidth(), getHeight(), this);
		this.requestFocus();

		for (int x = 0; x < 10; x++) {
			int m = 0;
			int n = 0;
			for (int y = 0; y < 10; y++) {

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
			if(mans[i]!=null){
		g.drawImage(mans[i].getManImage(),
				xPosition[mans[i].getXPosition()][mans[i].getYPosition()],
				yPosition[mans[i].getXPosition()][mans[i].getYPosition()], 80, 80,
				this);
		   }
		}
	}

	public  Block[][] getBlocks() {
		return this.blocks;
	}
}
