package csc2a.model;

//This class instantiates the door of the game where the player will go through to reach the next level

import java.io.File;
import java.net.MalformedURLException;

import csc2a.designpatterns.iRenderVisitor;
import javafx.scene.Node;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Door extends GameObject {

	private String imgPath;
	private int xLoc;
	private int yLoc;
	
	private Node door;
	// The node contains an ObservableList of children 
	//that are rendered in order whenever this node is rendered
	
	@Override
	public void accept(iRenderVisitor visitor) {
		// TODO Auto-generated method stub
		
	}

	@SuppressWarnings("deprecation")
	public Door(int xLoc, int yLoc)
	{
		this.xLoc = xLoc;
		this.yLoc = yLoc;
		
		File file = new File("./utils/logout-icon.png");
		try {
			imgPath = "file://" + file.toURL().getPath();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		door = new ImageView(new Image(imgPath));
		door.setLayoutX(xLoc);
		door.setLayoutY(yLoc);
	}
	
	public Node getDoor()
	{
		return this.door;
	}

	/**
	 * @return the xLoc
	 */
	public int getxLoc() {
		return xLoc;
	}

	/**
	 * @param xLoc the xLoc to set
	 */
	public void setxLoc(int xLoc) {
		this.xLoc = xLoc;
	}

	/**
	 * @return the yLoc
	 */
	public int getyLoc() {
		return yLoc;
	}

	/**
	 * @param yLoc the yLoc to set
	 */
	public void setyLoc(int yLoc) {
		this.yLoc = yLoc;
	}
}
	

