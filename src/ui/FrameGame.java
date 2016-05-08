package ui;

import java.awt.Container;
import java.awt.Cursor;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import music.Player;
import util.FrameUtil;

public class FrameGame extends JFrame {
	private static final long serialVersionUID = 1L;
	public Container con;
	public static final Image WINDOW_BG = new ImageIcon("Graphics/开始界面2.jpg").getImage();
	public static Image cursorpng = new ImageIcon("Graphics/cursor.png").getImage();
	public JPanel firstPanel;
	public JPanel rulePanel;
	public JPanel teamPanel;
	public JPanel mapPanel;
	/**
	 * 实现移动
	 */
    private boolean moving;
    private int nowX;
    private int nowY;

	gameButton gB;
	private Cursor cursor;
	
	public FrameGame() {

		//播放音乐
		Player.playMusic("home");
		this.setUndecorated(true);
		this.setTitle("GrassCraft");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1200, 700);
		this.setResizable(false);
		//使窗体居中并设置图标
		FrameUtil.setFrameCenter(this);
		//设置鼠标
		cursor= Toolkit.getDefaultToolkit().createCustomCursor(
				cursorpng, new Point(0,0), "mycursor");
		this.setCursor(cursor);
		
		
		//button
		gB=new gameButton(this);
		con = this.getContentPane();
		firstPanel = new mainPanel();
		rulePanel = new rulePanel();
		teamPanel = new teamPanel();
		mapPanel = new mapPanel();
		initFirstPanel();
		initRulePanel();
		initTeamPanel();
		initMapPanel();
		con.add(firstPanel);
		this.setVisible(true);

		// 实现窗体移动
	  	this.setMove();
	}
	
	/**
	 * 实现窗体移动
	 */
	private void setMove() {
        this.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
            	if (e.getY() < 35) {
            		moving = true;
                    requestFocus();
                    nowX = e.getX();
                    nowY = e.getY();
            	}
            }
            public void mouseReleased(MouseEvent e) {
            	if (e.getY() < 35) {
            		moving = false;
            	}
            }
            @Override
            public void mouseEntered(MouseEvent e) {
            	if (e.getY() < 35) {
                   // setIn(true);
            	}
            }
        });
        this.addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(MouseEvent e) {
                if (moving) {
                    int left = getLocation().x;
                    int top = getLocation().y;
                    FrameGame.this.setLocation(left + e.getX() - nowX, top + e.getY() - nowY);
                }
            }
        });
	}

	private void initFirstPanel() {
		firstPanel.setLayout(null);
		firstPanel.add(gB.createExitButton());
		firstPanel.add(gB.createBeginButton());
		firstPanel.add(gB.createRuleButton());
		firstPanel.add(gB.createTeamButton());
	}


	private void initRulePanel() {
		rulePanel.setLayout(null);
		rulePanel.add(gB.createRuleBackButton());
	}

	private void initTeamPanel() {
		teamPanel.setLayout(null);
		teamPanel.add(gB.createTeamBackButton());
	}

	private void initMapPanel() {
		mapPanel.setLayout(null);
		mapPanel.add(gB.createStartBackButton());
	}


}