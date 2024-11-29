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
        String name = player.getName();
        EventLog.getInstance().logEvent(new Event("Player added!!!" + " Name: " + name));
    }

    // Requires: parameter to be a string and a name that has been added to the team
    // list
    // Modifies: this
    // Effects: remove a player from the team list
    public void removePlayer(String name) {
        String player = "";
        for (int i = 0; i < team.size(); i++) {
            if (team.get(i).getName().equals(name)) {
                player = team.get(i).getName();
                team.remove(team.get(i));
                break;
            }
        }
        EventLog.getInstance().logEvent(new Event("Player removed!!!" + " Name: " + player));
    }

    public ArrayList<Player> getTeam() {
        return this.team;
    }

    public int getTotalPlayers() {
        return this.team.size();
    }

    // Effects this is for checking if a team has a player with the given string
    public Boolean containsName(String name) {
        for (Player p : team) {
            String n = p.getName();
            if (n.equalsIgnoreCase(name)) {
                return true;
            }
        }
        return false;
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

    // returns string with given string
    public Player getPlayer(String name) {
        for (Player p : team) {
            String n = p.getName();
            if (n.equalsIgnoreCase(name)) {
                return p;
            }
        }
        return null;
    }

    // EFFECTS:

    public void printEventLog() {
        EventLog log = EventLog.getInstance();
        for (model.Event event : log) {
            System.out.println(event.toString());
        }
    }

}
