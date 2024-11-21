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
}
