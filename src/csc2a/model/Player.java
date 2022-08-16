package csc2a.model;

//This is player class
//It is responsible for the player movement as well the player avatar

import csc2a.designpatterns.iRenderVisitor;
import csc2a.util.KMBuffer;

import java.io.File;
import java.net.MalformedURLException;
import java.util.BitSet;

import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class Player extends GameObject{
	
	private static BitSet keys = new BitSet();
	private String imgPath;
	private int xLoc;
	private int yLoc;
	
	private Node player;

    boolean running, goNorth, goSouth, goEast, goWest;

	@Override
	public void accept(iRenderVisitor visitor) {
		// TODO Auto-generated method stub
		
	}
	
    @SuppressWarnings("deprecation")
	public Player(int xLoc, int yLoc) {
    	this.xLoc = xLoc;
		this.yLoc = yLoc;
		
		File file = new File("./utils/MiddleAgesMan_Sprites.png");
		try {
			imgPath = "file://" + file.toURL().getPath();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		player = new ImageView(new Image(imgPath));
		player.setLayoutX(xLoc);
		player.setLayoutY(yLoc);
    }
    
    /*
    public void setOnKeyPressed(Scene scene){
    	scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
        	public void handle(KeyEvent event) {
        		
        		if (KMBuffer.isKeyPressed(KeyCode.UP));
        		
        	}
    	});
    	*/
    

    public void setOnKeyPressed(Scene scene){
    	scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
        	public void handle(KeyEvent event) {
            	switch (event.getCode()) {
                	case UP:    goNorth = true; break;
                	case DOWN:  goSouth = true; break;
                	case LEFT:  goWest  = true; break;
                	case RIGHT: goEast  = true; break;
                	case SHIFT: running = true; break;
            	}
        		keys.set(event.getCode().ordinal(), true);
        	}
    	});
    	
    	
    	scene.setOnKeyReleased(new EventHandler<KeyEvent>() {
    		@Override
            public void handle(KeyEvent event) {
    			switch (event.getCode()) {
    				case UP:    goNorth = false; break;
                    case DOWN:  goSouth = false; break;
                    case LEFT:  goWest  = false; break;
                    case RIGHT: goEast  = false; break;
                    case SHIFT: running = false; break;
                 }
    			keys.set(event.getCode().ordinal(), false);
             }
    	});
    	
    	
    	AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                int dx = 0, dy = 0;

                if (KeyCode.UP != null )  dy -= 1;
                if (KeyCode.DOWN != null ) dy += 1;
                if (KeyCode.RIGHT != null)  dx += 1;
                if (KeyCode.LEFT != null)  dx -= 1;
                if (running) { dx *= 3; dy *= 3; }

              moveHeroBy(dx, dy);
            }
        };
        timer.start();
	}

    //This function moves player
	private void moveHeroBy(int dx, int dy) {
        if (dx == 0 && dy == 0) return;

        //This gets player from initial player location
        //It also keeps player in bound of the game canvas
        final double cx = player.getBoundsInLocal().getWidth()  / 2;
        final double cy = player.getBoundsInLocal().getHeight() / 2;

        double x = cx + player.getLayoutX() + dx;
        double y = cy + player.getLayoutY() + dy;

        moveHeroTo(x, y);
    }

    private void moveHeroTo(double x, double y) {
        final double cx = player.getBoundsInLocal().getWidth()  / 2;
        final double cy = player.getBoundsInLocal().getHeight() / 2;

        if (x - cx >= 0 &&
            x + cx <= 600 &&
            y - cy >= 0 &&
            y + cy <= 600) {
        	player.relocate(x - cx, y - cy);
        }
    }
    
    public Node getPlayer()
    {
    	return this.player;
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
