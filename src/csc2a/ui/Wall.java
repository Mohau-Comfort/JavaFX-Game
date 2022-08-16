package csc2a.ui;

//This class loads the jungle interface 

import java.io.File;
import java.net.MalformedURLException;

import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Wall {
	
	private String imgPath;
	private int xLoc;
	private int yLoc;
	
	private Node wall;
	
	@SuppressWarnings("deprecation")
	public Wall(int xLoc, int yLoc)
	{
		this.xLoc = xLoc;
		this.yLoc = yLoc;
		
		File file = new File("./utils/Jungle.jpg");
		try {
			imgPath = "file://" + file.toURL().getPath();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		wall = new ImageView(new Image(imgPath));
	}
	
	public Node getWall()
	{
		return this.wall;
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
