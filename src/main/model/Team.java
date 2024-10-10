package model;

import java.util.*;

public class Team {

  protected ArrayList<Player> team;

  public Team() {
    team = new ArrayList<>();
  }

  // Requires: player to have a name and evaluation.
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
      }

    }

    // for (Player player : team) {
    // if (player.getName() == name) {
    // team.remove(player);

    // }

    // }

  }

  public ArrayList<Player> getTeam() {
    return team;
  }

  public int getTotalPlayers() {
    return team.size();
  }

}
