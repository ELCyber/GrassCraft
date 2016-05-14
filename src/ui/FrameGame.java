package ui;

import java.awt.Container;
import java.awt.Cursor;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class FrameGame extends JFrame {
	private static final long serialVersionUID = 1L;
	public Container con;
	public static Image cursorpng = new ImageIcon("Graphics/cursor.png").getImage();
	public ImageIcon openingIcon = new ImageIcon("Graphics/开场动画hiki2.gif");
	public JPanel mainPanel;
	public JPanel rulePanel;
	public JPanel teamPanel;
	public JPanel mapPanel;
	public JPanel map2Panel;
//	public JPanel aiPanel;
	/**
	 * 开场动画
	 */
	private JLabel openingJLabel;
	OpeningThread openingThread = new OpeningThread();
	private boolean isaddMovie = false;
	/**
	 * 实现移动
	 */
	private boolean moving;
	private int nowX;
	private int nowY;
	private GameButton gB;
	private Cursor cursor;

	public FrameGame() {
		// 去除窗体边框
		this.setUndecorated(true);
		this.setTitle("GrassCraft");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);

		// 设置窗体大小，使窗体居中并设置图标
		this.setSize(1200, 700);
		// 窗体居中方法,之前util里的文件便可删除
		this.setLocationRelativeTo(null);
		// TODO 窗体图标，即任务栏图标，暂时找不到好的图标，用鼠标的草代替
		this.setIconImage(cursorpng);

		// 设置鼠标
		cursor = Toolkit.getDefaultToolkit().createCustomCursor(cursorpng, new Point(0, 0), "mycursor");
		this.setCursor(cursor);

		// 获得Button引用,并传入当前frame引用
		gB = new GameButton(this);
		// 获得frame的面板
		con = this.getContentPane();

		// 用JLabel实现开场动画并调用方法
		openingJLabel = new JLabel(openingIcon);
		openingJLabel.setBounds(0, 0, openingIcon.getIconWidth(), openingIcon.getIconHeight());
		this.add(openingJLabel);
		this.setVisible(true);
		// 加载开场动画
		this.addMovie();

		// 实现窗体移动
		this.setMove();
	}

	/*
	 * 开场动画，运用线程
	 */
	public void addMovie() {
		openingThread.start();
		//开场动画短，这个可以注释掉了
//		this.addKeyListener(new openKeyListener());
	}

	class OpeningThread extends Thread {
		public void run() {
			try {
				//开场动画样本是10000ms,想跳过的话直接按ESC|SPACE|ENTER
				 sleep(4000);
				if (!isaddMovie) {
					//关闭开场动画
					openingJLabel.setVisible(false);
					// 初始化面板
					initPanel();
					// 如果开场动画后面板显示不出来，就调用下面的方法，现在初步判断opening.gif出现的情况是gif文件与frame大小不一致
					FrameGame.this.setVisible(true);
				    // 移除frame的键盘监听
				   // FrameGame.this.addKeyListener(null);
			} 
				}catch (InterruptedException e) {
				 e.printStackTrace();
			}

			}
	}

	/*
	 * 内部类，实现开场动画的键盘监听,用于跳过开场动画，有空写到别的类里
	 * 开场动画短，这个可以注释掉了
	 */
//
//	class openKeyListener extends KeyAdapter {
//
//		@Override
//		public void keyPressed(KeyEvent e) {
//			if (e.getKeyCode() == KeyEvent.VK_ESCAPE || e.getKeyCode() == KeyEvent.VK_ENTER
//					|| e.getKeyCode() == KeyEvent.VK_SPACE) {
//				openingJLabel.setVisible(false);
//				initPanel();
//				FrameGame.this.setVisible(true);
//				isaddMovie = true;
//			}
//
//		}
//
//	}

	/**
	 * 初始化面板
	 */
	private void initPanel() {
		initMainPanel();
		initRulePanel();
		initTeamPanel();
		initMapPanel();
	}

	/**
	 * 实现窗体移动,因为frame去除了边框
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

	private void initMainPanel() {
		mainPanel = new mainPanel();
		con.add(mainPanel);
		mainPanel.setLayout(null);
		mainPanel.add(gB.createExitButton(), 0);
		mainPanel.add(gB.createBeginButton(), 0);
		mainPanel.add(gB.createRuleButton(), 0);
		mainPanel.add(gB.createTeamButton(), 0);
	}

	private void initRulePanel() {
		rulePanel = new rulePanel();
		rulePanel.setLayout(null);
		rulePanel.add(gB.createRuleBackButton());
	}

	private void initTeamPanel() {
		teamPanel = new teamPanel();
		teamPanel.setLayout(null);
		teamPanel.add(gB.createTeamBackButton());
	}

	public void initMapPanel() {
		mapPanel = new mapPanel(gB);
		mapPanel.setLayout(null);
		mapPanel.add(gB.createStartBackButton());
		mapPanel.add(gB.createReStartButton());
		mapPanel.add(gB.createMapExitButton());
	}
	/*
	 * 人机
	 */
	public void initMap2Panel() {
		map2Panel = new mapPanel(gB,0);
		map2Panel.setLayout(null);
		map2Panel.add(gB.createStartBackButton());
		map2Panel.add(gB.createReStartButton());
		map2Panel.add(gB.createMapExitButton());
	}
//	public void initAiPanel() {
//		aiPanel = new AiPanel(gB);
//		aiPanel.setLayout(null);
//		aiPanel.add(gB.createStartBackButton());
//		aiPanel.add(gB.createReStartButton());
//		aiPanel.add(gB.createMapExitButton());
//	}


}