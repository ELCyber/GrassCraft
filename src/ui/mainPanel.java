package ui;


import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
/*
 * 主界面背景图，gif格式，同样是用JLabel实现
 */
public class mainPanel extends JPanel{
	private static final long serialVersionUID = 1L;
	public static final ImageIcon BG=new ImageIcon("Graphics/开始界面非主流版本循环.gif");
	
     @Override
     public void paintComponent(Graphics g){
        g.drawImage(BG.getImage(), 0, 0,this); 
   }
}


