package model;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;



import java.util.ArrayList;

public class TeamTest {

  private Team team1;
  private Player player1;
  private Player player2;


    
    @BeforeEach
    void runBefore() {
      team1 = new Team();
      player1 = new Player("John", "Defender", 5);
      player2 = new Player("Sam", "Foward", 4);
    }

    @Test
    void testConstructor() {
      assertEquals(0, team1.getTotalPlayers());

    }

    @Test
    void testAddPlayer(){
      team1.addPlayer(player1);
      assertEquals(1, team1.getTotalPlayers());
      team1.addPlayer(player2);
      assertEquals(2, team1.getTotalPlayers());


    }

    @Test 
    void testRemovePlayer(){
      team1.addPlayer(player1);
      team1.addPlayer(player2);
      team1.removePlayer("John");
      assertEquals(1, team1.getTotalPlayers());
      team1.removePlayer("Sam");
      assertEquals(0, team1.getTotalPlayers());

    }


}
  

