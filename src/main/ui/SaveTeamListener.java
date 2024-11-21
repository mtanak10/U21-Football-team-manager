package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

import javax.swing.JOptionPane;

import model.Team;
import persistence.*;

public class SaveTeamListener implements ActionListener {

    private Team team;
    private JsonWriter jsonWriter;
    private static final String JSON_STORE = "./data/team.json";

    public SaveTeamListener(Team team) {
        this.team = team;
        jsonWriter = new JsonWriter(JSON_STORE);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        try {
            jsonWriter.open();
            jsonWriter.write(team);
            jsonWriter.close();
            JOptionPane.showMessageDialog(null, "Team saved successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
            System.out.println("Saved Team to " + JSON_STORE);
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Unable to save team to file.", "Error", JOptionPane.ERROR_MESSAGE);
            System.out.println("Unable to write to file: " + JSON_STORE);
        }

    }

}
