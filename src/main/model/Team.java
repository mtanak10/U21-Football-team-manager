package model;

import java.util.*;

public class Team {

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

}
