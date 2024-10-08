package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PlayerTest {

  private Player player1;


    
    @BeforeEach
    void runBefore() {
      player1 = new Player("John", "Defender", 5);

    }

    @Test
    void testConstructor() {
      assertEquals("John", player1.getName());
      assertEquals("Defender", player1.getPosition());
      assertEquals(5, player1.getEvaluation());
      assertEquals(false, player1.getDrinkingStatus());
      assertEquals(false, player1.getInjuryStatus());
      assertEquals(false, player1.getSleepingStatus());
      assertEquals(0, player1.getGoal());
      assertEquals(0, player1.getAttendanceTraining());
      assertEquals(0, player1.getTotalTraining());
      assertEquals(0, player1.getNumTrainingAttended());

    }

    
    @Test
    void testScore(int goal){
      player1.score(1);
      assertEquals(1, player1.getGoal());
      player1.score(3);
      assertEquals(4, player1.getGoal());

    }

    @Test
    void testCatchInjury(){
      player1.catchInjury();
      assertEquals(true, player1.getInjuryStatus());
      player1.catchInjury();
      assertEquals(true, player1.getInjuryStatus());
    }

    @Test
    void testHealInjury(){
      player1.catchInjury();
      player1.healInjury();
      assertEquals(false, player1.getInjuryStatus());
      player1.healInjury();
      assertEquals(false, player1.getInjuryStatus());
    }
   
    @Test
    void testAttendTraining(){
      player1.attendTraining();
      assertEquals(1, player1.getAttendanceTraining());
      player1.attendTraining();
      assertEquals(1, player1.getAttendanceTraining());
      player1.missTraining();
      assertEquals(2/3, player1.getAttendanceTraining());

    }

    @Test
    void testMissTraining(){
      player1.missTraining();
      assertEquals(0, player1.getAttendanceTraining());
      player1.attendTraining();
      assertEquals(0.5, player1.getAttendanceTraining());
    }

    @Test
    void testIsAvailable() {
      assertEquals(false, player1.isAvailable());
      player1.attendTraining();
      assertEquals(true, player1.attendaceTraining);
    }


}
