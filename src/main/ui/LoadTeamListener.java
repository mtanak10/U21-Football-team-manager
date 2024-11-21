package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JOptionPane;

import model.Team;
import persistence.*;

public class LoadTeamListener implements ActionListener {

    private Team team;
    private JsonReader jsonReader;
    private static final String JSON_STORE = "./data/team.json";

    public LoadTeamListener(Team team) {
        this.team = team;
        jsonReader = new JsonReader(JSON_STORE);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Load Team button clicked"); // Debug statement
        try {
            Team loadedTeam = jsonReader.read();
            team.getTeam().clear();
            team.getTeam().addAll(loadedTeam.getTeam());
            JOptionPane.showMessageDialog(null, "Team loaded successfully!", "Success",
                    JOptionPane.INFORMATION_MESSAGE);
            System.out.println("Loaded Team from " + JSON_STORE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Unable to load team from file.", "Error", JOptionPane.ERROR_MESSAGE);
            System.out.println("Unable to read from file: " + JSON_STORE);
        }
    }

}
