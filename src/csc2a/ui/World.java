package csc2a.ui;

//This class iniatializes the Game World
//It extends the parent javafx import which is responsible 
// for a Group node that contains an ObservableList of children that are 
//rendered in order whenever this node is rendered. 

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

@SuppressWarnings("unused")
public class World extends Parent {

	private Door door = null;
	private final int Size = 30;
	
	public World(int[][] Level, int StageLevel, Scene scene)
	{	
		//This sets the game pane size
		//It is also the array of the game level which sets the game utilities for each level of the game
		//For each level there is new setting of the game canvas and it's utilities
		GridPane row = new GridPane();
		for(int x = 0; x < 22; x++)
		{
			
			for(int y = 0; y < 22; y++)
			{
				if(Level[x][y] == 1)
				{
					Wall wall = new Wall(x * 30, y * 30);
					row.add(wall.getWall(), wall.getyLoc(), wall.getxLoc()); //sets the wall of the game (jungle)
				}else if(Level[x][y] == 2)
				{
					door = new Door(x * 30, y * 30);
					row.add(door.getDoor(), door.getyLoc(), door.getxLoc());  //sets the door of the game
				}else if(Level[x][y] == 3)
				{	
					Coin coin = new Coin(x * Size, y * Size);
					row.add(coin.getCoin(), coin.getyLoc(), coin.getxLoc());
				}else if(Level[x][y] == 4)
				{	
					Player player = new Player(x * Size, y * Size);
					row.add(player.getPlayer(), player.getyLoc(), player.getxLoc());
					player.setOnKeyPressed(scene);
				}else if(Level[x][y] == 5)
				{	
					if(StageLevel == 2)
					{
						Bomb bomb = new Bomb(x * Size, y * Size);
						row.add(bomb.getBomb(), bomb.getyLoc(), bomb.getxLoc());
					}else
					{
						row.add(Space.emptySpace(x * Size, y * Size), y * Size, x * Size);
					}
					
				}else if(Level[x][y] == 6)
				{	
					if(StageLevel == 2)
					{
						Stone stone = new Stone(x * Size, y * Size);
						row.add(stone.getStone(), stone.getyLoc(), stone.getxLoc());
					}else
					{
						row.add(Space.emptySpace(x * Size, y * Size), y * Size, x * Size);
					}
		
				}else
				{
					row.add(Space.emptySpace(x * Size, y * Size), y * Size, x * Size);
				}
			}
		}
		
		getChildren().add(row);
	}
	
}
