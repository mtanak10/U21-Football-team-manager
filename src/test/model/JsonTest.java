package model;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JsonTest {
    protected void checkPlayer(String name, String position, int evaluation, Player player) {
        assertEquals(name, player.getName());
        assertEquals(position, player.getPosition());
        assertEquals(evaluation, player.getEvaluation());

    }

}
