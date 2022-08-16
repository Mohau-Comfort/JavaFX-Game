package csc2a.ui;

//This class is responsible for the menubar of the game
//The buttons of the menu
//The manual of the game

import java.io.File;

import csc2a.file.GameFileHandler;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Buttons {

	
	//Variables for the menubar of the game
	private Button btnManual = null;
	private Button btnSave = null;
	private Button btnNew = null;
	private Button btnSaved = null;
	private Button btnExit = null;
	private Stage mainStage;
	private TextArea manual = null;
	private Stages stages = null;

	private static int[][] level = new int[22][22];

	private static String setTime = null;
	private int StageLevel = 0;
	
	//Instiates the main menu of the game
	public Buttons(Stage mainStage)
	{
		this.mainStage = mainStage;
		stages = new Stages(mainStage, this);
		btnManual();
		btnSave();
		btnSaved();
		btnNew();
		btnExit();
	}
	
	//button click event for the instruction manual of the game
	public Button btnManual()
	{
		btnManual = new Button("Instruction Manual");
		btnManual.setPrefSize(117, 20);
		btnManual.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				manual = new TextArea();
				manual.setText(GameFileHandler.writeManual(new File("./utils/manual.txt")));
				mainStage.hide();
				stages.manualStage(manual);
			}
		});
		
		return btnManual;
	}
	
	//button click event for the save game event
	public Button btnSave()
	{
		btnSave = new Button("Save Game");
		
		btnSave.setPrefSize(117, 20);
		
		btnSave.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				
				GameFileHandler.saveGame(level);
				//Save game level to file
				GameFileHandler.saveLevel(StageLevel);
			}
			
		});
		
		return btnSave; 
	}
	
	//button click event to start a new
	public Button btnNew()
	{
		btnNew = new Button("Start New Game");
		btnNew.setPrefSize(117, 20);
		btnNew.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
		  level = GameFileHandler.readTextFile(new File("./utils/Level1.txt"));
				  mainStage.hide();
				  stages.NewGame(level);
			}
			
		});
		
		return btnNew;
	}
	
	//button click event to open game saved level
	public Button btnSaved()
	{
		btnSaved = new Button("Open Saved Game");
		btnSaved.setPrefSize(117, 20);
		btnSaved.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				level = GameFileHandler.OpenSaved();
				
				StageLevel = GameFileHandler.savedLevel();
				mainStage.hide();
				
				stages.openSavedGame(level);
			}	
		});
		
		return btnSaved;
	}
	
	//button click event to exit game
	public Button btnExit()
	{
		btnExit = new Button("Exit Game");
		btnExit.setPrefSize(117, 20);
		btnExit.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				System.exit(0);
			}	
		});
		
		return btnExit;
	}
	
	public VBox btnCombo1()
	{
		VBox vb = new VBox();
		
		vb.getChildren().add(btnManual);
		vb.getChildren().add(btnNew);
		vb.getChildren().add(btnSaved);
		vb.getChildren().add(btnExit);

		return vb;
	}
	
	public HBox btnCombo2()
	{
		HBox hb = new HBox();
		
		hb.getChildren().add(btnNew);
		hb.getChildren().add(btnSaved);
		hb.getChildren().add(btnSave);
		hb.getChildren().add(btnExit);
		
		return hb;
	}
	
	public HBox btnCombo3()
	{
		HBox hb = new HBox();
		
		hb.getChildren().add(btnManual);
		hb.getChildren().add(btnNew);
		hb.getChildren().add(btnSaved);
		hb.getChildren().add(btnSave);
		hb.getChildren().add(btnExit);
		
		return hb;
	}
	
	public int getStageLevel()
	{
		return this.StageLevel;
	}
	
	public void setStageLevel(int StageLevel)
	{
		this.StageLevel = StageLevel;
	}
	
}
