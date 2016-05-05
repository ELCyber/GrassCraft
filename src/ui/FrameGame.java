package ui;

import java.awt.Container;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import util.FrameUtil;

public class FrameGame extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	public Container con;
	public static final Image WINDOW_BG = new ImageIcon("Graphics/开始界面2.jpg")
			.getImage();
	public JPanel beginPanel;
	public JPanel firstPanel;
	public JPanel rulePanel;
	public JPanel teamPanel;
	//
	// change
	// add mapPanel
	//
	public JPanel mapPanel;
	public JButton startButton;
	public JButton startBackButton;
	public JButton ruleBackButton;
	public JButton teamBackButton;
	public JButton ruleButton;
	public JButton teamButton;
	Graphics g;

	public FrameGame() {

		this.setTitle("GrassCraft");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1200, 700);
		this.setResizable(false);
		FrameUtil.setFrameCenter(this);

		con = this.getContentPane();
		firstPanel = new mainPanel();
		beginPanel = new beginPanel();
		rulePanel = new rulePanel();
		teamPanel = new teamPanel();
		//
		// change
		// new mapPanel
		//
		mapPanel = new mapPanel();
		initFirstPanel();
		// initBeginPanel();
		initRulePanel();
		initTeamPanel();
		//
		// change
		// init mapPanel;
		initMapPanel();
		con.add(firstPanel);
		this.setVisible(true);
	}

	private void initFirstPanel() {

		firstPanel.setLayout(null);
		firstPanel.add(createBeginButton());
		firstPanel.add(createRuleButton());
		firstPanel.add(createTeamButton());
	}

	// for I founded a new java file(more convenient for me) so maybe we can
	// delete this method and the beginPanel.java;
	//雾草为什么我要写英文注释＝ ＝
	//总之就是我刚开始没看见已经有了begin界面。。。就直接建了一个新了。。。不好意思哦辛苦大家～
	//可以注释掉下面的方法以及左边的beginpanel.java文件～
	
	 /* void initBeginPanel() {
	  
	  beginPanel.setLayout(null); beginPanel.add(this.createStartBackButton());
	  }*/
	 

	private void initRulePanel() {
		rulePanel.setLayout(null);
		rulePanel.add(this.createRuleBackButton());
	}

	private void initTeamPanel() {
		teamPanel.setLayout(null);
		teamPanel.add(this.createTeamBackButton());
	}

	//
	// change
	// add new method to init mapPanel
	//
	private void initMapPanel() {
		mapPanel.setLayout(null);
		mapPanel.add(this.createStartBackButton());
	}

	private JButton createTeamButton() {
		teamButton = new JButton();
		ImageIcon icon = new ImageIcon("Graphics/按钮制作团队.png");
		teamButton.setBorder(null);
		teamButton.setBounds(650, 480, 260, 68);
		Image temp = icon.getImage().getScaledInstance(teamButton.getWidth(),
				teamButton.getHeight(), icon.getImage().SCALE_DEFAULT);
		icon = new ImageIcon(temp);
		teamButton.setIcon(icon);

		teamButton.addActionListener(this);
		return teamButton;
	}

	private JButton createRuleButton() {
		ruleButton = new JButton();
		ImageIcon icon = new ImageIcon("Graphics/按钮游戏规则.png");
		ruleButton.setBorder(null);
		ruleButton.setBounds(640, 370, 272, 73);
		Image temp = icon.getImage().getScaledInstance(ruleButton.getWidth(),
				ruleButton.getHeight(), icon.getImage().SCALE_DEFAULT);
		icon = new ImageIcon(temp);
		ruleButton.setIcon(icon);

		ruleButton.addActionListener(this);
		return ruleButton;
	}

	public JButton createBeginButton() {
		startButton = new JButton();
		ImageIcon icon = new ImageIcon("Graphics/按钮开始.png");
		startButton.setBorder(null);
		startButton.setBounds(660, 285, 162, 56);
		Image temp = icon.getImage().getScaledInstance(startButton.getWidth(),
				startButton.getHeight(), icon.getImage().SCALE_DEFAULT);
		icon = new ImageIcon(temp);
		startButton.setIcon(icon);

		startButton.addActionListener(this);
		return startButton;
	}

	/*
	 * public JButton createBackButton() { JButton backButton = new
	 * JButton("back"); backButton.setBorder(null); backButton.setBounds(1000,
	 * 50, 167, 72); backButton.addActionListener(this); return backButton; }
	 */

	public JButton createStartBackButton() {
		startBackButton = new JButton("back");
		startBackButton.setBorder(null);
		startBackButton.setBounds(1000, 50, 167, 72);

		startBackButton.addActionListener(this);
		return startBackButton;
	}

	public JButton createRuleBackButton() {
		ruleBackButton = new JButton("back");
		ruleBackButton.setBorder(null);
		ruleBackButton.setBounds(1000, 50, 167, 72);

		ruleBackButton.addActionListener(this);
		return ruleBackButton;
	}

	private JButton createTeamBackButton() {
		teamBackButton = new JButton("back");
		teamBackButton.setBorder(null);
		teamBackButton.setBounds(1000, 50, 167, 72);

		teamBackButton.addActionListener(this);
		return teamBackButton;
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == startButton) {
			con.removeAll();
			//
			// change
			// change the game panel
			//
			con.add(mapPanel);
			con.revalidate();
			con.repaint();
		}
		if (e.getSource() == startBackButton || e.getSource() == ruleBackButton
				|| e.getSource() == teamBackButton) {
			con.removeAll();
			con.add(firstPanel);
			con.revalidate();
			con.repaint();
		}
		if (e.getSource() == ruleButton) {
			con.removeAll();
			con.add(rulePanel);
			con.revalidate();
			con.repaint();
		}
		if (e.getSource() == teamButton) {
			con.removeAll();
			con.add(teamPanel);
			con.revalidate();
			con.repaint();
		}
	}

}