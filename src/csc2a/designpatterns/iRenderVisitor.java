package csc2a.designpatterns;

import csc2a.model.Bomb2;
import csc2a.model.Player;
import csc2a.ui.Space;
import csc2a.ui.Wall;
import csc2a.ui.World;

/**
 * 
 * AbstractVisitor interface
 * Used to define all of the render functions for your different GameObjects
 * @author  <YOUR DETAILS HERE>
 *
 */
public interface iRenderVisitor {
	/* TODO: render(YourGameObjectA a); method */
	void render(Space space);
	/* TODO: render(YourGameObjectB b); method */
	void render(Wall wall);
	// ...
	
	/* TODO: render(YourGameObjectC c); method */
	void render(Player player);
	
	/* render(YourGameObjectD d); method */
	void render(Bomb2 bomb2);
	void render(World world);
}
