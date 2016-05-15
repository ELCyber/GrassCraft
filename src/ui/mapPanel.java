package ui;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Ai.Ai;
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
	private Ai aiControl;
	private PlayerControl playControl;
	//TODO 换图片
	public JLabel blueWinPicture;
	public JLabel redWinPicture;
	private ImageIcon blueWin = new ImageIcon("Graphics/gameBG.jpeg");
	private ImageIcon redWin = new ImageIcon("Graphics/gameBG.jpeg");
	private String onesun="Graphics/allsun/血量1.png";
    private String twosun="Graphics/allsun/血量2.png";
    private String threesun="Graphics/allsun/血量3.png";
	String[] allsun={onesun,twosun,threesun};
	

	private GameButton gameButton;
	/**
	 * 双人
	 */
	public mapPanel(GameButton gameButton) {
        this.gameButton=gameButton;
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
		playControl=new PlayerControl(gameControl);
		this.addKeyListener(playControl);
	}
	/**
	 * 人机
	 * @param gameButton
	 */
	public mapPanel(GameButton gameButton,int diffculty) {
        this.gameButton=gameButton;
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
		playControl=new PlayerControl(gameControl);
		aiControl=new Ai(gameControl);
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
		redWinPicture.setLayout(null);
		redWinPicture.add(gameButton.playAgainButton(300, 175, 600, 350));
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
		for(int i=0;i<6;i++){
			if(mans[i]!=null){
				int b=mans[i].getBlood();
				ImageIcon image=new ImageIcon(allsun[b-1]);
						g.drawImage(image.getImage(),
						xPosition[mans[i].getXPosition()][mans[i].getYPosition()]-5,
						yPosition[mans[i].getXPosition()][mans[i].getYPosition()]-30, 70,35,
						this);
				
			}
		}
		
	}

	public  Block[][] getBlocks() {
		return this.blocks;
	}
	public Ai getAiControl(){
		return this.aiControl;
	}
    public PlayerControl getPlayerControl(){
    	return this.playControl;
    }
}
