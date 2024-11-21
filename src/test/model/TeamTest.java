package model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TeamTest {

    private Team team1;
    private Player player1;
    private Player player2;
    private Player player3;

    @BeforeEach
    void runBefore() {
        team1 = new Team();
        player1 = new Player("John", "DF", 5);
        player2 = new Player("Sam", "FW", 4);
        player3 = new Player("Josh", "MF", 4);
        
    }

    @Test
    void testConstructor() {
        assertEquals(0, team1.getTotalPlayers());
    }

    @Test
    void testAddPlayer() {
        team1.addPlayer(player1);
        assertEquals(1, team1.getTotalPlayers());
        team1.addPlayer(player2);
        assertEquals(2, team1.getTotalPlayers());
    }

    @Test
    void testRemovePlayer() {
        team1.addPlayer(player1);
        team1.addPlayer(player2);
        team1.addPlayer(player3);
        assertEquals(3, team1.getTotalPlayers());
        team1.removePlayer("Sam");
        assertEquals(2, team1.getTotalPlayers());
        team1.removePlayer("John");
        assertEquals(1, team1.getTotalPlayers());
    }

    @Test
    void testGetTeam() {
        team1.addPlayer(player1);
        team1.addPlayer(player2);
        ArrayList<Player> team2 = team1.getTeam();
        assertEquals(2, team2.size());
        assertEquals(true, team2.contains(player1));

    }

    @Test 
    void testContainsName(){
        team1.addPlayer(player1);
        team1.addPlayer(player2);
        assertTrue(team1.containsName("John"));
        assertTrue(team1.containsName("Sam"));
        assertFalse(team1.containsName("a"));
    }

}
