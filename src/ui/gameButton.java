package ui;

import java.awt.Container;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import music.Player;

/**
 * 重复代码有点多，有空优化
 **/
public class gameButton extends MouseAdapter {
	ImageIcon iconExit = new ImageIcon("Graphics/Button/exit.png");
	ImageIcon iconTeam = new ImageIcon("Graphics/Button缩小版/制作团队（小）.png");
	ImageIcon iconRule = new ImageIcon("Graphics/Button缩小版/游戏规则(小).png");
	ImageIcon iconStart = new ImageIcon("Graphics/Button缩小版/开始（小）.png");
	ImageIcon iconExitEntered = new ImageIcon("Graphics/Button/exitentered.png");
	ImageIcon iconExitClicked = new ImageIcon("Graphics/Button/exitclicked.png");
	ImageIcon iconStartEntered = new ImageIcon("Graphics/Button/开始（大）.png");
	ImageIcon iconRuleEntered = new ImageIcon("Graphics/Button/游戏规则（大）.png");
	ImageIcon iconTeamEntered = new ImageIcon("Graphics/Button/制作团队（大）.png");
	ImageIcon iconBack = new ImageIcon("Graphics/Button/退出按钮 （小）.png");
	ImageIcon iconBackEntered = new ImageIcon("Graphics/Button/退出按钮（大）.png");
	ImageIcon iconReStart = new ImageIcon("Graphics/Button/重新开始（小）.png");
	ImageIcon iconReStartEntered= new ImageIcon("Graphics/Button/重新开始 （大）.png");

	public JButton startButton;
	public JButton ruleButton;
	public JButton teamButton;
	public JButton ruleBackButton;
	public JButton teamBackButton;
	public JButton startBackButton;
	public JButton exitGameButton;
	public JButton reStartButton;
	public JButton exitMapGameButton;
	//重新開始
    public mapPanel newMapPanel;
	public Container con;
	FrameGame frame;

	public gameButton(FrameGame frame) {
		this.frame = frame;
		con = frame.getContentPane();
	}

	public JButton createExitButton() {
		exitGameButton = new JButton();
		exitGameButton.setBorder(null);
		exitGameButton.setBounds(1000, 50, 140, 120);
		exitGameButton.setContentAreaFilled(false);
		exitGameButton.setBorderPainted(false);
		exitGameButton.setIcon(iconExit);
		exitGameButton.setRolloverIcon(iconExitEntered);
		exitGameButton.setPressedIcon(iconExitClicked);
		exitGameButton.addMouseListener(this);
		return exitGameButton;
	}

	public JButton createTeamButton() {
		teamButton = new JButton();
		teamButton.setBorder(null);
		teamButton.setBounds(680, 480, 260, 68);
		teamButton.setContentAreaFilled(false);
		teamButton.setBorderPainted(false);
		teamButton.setIcon(iconTeam);
		teamButton.setRolloverIcon(iconTeamEntered);
		teamButton.addMouseListener(this);
		return teamButton;
	}

	public JButton createRuleButton() {
		ruleButton = new JButton();
		ruleButton.setBorder(null);
		ruleButton.setBounds(700, 370, 272, 73);
		ruleButton.setBorderPainted(false);
		ruleButton.setContentAreaFilled(false);
		ruleButton.setIcon(iconRule);
		ruleButton.setRolloverIcon(iconRuleEntered);
		ruleButton.addMouseListener(this);
		return ruleButton;
	}

