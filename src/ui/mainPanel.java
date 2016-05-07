package ui;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class mainPanel extends JPanel{
	 public static final Image UI=new ImageIcon("Graphics/开始界面2.jpg").getImage();
	 public exitButton exitB;
	 public mainPanel(){
		 exitB=new exitButton();
		 exitB.setBounds(1000, 50, 140, 120);
		 this.add(exitB);
	 }
     @Override
     public void paintComponent(Graphics g){
        g.drawImage( UI, 0, 0,1200,700,null);
   }
}


