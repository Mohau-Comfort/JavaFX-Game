package csc2a.ui;

//This class intantiates the GamePane of the game
//Loads the instruction manual of the game

import java.io.File;
import java.net.MalformedURLException;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;

@SuppressWarnings("unused")
public class Stages {
	
	private static World world = null;
	private Stage mainStage;
	private int StageLevel = 0;
	private Buttons buttons = null;
	private Label countTime = null;
	private int seconds =60;
	private String imgPath;
	private int initTime = 60;
	
	public Stages(Stage mainStage, Buttons buttons)
	{
		this.mainStage = mainStage;
		this.buttons = buttons;
	}
	
	public void manualStage(TextArea manual)
	{
		BorderPane rootBorder = new BorderPane();
		
		Scene StartScene = new Scene(rootBorder, 680, 250);
		mainStage.setTitle("Instruction Manual");
		mainStage.setScene(StartScene);
		mainStage.setResizable(false);
		rootBorder.setCenter(manual);
		rootBorder.setTop(buttons.btnCombo2());
		
		mainStage.show();
	}
	
	public void NewGame(int[][] level)
	{
		BorderPane rootBorder = new BorderPane();
		
		buttons.btnNew().setDisable(true);
		buttons.btnSaved().setDisable(true);
		
		StageLevel = 1;
		buttons.setStageLevel(StageLevel);
		Scene StartScene = new Scene(rootBorder);
		mainStage.setTitle("Bom The Bomber");
		mainStage.setScene(StartScene);
		mainStage.setResizable(false);
	
		Label lblTimer = new Label("Game Timer: ");
		lblTimer.setPrefSize(140, 20);
		lblTimer.setFont(Font.font(20));
		lblTimer.setLayoutX(480);
		
		countTime = new Label("61");
		countTime.setPrefSize(140, 20);
		countTime.setFont(Font.font("Time New Roman"));
		countTime.setLayoutX(530);
		
		rootBorder.setPrefSize(600, 600);
		
		doCountDown();
		
		Group group = new Group();
		
		group.getChildren().add(buttons.btnCombo2());
		group.getChildren().add(lblTimer);
		group.getChildren().add(countTime);
		
		rootBorder.setTop(group);
		
		world = new World(level, StageLevel, StartScene);
		
		rootBorder.setCenter(world);
		
		mainStage.show();
	}
	
	public void openSavedGame(int[][] level)
	{
		BorderPane rootBorder = new BorderPane();
		
		buttons.btnNew().setDisable(true);
		buttons.btnSaved().setDisable(true);
		
		Scene StartScene = new Scene(rootBorder);
		mainStage.setTitle("Bom The Bomber");
		mainStage.setScene(StartScene);
		mainStage.setResizable(false);
	
		Label lblTimer = new Label("Game Timer: ");
		lblTimer.setPrefSize(140, 20);
		lblTimer.setFont(Font.font(20));
		lblTimer.setLayoutX(480);
		
		countTime = new Label("61");
		countTime.setPrefSize(140, 20);
		countTime.setFont(Font.font("Time New Roman"));
		countTime.setLayoutX(530);

		rootBorder.setPrefSize(600, 600);
		
		doCountDown();
		
		Group group = new Group();
		
		group.getChildren().add(buttons.btnCombo2());
		group.getChildren().add(lblTimer);
		group.getChildren().add(countTime);
		rootBorder.setTop(group);
		
		world = new World(level, buttons.getStageLevel(), StartScene);

		rootBorder.setCenter(world);
		
		mainStage.show();
	}
	
	public void doCountDown()
	{	
		Timeline time = new Timeline();
		time.setCycleCount(Timeline.INDEFINITE);
		seconds = initTime;
		KeyFrame frame = new KeyFrame(Duration.seconds(1), new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent e) {
				// TODO Auto-generated method stub
				seconds--;
				if(seconds <= 40)
				{
					countTime.setTextFill(Color.RED);
				}
				
				countTime.setText(seconds + "");
				
				if(seconds == 0)
				{
					GameOver();
					time.stop();
				}
			}
		});
		
		time.getKeyFrames().add(frame);
		time.playFromStart();
	}
	
	public void GameOver()
	{
		BorderPane rootBorder = new BorderPane();
		
		buttons.btnNew().setDisable(false);
		buttons.btnSaved().setDisable(false);
		
		Scene StartScene = new Scene(rootBorder, 450, 500);
		mainStage.setTitle("Bom The Bomber");
		mainStage.setScene(StartScene);
		mainStage.setResizable(false);
		
		File file = new File("./utils/gameover.jpg");
		try {
			imgPath = "file://" + file.toURL().getPath();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Node overImage = new ImageView(new Image(imgPath));
		rootBorder.setCenter(overImage);
		rootBorder.setTop(buttons.btnCombo3());
		
		mainStage.show();
	}

}
