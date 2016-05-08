package ui;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class ChangePanel extends JPanel implements Runnable{
	public Image[] a = new Image[3];
	Image img;
	int i = 0;
	Thread t = new Thread(this);
    boolean isOver = false;
	public ChangePanel() {
		for(i=0;i<3;i++){
		a[i] = new ImageIcon("/Users/chengyunfei/Desktop/el用过的图/tuantuan/"+i+".jpeg").getImage();
		}
		this.setSize(500, 500);
		this.setVisible(true);
		t.start();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (i<3) {
			try {
				img = a[i];
				t.sleep(1000);
				i++;
				repaint();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		isOver =true;
		}

	}

	public void paintComponent(Graphics g) {
		g.drawImage(img, 0, 0, getHeight(), getWidth(), this);
	}

}
