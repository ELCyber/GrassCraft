package ui;

import java.awt.Container;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import music.Player;

public class gameButton extends MouseAdapter{
	ImageIcon iconExit = new ImageIcon("Graphics/Button/exit.png");
	ImageIcon iconExitEntered = new ImageIcon("Graphics/Button/exitentered.png");
	ImageIcon iconExitClicked = new ImageIcon("Graphics/Button/exitclicked.png");
	
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
		ImageIcon icon = new ImageIcon("Graphics/Button/按钮制作团队.png");
		teamButton.setBorder(null);
		teamButton.setBounds(650, 480, 260, 68);
		teamButton.setIcon(icon);

		teamButton.addMouseListener(this);
		return teamButton;
	}

	public JButton createRuleButton() {
		ruleButton = new JButton();
		ImageIcon icon = new ImageIcon("Graphics/Button/按钮游戏规则.png");
		ruleButton.setBorder(null);
		ruleButton.setBounds(640, 370, 272, 73);
		ruleButton.setIcon(icon);

		ruleButton.addMouseListener(this);
		return ruleButton;
	}

	public JButton createBeginButton() {
		startButton = new JButton();
		ImageIcon icon = new ImageIcon("Graphics/Button/按钮开始.png");
		startButton.setBorder(null);
		startButton.setBounds(660, 285, 162, 56);
		startButton.setIcon(icon);

		startButton.addMouseListener(this);
		return startButton;
	}


	public JButton createStartBackButton() {
		startBackButton = new JButton("back");
		startBackButton.setBorder(null);
		startBackButton.setBounds(1000, 50, 167, 72);

		startBackButton.addMouseListener(this);
		return startBackButton;
	}

	public JButton createRuleBackButton() {
		ruleBackButton = new JButton("back");
		ruleBackButton.setBorder(null);
		ruleBackButton.setBounds(1000, 50, 167, 72);

		ruleBackButton.addMouseListener(this);
		return ruleBackButton;
	}

	public JButton createTeamBackButton() {
		teamBackButton = new JButton("back");
		teamBackButton.setBorder(null);
		teamBackButton.setBounds(1000, 50, 167, 72);

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
			Player.playSound("amaprollover");
			}
		if (e.getSource() == startBackButton || e.getSource() == ruleBackButton
				|| e.getSource() == teamBackButton) {
			con.removeAll();
			con.add(frame.firstPanel);
			con.revalidate();
			con.repaint();
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
