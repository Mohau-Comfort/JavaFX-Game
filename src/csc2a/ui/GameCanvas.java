package csc2a.ui;

import csc2a.designpatterns.RenderGameObjectVisitor;
import javafx.scene.canvas.Canvas;
import java.util.ArrayList;

import csc2a.model.Bomb;
import csc2a.model.Coin;
import csc2a.model.Door;
import csc2a.model.Player;
import csc2a.model.Stone;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.canvas.GraphicsContext;

/**
 * 
 * Canvas used to render all of your GameObjects using the Visitor
 * This is the Client in the Visitor Design Pattern
 * @author  <217044163 Mahlakwane MC>
 *
 */
public class GameCanvas extends Canvas{
	
	//Attributes
	RenderGameObjectVisitor visitor = new RenderGameObjectVisitor();
	GraphicsContext gc = null;
	/* TODO: Store all of your GameObjects (Using GameObjectContainers) here */
	
	
	/**
	 * Default Constructor
	 */
	public GameCanvas() {
		
		visitor = new RenderGameObjectVisitor();		
	}
	
		
	/**
	 * Method used to redraw the canvas whenever called
	 */
	public void redrawCanvas(){
		
	/* TODO: Get GraphicsContext */
		visitor.setGraphicsContext(gc);
	/* TODO: Set Visitor's GraphicsContext */
		gc = getGraphicsContext2D();
	/* TODO: Iterate through ALL GameObjects (Using GameObjectContainers) */
	/* TODO: Get EACH GameObject to accept() the Visitor */
	}	
}
