package ui;


import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
/*
 * 主界面背景图，gif格式，同样适用JLabel实现
 */
public class mainPanel extends JPanel{
	private static final long serialVersionUID = 1L;
	public static final ImageIcon BG=new ImageIcon("Graphics/主面板.gif");
	 JLabel backgroundLabel;
	 
	 public mainPanel(){
		 backgroundLabel= new JLabel(BG);
		 backgroundLabel.setBounds(0, 0, BG.getIconWidth(), BG.getIconHeight());
	 	 this.add(backgroundLabel);
	 }
//     @Override
//     public void paintComponent(Graphics g){
//        //g.drawImage(UI, 0, 0,this); 
//   }
}


