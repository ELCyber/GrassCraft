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
public class gameButton extends MouseAdapter{
	ImageIcon iconExit = new ImageIcon("Graphics/Button/exit.png");
	ImageIcon iconTeam = new ImageIcon("Graphics/Button缩小版/制作团队（小）.png");
	ImageIcon iconRule = new ImageIcon("Graphics/Button缩小版/游戏规则(小).png");
	ImageIcon iconStart= new ImageIcon("Graphics/Button缩小版/开始（小）.png");
	ImageIcon iconExitEntered = new ImageIcon("Graphics/Button/exitentered.png");
	ImageIcon iconExitClicked = new ImageIcon("Graphics/Button/exitclicked.png");
	ImageIcon iconStartEntered = new ImageIcon("Graphics/Button/开始（大）.png");
	ImageIcon iconRuleEntered = new ImageIcon("Graphics/Button/游戏规则（大）.png");
	ImageIcon iconTeamEntered = new ImageIcon("Graphics/Button/制作团队（大）.png");
	ImageIcon iconBack = new ImageIcon("Graphics/Button/退出.png");
	
	
	public JButton startButton;
	public JButton ruleButton;
	public JButton teamButton;
	public JButton ruleBackButton;
	public JButton teamBackButton;
	public JButton startBackButton;
	public JButton exitGameButton;
	
	public Container con;
	FrameGame frame;
	public gameButton(FrameGame frame){
		
		this.frame=frame;
		con=frame.getContentPane();
	}
	public JButton createExitButton() {
		exitGameButton = new JButton();
		exitGameButton.setBorder(null);
		exitGameButton.setBounds(1000, 50, 140, 120);
		exitGameButton.setContentAreaFilled(false);
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
		teamButton.setIcon(iconTeam);
		teamButton.setRolloverIcon(iconTeamEntered);
		teamButton.addMouseListener(this);
		return teamButton;
	}

	public JButton createRuleButton() {
		ruleButton = new JButton();
		ruleButton.setBorder(null);
		ruleButton.setBounds(700, 370, 272, 73);
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
		startButton.setIcon(iconStart);
		startButton.setRolloverIcon(iconStartEntered);
		startButton.addMouseListener(this);
		return startButton;
	}


	public JButton createStartBackButton() {
		startBackButton = new JButton();
		startBackButton.setBorder(null);
		startBackButton.setBounds(1000,400,224,336);
		startBackButton.setContentAreaFilled(false);
		startBackButton.setIcon(iconBack);
		startBackButton.addMouseListener(this);
		return startBackButton;
	}

	public JButton createRuleBackButton() {
		ruleBackButton = new JButton();
		ruleBackButton.setBorder(null);
		ruleBackButton.setBounds(1000, 50, 224, 336);
		ruleBackButton.setContentAreaFilled(false);
		ruleBackButton.setIcon(iconBack);
		ruleBackButton.addMouseListener(this);
		return ruleBackButton;
	}

	public JButton createTeamBackButton() {
		teamBackButton = new JButton();
		teamBackButton.setBorder(null);
		teamBackButton.setBounds(1000, 450, 224,336);
		teamBackButton.setContentAreaFilled(false);
		teamBackButton.setIcon(iconBack);
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
		if (e.getSource() == startBackButton || e.getSource() == ruleBackButton
				|| e.getSource() == teamBackButton) {
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
		if(e.getSource() == exitGameButton){
			System.exit(0);
		}
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		Player.playSound("amaprollover");
	}

}
