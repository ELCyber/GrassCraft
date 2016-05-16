package ui;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class rulePanel extends JPanel {
	 public static final Image RULE=new ImageIcon("Graphics/new游戏规则.png").getImage();
     @Override
     public void paintComponent(Graphics g){

        g.drawImage(RULE, 0, 0,1200,700,null);
        this.requestFocus();
   }
}
