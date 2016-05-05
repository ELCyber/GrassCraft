package ui;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Block  {
	String name;
	
	//Image block = new ImageIcon(name).getImage();
	//
	//
	public Block(){
		this.name="/Users/chengyunfei/Desktop/ELwork/GrassCraft/Graphics/colorBlock/green.png";
	}
	
	public void changeColor(int number) {
		switch (number) {
		case 1:
			this.name = "/Users/chengyunfei/Desktop/ELwork/GrassCraft/Graphics/colorBlock/yellow2.png";
			break;
		case 2:
			this.name = "/Users/chengyunfei/Desktop/ELwork/GrassCraft/Graphics/colorBlock/blue.png";
			break;
		case 3:
			this.name = "/Users/chengyunfei/Desktop/ELwork/GrassCraft/Graphics/colorBlock/lightRed.png";
			break;
		default:
			break;
		}
		
	}

	public Image getImage() {
		Image block = new ImageIcon(name).getImage();
		return block;
	}

}

