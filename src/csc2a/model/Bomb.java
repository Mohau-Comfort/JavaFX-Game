package csc2a.model;

//This class is for the bomb that the player plants and destroys rocks

import java.io.File;
import java.net.MalformedURLException;

import csc2a.designpatterns.iRenderVisitor;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Bomb extends GameObject
{

	private String imgPath;
	private int xLoc;
	private int yLoc;
	
	private Node bomb;
	
	@Override
	public void accept(iRenderVisitor visitor) 
	{
		// TODO Auto-generated method stub
	}

	@SuppressWarnings("deprecation")
	public Bomb(int xLoc, int yLoc)
	{
		this.xLoc = xLoc;
		this.yLoc = yLoc;
		
		File file = new File("./utils/C4-resizeimage.png");
		try {
			imgPath = "file://" + file.toURL().getPath();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		bomb = new ImageView(new Image(imgPath));
		bomb.setLayoutX(xLoc);
		bomb.setLayoutY(yLoc);
	}
	
	public Node getBomb()
	{
		return this.bomb;
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
