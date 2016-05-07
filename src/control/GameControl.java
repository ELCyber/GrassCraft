package control;

import dto.Grassman;
import ui.mapPanel;

public class GameControl {
	
	private mapPanel mapP;
	private Grassman man;
	
	public GameControl(mapPanel mapP,Grassman man){
		this.mapP=mapP;
		this.man=man;
	}

	public void KeyUp() {
		man.setY(1);
		if(man.isOverZone(man.getXPosition(),man.getYPosition())){
			man.setY(-1);
			return;
		}
		this.mapP.repaint();
	}

	public void KeyDown() {
		man.setY(-1);
		if(man.isOverZone(man.getXPosition(),man.getYPosition())){
			man.setY(1);
			return;
		}
		this.mapP.repaint();
	}

	public void KeyLeft() {
		man.setX(-1);
		if(man.isOverZone(man.getXPosition(),man.getYPosition())){
			man.setX(1);
			return;
		}
		this.mapP.repaint();
	}

	public void KeyRight() {
		man.setX(1);
		if(man.isOverZone(man.getXPosition(),man.getYPosition())){
			man.setX(-1);
			return;
		}
		this.mapP.repaint();
	}
    
}
