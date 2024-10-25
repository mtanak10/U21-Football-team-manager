package model;

import java.util.*;
// Team an Arraylist of playeys

import org.json.JSONArray;
import org.json.JSONObject;

import persistence.Writable;

public class Team implements Writable {

    private ArrayList<Player> team;

    public Team() {
        team = new ArrayList<>();
    }

    // Requires: player to have a name and evaluation.ss
    // Modifies: this team list
    // Effects: Adds a Player into the list team
    public void addPlayer(Player player) {
        team.add(player);
    }

    // Requires: parameter to be a string and a name that has been added to the team
    // list
    // Modifies: this
    // Effects: remove a player from the team list
    public void removePlayer(String name) {
        for (int i = 0; i < team.size(); i++) {
            if (team.get(i).getName().equals(name)) {
                team.remove(team.get(i));
                break;
            }
        }
    }

    public ArrayList<Player> getTeam() {
        return this.team;
    }

    public int getTotalPlayers() {
        return this.team.size();
    }

    // Effects: Team to JsonObject
    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("team", teamToJson());
        return json;
    }

    // EFFECTS: returns the list of players as a JSONArray
    public JSONArray teamToJson() {
        JSONArray jsonArray = new JSONArray();

        for (Player p : team) {
            jsonArray.put(p.toJson());
        }

        return jsonArray;
    }
}
