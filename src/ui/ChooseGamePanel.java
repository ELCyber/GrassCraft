package ui;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import music.Player;

public class ChooseGamePanel extends JPanel implements MouseListener {
      
	 FrameGame frame;
	 JButton singleButton;
	 JButton doubleButton;
	 JButton backButton;
	 GameButton gameButton;
	 public ChooseGamePanel(FrameGame frame,GameButton gameButton){
		 this.setLayout(null);
		 this.setOpaque(false);
		 this.frame=frame;
		 this.gameButton=gameButton;
		 this.add(createSingleButton());
		 this.add(createDoubleButton());
		 this.add(createBackButton());
	 }
		public JButton createSingleButton() {
			singleButton = new JButton("single");
			singleButton.setBorder(null);
			singleButton.setBounds(500,300, 100, 50);
			singleButton.setContentAreaFilled(true);
			singleButton.setBorderPainted(false);
//			singleButton.setIcon(iconStart);
//			singleButton.setRolloverIcon(iconStartEntered);
			singleButton.addMouseListener(this);
			return singleButton;
		}	
		public JButton createDoubleButton() {
			doubleButton = new JButton("double");
			doubleButton.setBorder(null);
			doubleButton.setBounds(500,400, 100, 50);
			doubleButton.setContentAreaFilled(true);
			doubleButton.setBorderPainted(false);
//			doubleButton.setIcon(iconStart);
//			doubleButton.setRolloverIcon(iconStartEntered);
			doubleButton.addMouseListener(this);
			return doubleButton;
		}
		public JButton createBackButton() {
			backButton = new JButton("back");
			backButton.setBorder(null);
			backButton.setBounds(500,500, 100, 50);
			backButton.setContentAreaFilled(true);
			backButton.setBorderPainted(false);
//			backButton.setIcon(iconStart);
//			backButton.setRolloverIcon(iconStartEntered);
			backButton.addMouseListener(this);
			return backButton;
		}
		@Override
		public void mouseClicked(MouseEvent e) {
			if(e.getSource()==singleButton){
				ChooseGamePanel.this.setVisible(false);
				frame.getContentPane().removeAll();
				frame.initMap2Panel();
				frame.getContentPane().add(frame.map2Panel);
				frame.getContentPane().revalidate();
				frame.getContentPane().repaint();
				Player.stopMusic();
				Player.playMusic("home");
			}
            if(e.getSource()==doubleButton){
            	ChooseGamePanel.this.setVisible(false);
            	frame.getContentPane().removeAll();
				frame.getContentPane().add(frame.mapPanel);
				frame.getContentPane().revalidate();
				frame.getContentPane().repaint();
				Player.stopMusic();
				Player.playMusic("home");
			}
            if(e.getSource()==backButton){
            	ChooseGamePanel.this.setVisible(false);
            	gameButton.reSetButton();
			}
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
		public void mousePressed(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}
}
