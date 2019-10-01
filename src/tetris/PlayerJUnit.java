package tetris;

import static org.junit.Assert.*;

import org.junit.Test;

public class PlayerJUnit 
{

	@Test
	public void test() 
	{
		Player newPlayer1 = new Player();
		newPlayer1.setName("Meiji");
		newPlayer1.setPlayerScoreLevel1(150);
		newPlayer1.setPlayerScoreLevel2(300);
		newPlayer1.setPlayerScoreMax();
		
		Player newPlayer2 = new Player();
		newPlayer2.setName("Fern");
		
		System.out.println("Testing newPlayer1");
		assertEquals(newPlayer1.getName(), "Meiji");
		assertEquals(newPlayer1.getPlayerScoreLevel1(), 150);
		assertEquals(newPlayer1.getPlayerScoreLevel2(), 300);
		assertEquals(newPlayer1.getPlayerScoreLevel3(), -1);
		assertEquals(newPlayer1.getPlayerScoreLevel4(), -1);
		assertEquals(newPlayer1.getPlayerScoreLevel5(), -1);
		assertEquals(newPlayer1.getPlayerScoreMax(), 300);
		assertTrue(newPlayer1.isLevelUnlocked(newPlayer1, 1));
		assertTrue(newPlayer1.isLevelUnlocked(newPlayer1, 2));
		assertFalse(newPlayer1.isLevelUnlocked(newPlayer1, 3));
		assertFalse(newPlayer1.isLevelUnlocked(newPlayer1, 4));
		assertFalse(newPlayer1.isLevelUnlocked(newPlayer1, 5));
		assertFalse(newPlayer1.checkExistedPlayers(newPlayer1));
		System.out.println("Success newPlayer1!\n");
		
		
		System.out.println("Testing newPlayer2");
		assertEquals(newPlayer2.getName(), "Fern");
		assertEquals(newPlayer2.getPlayerScoreLevel1(), -1);
		assertEquals(newPlayer2.getPlayerScoreLevel2(), -1);
		assertEquals(newPlayer2.getPlayerScoreLevel3(), -1);
		assertEquals(newPlayer2.getPlayerScoreLevel4(), -1);
		assertEquals(newPlayer2.getPlayerScoreLevel5(), -1);
		assertEquals(newPlayer2.getPlayerScoreMax(), -1);
		assertFalse(newPlayer2.isLevelUnlocked(newPlayer2, 1));
		assertFalse(newPlayer2.isLevelUnlocked(newPlayer2, 2));
		assertFalse(newPlayer2.isLevelUnlocked(newPlayer2, 3));
		assertFalse(newPlayer2.isLevelUnlocked(newPlayer2, 4));
		assertFalse(newPlayer2.isLevelUnlocked(newPlayer2, 5));
		assertFalse(newPlayer1.checkExistedPlayers(newPlayer2));
		
		System.out.println("Success newPlayer2!");
		newPlayer1.addNewPlayer(newPlayer1);
	}
}
