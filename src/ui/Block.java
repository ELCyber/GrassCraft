package ui;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Block  {
	String name;
	
	//Image block = new ImageIcon(name).getImage();
	//
	//
	public Block(){
		this.name="Graphics/colorBlock/green.png";
	}
	
	public void changeColor(int number) {
		switch (number) {
		case 1:
			this.name = "Graphics/colorBlock/yellow2.png";
			break;
		case 2:
			this.name = "Graphics/colorBlock/blue.png";
			break;
		case 3:
			this.name = "Graphics/colorBlock/lightRed.png";
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

