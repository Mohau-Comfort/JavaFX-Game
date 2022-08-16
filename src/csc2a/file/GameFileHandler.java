package csc2a.file;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

/**
 * 
 * Class to handle all interactions with files
 * @author <217044163 Mahlakwane M.C>
 *
 */
public class GameFileHandler {
	/* TODO: Methods to handle text files */
	//Method for reading all game inputs using file input stream
	public static int[][] readTextFile(File file)
	{
		final int[][] FileInput = new int[22][22];
		
		Scanner scInp = null;
		
		try
		{
			scInp = new Scanner(file);
			
			int x = 0;
			
			while(scInp.hasNext())
			{
				String line = scInp.nextLine();
				String[] lineAry = line.split("\t");
				for(int y = 0; y < 22; y++)
				{
					FileInput[x][y] = Integer.parseInt(lineAry[y]);
				}
			
				x++;
			}
			
		}catch(FileNotFoundException fnfex)
		{
			System.out.println("File " + file + " is not found in the data folder");
		}finally
		{
			if(scInp != null)
			{
				scInp.close();
			}
		}
		
		return FileInput;
	}
	
	//This method writes to the game manual
	public static String writeManual(File fileManual)
	{
		String Manual = new String();
		
		Scanner scInp = null;
		
		try
		{
			scInp = new Scanner(fileManual);
			
			while(scInp.hasNext())
			{
				Manual += scInp.nextLine() + "\n";
			}
			
		}catch(FileNotFoundException fnfex)
		{
			System.out.println("File " + fileManual + " is not found in the data folder");
		}finally
		{
			if(scInp != null)
			{
				scInp.close();
			}
		}
		
		return Manual;
	}
	
	/* TODO: Methods to handle binary files */
	
	//This method saves all game content that needs to be saved including game levels
	public static boolean saveGame(int[][] saveAry)
	{
		DataOutputStream dataSave = null;
		
		try
		{
			FileOutputStream fos = new FileOutputStream("./utils/Saved.dat");
			BufferedOutputStream buf = new BufferedOutputStream(fos);
			
			dataSave = new DataOutputStream(buf);
			
			for(int x = 0; x < 22; x++)
			{
				for(int y = 0; y < 22; y++)
				{
					dataSave.writeInt(saveAry[x][y]);
				}
			}
			
			return true;
			
		}catch(IOException ex)
		{
			ex.printStackTrace();
		}finally
		{
			if(dataSave != null)
			{
				try
				{
					dataSave.close();
				}catch(IOException ex)
				{
					ex.printStackTrace();
				}
			}
		}
		return false;
	}
	
	//This saves all kinds of the level and stage 
	public static void saveLevel(int StageLevel)
	{
		DataOutputStream dataSave = null;
		
		try
		{
			FileOutputStream fos = new FileOutputStream("./utils/Stage.dat");
			BufferedOutputStream buf = new BufferedOutputStream(fos);
			
			dataSave = new DataOutputStream(buf);
			
			dataSave.writeInt(StageLevel);
			
		}catch(IOException ex)
		{
			ex.printStackTrace();
		}finally
		{
			if(dataSave != null)
			{
				try
				{
					dataSave.close();
				}catch(IOException ex)
				{
					ex.printStackTrace();
				}
			}
		}
	}
	
	//This opens the saved levels
	public static int[][] OpenSaved()
	{
		int[][] SavedLevel = new int[22][22];
		DataInputStream dataOpen = null;
		
		try
		{
			FileInputStream fis = new FileInputStream("./utils/Saved.dat");
			BufferedInputStream bif = new BufferedInputStream(fis);
			
			dataOpen = new DataInputStream(bif);

			for(int x = 0; x < 22; x++)
			{
				for(int y = 0; y < 22; y++)
				{
					SavedLevel[x][y] = dataOpen.readInt();
				}
			}
			
		}catch(IOException ex)
		{
			ex.printStackTrace();
		}finally
		{
			if(dataOpen != null)
			{
				try
				{
					dataOpen.close();
				}catch(IOException ex)
				{
					ex.printStackTrace();
				}
			}
		}
		
		return SavedLevel;
	}
	
	//This opens the last level saved
	public static int savedLevel()
	{
		DataInputStream dataOpen = null;
		int SavedStage = 0;
		
		try
		{
			FileInputStream fis = new FileInputStream("./utils/Stage.dat");
			BufferedInputStream bif = new BufferedInputStream(fis);
			
			dataOpen = new DataInputStream(bif);
			
			SavedStage = dataOpen.readInt();
			
		}catch(IOException ex)
		{
			ex.printStackTrace();
		}finally
		{
			if(dataOpen != null)
			{
				try
				{
					dataOpen.close();
				}catch(IOException ex)
				{
					ex.printStackTrace();
				}
			}
		}
	
		return SavedStage;
	}

}

