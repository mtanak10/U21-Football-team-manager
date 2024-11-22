package model;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import persistence.JsonReader;

import static org.junit.jupiter.api.Assertions.*;

// Referenced from JsonSerializationDemo Persistence JsonWriterTest

public class JsonReaderTest extends JsonTest {

    @Test
    void testReaderNonExistentFile() {

        JsonReader reader = new JsonReader("./data/noSuchFile.json");

        try {
            reader.read();
            fail("Exception was expected");

        } catch (IOException e) {
            // pass

        }

    }

    @Test
    void testReaderEmptyTeam() {
        JsonReader reader = new JsonReader("./data/testReaderEmptyTeam.json");

        try {
            Team tm = reader.read();
            assertEquals(0, tm.getTotalPlayers());

        } catch (IOException e) {
            fail("Coudn't read from file");
        }
    }

    @Test
    void testReaderGeneralTeam() {
        JsonReader reader = new JsonReader("./data/testReaderGeneralTeam.json");

        try {
            Team tm = reader.read();
            ArrayList<Player> team = tm.getTeam();
            assertEquals(2, tm.getTotalPlayers());
            Player p1 = team.get(0);
            Player p2 = team.get(1);
            checkPlayer("A", "DF", 5, p1);
            checkPlayer("B", "GK", 3, p2);

        } catch (IOException e) {
            fail("Coudn't read from file");
        }
    }

    @Test
void testAddPlayer() {
    JsonReader reader = new JsonReader("./data/teamReaderTest.json");

    try {
        // Read the team from the JSON file
        Team team = reader.read();

        // Assertions to verify the player was added correctly
        assertEquals(1, team.getTotalPlayers()); // Verify there is exactly one player

        // Retrieve the player and verify all attributes
        Player player = team.getTeam().get(0);
        assertEquals("John Doe", player.getName());
        assertEquals("Midfielder", player.getPosition());
        assertEquals(7, player.getEvaluation());
        assertTrue(player.getDrinkingStatus()); // Verify drinking status
        assertTrue(player.getInjuryStatus()); // Verify injury status
        assertTrue(player.getSleepingStatus()); // Verify sleeping status
        assertEquals(15, player.getTotalTraining());
        assertEquals(12, player.getNumTrainingAttended());
        assertEquals(0.85, player.getAttendanceTraining(), 0.01); // Allow small delta for floating-point comparison
        assertEquals(5, player.getGoal());

    } catch (IOException e) {
        fail("Couldn't read from file");
    }
}


    
   

}
