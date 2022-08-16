package csc2a.ui;

//This class is responsible for setting the fill color graphics context of the empty space of the game canvas

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import csc2a.designpatterns.iRenderVisitor;
import csc2a.model.GameObject;

public class Space extends GameObject {
	

	
	public static Rectangle emptySpace(int xLoc, int yLoc) {
		Rectangle cell = new Rectangle(30, 30);
		cell.setLayoutX(xLoc);
		cell.setLayoutY(yLoc);
		cell.setFill(Color.WHITE);
		return cell;
	} 

	//This sets the location for the x and y locations of the game
	public Space(int x, int y)
	{
		super(x, y);
	}

	
	@Override
	public void accept(iRenderVisitor visitor) {
		// TODO Auto-generated method stub
		visitor.render(this);	
	}
	
	

}
