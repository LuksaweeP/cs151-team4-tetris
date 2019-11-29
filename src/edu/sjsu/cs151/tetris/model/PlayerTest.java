package edu.sjsu.cs151.tetris.model;

import java.util.ArrayList;

public class PlayerTest 
{
	public static void main(String[] args)
	{
			Leaderboard playerList = new Leaderboard();
			
			ArrayList <Player> list = playerList.getPlayer();
			
			int number = playerList.getNumberPlayers();
				
			Player players = new Player();
			for (int i =0; i < number; i++)
			{
				players = list.get(i);
				System.out.print(players.getName() + " ");
				int [] playerScore = players.getPlayerScore();
				for (int score: playerScore)
					System.out.print(score + " ");
				System.out.println();
			}
			System.out.println("Number of player: " + number);
			
			Player newPlayer = new Player();
			newPlayer.setName("Fern");
			playerList.addNewPlayer("Fern");
			
			System.out.println("Number of player: " + number);
			
			Player newPlayer1 = new Player();
			newPlayer1.setName("Menjiao");
			playerList.addNewPlayer("Ken");
			System.out.println("Number of player: " + number);
			
			
			System.out.print(newPlayer1.getName());
			
			int [] player1Score = newPlayer1.getPlayerScore();
			for (int score: player1Score)
				System.out.print(score + " ");
			System.out.println();
			System.out.println("Number of player: " + number);
			
			
			System.out.println(playerList.getPlayerIndex("Nick"));
			System.out.println(playerList.getPlayerIndex("Fern"));
			System.out.println(playerList.getPlayerIndex("Meiji"));
			System.out.println(playerList.getPlayerIndex("Menjiao"));
			
			
			Player loadPlayer = playerList.loadPlayer("Fern");
			System.out.print(loadPlayer.getName() + " ");
			int [] loadPlayerScore = loadPlayer.getPlayerScore();
			for (int score: loadPlayerScore)
				System.out.print(score + " ");
			
			System.out.println();
			Player tmpPlayer = playerList.loadPlayer("Fern");
			int [] tmpPlayerScore = tmpPlayer.getPlayerScore();
			String playerName = loadPlayer.getName();
			String tempScore = "";
			for (int i = 0; i < 6; i++) 
				{	
					tempScore += ", " + tmpPlayerScore[i];
				}
			
			String oldData = playerName + tempScore;
			
			loadPlayer.setPlayerScore(1, 300);
			loadPlayer.setPlayerHighScore();
			loadPlayerScore = loadPlayer.getPlayerScore();
			String curScore = "";
			for (int i = 0; i < 6; i++) 
			{	
				curScore += ", " + loadPlayerScore[i];
			}
					
			String newData = playerName + curScore;
			playerList.savePlayer(oldData, newData);
			playerList.getCurrentPlayersData();
			
			
			list = playerList.getPlayer();
			
			number = playerList.getNumberPlayers();
				
			players = new Player();
			for (int i =0; i < number; i++)
			{
				players = list.get(i);
				System.out.print(players.getName() + " ");
				int [] playerScore = players.getPlayerScore();
				for (int score: playerScore)
					System.out.print(score + " ");
				System.out.println();
			}
			System.out.println("Number of player: " + number);
			
	}
}


