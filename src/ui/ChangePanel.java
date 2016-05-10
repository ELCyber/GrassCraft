package ui;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class ChangePanel extends JPanel {
	public Image[] a = new Image[3];
	Image img;
	int i = 0;
	Thread t = new Thread(new changeIcon());
//	boolean isOver = false;

	public ChangePanel() {
		for (int m = 0; m < 3; m++) {
			a[m] = new ImageIcon("/Users/chengyunfei/Desktop/el用过的图/tuantuan/" + m + ".jpeg").getImage();
		}
		this.setSize(1200, 700);
		this.setVisible(true);
		t.start();
	}
    public void isOver(){
    	this.setVisible(false);
    }
	public class changeIcon implements Runnable {
		@Override
		public void run() {
			// TODO Auto-generated method stub
			while (i < 3) {
				try {
					img = a[i];
					repaint();
					t.sleep(1000);
					i++;
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
          isOver();
		}
	}

	public void paintComponent(Graphics g) {
		g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
	}

}
