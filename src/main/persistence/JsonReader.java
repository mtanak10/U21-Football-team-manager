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
        this.source = source;
    }

    // EFFECTS: reads Team from file and returns it;
    // throws IOException if an error occurs reading data from file
    public Team read() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parseTeam(jsonObject);
    }

    // EFFECTS: reads source file as string and returns it
    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s));
        }

        return contentBuilder.toString();
    }

    // EFFECTS: parses workroom from JSON object and returns it
    private Team parseTeam(JSONObject jsonObject) {
        Team tm = new Team();
        addTeam(tm, jsonObject);
        return tm;

    }

    // MODIFIES: tm
    // EFFECTS: parses list of player from JSON object and adds them to team
    private void addTeam(Team tm, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("team");
        for (Object json : jsonArray) {
            JSONObject nextPlayer = (JSONObject) json;
            addPlayer(tm, nextPlayer);

        }

    }

    // MODIFIES: tm
    // EFFECTS: parses player from JSON object and adds it to team
    private void addPlayer(Team tm, JSONObject jsonObject) {
        String name = jsonObject.getString("name");
        String position = jsonObject.getString("position");
        int evaluation = jsonObject.getInt("evaluation");
        Boolean drinkingStatus = jsonObject.getBoolean("drinkingStatus");
        double attendanceTraining = jsonObject.getDouble("attendanceTraining");
        Boolean injuryStatus = jsonObject.getBoolean("Injury Status");
        Boolean sleepingStatus = jsonObject.getBoolean("Sleeping Status");
        double totalTraining = jsonObject.getDouble("Total Training");
        double numTrainingAttended = jsonObject.getDouble("Num Training Attended");
        int goal = jsonObject.getInt("Goal");
        Player player = new Player(name, position, evaluation);
        if (drinkingStatus) {
            player.drink();
        }
        if (injuryStatus) {
            player.catchInjury();
        }
        if (sleepingStatus) {
            player.drink();
        }
        changeAttendance(player, totalTraining, numTrainingAttended, attendanceTraining);

        player.score(goal);

        tm.addPlayer(player);
    }

    // Effect: change the attendace status of the player
    public void changeAttendance(Player player, double total, double numAttend, double rate) {

        player.setTotalTraining(total);
        player.setNumTrainingAttendance(numAttend);
        player.setAttendanceRate(rate);

    }

}
