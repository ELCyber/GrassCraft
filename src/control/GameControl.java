package control;

import dto.Grassman;
import ui.mapPanel;

public class GameControl {
	
	private mapPanel mapP;
	private Grassman man;
	private Grassman[] mans;
	public GameControl(mapPanel mapP,Grassman[] grassMans){
		//初始化，传入第一个grassman及所有grassman数组；
		this.mapP=mapP;
        this.man=grassMans[0];
        this.mans = grassMans;
	}
	
	// Actions control
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
	
	public void KeyOffen(){}
	
	// Time control
	
	public void getNextPlayer(){	
	}
   
	
	
    
}
