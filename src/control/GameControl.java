package control;

import dto.Grassman;
import ui.mapPanel;

public class GameControl {
	
	private mapPanel mapP;
	private Grassman man;
	private Grassman nextMan;
	private Grassman[] mans;
	public GameControl(mapPanel mapP,Grassman[] grassMans){
		this.mapP=mapP;
        this.man=grassMans[0];
        this.mans = grassMans;
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
	public void KeyNextPlayer(){
		this.man=mans[this.getMan()];
	}
    public int getMan(){
    	int n = 1;
    	for(int i=0;i<6;i++){
    		if(this.man==mans[i]){
    			n=i+1;
    			break;
    		}
    	}
    	return n%6;
    }
}
