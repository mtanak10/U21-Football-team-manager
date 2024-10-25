package persistence;

import model.Player;
import model.Team;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import org.json.*;

// Referenced from JsonSerializationDemo Persistence JsonReader
// https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo.git

// Represents a reader that reads workroom from JSON data stored in file
public class JsonReader {
    private String source;

    // EFFECTS: constructs reader to read from source file
    public JsonReader(String source) {
        // stub
    }

    // EFFECTS: reads Team from file and returns it;
    // throws IOException if an error occurs reading data from file
    public Team read() throws IOException {
        return null;
    }

    // EFFECTS: reads source file as string and returns it
    private String readFile(String source) throws IOException {
       return "";
    }

    // EFFECTS: parses workroom from JSON object and returns it
    private Team parseTeam(JSONObject jsonObject) {
        return null;

    }

    // MODIFIES: tm
    // EFFECTS: parses list of player from JSON object and adds them to team
    private void addTeam(Team tm, JSONObject jsonObject) {
        // stub

    }

    // MODIFIES: tm
    // EFFECTS: parses player from JSON object and adds it to team
    private void addPlayer(Team tm, JSONObject jsonObject) {
        // stub

    }

}
