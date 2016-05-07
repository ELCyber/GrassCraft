package ui;


import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;


public class exitButton extends JButton implements MouseListener{
	ImageIcon iconExit = new ImageIcon("Graphics/Button/exit.png");
	ImageIcon iconExitEntered = new ImageIcon("Graphics/Button/exitentered.png");
	ImageIcon iconExitClicked = new ImageIcon("Graphics/Button/exitclicked.png");
	
	public exitButton(){
		this.setBorder(null);
		this.setContentAreaFilled(false);
		this.setIcon(iconExit);
		this.setRolloverIcon(iconExitEntered);
		this.setPressedIcon(iconExitClicked);
		this.addMouseListener(this);
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		System.exit(0);
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
