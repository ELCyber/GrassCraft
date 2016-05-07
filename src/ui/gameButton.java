package ui;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class gameButton implements ActionListener{
	public JButton startButton;
	public JButton ruleButton;
	public JButton teamButton;
	public JButton ruleBackButton;
	public JButton teamBackButton;
	public JButton startBackButton;
	
	public Container con;
	FrameGame frame;
	public gameButton(FrameGame frame){
		
		this.frame=frame;
		con=frame.getContentPane();
	}
	public JButton createTeamButton() {
		teamButton = new JButton();
		ImageIcon icon = new ImageIcon("Graphics/Button/按钮制作团队.png");
		teamButton.setBorder(null);
		teamButton.setBounds(650, 480, 260, 68);
		teamButton.setIcon(icon);

		teamButton.addActionListener(this);
		return teamButton;
	}

	public JButton createRuleButton() {
		ruleButton = new JButton();
		ImageIcon icon = new ImageIcon("Graphics/Button/按钮游戏规则.png");
		ruleButton.setBorder(null);
		ruleButton.setBounds(640, 370, 272, 73);
		ruleButton.setIcon(icon);

		ruleButton.addActionListener(this);
		return ruleButton;
	}

	public JButton createBeginButton() {
		startButton = new JButton();
		ImageIcon icon = new ImageIcon("Graphics/Button/按钮开始.png");
		startButton.setBorder(null);
		startButton.setBounds(660, 285, 162, 56);
		startButton.setIcon(icon);

		startButton.addActionListener(this);
		return startButton;
	}


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

	public JButton createTeamBackButton() {
		teamBackButton = new JButton("back");
		teamBackButton.setBorder(null);
		teamBackButton.setBounds(1000, 50, 167, 72);

		teamBackButton.addActionListener(this);
		return teamBackButton;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == startButton) {
			con.removeAll();
			con.add(frame.mapPanel);
			con.revalidate();
			con.repaint();
			//change music
//			gcAP.stopMusic();
			// gcAP.playMusic("02");
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
	}

}
