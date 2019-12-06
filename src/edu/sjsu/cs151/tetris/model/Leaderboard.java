package edu.sjsu.cs151.tetris.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

/**
 * The class that will manage and update the player in the game.
 * @author Luksawee
 *
 */
public class Leaderboard 
{
	/**
	 * The construction of Leaderboard
	 */
	public Leaderboard()
	{
		playerList = new ArrayList<Player>();
		ArrayList <String> list = new ArrayList<String>();
		Player tmp = new Player();
		try 
		{
			InputStream is = getClass().getResourceAsStream("players.txt");
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			//BufferedReader br = new BufferedReader(new FileReader("src/edu/sjsu/cs151/tetris/model/players.txt")); // /Users/Luksawee/Desktop/
			while (br.ready()) 
			{
				// The output from br.readLine() is string; therefore we need to convert from string to int.
				list.add(br.readLine());
				numberPlayers++;
			}
		//close file
		br.close();
		} 
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
		
		String [] table;
		String [] playersName = new String[numberPlayers];
		int [][] playerScore = new int [numberPlayers][6];
		/**
		 * case: there is an existed player name.
		 */
		for (int i = 0; i < numberPlayers; i++)
		{
			table = list.get(i).split(", ");
			playersName[i] = table[0];
			tmp.setName(playersName[i]);
			
			// update player score level 1, 2, 3, 4, 5
			for (int j =1; j < 6; j++)
			{
			playerScore[i][j] = Integer.parseInt(table[j]);
			tmp.setPlayerScore(j, playerScore[i][j]);
			}
			
			tmp.setPlayerHighScore();
			tmp.getPlayerHighScore();
					
			playerList.add(i, tmp);
			tmp = new Player();
		}	
	}
	
	
	/**
	 * This method will re reads in all players and get all the current data.
	 */
	public void getCurrentPlayersData()
	{
		ArrayList <String> list = new ArrayList<String>();
		Player tmp = new Player();
		try 
		{
			InputStream is = getClass().getResourceAsStream("players.txt");
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			//BufferedReader br = new BufferedReader(new FileReader("src/edu/sjsu/cs151/tetris/model/players.txt")); // /Users/Luksawee/Desktop/
			while (br.ready()) 
			{
				// The output from br.readLine() is string; therefore we need to convert from string to int.
				list.add(br.readLine());
			}
		//close file
		br.close();
		} 
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
		
		String [] table;
		String [] playersName = new String[numberPlayers];
		int [][] playerScore = new int [numberPlayers][6];
		/**
		 * case: there is an existed player name.
		 */
		for (int i = 0; i < numberPlayers; i++)
		{
			table = list.get(i).split(", ");
			playersName[i] = table[0];
			tmp.setName(playersName[i]);
			
			// update player score level 1, 2, 3, 4, 5
			for (int j =1; j < 6; j++)
			{
			playerScore[i][j] = Integer.parseInt(table[j]);
			tmp.setPlayerScore(j, playerScore[i][j]);
			}
			
			tmp.setPlayerHighScore();
			tmp.getPlayerHighScore();
					
			playerList.add(i, tmp);
			tmp = new Player();
		}
	}
	
	
	/**
	 * This method returns the current list of players.
	 * @return The list of players
	 */
	public ArrayList<Player> getPlayer()
	{
		return playerList;
	}
	
	/**
	 * This method return the current number of player in the existed file
	 * @return numberPlayers
	 */
	public int getNumberPlayers()
	{
		return numberPlayers;
	}
	
	/**
	 * This method will return the index of the player
	 * @param aName that use to download player name
	 * @return index
	 */
	public int getPlayerIndex(String aName)
	{
		Player tmp = new Player();
		int index = 0;
		for(int i = 0; i < numberPlayers; i++)
		{
			tmp = playerList.get(i);
			if ((aName).equals(tmp.getName()))
				index = i;
		}
			return index;
	}
	
	/**
	 * This method will use to return playerlist at select index
	 * @param aName that use to download player name
	 * @return player
	 */
	public Player loadPlayer(String aName)
	{
		int index = getPlayerIndex(aName);
		return playerList.get(index);
	}
	
	/**
	 * This method will use to return player
	 * @param aName that use to download player name
	 * @return player 
	 */
	public Player getCurPlayer(String aName)
	{
		int index = getPlayerIndex(aName);
		player =  playerList.get(index);
		return player;
	}
	
	/**
	 * This method will check whether not player has already token.
	 * @param newPlayer newPlayer the object in the player
	 * @return true is the 
	 */
	public boolean isValidNewPlayers(String newPlayer)
	{		
		Player tmp = new Player();
		String inValidname = "INVALID NAME";
		for (int i = 0; i < numberPlayers; i++)
		{
			tmp = playerList.get(i);
			if (newPlayer.equalsIgnoreCase(tmp.getName()))
			{
				System.out.println("Invalid new username");
				return false;
			}
			
			if(newPlayer.equalsIgnoreCase(inValidname))
			{
				System.out.println("Invalid new username");
				return false;
			}
			
			if (newPlayer.equalsIgnoreCase(""))
			{
				System.out.println("Invalid new username");
				return false;
			}
			
			tmp = new Player();
		}
		return true;
	}

	/**
	 * This method is used to add new player.
	 * @param aName given new player
	 */
	public void addNewPlayer(String newPlayer)
	{
		if (isValidNewPlayers(newPlayer) == true)
		{
			player = new Player();
			player.setName(newPlayer);
			
			try 
			{	
				//OutputStream outputStream = new FileOutputStream("players.txt");
				//OutputStreamWriter writer = new OutputStreamWriter(outputStream);
				FileWriter writer = new FileWriter("src/edu/sjsu/cs151/tetris/model/players.txt", true); // /Users/Luksawee/Desktop/
				writer.write(newPlayer);
							
				//int [] playerScore = newPlayer.getPlayerScore();
				writer.write(", 0");
				for(int i = 1; i < 5; i++)
				{
					writer.append(", -1");	
					//writer.write(Integer.toString(playerScore[i]));
				}
				writer.write(", 0");
				writer.write("\r\n");
				writer.close();
				
				playerList.add(player);
				numberPlayers++;
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}
		}
		
		else
			System.out.println("The username has already taken");	
	}
	
	/**
	 * This method will save the player score to the player.txt
	 */
	public void savePlayer(String oldData, String newData) 
	{
		String filePath = "src/edu/sjsu/cs151/tetris/model/players.txt";
		File file = new File(filePath);
		String oldContent = "";
		BufferedReader reader = null;
		FileWriter writer = null;

		try {
			reader = new BufferedReader(new FileReader(file));

			// Reading all the lines of input text file into oldContent
			String line = reader.readLine();
			while (line != null) {
				oldContent = oldContent + line + System.lineSeparator();

				line = reader.readLine();
			}
			// Replacing oldString with newString in the oldContent

			String newContent = oldContent.replaceAll(oldData, newData);

			// Rewriting the input text file with newContent

			writer = new FileWriter(file);
			writer.write(newContent);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				// Closing the resources

				reader.close();

				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	private ArrayList <Player> playerList;
	private int numberPlayers;
	private Player player;
}
