package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Leaderboard 
{
	/**
	 * This method reads in new players and adds them to the list of players.
	 */
	public void readPlayers()
	{
		try 
		{
			BufferedReader br = new BufferedReader(new FileReader("/Users/Luksawee/Desktop/players.txt"));
			while (br.ready()) 
			{
				// The output from br.readLine() is string; therefore we need to convert from string to int.
				playerList.add(br.readLine());
				numberPlayers++;
			}
		//close file
		br.close();
		} 
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}			
	}

	/**
	 * This method returns the current list of players.
	 * @return The list of players
	 */
	public ArrayList<String> getPlayer(){
		return playerList;
	}
	
	
	/**
	 * This method will check whether not player has already token.
	 * @param newPlayer newPlayer the object in the player
	 * @return true is the 
	 */
	public boolean isValidNewPlayers(Player newPlayer)
	{
		String [] name;
		String [] playersName = new String[numberPlayers];
		/**
		 * case: there is an existed player name.
		 */
		for (int i = 0; i < numberPlayers; i++)
		{
			name = playerList.get(i).split(", ");
			playersName[i] = name[0];
				if(playersName[i].equals(newPlayer.getName()))
				{
					System.out.println("Invalid new username");
					return true;
				}
		}
		return false;
	}

	/**
	 * This method is used to add new player.
	 * @param aName given new player
	 */
	public void addNewPlayer(Player newPlayer)
	{
		if (isValidNewPlayers(newPlayer) == false)
		{
			try 
			{
				FileWriter writer = new FileWriter("/Users/Luksawee/Desktop/players.txt", true);
				writer.write(newPlayer.getName());
				writer.write(", ");
				int [] playerLevel = newPlayer.getPlayerLevel();
				for(int i = 0; i < 5; i++)
				{
					writer.write(playerLevel[i]);
					writer.write(", ");
				}
				
				int [] playerScore = newPlayer.getPlayerScore();
				for(int i = 0; i < 6; i++)
				{
					writer.write(playerScore[i]);
					writer.write(", ");
				}
				writer.write("\r\n");
				writer.close();
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}
		}
		else
			System.out.println("The username has already taken");	
	}
	
	private ArrayList <String> playerList;
	private int numberPlayers;
}
