package model;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import persistence.JsonReader;
import persistence.JsonWriter;


import static org.junit.jupiter.api.Assertions.*;

// Referenced from JsonSerializationDemo Persistence JsonWriterTest

public class JsonWriterTest extends JsonTest {

    @Test
    void testWriteInvalidFile() {
        try {
            JsonWriter writer = new JsonWriter("./data/my\0illegal:fileName.json");
            writer.open();

            fail("IOException was expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testWriterEmptyTeam() {
        try {
            Team tm = new Team();
            JsonWriter writer = new JsonWriter("./data/testWriterEmptyTeam.json");

            writer.open();
            writer.write(tm);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterEmptyTeam.json");
            tm = reader.read();
            assertEquals(0, tm.getTotalPlayers());
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }

    @Test
    void testWriteGeneralTeam() {
        try {
            Team tm = new Team();
            tm.addPlayer(new Player("A", "DF", 5));
            tm.addPlayer(new Player("B", "GK", 3));
            JsonWriter writer = new JsonWriter("./data/testWriteGeneralTeam.json");

            writer.open();
            writer.write(tm);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriteGeneralTeam.json");
            tm = reader.read();
            ArrayList<Player> team = tm.getTeam();
            assertEquals(2, team.size());
            assertEquals(2, tm.getTotalPlayers());
            Player p1 = team.get(0);
            Player p2 = team.get(1);
            checkPlayer("A", "DF", 5, p1);
            checkPlayer("B", "GK", 3, p2);

        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }

    }

}