	public JButton createBeginButton() {
		startButton = new JButton();
		startButton.setBorder(null);
		startButton.setBounds(700, 285, 200, 56);
		startButton.setContentAreaFilled(false);
		startButton.setBorderPainted(false);
		startButton.setIcon(iconStart);
		startButton.setRolloverIcon(iconStartEntered);
		startButton.addMouseListener(this);
		return startButton;
	}
/**
 * mapPanel上的按钮
 * @return
 */
	//返回主界面
	public JButton createStartBackButton() {
		startBackButton = new JButton();
		startBackButton.setBorder(null);
		startBackButton.setBounds(950,550,250,150);
		startBackButton.setContentAreaFilled(false);
		startBackButton.setBorderPainted(false);
		startBackButton.setIcon(iconBack);
		startBackButton.setRolloverIcon(iconBackEntered);
		startBackButton.addMouseListener(this);
		return startBackButton;
	}
	//重新开始
	public JButton createReStartButton() {
		reStartButton = new JButton();
		reStartButton.setBorder(null);
		reStartButton.setBounds(950,400,250,150);
		reStartButton.setContentAreaFilled(false);
		reStartButton.setBorderPainted(false);
		reStartButton.setIcon(iconReStart);
		reStartButton.setRolloverIcon(iconReStartEntered);
		reStartButton.addMouseListener(this);
		return reStartButton;
	}
	//TODO 直接退出游戏，暂用主界面的退出游戏按钮
	public JButton createMapExitButton() {
		exitMapGameButton = new JButton();
		exitMapGameButton.setBorder(null);
		exitMapGameButton.setBounds(1000, 50, 140, 120);
		exitMapGameButton.setContentAreaFilled(false);
		exitMapGameButton.setBorderPainted(false);
		exitMapGameButton.setIcon(iconExit);
		exitMapGameButton.setRolloverIcon(iconExitEntered);
		exitMapGameButton.setPressedIcon(iconExitClicked);
		exitMapGameButton.addMouseListener(this);
		return exitMapGameButton;
	}
/**
 * rulePanel上的按钮
 * @return
 */
	public JButton createRuleBackButton() {
		ruleBackButton = new JButton();
		ruleBackButton.setBorder(null);
		ruleBackButton.setBounds(0, 550, 250, 150);
		ruleBackButton.setContentAreaFilled(false);
		ruleBackButton.setBorderPainted(false);
		ruleBackButton.setIcon(iconBack);
		ruleBackButton.setRolloverIcon(iconBackEntered);
		ruleBackButton.addMouseListener(this);
		return ruleBackButton;
	}
/**
 * teamPanel上的按钮
 * @return
 */
	public JButton createTeamBackButton() {
		teamBackButton = new JButton();
		teamBackButton.setBorder(null);
		teamBackButton.setBounds(950, 550, 250, 150);
		teamBackButton.setContentAreaFilled(false);
		teamBackButton.setBorderPainted(false);
		teamBackButton.setIcon(iconBack);
		teamBackButton.setRolloverIcon(iconBackEntered);
		teamBackButton.addMouseListener(this);
		return teamBackButton;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == startButton) {
			con.removeAll();
			con.add(frame.mapPanel);
			con.revalidate();
			con.repaint();
			Player.stopMusic();
			Player.playMusic("home");
		}
		if (e.getSource() == startBackButton || e.getSource() == ruleBackButton || e.getSource() == teamBackButton) {
			con.removeAll();
			con.add(frame.mainPanel);
			con.revalidate();
			con.repaint();
			Player.stopMusic();
			Player.playMusic("十二月的奇迹");
		}
		if (e.getSource() == ruleButton) {
			con.removeAll();
			con.add(frame.rulePanel);
			con.revalidate();
			con.repaint();
		}
		if (e.getSource() == teamButton) {
			con.removeAll();
			con.add(frame.teamPanel);
			con.revalidate();
			con.repaint();
		}
		if (e.getSource() == exitGameButton||e.getSource() == exitMapGameButton) {
			System.exit(0);
		}
		//mapPanel的重新开始按钮
		if(e.getSource() == reStartButton){
			con.removeAll();
			newMapPanel=new mapPanel();
			newMapPanel.setLayout(null);
			newMapPanel.add(createStartBackButton());
			newMapPanel.add(createReStartButton());
			newMapPanel.add(createMapExitButton());
			con.add(newMapPanel);
			con.revalidate();
			con.repaint();
		}
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		Player.playSound("amaprollover");
	}

}
