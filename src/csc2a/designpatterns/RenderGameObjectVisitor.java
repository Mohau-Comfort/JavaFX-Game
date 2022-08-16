package csc2a.designpatterns;

import csc2a.model.Bomb2;
import csc2a.model.Player;
import csc2a.ui.Space;
import csc2a.ui.Wall;
import csc2a.ui.World;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

/**
 * ConcreteVisitor class
 * Used to visit each GameObject and render them onto the GameCanvas
 * @author  <217044163 Mahlakwane M.C>
 *
 */
public class RenderGameObjectVisitor implements iRenderVisitor{
	
	//Attributes
	GraphicsContext gc = null;
	
	/**
	 * Mutator for the GraphicsContext from the GameCanvas
	 * Used to set gc so the Visitor can draw things on the Canvas
	 * @param gc the GraphicsContext from the GameCanvas
	 */
	public void setGraphicsContext(GraphicsContext gc) {
		this.gc = gc;
	}

	@Override
	public void render(World world) {
		// TODO Auto-generated method stub
		
		}


	@Override
	public void render(Wall wall) {
		// TODO Auto-generated method stub
		
		int x = (int)wall.getxLoc();
		int y = (int)wall.getyLoc();
		
	}

	@Override
	public void render(Player player) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(Bomb2 bomb2) {
		// TODO Auto-generated method stub
		
			/* TODO: Get location to start drawing */
			int x = (int)bomb2.getLocation().getX();
			int y = (int)bomb2.getLocation().getY();
			/*  Get the image of the bomb */
		    // load the image
	         Image image = new Image("./utils/Actions-edit-bomb-icon.png");
		
	}

	@Override
	public void render(Space space) {
		// TODO Auto-generated method stub
		
		/*Gets the location to start drawing */
		int x = (int)space.getLocation().getX();
		int y = (int)space.getLocation().getY();
		/* Draws the rectangle with correct colour */
		gc.setFill(Color.WHITE);
		
		//graphics.setStroke(planned.getType());
		/* TODO: Draw with correct shape(s) */
		gc.fillRect(x, y, 100, 100);
		
	}
	
	
	// ...

}
