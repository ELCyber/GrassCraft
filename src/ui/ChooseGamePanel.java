package ui;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import music.Player;

public class ChooseGamePanel extends JPanel implements MouseListener {
	 public static final ImageIcon BGhalf=new ImageIcon("Graphics/开始界面4.0.png");
	 FrameGame frame;
	 JButton singleButton;
	 JButton doubleButton;
	 JButton backButton;
	 GameButton gameButton;
	 ImageIcon iconSingle =new ImageIcon("Graphics/Button/single.png");
	 ImageIcon iconDouble =new ImageIcon("Graphics/Button/double.png");
	 ImageIcon iconBack =new ImageIcon("Graphics/Button/back.png");
	 ImageIcon iconBigSingle =new ImageIcon("Graphics/Button/bigSingle.png");
	 ImageIcon iconBigDouble =new ImageIcon("Graphics/Button/bigDouble.png");
	 ImageIcon iconBigBack =new ImageIcon("Graphics/Button/bigBack.png");
	 public ChooseGamePanel(FrameGame frame,GameButton gameButton){
		 this.setLayout(null);
		 this.setOpaque(false);
		 this.setBackground(null);
		 this.frame=frame;
		 this.gameButton=gameButton;
		 this.add(createSingleButton());
		 this.add(createDoubleButton());
		 this.add(createBackButton());
	 }
		public JButton createSingleButton() {
			
			singleButton = new JButton();
			singleButton.setBorder(null);
			singleButton.setBounds(950,240, 180, 50);
			singleButton.setContentAreaFilled(false);
			singleButton.setBorderPainted(false);
			singleButton.setIcon(iconSingle);
			singleButton.setRolloverIcon(iconBigSingle);
			singleButton.addMouseListener(this);
			return singleButton;
		}	
		public JButton createDoubleButton() {
			doubleButton = new JButton();
			doubleButton.setBorder(null);
			doubleButton.setBounds(950,300, 180, 50);
			doubleButton.setContentAreaFilled(false);
			doubleButton.setBorderPainted(false);
			doubleButton.setIcon(iconDouble);
			doubleButton.setRolloverIcon(iconBigDouble);
			doubleButton.addMouseListener(this);
			return doubleButton;
		}
		public JButton createBackButton() {
			backButton = new JButton();
			backButton.setBorder(null);
			backButton.setBounds(950,360, 180, 50);
			backButton.setContentAreaFilled(false);
			backButton.setBorderPainted(false);
			backButton.setIcon(iconBack);
			backButton.setRolloverIcon(iconBigBack);
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
//				Player.stopMusic();
//				Player.playMusic("home");
			}
            if(e.getSource()==doubleButton){
            	ChooseGamePanel.this.setVisible(false);
            	frame.getContentPane().removeAll();
            	frame.initMapPanel();
				frame.getContentPane().add(frame.mapPanel);
				frame.getContentPane().revalidate();
				frame.getContentPane().repaint();
//				Player.stopMusic();
//				Player.playMusic("home");
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
		@Override
		public void paintComponent(Graphics g){
			g.drawImage(BGhalf.getImage(), 910, 100,1200,700,910,100,1200,700,this); 
		}
		
}
