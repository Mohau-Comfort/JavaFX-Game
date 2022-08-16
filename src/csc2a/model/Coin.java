package csc2a.model;

//This class is for the coins that the player collects

import java.io.File;
import java.net.MalformedURLException;

import csc2a.designpatterns.iRenderVisitor;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Coin extends GameObject{

	private String imgPath;
	private int xLoc;
	private int yLoc;
	
	private Node Coin;
	// The node contains an ObservableList of children 
	//that are rendered in order whenever this node is rendered
	
	@Override
	public void accept(iRenderVisitor visitor) {
		// TODO Auto-generated method stub
		
	}
	
	@SuppressWarnings("deprecation")
	public Coin(int xLoc, int yLoc)
	{
		this.xLoc = xLoc;
		this.yLoc = yLoc;
		//This uploads the picture of the player
		File file = new File("./utils/Coin resizeimage.jpg");
		try {
			imgPath = "file://" + file.toURL().getPath();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Coin = new ImageView(new Image(imgPath));
		Coin.setLayoutX(xLoc);
		Coin.setLayoutY(yLoc);
	}
	
	public Node getCoin()
	{
		return this.Coin;
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
